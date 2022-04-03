package com.vishesh.mylibrary

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.drawable.Drawable
import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.text.InputType
import android.util.AttributeSet
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout

//Button Library
class BobbleButton @JvmOverloads constructor
    (context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) :
    AppCompatButton(context, attrs, defStyle) {

    //    attrs
    private val rectF = RectF()
    private val paint = Paint()
    private val buttonCornerRadius: Float
    private val buttonBackgroundColor: Int
    private val typedArray: TypedArray =
        context.theme.obtainStyledAttributes(attrs, R.styleable.BobbleButton, 0, 0)

    init {
        buttonCornerRadius =
            typedArray.getDimension(R.styleable.BobbleButton_circle_radius, 50f)
        buttonBackgroundColor = typedArray
            .getColor(
                R.styleable.BobbleButton_buttonColor,
                ContextCompat.getColor(getContext(), R.color.teal_200)
            )
        initPaint()
        typedArray.recycle()
    }

    override fun onDraw(canvas: Canvas?) {
        canvas ?: return
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
}

//Image Library
class BobbleImage @JvmOverloads constructor
    (context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) :
    AppCompatImageView(context, attrs, defStyle) {

    //attrs
    private val padding: Float
    private val typedArray =
        context.theme.obtainStyledAttributes(attrs, R.styleable.BobbleImage, 0, 0)

    init {

        padding = typedArray.getDimension(R.styleable.BobbleImage_padding, 20f)
        setPadding(padding.toInt(), padding.toInt(), padding.toInt(), padding.toInt())
    }
}

//Fab Library
class BobbleFab @JvmOverloads constructor
    (context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) :
    FloatingActionButton(context, attrs, defStyle) {
    //attrs
    private val borderBackgroundColor: Int
    private var fabIcon: Drawable?
    private val typedArray: TypedArray =
        context.obtainStyledAttributes(attrs, R.styleable.BobbleFab, 0, 0)

    init {

        borderBackgroundColor = typedArray.getColor(
            R.styleable.BobbleFab_FabBorderColor,
            ContextCompat.getColor(getContext(), R.color.white)
        )
        backgroundTintList = ColorStateList.valueOf(borderBackgroundColor)

        fabIcon = typedArray.getDrawable(R.styleable.BobbleFab_FabIcon)
        setImageDrawable(fabIcon)
        typedArray.recycle()
    }
}

//CardView Library
class BobbleCardView @JvmOverloads constructor
    (context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) :
    CardView(context, attrs, defStyle) {
    //attrs

    private val cardRadius: Float
    private val typedArray: TypedArray =
        context.obtainStyledAttributes(attrs, R.styleable.BobbleCardView, 0, 0)

    init {
        cardRadius = typedArray.getDimension(R.styleable.BobbleCardView_cardCornerRadius, 35f)
        radius = cardRadius
        typedArray.recycle()
    }
}

//EditText Library
class BobbleEditText @JvmOverloads constructor
    (context: Context, attrs: AttributeSet? = null) :
    AppCompatEditText(context, attrs) {

    //attrs
    companion object {
        private const val BORDER_OFFSET = 1F
    }

    private val rectF = RectF()
    private val paint = Paint()
    private val cornerRadius: Float
    private val textBoxColor: Int
    private val borderColor: Int
    private val borderPaint = Paint()
    private val borderWidth: Float
    private val typedArray =
        context.theme.obtainStyledAttributes(attrs, R.styleable.BobbleEditText, 0, 0)

    init {
        cornerRadius = typedArray.getDimension(R.styleable.BobbleEditText_corner_radius, 35f)
        textBoxColor = typedArray.getColor(
            R.styleable.BobbleEditText_textBoxColor,
            ContextCompat.getColor(getContext(), R.color.white)
        )
        borderColor = typedArray.getColor(
            R.styleable.BobbleEditText_borderColor,
            ContextCompat.getColor(getContext(), R.color.black)
        )
        borderWidth = typedArray.getDimension(R.styleable.BobbleEditText_borderWidth, 2f)

        initPaint()
        typedArray.recycle()
    }

    override fun onDraw(canvas: Canvas?) {
        canvas ?: return
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
        paint.isAntiAlias = true
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
}

//ImageButton Library
class BobbleImageButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) :
    AppCompatImageButton(context, attrs) {
    //attrs
    private val background: Int
    private val typedArray =
        context.theme.obtainStyledAttributes(attrs, R.styleable.BobbleImageButton, 0, 0)

    init {
        background = typedArray.getColor(
            R.styleable.BobbleImageButton_buttonBackGround,
            ContextCompat.getColor(getContext(), R.color.black)
        )
        backgroundTintList = ColorStateList.valueOf(background)
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
            var text: String? = ""
            var rightIcon: Drawable? = null
            var leftIcon: Drawable? = null
            var hint: String? = ""
            var inputType: String? = ""
            var maxLength = 0
            try {
                text = typedArray.getString(R.styleable.BobbleImageEditText_text)
                leftIcon = typedArray.getDrawable(R.styleable.BobbleImageEditText_leftIcon)
                rightIcon = typedArray.getDrawable(R.styleable.BobbleImageEditText_rightIcon)
                maxLength = typedArray.getInt(R.styleable.BobbleImageEditText_maxLength, 50)
                hint = typedArray.getString(R.styleable.BobbleImageEditText_editTextHint)
                inputType = typedArray.getString(R.styleable.BobbleImageEditText_inputType)
            } catch (e: Exception) {
                Log.e("StyleInputEditText", "There was an error loading attributes.")
            } finally {
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
    }

    private fun setText(text: String?) {
        editText.setText(text)
    }

    private fun setMaxLength(maxLength: Int) {
        val filterArray = arrayOfNulls<InputFilter>(1)
        filterArray[0] = LengthFilter(maxLength)
        editText.filters = filterArray
    }

    private fun setInputType(input: String?) {
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

    private fun setRightIcon(icon: Drawable?) {
        if (icon == null) {
            rightIcon.visibility = GONE
        } else {
            rightIcon.visibility = VISIBLE
            rightIcon.setImageDrawable(icon)
        }
    }

    private fun setHint(hint: String?) {
        editText.hint = hint
    }

    private fun setLeftIcon(image: Drawable?) {
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
    TabLayout(context, attrs, defStyleAttr) {
    private val tabText: Int
    private val tabSelectedText: Int
    private val typedArray =
        context.theme.obtainStyledAttributes(
            attrs, R.styleable.BobbleTabLayout, 0, 0
        )

    init {
        tabText = typedArray.getColor(R.styleable.BobbleTabLayout_tabTextColor,
        ContextCompat.getColor(getContext(),R.color.grey))
        tabTextColors = ColorStateList.valueOf(tabText)

        tabSelectedText = typedArray.getColor(R.styleable.BobbleTabLayout_tabSelectedTextColor,
        ContextCompat.getColor(getContext(), R.color.black))

        if (isSelected){
            tabTextColors = ColorStateList.valueOf(tabSelectedText)
        }
    }


}






