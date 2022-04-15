package com.uiLibrary.bobbleLibrary

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.*
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout

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

//Button Library
class BobbleButton @JvmOverloads constructor
    (context: Context, attrs: AttributeSet? = null) :
    MaterialButton(context, attrs) {

    //    attrs
    private var backgroundTint: ColorStateList?
    private var radius: Float
    private var textColor: ColorStateList?

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
            typedArray.getColorStateList(R.styleable.BobbleButton_android_backgroundTint)

        backgroundTint = ContextCompat.getColorStateList(context, R.color.button_background)
        backgroundTintList = backgroundTint

        textColor = typedArray.getColorStateList(
            R.styleable.BobbleButton_android_textColor
        )
        textColor = ContextCompat.getColorStateList(context, R.color.text_color)
        setTextColor(textColor)

        radius = typedArray.getDimension(R.styleable.BobbleButton_cornerRadius, 100f)
        cornerRadius = radius.toInt()

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
        typedArray.recycle()
        getTheme(customTheme)
    }

    override fun setTextColor(colors: ColorStateList?) {
        super.setTextColor(colors)
    }

    fun getTheme(theme: String?) {
        return applyTheme(theme)
    }

}

//Image Library
class BobbleImage @JvmOverloads constructor
    (context: Context, attrs: AttributeSet? = null) :
    AppCompatImageView(context, attrs) {

    //attrs
    private val padding: Float
    private var background: Int
    private var customTheme: String?
    private val typedArray =
        context.theme.obtainStyledAttributes(attrs, R.styleable.BobbleImage, 0, 0)

    init {

        //set different background colors for different theme
        customTheme = typedArray.getString(R.styleable.BobbleImage_customTheme)
        background =
            typedArray.getColor(
                R.styleable.BobbleImage_backgroundColor,
                ContextCompat.getColor(getContext(), R.color.imageBackground)
            )
        setBackgroundColor(background)
        getTheme(customTheme)

        //setting up predefined padding for the image view
        padding =
            typedArray.getDimension(R.styleable.BobbleImage_android_padding, dpToPx(context, 16f))
        setPadding(padding.toInt(), padding.toInt(), padding.toInt(), padding.toInt())
    }


    fun getTheme(theme: String?) {
        return applyTheme(theme)
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
        fabIcon = ContextCompat.getDrawable(getContext(), R.drawable.add_cam)
        setImageDrawable(fabIcon)
        getTheme(customTheme)
        typedArray.recycle()
    }

    fun maxImageSize(size: Float) {
        setMaxImageSize(size.toInt())
    }

    fun fabCustomSize(size: Float) {
        customSize = size.toInt()
    }

    fun getTheme(theme: String?) {
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

        getTheme(customTheme)
        typedArray.recycle()
    }

    fun cardBackGroundColor(color: Int) {
        setCardBackgroundColor(color)
    }

    fun cardCornerRadius(radius: Float) {
        setRadius(radius)
    }

    fun getTheme(theme: String?) {
        return applyTheme(theme)
    }

}

//EditText Library
class BobbleRoundCornerEditText @JvmOverloads constructor
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

        getTheme(customTheme)
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

    fun getTheme(theme: String?) {
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
            typedArray.getColorStateList(R.styleable.BobbleImageButton_android_backgroundTint)
        background = ContextCompat.getColorStateList(context, R.color.button_background)
        backgroundTintList = background
        getTheme(customTheme)
        typedArray.recycle()
    }

    fun getTheme(theme: String?) {
        return applyTheme(theme)
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
        getTheme(customTheme)
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

    override fun setSelectedTabIndicatorColor(color: Int) {
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

    fun getTheme(theme: String?) {
        return applyTheme(theme)
    }
}






