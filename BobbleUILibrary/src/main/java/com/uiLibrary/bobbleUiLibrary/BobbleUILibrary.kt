package com.uiLibrary.bobbleUiLibrary

import android.content.Context
import android.util.AttributeSet

class BobbleUILibrary@JvmOverloads constructor
    (context: Context, attrs: AttributeSet? = null) {
    private val button:BobbleButton
    private val fab: BobbleFab
    private val cardView:BobbleCardView
    private val imageButton:BobbleImageButton
    private val editText:BobbleEditText
    private val tabLayout:BobbleTabLayout
    private val imageView:BobbleImageView

    init {
        button = BobbleButton(context,attrs)
        fab = BobbleFab(context,attrs)
        cardView = BobbleCardView(context,attrs)
        imageButton = BobbleImageButton(context,attrs)
        editText = BobbleEditText(context, attrs)
        tabLayout = BobbleTabLayout(context, attrs)
        imageView = BobbleImageView(context, attrs)
    }
}