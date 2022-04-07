package com.uiLibrary.bobblelib

import android.graphics.Color
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
            Toast.makeText(this,"This is a fab",Toast.LENGTH_SHORT).show()
        }
        binding.button.setRadius(20f)
        binding.button.isDarkTheme(true)
    }
}