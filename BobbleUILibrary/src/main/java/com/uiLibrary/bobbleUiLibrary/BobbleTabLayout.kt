package com.uiLibrary.bobbleUiLibrary

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout
import com.uiLibrary.bobbleUiLibrary.R

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
        setTheme(customTheme)
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

    fun setIndicatorColor(color: Int) {
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

    fun setTheme(theme: String?) {
        return applyTheme(theme)
    }
}