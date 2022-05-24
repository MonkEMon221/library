package com.uiLibrary.bobbleUiLibrary

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import com.google.android.material.button.MaterialButton


//Button Library
class BobbleButton @JvmOverloads constructor
    (context: Context, attrs: AttributeSet? = null) :
    MaterialButton(context, attrs) {

    //    attrs
    private var backgroundTint: ColorStateList?
    private var radius: Float
    private var text: ColorStateList?

    private var customTheme: String?
    private val padding: Float
    private val paddingTop: Float
    private val paddingBottom: Float
    private val paddingLeft: Float
    private val paddingRight: Float
    private val typedArray: TypedArray =
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.BobbleButton,
            0,
            0
        )

    init {
        customTheme = typedArray.getString(R.styleable.BobbleButton_customTheme)

        backgroundTint =
            typedArray.getColorStateList(
                R.styleable.BobbleButton_backgroundTint
            )
        backgroundColor(backgroundTint)

        text = typedArray.getColorStateList(
            R.styleable.BobbleButton_android_textColor
        )
        buttonTextColor(text)

        radius =
            typedArray.getDimension(
                R.styleable.BobbleButton_cornerRadius, resources.getDimensionPixelSize(
                    com.intuit.sdp.R.dimen._30sdp
                ).toFloat()
            )
        buttonCornerRadius(radius)

        padding =
            typedArray.getDimension(R.styleable.BobbleButton_android_padding, 0f)

        paddingTop =
            typedArray.getDimension(
                R.styleable.BobbleButton_android_paddingTop,
                resources.getDimensionPixelSize(
                    com.intuit.sdp.R.dimen._8sdp
                ).toFloat()
            )
        paddingBottom =
            typedArray.getDimension(
                R.styleable.BobbleButton_android_paddingBottom,
                resources.getDimensionPixelSize(
                    com.intuit.sdp.R.dimen._8sdp
                ).toFloat()
            )
        paddingLeft =
            typedArray.getDimension(
                R.styleable.BobbleButton_android_paddingLeft,
                resources.getDimensionPixelSize(
                    com.intuit.sdp.R.dimen._24sdp
                ).toFloat()
            )
        paddingRight =
            typedArray.getDimension(
                R.styleable.BobbleButton_android_paddingRight,
                resources.getDimensionPixelSize(
                    com.intuit.sdp.R.dimen._24sdp
                ).toFloat()
            )

        //preDefined padding
        if (padding > 0f) {
            setPadding(padding.toInt())
        } else {
            setPadding(
                paddingLeft.toInt(),
                paddingTop.toInt(),
                paddingRight.toInt(),
                paddingBottom.toInt()
            )
        }
        setTheme(customTheme)

        typedArray.recycle()
    }

    fun setTheme(theme: String?) {
        return applyTheme(theme)
    }

    fun buttonCornerRadius(radius: Float) {
        cornerRadius = radius.toInt()
    }

    fun buttonTextColor(tint: ColorStateList?) {
        text = tint ?: ContextCompat.getColorStateList(context, R.color.text_color)
        setTextColor(text)
    }

    fun backgroundColor(tintList: ColorStateList?) {
        backgroundTint =
            tintList ?: ContextCompat.getColorStateList(context, R.color.button_background)
        backgroundTintList = backgroundTint
    }

    fun setEnable(enable: Boolean) {
        if (isEnabled != enable) {
            isEnabled = enable
        }
    }
}