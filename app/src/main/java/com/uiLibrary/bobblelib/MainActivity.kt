package com.uiLibrary.bobblelib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
    }
}