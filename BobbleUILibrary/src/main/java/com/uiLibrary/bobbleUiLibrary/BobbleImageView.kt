package com.uiLibrary.bobbleUiLibrary

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.annotation.RequiresApi
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
    private var scaleTypeImage1: ImageView.ScaleType?
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
    private var scaleTypeImage2: ImageView.ScaleType?
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

        src1 = typedArray.getDrawable(R.styleable.BobbleImage_srcPrimary)
        setDrawableImagePrimary(src1)

        image1HasColorFilter =
            typedArray.getBoolean(
                R.styleable.BobbleImage_enableColorFilterPrimary,
                image1HasColorFilter
            )

        imageColor1 = typedArray.getColor(
            R.styleable.BobbleImage_imageColorPrimary,
            ContextCompat.getColor(getContext(), R.color.imageColor)
        )
        if (image1HasColorFilter) {
            image1.setColorFilter(imageColor1, PorterDuff.Mode.SRC_ATOP)
        } else {
            image1.colorFilter = null
        }

        translationZImage1 =
            typedArray.getDimension(R.styleable.BobbleImage_translationZImagePrimary, 0f)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setTranslationZPrimary(translationZImage1)
        }


        gravityImage1 = typedArray.getString(R.styleable.BobbleImage_gravityImagePrimary)
        setGravityImagePrimary(gravityImage1)

        scaleTypeImage1 =
            ImageView.ScaleType.values()[typedArray.getInt(
                R.styleable.BobbleImage_scaleTypePrimary,
                3
            )]
        setScaleTypeImagePrimary(scaleTypeImage1)

        marginImage1 =
            typedArray.getDimension(R.styleable.BobbleImage_marginImagePrimary, 0f)

        marginTopImage1 =
            typedArray.getDimension(
                R.styleable.BobbleImage_marginTopImagePrimary, 0f
            )

        marginBottomImage1 =
            typedArray.getDimension(
                R.styleable.BobbleImage_marginBottomImagePrimary, 0f
            )

        marginLeftImage1 =
            typedArray.getDimension(
                R.styleable.BobbleImage_marginLeftImagePrimary, 0f
            )

        marginRightImage1 =
            typedArray.getDimension(
                R.styleable.BobbleImage_marginRightImagePrimary, 0f
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

        src2 = typedArray.getDrawable(R.styleable.BobbleImage_srcSecondary)
        setDrawableImageSecondary(src2)

        image2HasColorFilter =
            typedArray.getBoolean(
                R.styleable.BobbleImage_enableColorFilterSecondary,
                image2HasColorFilter
            )
        imageColor2 = typedArray.getColor(
            R.styleable.BobbleImage_imageColorSecondary,
            ContextCompat.getColor(getContext(), R.color.imageColor)
        )
        if (image2HasColorFilter) {
            image2.setColorFilter(imageColor2, PorterDuff.Mode.SRC_ATOP)
        } else {
            image2.colorFilter = null
        }

        translationZImage2 =
            typedArray.getDimension(R.styleable.BobbleImage_translationZImageSecondary, 0f)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setTranslationZSecondary(translationZImage2)
        }

        gravityImage2 = typedArray.getString(R.styleable.BobbleImage_gravityImageSecondary)
        setGravityImageSecondary(gravityImage2)

        scaleTypeImage2 =
            ImageView.ScaleType.values()[typedArray.getInt(
                R.styleable.BobbleImage_scaleTypeSecondary,
                3
            )]
        setScaleTypeImageSecondary(scaleTypeImage2)

        marginImage2 =
            typedArray.getDimension(R.styleable.BobbleImage_marginImageSecondary, 0f)

        marginTopImage2 =
            typedArray.getDimension(
                R.styleable.BobbleImage_marginTopImageSecondary, 0f
            )

        marginBottomImage2 =
            typedArray.getDimension(
                R.styleable.BobbleImage_marginBottomImageSecondary, 0f
            )

        marginLeftImage2 =
            typedArray.getDimension(
                R.styleable.BobbleImage_marginLeftImageSecondary, 0f
            )

        marginRightImage2 =
            typedArray.getDimension(
                R.styleable.BobbleImage_marginRightImageSecondary, 0f
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

        if (translationZImage1 > translationZImage2) {
            image2.visibility = GONE
        } else if (translationZImage2 > translationZImage1) {
            image1.visibility = GONE
        }

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

    fun setColorImagePrimary(color: Int, mode: PorterDuff.Mode) {
        image1.setColorFilter(ContextCompat.getColor(context, color), mode)
    }

    fun setDrawableImagePrimary(id: Drawable?) {
        image1.setImageDrawable(id)
    }

    fun setPrimaryImageWithGlide(
        context: Context,
        imagePath: String,
        placeholder: Drawable?,
        error: Drawable?
    ) {

        Glide.with(context).load(imagePath).placeholder(placeholder)
            .error(error).into(image1)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun setTranslationZPrimary(value: Float) {
        image1.translationZ = value
    }

    fun enableColorFilterPrimary(boolean: Boolean) {
        if (image1HasColorFilter != boolean) {
            image1HasColorFilter = boolean
        }
    }

    fun setGravityImagePrimary(gravity: String?) {
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

    fun setScaleTypeImagePrimary(scaleType: ImageView.ScaleType?) {
        image1.scaleType = scaleType
    }


    /** image2 functions*/

    fun setColorImageSecondary(color: Int, mode: PorterDuff.Mode) {
        image2.setColorFilter(ContextCompat.getColor(context, color), mode)
    }

    fun setDrawableImageSecondary(id: Drawable?) {
        image2.setImageDrawable(id)
    }

    fun setSecondaryImageWithGlide(
        context: Context,
        imagePath: String,
        placeholder: Drawable?,
        error: Drawable?
    ) {
        Glide.with(context).load(imagePath).placeholder(placeholder)
            .error(error).into(image2)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun setTranslationZSecondary(value: Float) {
        image2.translationZ = value
    }

    fun enableColorFilterSecondary(boolean: Boolean) {
        if (image2HasColorFilter != boolean) {
            image2HasColorFilter = boolean
        }
    }

    @SuppressLint("RtlHardcoded")
    fun setGravityImageSecondary(gravity: String?) {
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

    fun setScaleTypeImageSecondary(scaleType: ImageView.ScaleType?) {
        image2.scaleType = scaleType
    }

}