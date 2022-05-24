package com.uiLibrary.bobbleUiLibrary

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

//Fab Library
class BobbleFab @JvmOverloads constructor
    (context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) :
    FloatingActionButton(context, attrs, defStyle) {
    //attrs
    private val fabCustomSize: Float
    private val maxImageSize: Float
    private var borderBackgroundColor: ColorStateList?
    private var fabIcon: Drawable?
    private var customTheme: String?
    private val typedArray: TypedArray =
        context.obtainStyledAttributes(attrs, R.styleable.BobbleFab, 0, 0)

    init {

        isClickable = true
        isFocusable = true

        val size = resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._75sdp)
        val iconSize = resources.getDimensionPixelSize(com.intuit.sdp.R.dimen._40sdp)

        //preDefined fab size
        fabCustomSize = typedArray.getDimension(R.styleable.BobbleFab_fabCustomSize, size.toFloat())
        fabCustomSize(fabCustomSize)

        //preDefined fab image size
        maxImageSize = typedArray.getDimension(R.styleable.BobbleFab_maxImageSize,
            iconSize.toFloat()
        )
        maxImageSize(maxImageSize)

        //setting up different border color for different theme
        customTheme = typedArray.getString(R.styleable.BobbleFab_customTheme)

        borderBackgroundColor =
            typedArray.getColorStateList(
                R.styleable.BobbleFab_backgroundTint
            )
        fabBackgroundColor(borderBackgroundColor)

        //preDefined fab image
        fabIcon = typedArray.getDrawable(R.styleable.BobbleFab_android_src)
        setImageDrawable(fabIcon)
        setTheme(customTheme)
        typedArray.recycle()
    }

    fun maxImageSize(size: Float) {
        setMaxImageSize(size.toInt())
    }

    fun fabBackgroundColor(tintList: ColorStateList?) {
        borderBackgroundColor =
            tintList ?: ContextCompat.getColorStateList(context, R.color.indicatorColor)
        backgroundTintList = borderBackgroundColor
    }

    fun fabCustomSize(size: Float) {
        customSize = size.toInt()
    }

    fun setTheme(theme: String?) {
        return applyTheme(theme)
    }
}