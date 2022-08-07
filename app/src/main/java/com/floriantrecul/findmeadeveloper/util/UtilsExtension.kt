package com.floriantrecul.findmeadeveloper.util

import android.content.Intent
import android.net.Uri

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