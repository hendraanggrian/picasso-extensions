package com.hendraanggrian.picasso.target

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ProgressBar

/**
 * @author Hendra Anggrian (hendraanggrian@gmail.com)
 */
object Targets {

    /**
     * Set progress bar with defined width and height as target's placeholder.
     */
    @JvmOverloads
    fun placeholder(target: ImageView, progressWidth: Int = ViewGroup.LayoutParams.WRAP_CONTENT, progressHeight: Int = ViewGroup.LayoutParams.WRAP_CONTENT): Targeter =
            PlaceholderTargeter(target, ProgressBar(target.context).apply {
                layoutParams = FrameLayout.LayoutParams(progressWidth, progressHeight).apply { gravity = Gravity.CENTER }
            })

    /**
     * Set custom view as target's placeholder.
     */
    fun placeholder(target: ImageView, placeholder: View): Targeter = PlaceholderTargeter(target, placeholder)
}