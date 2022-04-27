package com.uiLibrary.bobbleUiLibrary

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat

//EditText Library
class BobbleEditText @JvmOverloads constructor
    (context: Context, attrs: AttributeSet? = null) :
    AppCompatEditText(context, attrs) {

    companion object {
        private const val BORDER_OFFSET = 4f
    }

    private val rectF = RectF()
    private val paint = Paint()
    private val borderPaint = Paint()

    //attrs
    private var textColor: Int
    private var cornerRadius: Float
    private var textBoxColor: Int
    private var borderColor: Int
    private var borderWidth: Float
    private var customTheme: String?
    private val typedArray =
        context.theme.obtainStyledAttributes(attrs, R.styleable.BobbleEditText, 0, 0)

    init {
        isClickable = true
        isFocusable = true

        cornerRadius =
            typedArray.getDimension(R.styleable.BobbleEditText_corner_radius, dpToPx(context, 30f))

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
        background = null

        borderColor =
            typedArray.getColor(
                R.styleable.BobbleEditText_borderColor,
                ContextCompat.getColor(getContext(), R.color.borderColor)
            )

        borderWidth =
            typedArray.getDimension(R.styleable.BobbleEditText_borderWidth, dpToPx(context, 1f))

        setTheme(customTheme)
        typedArray.recycle()
    }

    //create editBox with adjustable border radius
    override fun onDraw(canvas: Canvas?) {
        canvas ?: return
        initPaint()
        val offset = 0f
        val radius = cornerRadius
        rectF.set(offset, offset, width.toFloat() - offset, height.toFloat() - offset)
        canvas.drawRoundRect(rectF, radius, radius, paint)
        drawBorder(canvas)
        super.onDraw(canvas)
    }

    private fun initPaint() {
        paint.style = Paint.Style.FILL
        paint.color = textBoxColor
        paint.isAntiAlias = false
    }

    //   create border for edittext box
    private fun drawBorder(canvas: Canvas) {
        initBorderPaint()
        canvas.drawRoundRect(
            BORDER_OFFSET,
            BORDER_OFFSET,
            width.toFloat() - BORDER_OFFSET,
            height.toFloat() - BORDER_OFFSET,
            cornerRadius,
            cornerRadius,
            borderPaint
        )
    }

    private fun initBorderPaint() {
        borderPaint.style = Paint.Style.STROKE
        borderPaint.strokeWidth = borderWidth
        borderPaint.color = borderColor
        borderPaint.isAntiAlias = true
    }

    fun setRadius(radius: Float) {
        if (cornerRadius != radius) {
            cornerRadius = radius
            invalidate()
        }
    }

    fun setBorderWidth(radius: Float) {
        if (borderWidth != radius) {
            borderWidth = radius
            invalidate()
        }
    }

    fun borderColor(color: Int) {
        if (borderColor != color) {
            borderColor = color
            invalidate()
        }
    }

    fun textBoxColor(color: Int) {
        if (textBoxColor != color) {
            textBoxColor = color
            invalidate()
        }
    }

    override fun setTextColor(colors: Int) {
        super.setTextColor(colors)
    }

    fun setTheme(theme: String?) {
        return applyTheme(theme)
    }
}