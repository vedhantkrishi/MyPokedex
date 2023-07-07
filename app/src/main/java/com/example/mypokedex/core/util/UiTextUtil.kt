package com.example.mypokedex.core.util

import android.content.Context

fun UiText.asString(context: Context): String {
    return when (this) {
        is UiText.StringResource -> context.getString(this.id)
    }
}