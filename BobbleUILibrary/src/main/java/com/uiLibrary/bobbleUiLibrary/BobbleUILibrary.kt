package com.uiLibrary.bobbleUiLibrary

import android.content.Context
import android.util.AttributeSet


class BobbleUILibrary @JvmOverloads constructor
    (context: Context, attrs: AttributeSet? = null) {

    /**initializing variables for different bobble Ui Library components*/
    var bobbleButton: BobbleButton = BobbleButton(context, attrs)
    val bobbleFab: BobbleFab = BobbleFab(context, attrs)
    val bobbleCardView: BobbleCardView = BobbleCardView(context, attrs)
    val bobbleImageButton: BobbleImageButton = BobbleImageButton(context, attrs)
    val bobbleEditText: BobbleEditText = BobbleEditText(context, attrs)
    val bobbleTabLayout: BobbleTabLayout = BobbleTabLayout(context, attrs)
    val bobbleImageView: BobbleImageView = BobbleImageView(context, attrs)
    val bobbleCircleImageView: BobbleCircleImageView = BobbleCircleImageView(context, attrs)

}
