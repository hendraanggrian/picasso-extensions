[![bintray](https://img.shields.io/badge/bintray-pikasso-brightgreen.svg)](https://bintray.com/hendraanggrian/pikasso)
[![download](https://api.bintray.com/packages/hendraanggrian/pikasso/pikasso/images/download.svg) ](https://bintray.com/hendraanggrian/pikasso/pikasso/_latestVersion)
[![build](https://travis-ci.com/hendraanggrian/pikasso.svg)](https://travis-ci.com/hendraanggrian/pikasso)
[![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)

Pikasso
=======
![demo_transformations][demo_transformations]
![demo_palette][demo_palette]

Kotlin extensions for Picasso image loader.
* Invoke callback and target with Kotlin DSL.
* Use pre-loaded transformations with extension functions.
* Supports material components Palette alongside too.

Download
--------
```gradle
dependencies {
    compile "com.hendraanggrian.pikasso:pikasso:$version"

    // or download separately
    compile "com.hendraanggrian.pikasso:pikasso-commons:$version"
    compile "com.hendraanggrian.pikasso:pikasso-transformations:$version"
    compile "com.hendraanggrian.pikasso:pikasso-palette:$version"
}
```

Pikasso Commons
---------------
Call `picasso` to get global instance of `Picasso`.
Or `buildPicasso` to invoke `Picasso.Builder`.

```kotlin
picasso.load(url).into(imageView)

val myPicasso = buildPicasso {
    loggingEnabled(true)
    memoryCache(Cache.NONE)
    listener { picasso, uri, exception -> }
}
myPicasso.load(url).into(imageView)
```

Clean declaration of `Callback` when loading images into `ImageView`. 

```kotlin
picasso.load(url).into(imageView) {
    onSuccess {
        celebrate()
    }
}
```

Or into `Target` with Kotlin DSL.

```kotlin
picasso.load(url).into {
    onLoaded { bitmap, from ->
        process(bitmap)
    }
}
```

Pikasso Transformations
-----------------------
Transform request using Kotlin extension functions.

```kotlin
picasso.load(url)
    .circle()
    .into(imageView)

// multiple transformations are also supported
picasso.load(url)
    .circle()
    .grayscale()
    .into(imageView)
```

### Available transformations
|              |                                                         Transformations             |
|--------------|-------------------------------------------------------------------------------------|
| crop square  | `square()`                                                                          |
| crop circle  | `circle()`                                                                          |
| crop rounded | `rounded(radius)`<br> `rounded(radius, margin)<br> rounded(radius, margin, usedDp)` |
| overlay      | `overlay(color, alpha)`<br> `overlay(context, colorRes, alpha)`                     |
| grayscale    | `grayscale()`                                                                       |

Pikasso Palette
---------------
Get a palette synchronously from `RequestCreator`.

```kotlin
val palette = picasso.load(url).palette
val vibrant = palette.getVibrantColor(defaultColor)
```

Or asynchronously.

```kotlin
picasso.load(url).palette {
    onLoaded { bitmap, from ->
        useVibrant {
            title.setTextColor(it)
        }
    }
}
```

Alternatively, you can also load image to target image and extract its palette. 

```kotlin
picasso.load(url).palette(imageView) {
    onSuccess {
        useMuted {
            layout.setBackgroundColor(it)
        }
    }
}
```

License
-------
    Copyright 2018 Hendra Anggrian

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[demo_transformations]: /art/demo_transformations.gif
[demo_palette]: /art/demo_palette.gif
ns and
    limitations under the License.

[jcenter]: https://bintray.com/hendraanggrian/pikasso
[demo_transformations]: /art/demo_transformations.gif
[demo_palette]: /art/demo_palette.gif
mo_palette.gif
ansformations.gif
[demo_palette]: /art/demo_palette.gif
mo_palette.gif

