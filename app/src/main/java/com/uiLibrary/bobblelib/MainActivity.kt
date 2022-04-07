package com.uiLibrary.bobblelib

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.uiLibrary.bobblelib.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener {
            Toast.makeText(this,"This is a fab",Toast.LENGTH_SHORT).show()
        }
        binding.button.setRadius(20f)
        binding.button.isDarkTheme(true)

        binding.image.imageBackgroundColor(Color.parseColor("#FFA726"))
        binding.image.isDarkTheme(true)

        binding.fab.fabBorderColor(Color.parseColor("#FFA726"))
        binding.fab.maxImageSize(100f)
        binding.fab.fabCustomSize(200f)
        binding.fab.isDarkTheme(true)

        binding.card.cardBackGroundColor(Color.parseColor("#FFA726"))
        binding.card.cardCornerRadius(0f)
        binding.card.isDarkTheme(true)

        binding.edit.setRadius(0f)
        binding.edit.setBorderWidth(50f)
        binding.edit.borderColor(Color.parseColor("#FFA726"))
        binding.edit.textBoxColor(Color.parseColor("#FFA726"))
        binding.edit.isDarkTheme(true)

        binding.imgButton.setBackGroundColor(Color.parseColor("#FFA726"))
        binding.imgButton.isDarkTheme(true)

        binding.edit2.setText("Random")
        binding.edit2.setHint("Phone")
        binding.edit2.setInputType("password")
        binding.edit2.setLeftIcon(ContextCompat.getDrawable(this,R.drawable.save))

    }
}