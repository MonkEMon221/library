package com.uiLibrary.bobbleUiLibrary

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import androidx.appcompat.widget.AppCompatTextView


class BobbleTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatTextView(context, attrs) {

    private val minSize: Float
    private val maxSize: Float
    private var mTestPaint: Paint? = null

    private val typedArray =
        context.theme.obtainStyledAttributes(attrs, R.styleable.BobbleTextView, 0, 0)

    init {
        minSize = typedArray.getDimension(
            R.styleable.BobbleTextView_minTextSize, resources.getDimensionPixelSize(
                com.intuit.sdp.R.dimen._8sdp
            ).toFloat()
        )
        maxSize = typedArray.getDimension(R.styleable.BobbleTextView_maxTextSize, textSize)

        mTestPaint = Paint()
        mTestPaint!!.set(this.paint)

        typedArray.recycle()
    }


    private fun refitText(text: String, textWidth: Int) {
        if (textWidth <= 0) return
        val targetWidth = textWidth - this.paddingLeft - this.paddingRight
        var hi = maxSize
        var lo = minSize
        val threshold = 0.5f
        mTestPaint!!.set(this.paint)
        while (hi - lo > threshold) {
            val size = (hi + lo) / 2
            mTestPaint!!.textSize = size
            if (mTestPaint!!.measureText(text) >= targetWidth) hi = size
            else lo = size
        }

        this.setTextSize(TypedValue.COMPLEX_UNIT_PX, lo)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val parentWidth = MeasureSpec.getSize(widthMeasureSpec)
        val height = measuredHeight
        refitText(this.text.toString(), parentWidth)
        setMeasuredDimension(parentWidth, height)
    }

    override fun onTextChanged(text: CharSequence, start: Int, before: Int, after: Int) {
        refitText(text.toString(), this.width)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        if (w != oldw) {
            refitText(this.text.toString(), w)
        }
    }
}