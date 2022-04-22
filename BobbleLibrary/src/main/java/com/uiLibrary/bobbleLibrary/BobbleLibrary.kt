package com.uiLibrary.bobbleLibrary

import android.app.ActionBar
import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.*
import android.graphics.drawable.Drawable
import android.graphics.drawable.VectorDrawable
import android.media.Image
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.core.view.setMargins
import androidx.core.view.setPadding
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import java.lang.reflect.Type
import java.util.*

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
        context.theme.obtainStyledAttributes(attrs, R.styleable.BobbleButton, 0, 0)

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
            typedArray.getDimension(R.styleable.BobbleButton_cornerRadius, dpToPx(context, 30f))
        buttonCornerRadius(radius)

        padding =
            typedArray.getDimension(R.styleable.BobbleButton_android_padding, 0f)

        paddingTop =
            typedArray.getDimension(
                R.styleable.BobbleButton_android_paddingTop,
                dpToPx(context, 8f)
            )
        paddingBottom =
            typedArray.getDimension(
                R.styleable.BobbleButton_android_paddingBottom,
                dpToPx(context, 8f)
            )
        paddingLeft =
            typedArray.getDimension(
                R.styleable.BobbleButton_android_paddingLeft,
                dpToPx(context, 24f)
            )
        paddingRight =
            typedArray.getDimension(
                R.styleable.BobbleButton_android_paddingRight,
                dpToPx(context, 24f)
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
        if (tint == null) {
            text = ContextCompat.getColorStateList(context, R.color.text_color)
        } else {
            text = tint
        }
        setTextColor(text)
    }

    fun backgroundColor(tintList: ColorStateList?) {
        if (tintList == null) {
            backgroundTint = ContextCompat.getColorStateList(context, R.color.button_background)
        } else {
            backgroundTint = tintList
        }
        backgroundTintList = backgroundTint
    }

    fun setEnable(enable: Boolean) {
        if (isEnabled != enable) {
            isEnabled = enable
        }
    }
}

//Fab Library
class BobbleFab @JvmOverloads constructor
    (context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) :
    FloatingActionButton(context, attrs, defStyle) {
    //attrs
    private val fabCustomSize: Float
    private val maxImageSize: Float
    private var borderBackgroundColor: Int
    private var fabIcon: Drawable?
    private var customTheme: String?
    private val typedArray: TypedArray =
        context.obtainStyledAttributes(attrs, R.styleable.BobbleFab, 0, 0)

    init {

        val size = dpToPx(context, 75f)
        val iconSize = dpToPx(context, 40f)

        //preDefined fab size
        fabCustomSize = typedArray.getDimension(R.styleable.BobbleFab_fabCustomSize, size)
        fabCustomSize(fabCustomSize)

        //preDefined fab image size
        maxImageSize = typedArray.getDimension(R.styleable.BobbleFab_maxImageSize, iconSize)
        maxImageSize(maxImageSize)

        //setting up different border color for different theme
        customTheme = typedArray.getString(R.styleable.BobbleFab_customTheme)
        setBackgroundColor(R.color.purple_200)
        borderBackgroundColor = typedArray.getColor(
            R.styleable.BobbleFab_backgroundTint,
            ContextCompat.getColor(context, R.color.borderBackground)
        )
        backgroundTintList = ColorStateList.valueOf(borderBackgroundColor)

        //preDefined fab image
        fabIcon = typedArray.getDrawable(R.styleable.BobbleFab_android_src)
        setImageDrawable(fabIcon)
        setTheme(customTheme)
        typedArray.recycle()
    }

    fun maxImageSize(size: Float) {
        setMaxImageSize(size.toInt())
    }

    fun fabCustomSize(size: Float) {
        customSize = size.toInt()
    }

    fun setTheme(theme: String?) {
        return applyTheme(theme)
    }
}

//CardView Library
class BobbleCardView @JvmOverloads constructor
    (context: Context, attrs: AttributeSet? = null) :
    MaterialCardView(context, attrs) {
    //attrs
    private val cardBackgroundColor: Int
    private var customTheme: String?
    private val cardRadius: Float
    private val typedArray: TypedArray =
        context.obtainStyledAttributes(attrs, R.styleable.BobbleCardView, 0, 0)

    init {

        //preDefined cardView Radius
        cardRadius = typedArray.getDimension(
            R.styleable.BobbleCardView_cardCornerRadius,
            dpToPx(context, 10f)
        )
        cardCornerRadius(cardRadius)

        customTheme = typedArray.getString(R.styleable.BobbleCardView_customTheme)

        //card background color based on different theme.
        cardBackgroundColor =
            typedArray.getColor(
                R.styleable.BobbleCardView_cardBackgroundColor,
                ContextCompat.getColor(getContext(), R.color.imageBackground)
            )
        cardBackGroundColor(cardBackgroundColor)
        backgroundTintList = null

        setTheme(customTheme)
        typedArray.recycle()
    }

    fun cardBackGroundColor(color: Int) {
        setCardBackgroundColor(color)
    }

    fun cardCornerRadius(radius: Float) {
        setRadius(radius)
    }

    fun setTheme(theme: String?) {
        return applyTheme(theme)
    }

}

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
        if (tint == null) {
            background = ContextCompat.getColorStateList(context, R.color.button_background)
        } else {
            background = tint
        }
        backgroundTintList = background
    }

    fun setEnable(enable: Boolean) {
        if (isEnabled != enable) {
            isEnabled = enable
        }
    }
}

// TabLayout Library
class BobbleTabLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    TabLayout(context, attrs, defStyleAttr), TabLayout.OnTabSelectedListener {
    private var customTheme: String?
    private var tabText: Int
    private var tabSelectedText: Int
    private var tabIndicatorColor: Int
    private var boldText: Boolean
    private var selectedTabBold: Boolean
    private val textSize: Float
    private var background: Int
    private val typedArray =
        context.theme.obtainStyledAttributes(
            attrs, R.styleable.BobbleTabLayout, 0, 0
        )

    init {

        customTheme =
            typedArray.getString(R.styleable.BobbleTabLayout_customTheme)

        //different tabText color/selected tab text color based on different themes.
        tabText =
            typedArray.getColor(
                R.styleable.BobbleTabLayout_tabTextColor,
                ContextCompat.getColor(getContext(), R.color.tabTextColor)
            )

        tabSelectedText =
            typedArray.getColor(
                R.styleable.BobbleTabLayout_tabSelectedTextColor,
                ContextCompat.getColor(getContext(), R.color.tabSelectedTextColor)
            )

        //preDefined tab indicator color
        tabIndicatorColor =
            typedArray.getColor(
                R.styleable.BobbleTabLayout_tabIndicatorColor,
                ContextCompat.getColor(getContext(), R.color.indicatorColor)
            )
        setSelectedTabIndicatorColor(tabIndicatorColor)

        //set tab text as bold
        boldText =
            typedArray.getBoolean(R.styleable.BobbleTabLayout_boldText, false)

        //set selected tab text as Bold
        selectedTabBold =
            typedArray.getBoolean(R.styleable.BobbleTabLayout_selectedTabBoldText, false)

        //predefined textSize
        textSize =
            typedArray.getDimension(
                R.styleable.BobbleTabLayout_android_textSize,
                12f
            )

        background = typedArray.getColor(
            R.styleable.BobbleTabLayout_android_background,
            ContextCompat.getColor(getContext(), R.color.tabBackground)
        )
        setBackgroundColor(background)

        typedArray.recycle()
        setTheme(customTheme)
        addOnTabSelectedListener(this)
    }

    override fun addTab(tab: Tab, position: Int, setSelected: Boolean) {
        super.addTab(tab, position, setSelected)
        val layout = LayoutInflater.from(context).inflate(R.layout.tab_custom, null) as View
        val text = layout.findViewById<TextView>(R.id.text1)
        val image = layout.findViewById<ImageView>(R.id.imageLeft)
        image.setImageDrawable(tab.icon)
        text.text = tab.text
        text.setTextColor(tabText)
        text.textSize = textSize
        if (boldText)
            text.setTypeface(text.typeface, Typeface.BOLD)
        tab.customView = layout
    }

    override fun onTabSelected(tab: Tab?) {
        val textView = tab!!.customView as LinearLayout
        val text = textView.findViewById<TextView>(R.id.text1)
        text.setTextColor(tabSelectedText)
        if (selectedTabBold) {
            text?.setTypeface(null, Typeface.BOLD)
        }
    }

    override fun onTabUnselected(tab: Tab?) {
        val textView = tab!!.customView as LinearLayout
        val text = textView.findViewById<TextView>(R.id.text1)
        text.setTextColor(tabText)
        if (selectedTabBold) {
            text?.setTypeface(null, Typeface.NORMAL)
        }
    }

    override fun onTabReselected(tab: Tab?) {

    }

    fun setTextColor(color: Int) {
        if (tabText != color) {
            tabText = color
        }
    }

    fun setSelectedTabTextColor(color: Int) {
        if (tabSelectedText != color) {
            tabSelectedText = color
        }
    }

    fun setIndicatorColor(color: Int) {
        if (tabIndicatorColor != color) {
            tabIndicatorColor = color
        }
        super.setSelectedTabIndicatorColor(color)
    }

    fun setTabTextBold(boolean: Boolean) {
        if (boldText != boolean) {
            boldText = boolean
        }
    }

    fun setSelectedTabTextBold(boolean: Boolean) {
        if (selectedTabBold != boolean) {
            selectedTabBold = boolean
        }
    }

    fun setTheme(theme: String?) {
        return applyTheme(theme)
    }
}

//Image Library
class BobbleImage @JvmOverloads constructor(
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
        setImage1Drawable(src1)

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
        setImage2Drawable(src2)

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

    fun setImage1Color(color: Int, mode: PorterDuff.Mode) {
        image1.setColorFilter(ContextCompat.getColor(context, color), mode)
    }

    fun setImage1Drawable(id: Drawable?) {
        image1.setImageDrawable(id)
    }

    fun setTranslationZImage1(value: Float) {
        image1.translationZ = value
    }

    fun setColorFilter1(boolean: Boolean) {
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
            RIGHT -> lp1.gravity = Gravity.RIGHT
            LEFT -> lp1.gravity = Gravity.LEFT
            FILL -> lp1.gravity = Gravity.FILL
            FILL_HORIZONTAL -> lp1.gravity = Gravity.FILL_HORIZONTAL
            FILL_VERTICAL -> lp1.gravity = Gravity.FILL_VERTICAL
            NO_GRAVITY -> lp1.gravity = Gravity.NO_GRAVITY
        }
    }

    /** image2 functions*/

    fun setImage2Color(color: Int, mode: PorterDuff.Mode) {
        image2.setColorFilter(ContextCompat.getColor(context, color), mode)
    }

    fun setImage2Drawable(id: Drawable?) {
        image2.setImageDrawable(id)
    }

    fun setTranslationZImage2(value: Float) {
        image2.translationZ = value
    }

    fun setColorFilter2(boolean: Boolean) {
        if (image2HasColorFilter != boolean) {
            image2HasColorFilter = boolean
        }
    }

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




