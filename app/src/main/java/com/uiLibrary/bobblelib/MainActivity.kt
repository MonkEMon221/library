package com.uiLibrary.bobblelib

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.uiLibrary.bobblelib.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.fab.setOnClickListener {
            Toast.makeText(this, "This is a fab", Toast.LENGTH_SHORT).show()
        }
//        binding.button.setRadius(20f)
//        binding.button.buttonBackgroundColor(Color.TRANSPARENT)

//        binding.image.imageBackgroundColor(Color.parseColor("#FFA726"))
//
//        binding.fab.fabBorderColor(Color.parseColor("#FFA726"))
//        binding.fab.maxImageSize(40f)
//        binding.fab.fabCustomSize(90f)

//        binding.card.cardBackGroundColor(Color.parseColor("#FFA726"))
//        binding.card.cardCornerRadius(0f)

//        binding.edit.setRadius(0f)
//        binding.edit.setBorderWidth(2f)
//        binding.edit.borderColor(Color.parseColor("#E05021"))
//        binding.edit.textBoxColor(Color.parseColor("#FFA726"))
//        binding.edit.setCompoundDrawablesWithIntrinsicBounds(
//            ContextCompat.getDrawable(this, R.drawable.ic_search),
//            null,
//            null,
//            null
//        )

//        binding.imgButton.setBackGroundColor(Color.parseColor("#FFA726"))
//
//        binding.edit2.setText("Random")
//        binding.edit2.setHint("Phone")
//        binding.edit2.setInputType("password")
//        binding.edit2.setLeftIcon(ContextCompat.getDrawable(this, R.drawable.save))
//        binding.edit2.setRightIcon(ContextCompat.getDrawable(this, R.drawable.save))

//        binding.edit2.setLeftIcon(ContextCompat.getDrawable(this,R.drawable.save))

    }
}