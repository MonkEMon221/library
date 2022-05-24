package com.uiLibrary.bobbleUiLibrary

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView


class BobbleCircleImageView @JvmOverloads constructor
    (context: Context, attrs: AttributeSet? = null) : AppCompatImageView(context, attrs) {


    private val drawableRect = RectF()
    private val borderRect = RectF()

    private val shaderMatrix = Matrix()

    private val bitmapPaint = Paint()
    private val borderPaint = Paint()
    private val circleBackgroundPaint = Paint()

    private var borderColor = DEFAULT_BORDER_COLOR
    private var borderWidth = DEFAULT_BORDER_WIDTH
    private var circleBackgroundColor = DEFAULT_CIRCLE_BACKGROUND_COLOR

    private var bitmap: Bitmap? = null
    private var bitmapCanvas: Canvas? = null

    private var drawableRadius = 0f
    private var borderRadius = 0f

    private var initialized = false
    private var rebuildShader = false
    private var drawableDirty = false

    init {
        val typedArray =
            context.theme.obtainStyledAttributes(attrs, R.styleable.BobbleCircleImageView, 0, 0)
        borderWidth = typedArray.getDimensionPixelSize(
            R.styleable.BobbleCircleImageView_borderWidth,
            DEFAULT_BORDER_WIDTH
        )
        borderColor =
            typedArray.getColor(R.styleable.BobbleCircleImageView_borderColor, DEFAULT_BORDER_COLOR)
        circleBackgroundColor = typedArray.getColor(
            R.styleable.BobbleCircleImageView_backgroundColor,
            DEFAULT_CIRCLE_BACKGROUND_COLOR
        )
        typedArray.recycle()
        init()
    }

    private fun init() {
        initialized = true
        bitmapPaint.isAntiAlias = true
        bitmapPaint.isDither = true
        bitmapPaint.isFilterBitmap = true
        bitmapPaint.alpha = DEFAULT_IMAGE_ALPHA

        borderPaint.style = Paint.Style.STROKE
        borderPaint.isAntiAlias = true
        borderPaint.color = borderColor
        borderPaint.strokeWidth = borderWidth.toFloat()

        circleBackgroundPaint.style = Paint.Style.FILL
        circleBackgroundPaint.isAntiAlias = true
        circleBackgroundPaint.color = circleBackgroundColor
    }


    @SuppressLint("CanvasSize")
    override fun onDraw(canvas: Canvas) {

        if (circleBackgroundColor != Color.TRANSPARENT) {
            canvas.drawCircle(
                drawableRect.centerX(),
                drawableRect.centerY(),
                drawableRadius,
                circleBackgroundPaint
            )
        }
        if (bitmap != null) {
            if (drawableDirty && bitmapCanvas != null) {
                drawableDirty = false
                val drawable = drawable
                drawable.setBounds(0, 0, bitmapCanvas!!.width, bitmapCanvas!!.height)
                drawable.draw(bitmapCanvas!!)
            }
            if (rebuildShader) {
                rebuildShader = false
                val bitmapShader =
                    BitmapShader(bitmap!!, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
                bitmapShader.setLocalMatrix(shaderMatrix)
                bitmapPaint.shader = bitmapShader
            }
            canvas.drawCircle(
                drawableRect.centerX(),
                drawableRect.centerY(),
                drawableRadius,
                bitmapPaint
            )
        }
        if (borderWidth > 0) {
            canvas.drawCircle(
                borderRect.centerX(),
                borderRect.centerY(),
                borderRadius,
                borderPaint
            )
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        updateDimensions()
        invalidate()
    }

    fun setBorderColor(color: Int) {
        if (borderColor == color) {
            return
        }
        borderColor = color
        borderPaint.color = borderColor
        invalidate()
    }

    fun setCircleBackgroundColor(color: Int) {
        if (color == circleBackgroundColor) {
            return
        }
        circleBackgroundColor = color
        circleBackgroundPaint.color = color
        invalidate()
    }

    fun setBorderWidth(width: Int) {
        if (width == borderWidth) {
            return
        }
        borderWidth = width
        borderPaint.strokeWidth = width.toFloat()
        updateDimensions()
        invalidate()
    }

    override fun setImageResource(resId: Int) {
        super.setImageResource(resId)
        initializeBitmap()
        invalidate()
    }

    override fun setImageBitmap(bm: Bitmap?) {
        super.setImageBitmap(bm)
        initializeBitmap()
    }

    override fun setImageURI(uri: Uri?) {
        super.setImageURI(uri)
        initializeBitmap()
    }

    override fun setImageDrawable(drawable: Drawable?) {
        super.setImageDrawable(drawable)
        initializeBitmap()
        invalidate()
    }

    private fun getBitmapFromDrawable(drawable: Drawable?): Bitmap? {
        if (drawable == null) {
            return null
        }
        return if (drawable is BitmapDrawable) {
            drawable.bitmap
        } else try {
            val bitmap: Bitmap = if (drawable is ColorDrawable) {
                Bitmap.createBitmap(COLOR_DRAWABLE_DIMENSION, COLOR_DRAWABLE_DIMENSION, BITMAP_CONFIG)
            } else {
                Bitmap.createBitmap(
                    drawable.intrinsicWidth,
                    drawable.intrinsicHeight,
                    BITMAP_CONFIG
                )
            }
            val canvas = Canvas(bitmap)
            drawable.setBounds(0, 0, canvas.width, canvas.height)
            drawable.draw(canvas)
            bitmap
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    private fun initializeBitmap() {
        bitmap = getBitmapFromDrawable(drawable)
        bitmapCanvas = if (bitmap != null && bitmap!!.isMutable) {
            Canvas(bitmap!!)
        } else {
            null
        }
        if (!initialized) {
            return
        }
        if (bitmap != null) {
            updateBitmapSize()
        } else {
            bitmapPaint.shader = null
        }
    }

    private fun updateDimensions() {
        borderRect.set(calculateBounds())
        borderRadius =
            ((borderRect.height() - borderWidth) / 2.0f).coerceAtMost((borderRect.width() - borderWidth) / 2.0f)
        drawableRect.set(borderRect)
        if (borderWidth > 0) {
            drawableRect.inset(borderWidth - 1.0f, borderWidth - 1.0f)
        }
        drawableRadius = (drawableRect.height() / 2.0f).coerceAtMost(drawableRect.width() / 2.0f)
        updateBitmapSize()
    }

    private fun calculateBounds(): RectF {
        val imageWidth = width - paddingLeft - paddingRight
        val imageHeight = height - paddingTop - paddingBottom
        val diameter = imageWidth.coerceAtMost(imageHeight)
        val left = paddingLeft + (imageWidth - diameter) / 2f
        val top = paddingTop + (imageHeight - diameter) / 2f
        return RectF(left, top, left + diameter, top + diameter)
    }

    private fun updateBitmapSize() {
        if (bitmap == null) {
            return
        }
        val scale: Float
        var dx = 0f
        var dy = 0f

        shaderMatrix.set(null)
        val bitmapHeight = bitmap!!.height
        val bitmapWidth = bitmap!!.width

        if (bitmapWidth * drawableRect.height() > drawableRect.width() * bitmapHeight) {
            scale = drawableRect.height() / bitmapHeight.toFloat()
            dx = (drawableRect.width() - bitmapWidth * scale) * 0.5f
        } else {
            scale = drawableRect.width() / bitmapWidth.toFloat()
            dy = (drawableRect.height() - bitmapHeight * scale) * 0.5f
        }
        shaderMatrix.setScale(scale, scale)
        shaderMatrix.postTranslate(
            (dx + 0.5f).toInt() + drawableRect.left,
            (dy + 0.5f).toInt() + drawableRect.top
        )
        rebuildShader = true
    }

    companion object {
        private val BITMAP_CONFIG = Bitmap.Config.ARGB_8888

        private const val COLOR_DRAWABLE_DIMENSION = 2
        private const val DEFAULT_BORDER_WIDTH = 0
        private const val DEFAULT_BORDER_COLOR = Color.BLACK
        private const val DEFAULT_CIRCLE_BACKGROUND_COLOR = Color.TRANSPARENT
        private const val DEFAULT_IMAGE_ALPHA = 255
    }
}