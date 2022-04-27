package com.uiLibrary.bobbleUiLibrary

import android.content.Context
import android.util.AttributeSet

class BobbleUILibrary @JvmOverloads constructor
    (context: Context, attrs: AttributeSet? = null) {

    //initializing variables for different bobble Ui Library components

    val bobbleButton: BobbleButton
    val bobbleFab: BobbleFab
    val bobbleCardView: BobbleCardView
    val bobbleImageButton: BobbleImageButton
    val bobbleEditText: BobbleEditText
    val bobbleTabLayout: BobbleTabLayout
    val bobbleImageView: BobbleImageView

    init {
        bobbleButton = BobbleButton(context, attrs)    //Extending class BobbleButton
        bobbleFab = BobbleFab(context, attrs)    //Extending class BobbleFab
        bobbleCardView = BobbleCardView(context, attrs)    //Extending class BobbleCardView
        bobbleImageButton = BobbleImageButton(context, attrs)    //Extending class BobbleImageButton
        bobbleEditText = BobbleEditText(context, attrs)    //Extending class BobbleEditText
        bobbleTabLayout = BobbleTabLayout(context, attrs)    //Extending class BobbleTabLayout
        bobbleImageView = BobbleImageView(context, attrs)    //Extending class BobbleImageView
    }
}
