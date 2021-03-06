package com.uiLibrary.bobblelib

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayoutMediator
import com.uiLibrary.bobblelib.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var adapter: FragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = FragmentAdapter(supportFragmentManager, lifecycle)
        binding.viewPager2.adapter = adapter
        binding.viewPager2.setOnClickListener { v ->
            val imm =getSystemService(INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(v.windowToken, 0)
        }

        //Configuring tabs at different positions
        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "TAB2"
                }
                1 -> {
                    tab.text = "TAB"
                }
            }
            binding.viewPager2.currentItem = 1
        }.attach()
    }
}