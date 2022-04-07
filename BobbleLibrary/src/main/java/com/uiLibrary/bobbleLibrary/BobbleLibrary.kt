package com.uiLibrary.bobbleLibrary

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.*
import android.graphics.drawable.Drawable
import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.text.InputType
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.children
import androidx.core.view.setPadding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout

//dp value to pixel value function
fun dpToPx(context: Context, dp: Float): Float {
    return dp * (
            context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
}


//Button Library
class BobbleButton @JvmOverloads constructor
    (context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) :
    AppCompatButton(context, attrs, defStyle) {

    private val rectF = RectF()
    private val paint = Paint()

    //    attrs
    private var buttonCornerRadius: Float
    private var buttonBackgroundColor: Int
    private var isDarkTheme: Boolean
    private val textColor: Int
    private val typedArray: TypedArray =
        context.theme.obtainStyledAttributes(attrs, R.styleable.BobbleButton, 0, 0)

    init {
        buttonCornerRadius =
            typedArray.getDimension(R.styleable.BobbleButton_circle_radius, dpToPx(context, 0f))

        isDarkTheme =
            typedArray.getBoolean(R.styleable.BobbleButton_isDarkTheme, false)

        //set different text color for different theme
        textColor = if (!isDarkTheme) {
            typedArray.getColor(
                R.styleable.BobbleButton_android_textColor,
                ContextCompat.getColor(getContext(), R.color.black)
            )
        } else {
            typedArray
                .getColor(
                    R.styleable.BobbleButton_android_textColor,
                    ContextCompat.getColor(getContext(), R.color.white)
                )
        }
        setTextColor(textColor)

        //set different background colors for different theme
        buttonBackgroundColor =
            if (!isDarkTheme) {
                typedArray
                    .getColor(
                        R.styleable.BobbleButton_buttonColor,
                        ContextCompat.getColor(getContext(), R.color.teal_200)
                    )
            } else {
                typedArray
                    .getColor(
                        R.styleable.BobbleButton_buttonColor,
                        ContextCompat.getColor(getContext(), R.color.dark_grey)
                    )
            }
        typedArray.recycle()
    }

    //draw button with adjustable radius
    override fun onDraw(canvas: Canvas?) {
        canvas ?: return
        initPaint()
        val offset = 0f
        val radius = buttonCornerRadius
        rectF.set(offset, offset, width.toFloat() - offset, height.toFloat() - offset)
        canvas.drawRoundRect(rectF, radius, radius, paint)
        super.onDraw(canvas)
    }

    private fun initPaint() {
        paint.style = Paint.Style.FILL
        paint.color = buttonBackgroundColor
        paint.isAntiAlias = true
    }

    fun setRadius(radius: Float) {
        if (buttonCornerRadius != radius) {
            buttonCornerRadius = radius
            invalidate()
        }
    }

    fun isDarkTheme(enable: Boolean) {
        if (this.isDarkTheme != enable) {
            this.isDarkTheme = enable
            invalidate()
            requestLayout()
        }
    }

    fun buttonBackgroundColor(color: Int) {
        this.buttonBackgroundColor = color
        invalidate()
    }
}

//Image Library
class BobbleImage @JvmOverloads constructor
    (context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) :
    AppCompatImageView(context, attrs, defStyle) {

    //attrs
    private val padding: Float
    private var background: Int
    private var isDarkTheme: Boolean
    private val typedArray =
        context.theme.obtainStyledAttributes(attrs, R.styleable.BobbleImage, 0, 0)

    init {
        isDarkTheme = typedArray.getBoolean(R.styleable.BobbleImage_isDarkTheme, false)

        //set different background colors for different theme
        background = if (!isDarkTheme) {
            typedArray.getColor(
                R.styleable.BobbleImage_backgroundColor,
                ContextCompat.getColor(getContext(), R.color.white)
            )
        } else {
            typedArray.getColor(
                R.styleable.BobbleImage_backgroundColor,
                ContextCompat.getColor(getContext(), R.color.dark_grey)
            )
        }

        imageBackgroundColor(background)

        //setting up predefined padding for the image view
        padding = typedArray.getDimension(R.styleable.BobbleImage_padding, dpToPx(context, 16f))
        setPadding(padding.toInt(), padding.toInt(), padding.toInt(), padding.toInt())

    }

    fun imageBackgroundColor(color: Int) {
        setBackgroundColor(color)
        invalidate()
    }

    fun isDarkTheme(enable: Boolean) {
        if (this.isDarkTheme != enable) {
            this.isDarkTheme = enable
            invalidate()
            requestLayout()
        }
    }
}

//Fab Library
class BobbleFab @JvmOverloads constructor
    (context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) :
    FloatingActionButton(context, attrs, defStyle) {
    //attrs
    private val fabCustomSize: Float
    private val mazImageSize: Float
    private var isDarkTheme: Boolean
    private val borderBackgroundColor: Int
    private var fabIcon: Drawable?
    private val typedArray: TypedArray =
        context.obtainStyledAttributes(attrs, R.styleable.BobbleFab, 0, 0)

    init {

        val size = dpToPx(context, 75f)
        val iconSize = dpToPx(context, 40f)

        //preDefined fab size
        fabCustomSize = typedArray.getDimension(R.styleable.BobbleFab_fabCustomSize, size)
        fabCustomSize(fabCustomSize)

        //preDefined fab image size
        mazImageSize = typedArray.getDimension(R.styleable.BobbleFab_maxImageSize, iconSize)
        maxImageSize(mazImageSize)

        //setting up different border color for different theme
        isDarkTheme = typedArray.getBoolean(R.styleable.BobbleFab_isDarkTheme, false)
        borderBackgroundColor = if (!isDarkTheme) {
            typedArray.getColor(
                R.styleable.BobbleFab_backgroundTint,
                ContextCompat.getColor(getContext(), R.color.blue_Gray)
            )
        } else {
            typedArray.getColor(
                R.styleable.BobbleFab_backgroundTint,
                ContextCompat.getColor(getContext(), R.color.grey)
            )
        }
        fabBorderColor(borderBackgroundColor)

        //preDefined fab image
        fabIcon = typedArray.getDrawable(R.styleable.BobbleFab_android_src)
        fabIcon = ContextCompat.getDrawable(getContext(), R.drawable.add_cam)
        setImageDrawable(fabIcon)
        typedArray.recycle()
    }

    fun fabBorderColor(color: Int) {
        backgroundTintList = ColorStateList.valueOf(color)
    }

    fun maxImageSize(size: Float) {
        setMaxImageSize(size.toInt())
    }

    fun fabCustomSize(size: Float) {
        customSize = size.toInt()
    }

    fun isDarkTheme(enable: Boolean) {
        if (this.isDarkTheme != enable) {
            this.isDarkTheme = enable
            invalidate()
            requestLayout()
        }
    }
}

//CardView Library
class BobbleCardView @JvmOverloads constructor
    (context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) :
    CardView(context, attrs, defStyle) {
    //attrs
    private val cardBackgroundColor: Int
    private var isDarkTheme: Boolean
    private val cardRadius: Float
    private val typedArray: TypedArray =
        context.obtainStyledAttributes(attrs, R.styleable.BobbleCardView, 0, 0)

    init {

        //preDefined cardView Radius
        cardRadius = typedArray.getDimension(
            R.styleable.BobbleCardView_cardCornerRadius,
            dpToPx(context, 30f)
        )
        cardCornerRadius(cardRadius)

        isDarkTheme = typedArray.getBoolean(R.styleable.BobbleCardView_isDarkTheme, false)

        //card background color based on different theme.
        cardBackgroundColor = if (!isDarkTheme) {
            typedArray.getColor(
                R.styleable.BobbleCardView_cardBackgroundColor,
                ContextCompat.getColor(getContext(), R.color.white)
            )
        } else {
            typedArray.getColor(
                R.styleable.BobbleCardView_cardBackgroundColor,
                ContextCompat.getColor(getContext(), R.color.dark_grey)
            )
        }
        cardBackGroundColor(cardBackgroundColor)
        backgroundTintList = null

        typedArray.recycle()
    }

    fun cardBackGroundColor(color: Int) {
        setCardBackgroundColor(color)
    }

    fun cardCornerRadius(radius: Float) {
        setRadius(radius)
    }

    fun isDarkTheme(enable: Boolean) {
        if (this.isDarkTheme != enable) {
            this.isDarkTheme = enable
            invalidate()
            requestLayout()
        }
    }
}

//EditText Library
class BobbleRoundCornerEditText @JvmOverloads constructor
    (context: Context, attrs: AttributeSet? = null) :
    AppCompatEditText(context, attrs) {

    companion object {
        private const val BORDER_OFFSET = 1F
    }

    private val rectF = RectF()
    private val paint = Paint()
    private val borderPaint = Paint()

    //attrs
    private var cornerRadius: Float
    private var textBoxColor: Int
    private var borderColor: Int
    private var borderWidth: Float
    private var isDarkTheme: Boolean
    private val typedArray =
        context.theme.obtainStyledAttributes(attrs, R.styleable.BobbleEditText, 0, 0)

    init {
        cornerRadius =
            typedArray.getDimension(R.styleable.BobbleEditText_corner_radius, dpToPx(context, 30f))

        isDarkTheme = typedArray.getBoolean(R.styleable.BobbleEditText_isDarkTheme, false)

        //text box color based on different themes
        textBoxColor = if (!isDarkTheme) {
            typedArray.getColor(
                R.styleable.BobbleEditText_textBoxColor,
                ContextCompat.getColor(getContext(), R.color.white)
            )
        } else {
            typedArray.getColor(
                R.styleable.BobbleEditText_textBoxColor,
                ContextCompat.getColor(getContext(), R.color.dark_grey)
            )
        }
        background = null

        //border color based on different themes
        borderColor = if (!isDarkTheme) {
            typedArray.getColor(
                R.styleable.BobbleEditText_borderColor,
                ContextCompat.getColor(getContext(), R.color.black)
            )
        } else {
            typedArray.getColor(
                R.styleable.BobbleEditText_borderColor,
                ContextCompat.getColor(getContext(), R.color.white)
            )
        }

        borderWidth =
            typedArray.getDimension(R.styleable.BobbleEditText_borderWidth, dpToPx(context, 3f))

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

    //create border for edittext box
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
        borderPaint.isAntiAlias = false
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

    fun isDarkTheme(enable: Boolean) {
        if (this.isDarkTheme != enable) {
            this.isDarkTheme = enable
            invalidate()
            requestLayout()
        }
    }
}

//ImageButton Library
class BobbleImageButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) :
    AppCompatImageButton(context, attrs) {
    //attrs
    private var isDarkTheme: Boolean
    private val background: Int
    private val typedArray =
        context.theme.obtainStyledAttributes(attrs, R.styleable.BobbleImageButton, 0, 0)

    init {
        isDarkTheme = typedArray.getBoolean(R.styleable.BobbleImageButton_isDarkTheme, false)

        //imageButton background color based on different themes
        background = if (!isDarkTheme) {
            typedArray.getColor(
                R.styleable.BobbleImageButton_buttonBackGround,
                ContextCompat.getColor(getContext(), R.color.white)
            )
        } else {
            typedArray.getColor(
                R.styleable.BobbleImageButton_buttonBackGround,
                ContextCompat.getColor(getContext(), R.color.dark_grey)
            )
        }
        setBackGroundColor(background)

        typedArray.recycle()
    }

    fun setBackGroundColor(color: Int) {
        backgroundTintList = ColorStateList.valueOf(color)
    }

    fun isDarkTheme(enable: Boolean) {
        if (this.isDarkTheme != enable) {
            this.isDarkTheme = enable
            invalidate()
            requestLayout()
        }
    }
}

//ImageEdittext Library
class BobbleImageEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    RelativeLayout(context, attrs, defStyleAttr) {
    private var editText: EditText
    private var leftIcon: ImageView
    private var rightIcon: ImageView
    private var layout: RelativeLayout

    init {
        inflate(context, R.layout.layout, this)
        editText = findViewById(R.id.edit_text)
        leftIcon = findViewById(R.id.image_view)
        rightIcon = findViewById(R.id.error_image_view)
        layout = findViewById(R.id.layout)
        if (attrs != null) {
            val typedArray =
                context.theme.obtainStyledAttributes(attrs, R.styleable.BobbleImageEditText, 0, 0)

            val text: String? = typedArray.getString(R.styleable.BobbleImageEditText_text)
            val leftIcon: Drawable? =
                typedArray.getDrawable(R.styleable.BobbleImageEditText_leftIcon)
            val rightIcon: Drawable? =
                typedArray.getDrawable(R.styleable.BobbleImageEditText_rightIcon)
            val maxLength: Int = typedArray.getInt(R.styleable.BobbleImageEditText_maxLength, 50)
            val hint: String? = typedArray.getString(R.styleable.BobbleImageEditText_editTextHint)
            val inputType: String? = typedArray.getString(R.styleable.BobbleImageEditText_inputType)

            setBackgroundColor(
                Color.TRANSPARENT
            )
            typedArray.recycle()
            setLeftIcon(leftIcon)
            setHint(hint)
            setRightIcon(rightIcon)
            setMaxLength(maxLength)
            setInputType(inputType)
            setText(text)

        }
    }

    fun setText(text: String?) {
        editText.setText(text)
    }

    fun setMaxLength(maxLength: Int) {
        val filterArray = arrayOfNulls<InputFilter>(1)
        filterArray[0] = LengthFilter(maxLength)
        editText.filters = filterArray
    }

    fun setInputType(input: String?) {
        when (input) {
            "email" -> editText.inputType =
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS or InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            "password" -> {
                editText.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                editText.typeface = editText.typeface
            }
            "phone" -> editText.inputType = InputType.TYPE_CLASS_PHONE
            "name" -> editText.inputType =
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
        }
    }

    fun setRightIcon(icon: Drawable?) {
        if (icon == null) {
            rightIcon.visibility = GONE
        } else {
            rightIcon.visibility = VISIBLE
            rightIcon.setImageDrawable(icon)
        }
    }

    fun setHint(hint: String?) {
        editText.hint = hint
    }

    fun setLeftIcon(image: Drawable?) {
        if (image == null) {
            leftIcon.visibility = GONE
        } else {
            leftIcon.setImageDrawable(image)
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
    private var isDarkTheme: Boolean
    private var tabText: Int
    private var tabSelectedText: Int
    private var tabIndicatorColor: Int
    private var boldText: Boolean
    private var selectedTabBold: Boolean
    private val textSize: Float
    private val padding: Float
    private val paddingTop: Float
    private val paddingBottom: Float
    private val paddingLeft: Float
    private val paddingRight: Float
    private val typedArray =
        context.theme.obtainStyledAttributes(
            attrs, R.styleable.BobbleTabLayout, 0, 0
        )

    init {

        isDarkTheme =
            typedArray.getBoolean(R.styleable.BobbleTabLayout_isDarkTheme, false)

        //different tabText color/selected tab text color based on different themes.
        if (isDarkTheme) {
            tabText =
                typedArray.getColor(
                    R.styleable.BobbleTabLayout_tabTextColor,
                    ContextCompat.getColor(getContext(), R.color.lightGrey)
                )

            tabSelectedText =
                typedArray.getColor(
                    R.styleable.BobbleTabLayout_tabSelectedTextColor,
                    ContextCompat.getColor(getContext(), R.color.white)
                )

        } else {
            tabText =
                typedArray.getColor(
                    R.styleable.BobbleTabLayout_tabTextColor,
                    ContextCompat.getColor(getContext(), R.color.lightGrey)
                )

            tabSelectedText =
                typedArray.getColor(
                    R.styleable.BobbleTabLayout_tabSelectedTextColor,
                    ContextCompat.getColor(getContext(), R.color.black)
                )

        }

        //preDefined tab indicator color
        tabIndicatorColor =
            typedArray.getColor(
                R.styleable.BobbleTabLayout_tabIndicatorColor,
                ContextCompat.getColor(getContext(), R.color.teal_700)
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
                dpToPx(context, 5f)
            )

        padding =
            typedArray.getDimension(R.styleable.BobbleTabLayout_android_padding, 0f)

        paddingTop =
            typedArray.getDimension(
                R.styleable.BobbleTabLayout_android_paddingTop,
                dpToPx(context, 12f)
            )
        paddingBottom =
            typedArray.getDimension(
                R.styleable.BobbleTabLayout_android_paddingBottom,
                dpToPx(context, 12f)
            )
        paddingLeft =
            typedArray.getDimension(
                R.styleable.BobbleTabLayout_android_paddingLeft,
                dpToPx(context, 12f)
            )
        paddingRight =
            typedArray.getDimension(
                R.styleable.BobbleTabLayout_android_paddingRight,
                dpToPx(context, 12f)
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

        addOnTabSelectedListener(this)
    }

    override fun addTab(tab: Tab, position: Int, setSelected: Boolean) {
        super.addTab(tab, position, setSelected)

        val textView = LayoutInflater.from(context).inflate(R.layout.custom_tab, null) as TextView
        textView.text = tab.text

        textView.setTextColor(tabText)
        textView.textSize = textSize
        if (boldText)
            textView.setTypeface(textView.typeface, Typeface.BOLD)

        tab.customView = textView
    }

    override fun onTabSelected(tab: Tab?) {
        val textView = tab!!.customView as TextView?
        textView?.setTextColor(tabSelectedText)
        if (selectedTabBold) {
            textView?.setTypeface(null, Typeface.BOLD)
        }
    }

    override fun onTabUnselected(tab: Tab?) {
        val textView = tab!!.customView as TextView?
        textView?.setTextColor(tabText)
        if (selectedTabBold) {
            textView?.setTypeface(null, Typeface.NORMAL)
        }
    }

    override fun onTabReselected(tab: Tab?) {
    }

    fun isDarkTheme(boolean: Boolean) {
        if (isDarkTheme != boolean) {
            isDarkTheme = boolean
        }
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
}






