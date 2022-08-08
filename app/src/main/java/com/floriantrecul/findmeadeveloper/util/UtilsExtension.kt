package com.floriantrecul.findmeadeveloper.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.floriantrecul.findmeadeveloper.R
import java.util.*

fun String.buildUrlIntent() = Intent(Intent.ACTION_VIEW, Uri.parse(this))

fun String.buildEmailIntent() = Intent(
    Intent.ACTION_SENDTO,
    Uri.parse("mailto:${this}")
)

fun String?.isVisible(): Boolean {
    if (this.isNullOrEmpty() || this.isNullOrBlank()) {
        return false
    }
    return true
}

fun getColorArray(context: Context): Int {
    val colors = context.resources.getIntArray(R.array.colors)
    val color  = Random().nextInt(colors.size)
    return colors[color]
}