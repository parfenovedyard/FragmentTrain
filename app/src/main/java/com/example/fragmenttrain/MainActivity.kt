package com.example.fragmenttrain

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fragmenttrain.databinding.ActivityMainBinding
import com.example.fragmenttrain.ui.menu1.FragmentA
import com.example.fragmenttrain.ui.menu2.FragmentD

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.fragments
        setContentView(binding.root)

        if (savedInstanceState == null) {
            setupStartScreen(FragmentA())
        }

        setupActionBar(binding.toolbar)

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.frag_a -> {
                    Toast.makeText(this, "test", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.frag_d -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, FragmentD())
                        .commit()
                    true
                }else -> false
            }
        }
    }

    private fun setupStartScreen(frag: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, frag, "startFrag")
            .commit()
    }

    private fun setupActionBar(toolbar: androidx.appcompat.widget.Toolbar) {
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(true)
        } else{
            Log.e("ups", "trouble")
        }
        actionBar?.setHomeAsUpIndicator(R.drawable.ic_back_white_24)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}