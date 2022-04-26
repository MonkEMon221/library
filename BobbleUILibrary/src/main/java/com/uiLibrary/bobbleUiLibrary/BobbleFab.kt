package com.uiLibrary.bobbleUiLibrary

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.uiLibrary.bobbleUiLibrary.R

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