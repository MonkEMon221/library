package com.uiLibrary.bobbleUiLibrary

import android.content.Context
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatDelegate

//dp value to pixel value function
fun dpToPx(context: Context, dp: Float): Float {
    return dp * (
            context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
}

//theme
private const val lightMode = "light"
private const val darkMode = "dark"
private const val default = "default"

fun applyTheme(theme: String?) {
    when (theme) {
        lightMode -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        darkMode -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        default -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)

    }
}