package com.uiLibrary.bobbleUiLibrary

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.view.setMargins
import androidx.core.view.setPadding
import com.bumptech.glide.Glide

private const val CENTER = "center"
private const val CENTER_HORIZONTAL = "center_horizontal"
private const val CENTER_VERTICAL = "center_vertical"
private const val BOTTOM = "bottom"
private const val LEFT = "left"
private const val RIGHT = "right"
private const val TOP = "top"
private const val FILL = "fill"
private const val FILL_VERTICAL = "fill vertical"
private const val FILL_HORIZONTAL = "fill horizontal"
private const val NO_GRAVITY = "no gravity"

private val lp1 = FrameLayout.LayoutParams(
    FrameLayout.LayoutParams.WRAP_CONTENT,
    FrameLayout.LayoutParams.WRAP_CONTENT
)

private val lp2 = FrameLayout.LayoutParams(
    FrameLayout.LayoutParams.WRAP_CONTENT,
    FrameLayout.LayoutParams.WRAP_CONTENT
)

//Image Library
class BobbleImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private var background: Int
    private val padding: Float
    private val paddingTop: Float
    private val paddingBottom: Float
    private val paddingLeft: Float
    private val paddingRight: Float
    private val customTheme: String?

    private var src1: Drawable?
    private var imageColor1: Int
    private var image1HasColorFilter: Boolean = true
    private var translationZImage1: Float
    private var gravityImage1: String?
    private var marginImage1: Float
    private var marginTopImage1: Float
    private var marginBottomImage1: Float
    private var marginLeftImage1: Float
    private var marginRightImage1: Float

    private var src2: Drawable?
    private var image2HasColorFilter: Boolean = true
    private var imageColor2: Int
    private var translationZImage2: Float
    private var gravityImage2: String?
    private var marginImage2: Float
    private var marginTopImage2: Float
    private var marginBottomImage2: Float
    private var marginLeftImage2: Float
    private var marginRightImage2: Float

    private val typedArray =
        context.theme.obtainStyledAttributes(attrs, R.styleable.BobbleImage, 0, 0)
    private var image1: ImageView
    private var image2: ImageView
    private var layout: FrameLayout

    init {
        inflate(context, R.layout.image, this)
        layout = findViewById(R.id.layout)
        image1 = findViewById(R.id.image)
        image2 = findViewById(R.id.image1)

        customTheme = typedArray.getString(R.styleable.BobbleImage_customTheme)

        background = typedArray.getColor(
            R.styleable.BobbleImage_backgroundColor,
            ContextCompat.getColor(getContext(), R.color.imageBackground)
        )
        backgroundColor(background)

        padding =
            typedArray.getDimension(R.styleable.BobbleImage_android_padding, 0f)

        paddingTop =
            typedArray.getDimension(
                R.styleable.BobbleImage_android_paddingTop, 0f
            )

        paddingBottom =
            typedArray.getDimension(
                R.styleable.BobbleImage_android_paddingBottom, 0f
            )

        paddingLeft =
            typedArray.getDimension(
                R.styleable.BobbleImage_android_paddingLeft, 0f
            )

        paddingRight =
            typedArray.getDimension(
                R.styleable.BobbleImage_android_paddingRight, 0f
            )


        //preDefined padding
        if (padding > 0f) {
            layout.setPadding(padding.toInt())
        } else {
            layout.setPadding(
                paddingLeft.toInt(),
                paddingTop.toInt(),
                paddingRight.toInt(),
                paddingBottom.toInt()
            )
        }
        setTheme(customTheme)

        /**set Attributes for 1st image*/

        src1 = typedArray.getDrawable(R.styleable.BobbleImage_src1)
        setDrawableImage1(src1)

        image1HasColorFilter =
            typedArray.getBoolean(R.styleable.BobbleImage_enableColorFilter1, image1HasColorFilter)

        imageColor1 = typedArray.getColor(
            R.styleable.BobbleImage_imageColor1,
            ContextCompat.getColor(getContext(), R.color.imageColor)
        )
        if (image1HasColorFilter) {
            image1.setColorFilter(imageColor1, PorterDuff.Mode.SRC_ATOP)
        } else {
            image1.setColorFilter(null)
        }

        translationZImage1 = typedArray.getDimension(R.styleable.BobbleImage_translationZImage1, 0f)
        setTranslationZImage1(translationZImage1)

        gravityImage1 = typedArray.getString(R.styleable.BobbleImage_gravityImage1)
        setGravityImage1(gravityImage1)

        marginImage1 =
            typedArray.getDimension(R.styleable.BobbleImage_marginImage1, 0f)

        marginTopImage1 =
            typedArray.getDimension(
                R.styleable.BobbleImage_marginTopImage1, 0f
            )

        marginBottomImage1 =
            typedArray.getDimension(
                R.styleable.BobbleImage_marginBottomImage1, 0f
            )

        marginLeftImage1 =
            typedArray.getDimension(
                R.styleable.BobbleImage_marginLeftImage1, 0f
            )

        marginRightImage1 =
            typedArray.getDimension(
                R.styleable.BobbleImage_marginRightImage1, 0f
            )

        if (marginImage1 > 0) {
            lp1.setMargins(marginImage1.toInt())
        } else {
            lp1.setMargins(
                marginLeftImage1.toInt(),
                marginTopImage1.toInt(),
                marginRightImage1.toInt(),
                marginBottomImage1.toInt()
            )
        }
        image1.layoutParams = lp1


        /**set Attributes for 2nd image*/

        src2 = typedArray.getDrawable(R.styleable.BobbleImage_src2)
        setDrawableImage2(src2)

        image2HasColorFilter =
            typedArray.getBoolean(R.styleable.BobbleImage_enableColorFilter2, image2HasColorFilter)
        imageColor2 = typedArray.getColor(
            R.styleable.BobbleImage_imageColor2,
            ContextCompat.getColor(getContext(), R.color.imageColor)
        )
        if (image2HasColorFilter) {
            image2.setColorFilter(imageColor2, PorterDuff.Mode.SRC_ATOP)
        } else {
            image2.setColorFilter(null)
        }

        translationZImage2 = typedArray.getDimension(R.styleable.BobbleImage_translationZImage2, 0f)
        setTranslationZImage2(translationZImage2)

        gravityImage2 = typedArray.getString(R.styleable.BobbleImage_gravityImage2)
        setGravityImage2(gravityImage2)

        marginImage2 =
            typedArray.getDimension(R.styleable.BobbleImage_marginImage2, 0f)

        marginTopImage2 =
            typedArray.getDimension(
                R.styleable.BobbleImage_marginTopImage2, 0f
            )

        marginBottomImage2 =
            typedArray.getDimension(
                R.styleable.BobbleImage_marginBottomImage2, 0f
            )

        marginLeftImage2 =
            typedArray.getDimension(
                R.styleable.BobbleImage_marginLeftImage2, 0f
            )

        marginRightImage2 =
            typedArray.getDimension(
                R.styleable.BobbleImage_marginRightImage2, 0f
            )

        if (marginImage2 > 0) {
            lp2.setMargins(marginImage2.toInt())
        } else {
            lp2.setMargins(
                marginLeftImage2.toInt(),
                marginTopImage2.toInt(),
                marginRightImage2.toInt(),
                marginBottomImage2.toInt()
            )
        }
        image2.layoutParams = lp2

        typedArray.recycle()
    }

    /** layout functions*/
    fun backgroundColor(color: Int) {
        layout.setBackgroundColor(color)
    }

    fun setTheme(theme: String?) {
        return applyTheme(theme)
    }

    /** image1 functions*/

    fun setColorImage1(color: Int, mode: PorterDuff.Mode) {
        image1.setColorFilter(ContextCompat.getColor(context, color), mode)
    }

    fun setDrawableImage1(id: Drawable?) {
        image1.setImageDrawable(id)
    }

    fun setImage1WithGlide(context: Context, imagePath: String) {
        Glide.with(context).load(imagePath).centerCrop().skipMemoryCache(true).into(image1)
    }

    fun setTranslationZImage1(value: Float) {
        image1.translationZ = value
    }

    fun enableColorFilter1(boolean: Boolean) {
        if (image1HasColorFilter != boolean) {
            image1HasColorFilter = boolean
        }
    }

    fun setGravityImage1(gravity: String?) {
        when (gravity) {
            CENTER -> lp1.gravity = Gravity.CENTER
            CENTER_HORIZONTAL -> lp1.gravity = Gravity.CENTER_HORIZONTAL
            CENTER_VERTICAL -> lp1.gravity = Gravity.CENTER_VERTICAL
            BOTTOM -> lp1.gravity = Gravity.BOTTOM
            TOP -> lp1.gravity = Gravity.TOP
            RIGHT -> lp1.gravity = Gravity.END
            LEFT -> lp1.gravity = Gravity.START
            FILL -> lp1.gravity = Gravity.FILL
            FILL_HORIZONTAL -> lp1.gravity = Gravity.FILL_HORIZONTAL
            FILL_VERTICAL -> lp1.gravity = Gravity.FILL_VERTICAL
            NO_GRAVITY -> lp1.gravity = Gravity.NO_GRAVITY
        }
    }

    /** image2 functions*/

    fun setColorImage2(color: Int, mode: PorterDuff.Mode) {
        image2.setColorFilter(ContextCompat.getColor(context, color), mode)
    }

    fun setDrawableImage2(id: Drawable?) {
        image2.setImageDrawable(id)
    }

    fun setImage2WithGlide(context: Context, imagePath: String) {
        Glide.with(context).load(imagePath).fitCenter().skipMemoryCache(true).into(image2)
    }

    fun setTranslationZImage2(value: Float) {
        image2.translationZ = value
    }

    fun enableColorFilter2(boolean: Boolean) {
        if (image2HasColorFilter != boolean) {
            image2HasColorFilter = boolean
        }
    }

    @SuppressLint("RtlHardcoded")
    fun setGravityImage2(gravity: String?) {
        when (gravity) {
            CENTER -> lp2.gravity = Gravity.CENTER
            CENTER_HORIZONTAL -> lp2.gravity = Gravity.CENTER_HORIZONTAL
            CENTER_VERTICAL -> lp2.gravity = Gravity.CENTER_VERTICAL
            BOTTOM -> lp2.gravity = Gravity.BOTTOM
            TOP -> lp2.gravity = Gravity.TOP
            RIGHT -> lp2.gravity = Gravity.RIGHT
            LEFT -> lp2.gravity = Gravity.LEFT
            FILL -> lp2.gravity = Gravity.FILL
            FILL_HORIZONTAL -> lp2.gravity = Gravity.FILL_HORIZONTAL
            FILL_VERTICAL -> lp2.gravity = Gravity.FILL_VERTICAL
            NO_GRAVITY -> lp2.gravity = Gravity.NO_GRAVITY
        }
    }

}