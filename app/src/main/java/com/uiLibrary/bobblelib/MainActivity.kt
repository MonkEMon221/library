package com.uiLibrary.bobblelib

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.uiLibrary.bobblelib.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgButton.backgroundColor(ColorStateList.valueOf(Color.CYAN))
        binding.fab.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.ic_search))



//        binding.button.buttonCornerRadius(0f)
//        binding.button.backgroundColor(ColorStateList.valueOf(Color.CYAN))
//        binding.button.buttonTextColor(ColorStateList.valueOf(Color.BLACK))
//        binding.button.setTheme("dark")
//        binding.button.setEnable(false)

//        binding.image.setBackgroundColor(Color.parseColor("#FFA726"))

//        binding.image.setTheme("dark")
//
//        binding.fab.backgroundTintList = ColorStateList.valueOf(Color.BLUE)
//        binding.fab.maxImageSize(40f)
//        binding.fab.fabCustomSize(90f)
//        binding.fab.setTheme("dark")

//        binding.card.cardBackGroundColor(Color.parseColor("#FFA726"))
//        binding.card.cardCornerRadius(0f)
//        binding.card.setTheme("dark")

//        binding.edit.setRadius(0f)
//        binding.edit.setBorderWidth(2f)
//        binding.edit.borderColor(Color.parseColor("#E05021"))
//        binding.edit.textBoxColor(Color.parseColor("#FFA726"))
//        binding.edit.setTheme("dark")

//        binding.imgButton.backgroundColor(ColorStateList.valueOf(Color.GRAY))
//        binding.imgButton.setTheme("dark")


    }
}