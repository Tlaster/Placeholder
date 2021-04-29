package moe.tlaster.placeholder

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

private const val ID_PlaceHolder = "placeholder"

@Composable
fun TextPlaceHolder(
    modifier: Modifier = Modifier,
    length: Int,
    durationMillis: Int = PlaceholderConstants.DefaultDurationMillis,
    delayMillis: Long = 0,
    color: PlaceholderColors = PlaceholderConstants.DefaultColor,
) {
    val value = buildAnnotatedString {
        repeat(length) {
            appendInlineContent(ID_PlaceHolder)
        }
    }
    Text(
        text = value, inlineContent = mapOf(
            ID_PlaceHolder to InlineTextContent(
                androidx.compose.ui.text.Placeholder(
                    width = LocalTextStyle.current.fontSize,
                    height = LocalTextStyle.current.fontSize,
                    placeholderVerticalAlign = PlaceholderVerticalAlign.TextCenter
                )
            ) {
                Placeholder(
                    modifier = modifier.fillMaxSize(),
                    durationMillis = durationMillis,
                    delayMillis = delayMillis,
                    color = color,
                )
            },
        )
    )
}

@Composable
fun Placeholder(
    modifier: Modifier,
    durationMillis: Int = PlaceholderConstants.DefaultDurationMillis,
    delayMillis: Long = 0,
    color: PlaceholderColors = PlaceholderConstants.DefaultColor,
) {
    var started by rememberSaveable(delayMillis) {
        mutableStateOf(delayMillis == 0L)
    }
    if (!started) {
        LaunchedEffect(delayMillis) {
            delay(delayMillis)
            started = true
        }
    }
    val colorAnimation = if (started) {
        val transition = rememberInfiniteTransition()
        val colorAnimation by transition.animateColor(
            initialValue = color.start,
            targetValue = color.end,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationMillis,
                    easing = CubicBezierEasing(1.0f, 0.0f, 0.8f, 0.3f)
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
        colorAnimation
    } else {
        color.start
    }

    Box(modifier = modifier.background(color = colorAnimation))
}

object PlaceholderConstants {
    const val DefaultDurationMillis: Int = 1500
    val DefaultColor = PlaceholderColors(
        start = Color.Black.copy(alpha = 0.1f),
        end = Color.Black.copy(alpha = 0.025f)
    )
}

data class PlaceholderColors(
    val start: Color,
    val end: Color,
)