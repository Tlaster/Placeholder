# Placeholder  
[![](https://jitpack.io/v/Tlaster/Placeholder.svg)](https://jitpack.io/#Tlaster/Placeholder)  

Let you have `Placeholder` in Jetpack Compose 

<img src="image/image.gif" height=400>

# Usage
Add Jitpack
```
maven { url 'https://jitpack.io' }
```
Add the dependency
```
implementation "com.github.Tlaster:Placeholder:$version_Placeholder"
```
Example
```kotlin
ListItem(
    icon = {
        Placeholder(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape),
            delayMillis = 100,
        )
    },
    text = {
        TextPlaceHolder(
            length = 50,
            delayMillis = 100,
        )
    },
)
```

# License
```
MIT License

Copyright (c) 2021 Tlaster

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
