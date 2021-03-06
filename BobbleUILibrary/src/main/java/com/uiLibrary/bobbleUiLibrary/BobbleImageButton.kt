package com.uiLibrary.bobbleUiLibrary

import android.content.Context
import android.content.res.ColorStateList
import android.os.Build
import android.util.AttributeSet
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.content.ContextCompat

//ImageButton Library

class BobbleImageButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) :
    AppCompatImageButton(context, attrs) {
    //attrs
    private var customTheme: String?
    private var background: ColorStateList?
    private val typedArray =
        context.theme.obtainStyledAttributes(attrs, R.styleable.BobbleImageButton, 0, 0)

    init {
        customTheme = typedArray.getString(R.styleable.BobbleImageButton_customTheme)
        //imageButton background color based on different themes
        background =
            typedArray.getColorStateList(
                R.styleable.BobbleImageButton_android_backgroundTint
            )
        backgroundColor(background)

        setTheme(customTheme)
        typedArray.recycle()
    }

    fun setTheme(theme: String?) {
        return applyTheme(theme)
    }

    fun backgroundColor(tint: ColorStateList?) {
        background = tint ?: ContextCompat.getColorStateList(context, R.color.button_background)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            backgroundTintList = background
        }
    }

    fun setEnable(enable: Boolean) {
        if (isEnabled != enable) {
            isEnabled = enable
        }
    }
}