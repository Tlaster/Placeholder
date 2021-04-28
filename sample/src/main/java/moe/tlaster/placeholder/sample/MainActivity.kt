package moe.tlaster.placeholder.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import moe.tlaster.placeholder.Placeholder
import moe.tlaster.placeholder.TextPlaceHolder

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Scaffold {
                    val state = rememberLazyListState()

                    LazyColumn(
                        state = state
                    ) {
                        items(1000) {
                            val delay = (it - state.firstVisibleItemIndex) * 50L
                            ListItem(
                                icon = {
                                    Placeholder(
                                        modifier = Modifier
                                            .size(32.dp)
                                            .clip(CircleShape),
                                        delayMillis = delay,
                                    )
                                },
                                text = {
                                    Column {
                                        TextPlaceHolder(
                                            modifier = Modifier.fillMaxWidth(0.4f),
                                            delayMillis = delay,
                                        )
                                    }
                                },
                                secondaryText = {
                                    TextPlaceHolder(
                                        modifier = Modifier.fillMaxWidth(),
                                        delayMillis = delay,
                                    )
                                },
                                overlineText = {
                                    Column {
                                        Spacer(modifier = Modifier.height(8.dp))
                                        TextPlaceHolder(
                                            modifier = Modifier.fillMaxWidth(0.2f),
                                            delayMillis = delay,
                                        )
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

