const val VERSION_BANNERBAR = VERSION_ANDROIDX
const val VERSION_PREFY = "0.2"

fun Dependencies.hendraanggrian(module: String, version: String) = "com.hendraanggrian:$module:$version"

fun Dependencies.hendraanggrian(repo: String, module: String, version: String) = "com.hendraanggrian.$repo:$module:$version"

fun Plugins.hendraanggrian(module: String) = id("com.hendraanggrian.$module")
