package com.uiLibrary.bobbleUiLibrary

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout


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
    private var tabIndicatorHeight: Float
    private var tabIndicatorMargin: Float
    private var tabIndicatorRadius: Float
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

        tabIndicatorHeight =
            typedArray.getDimension(
                R.styleable.BobbleTabLayout_indicatorHeight, resources.getDimensionPixelSize(
                    com.intuit.sdp.R.dimen._5sdp
                ).toFloat()
            )

        tabIndicatorMargin =
            typedArray.getDimension(
                R.styleable.BobbleTabLayout_tabIndicatorMargin, resources.getDimensionPixelSize(
                    com.intuit.sdp.R.dimen._25sdp
                ).toFloat()
            )

        tabIndicatorRadius =
            typedArray.getDimension(
                R.styleable.BobbleTabLayout_tabIndicatorRadius, resources.getDimensionPixelSize(
                    com.intuit.sdp.R.dimen._15sdp
                ).toFloat()
            )

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

        wrapTabIndicatorToTitle(this, tabIndicatorMargin.toInt(), tabIndicatorMargin.toInt())
        setSelectedTabIndicator(indicator(tabIndicatorHeight.toInt()))
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

    fun setIndicatorHeight(height: Float) {
        if (tabIndicatorHeight != height) {
            tabIndicatorHeight = height
        }
    }

    fun setIndicatorMargin(margin: Float) {
        if (tabIndicatorMargin != margin) {
            tabIndicatorMargin = margin
        }
    }

    fun setIndicatorRadius(radius: Float) {
        if (tabIndicatorRadius != radius) {
            tabIndicatorRadius = radius
        }
    }

    fun setTheme(theme: String?) {
        return applyTheme(theme)
    }

    private fun indicator(height: Int): Drawable {
        val shape = GradientDrawable()
        shape.shape = GradientDrawable.RECTANGLE
        shape.cornerRadius = tabIndicatorRadius
        shape.setColor(tabIndicatorColor)
        shape.setSize(0, height)
        return shape
    }

    private fun wrapTabIndicatorToTitle(
        tabLayout: TabLayout,
        externalMargin: Int,
        internalMargin: Int
    ) {
        val tabStrip = tabLayout.getChildAt(0)
        if (tabStrip is ViewGroup) {
            val childCount = tabStrip.childCount
            for (i in 0 until childCount) {
                val tabView = tabStrip.getChildAt(i)
                //set minimum width to 0 for instead for small texts, indicator is not wrapped as expected
                tabView.minimumWidth = 0
                // set padding to 0 for wrapping indicator as title
                tabView.setPadding(0, tabView.paddingTop, 0, tabView.paddingBottom)
                // setting custom margin between tabs
                if (tabView.layoutParams is MarginLayoutParams) {
                    val layoutParams = tabView.layoutParams as MarginLayoutParams
                    when (i) {
                        0 -> {
                            // left
                            settingMargin(layoutParams, externalMargin, internalMargin)
                        }
                        childCount - 1 -> {
                            // right
                            settingMargin(layoutParams, internalMargin, externalMargin)
                        }
                        else -> {
                            // internal
                            settingMargin(layoutParams, internalMargin, internalMargin)
                        }
                    }
                }
            }
            tabLayout.requestLayout()
        }
    }

    private fun settingMargin(layoutParams: MarginLayoutParams, start: Int, end: Int) {
        layoutParams.marginStart = start
        layoutParams.marginEnd = end
        layoutParams.leftMargin = start
        layoutParams.rightMargin = end
    }
}