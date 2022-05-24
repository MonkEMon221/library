package com.uiLibrary.bobbleUiLibrary

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding

//EditText Library
class BobbleEditText @JvmOverloads constructor
    (context: Context, attrs: AttributeSet? = null) :
    AppCompatEditText(context, attrs) {


    //attrs
    private var textColor: Int
    private var cornerRadius: Float
    private var textBoxColor: Int
    private var borderColor: Int
    private var borderWidth: Float
    private var customTheme: String?

    private var cPadding: Float
    private var cPaddingLeft: Float
    private var cPaddingTop: Float
    private var cPaddingRight: Float
    private var cPaddingBottom: Float

    private val typedArray =
        context.theme.obtainStyledAttributes(attrs, R.styleable.BobbleEditText, 0, 0)

    init {

        cPadding = typedArray.getDimension(R.styleable.BobbleEditText_android_padding, 0f)

        cPaddingLeft = typedArray.getDimension(
            R.styleable.BobbleEditText_android_paddingLeft,
            resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._10sdp).toFloat()
        )
        cPaddingTop = typedArray.getDimension(
            R.styleable.BobbleEditText_android_paddingTop,
            resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._10sdp).toFloat()
        )
        cPaddingRight = typedArray.getDimension(
            R.styleable.BobbleEditText_android_paddingRight,
            resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._10sdp).toFloat()
        )
        cPaddingBottom = typedArray.getDimension(
            R.styleable.BobbleEditText_android_paddingBottom,
            resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._10sdp).toFloat()
        )

        cornerRadius =
            typedArray.getDimension(
                R.styleable.BobbleEditText_corner_radius,
                resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._30sdp).toFloat()
            )


        customTheme = typedArray.getString(R.styleable.BobbleEditText_customTheme)

        textColor = typedArray.getColor(
            R.styleable.BobbleEditText_android_textColor,
            ContextCompat.getColor(context, R.color.textColor)
        )

        setTextColor(textColor)

        textBoxColor =
            typedArray.getColor(
                R.styleable.BobbleEditText_textBoxColor,
                ContextCompat.getColor(getContext(), R.color.textBoxColor)
            )

        borderColor =
            typedArray.getColor(
                R.styleable.BobbleEditText_borderColor,
                ContextCompat.getColor(getContext(), R.color.borderColor)
            )

        borderWidth =
            typedArray.getDimension(
                R.styleable.BobbleEditText_borderWidth,
                resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._1sdp).toFloat()
            )

        setTheme(customTheme)

        if (cPadding > 0f) {
            setPadding(cPadding.toInt())
        } else {
            setPadding(
                cPaddingLeft.toInt(),
                cPaddingTop.toInt(),
                cPaddingRight.toInt(),
                cPaddingBottom.toInt()
            )
        }
        setTextBoxColor(textBoxColor)
        setRadius(cornerRadius)
        setBorderColor(borderColor)
        setBorderWidth(borderWidth)

        background = getShapeBackground(cornerRadius, textBoxColor, borderWidth, borderColor)
        typedArray.recycle()
    }

    fun setRadius(radius: Float) {
        if (cornerRadius != radius) {
            cornerRadius = radius
            background = getShapeBackground(radius, textBoxColor, borderWidth, borderColor)
        }

    }

    fun setBorderWidth(radius: Float) {
        if (borderWidth != radius) {
            borderWidth = radius
            background = getShapeBackground(cornerRadius, textBoxColor, radius, borderColor)
        }

    }

    fun setBorderColor(color: Int) {
        if (borderColor != color) {
            borderColor = color
            background = getShapeBackground(cornerRadius, textBoxColor, borderWidth, color)
        }
    }

    fun setTextBoxColor(color: Int) {
        if (textBoxColor != color) {
            textBoxColor = color
            background = getShapeBackground(cornerRadius, color, borderWidth, borderColor)
        }
    }

    override fun setTextColor(colors: Int) {
        super.setTextColor(colors)
    }

    fun setTheme(theme: String?) {
        return applyTheme(theme)
    }

    private fun getShapeBackground(
        radius: Float,
        boxColor: Int,
        border: Float,
        color: Int
    ): Drawable {

        val shape = GradientDrawable()

        shape.shape = GradientDrawable.RECTANGLE
        shape.cornerRadius = radius
        shape.setColor(boxColor)
        shape.setStroke(border.toInt(), color)
        return shape
    }
}