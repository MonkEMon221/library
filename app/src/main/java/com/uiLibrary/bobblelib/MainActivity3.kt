package com.uiLibrary.bobblelib

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.uiLibrary.bobbleUiLibrary.BobbleButton
import com.uiLibrary.bobbleUiLibrary.BobbleUILibrary

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        addButton()
        addImageButton()
        addEdittext()
        addFab()
        addCard()
        addImageView()
        addTab()

    }

    private fun addButton() {
        val ll: LinearLayout = findViewById(R.id.rootLayout)
        val btn = BobbleUILibrary(this)
        btn.bobbleButton.setText("New Button")
        btn.bobbleButton.buttonCornerRadius(0f)
        btn.bobbleButton.backgroundColor(ColorStateList.valueOf(Color.CYAN))
        btn.bobbleButton.buttonTextColor(ColorStateList.valueOf(Color.BLACK))
        btn.bobbleButton.setEnable(false)
        btn.bobbleButton.setTheme("default")
        ll.addView(btn.bobbleButton)
    }

    private fun addImageButton() {
        val ll: LinearLayout = findViewById(R.id.rootLayout)
        val imgBtn = BobbleUILibrary(this)
        imgBtn.bobbleImageButton.layoutParams = ViewGroup.LayoutParams(200, 200)
        imgBtn.bobbleImageButton.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.add_cam
            )
        )
        imgBtn.bobbleImageButton.backgroundColor(ColorStateList.valueOf(Color.GREEN))
        imgBtn.bobbleImageButton.setEnable(true)
        imgBtn.bobbleImageButton.setTheme("default")
        ll.addView(imgBtn.bobbleImageButton)
    }

    private fun addEdittext() {
        val ll: LinearLayout = findViewById(R.id.rootLayout)
        val edtxt = BobbleUILibrary(this)
        edtxt.bobbleEditText.setHint("Enter A Text")
        edtxt.bobbleEditText.setRadius(30f)
        edtxt.bobbleEditText.setBorderWidth(50f)
        edtxt.bobbleEditText.setTextColor(Color.RED)
        edtxt.bobbleEditText.borderColor(Color.parseColor("#E05021"))
        edtxt.bobbleEditText.textBoxColor(Color.parseColor("#6200EE"))
        edtxt.bobbleEditText.setTheme("default")
        ll.addView(edtxt.bobbleEditText)
    }

    private fun addCard() {
        val ll: LinearLayout = findViewById(R.id.rootLayout)
        val card = BobbleUILibrary(this)
        card.bobbleCardView.layoutParams = ViewGroup.LayoutParams(200, 200)
        card.bobbleCardView.cardCornerRadius(0f)
        card.bobbleCardView.cardBackGroundColor(Color.parseColor("#6200EE"))
        card.bobbleCardView.setTheme("default")
        ll.addView(card.bobbleCardView)
    }

    private fun addFab() {
        val ll: LinearLayout = findViewById(R.id.rootLayout)
        val fab = BobbleUILibrary(this)
        fab.bobbleFab.maxImageSize(100f)
        fab.bobbleFab.fabCustomSize(200f)
        fab.bobbleFab.backgroundTintList = ColorStateList.valueOf(Color.BLUE)
        fab.bobbleFab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_search))
        fab.bobbleFab.setTheme("default")
        ll.addView(fab.bobbleFab)
    }

    private fun addImageView() {
        val ll: LinearLayout = findViewById(R.id.rootLayout)
        val img = BobbleUILibrary(this)
        img.bobbleImageView.setDrawableImage1(ContextCompat.getDrawable(this, R.drawable.animal))
        img.bobbleImageView.setDrawableImage2(ContextCompat.getDrawable(this, R.drawable.animal2))
        img.bobbleImageView.backgroundColor(Color.parseColor("#3ffaaa"))
        img.bobbleImageView.setColorImage1(R.color.purple_200, PorterDuff.Mode.SRC_ATOP)
        img.bobbleImageView.setColorImage2(
            R.color.purple_500,
            PorterDuff.Mode.SRC_ATOP
        )
        img.bobbleImageView.setGravityImage2("center")
        img.bobbleImageView.setGravityImage1("center")
        img.bobbleImageView.setTranslationZImage2(4f)
        img.bobbleImageView.setTranslationZImage1(3f)
        img.bobbleImageView.enableColorFilter1(true)
        img.bobbleImageView.enableColorFilter2(true)
        img.bobbleImageView.setTheme("default")
        ll.addView(img.bobbleImageView)
    }

    private fun addTab(){
        val ll:LinearLayout = findViewById(R.id.rootLayout)
        val tab = BobbleUILibrary(this)
        tab.bobbleTabLayout.setIndicatorColor(Color.parseColor("#def56a"))
        tab.bobbleTabLayout.setTextColor(Color.parseColor("#FFA726"))
        tab.bobbleTabLayout.setSelectedTabTextColor(Color.parseColor("#FFA726"))
        tab.bobbleTabLayout.setIndicatorColor(Color.parseColor("#def56a"))
        tab.bobbleTabLayout.setTabTextBold(true)
        tab.bobbleTabLayout.setSelectedTabTextBold(true)
        tab.bobbleTabLayout.setTheme("default")
        ll.addView(tab.bobbleTabLayout)

    }
}