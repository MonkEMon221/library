package com.uiLibrary.bobbleUiLibrary

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.google.android.material.card.MaterialCardView
import com.uiLibrary.bobbleUiLibrary.R

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