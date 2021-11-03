package com.example.fragmenttrain

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fragmenttrain.databinding.ActivityMainBinding
import com.example.fragmenttrain.ui.FragmentStart
import com.example.fragmenttrain.ui.FragmentStart2

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.fragments
        setContentView(binding.root)

        if (savedInstanceState == null) {
            setupStartScreen(R.id.fragment_container, FragmentStart())
        }

        setupActionBar(binding.toolbar)

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.frag_a -> {
                    setupStartScreen(R.id.fragment_container, FragmentStart()) // это я эксперементирую
                    true
                }
                R.id.frag_d -> {
                    setupStartScreen(R.id.fragment_container, FragmentStart2())
                    true
                }else -> false
            }
        }

    }

    private fun setupStartScreen(id: Int, frag: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(id, frag)
            .commit()
    }

    private fun setupActionBar(toolbar: androidx.appcompat.widget.Toolbar) {
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(true)
        }
        actionBar?.setHomeAsUpIndicator(R.drawable.ic_back_white_24)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}