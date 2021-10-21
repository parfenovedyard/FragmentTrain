package com.example.fragmenttrain

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fragmenttrain.databinding.ActivityMainBinding
import com.example.fragmenttrain.ui.menu1.FragmentA
import com.example.fragmenttrain.ui.menu2.FragmentD

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupActionBar(binding.toolbar)

        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
             when (item.itemId) {
                R.id.frag_a -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, FragmentA())
                        .addToBackStack(null)
                        .commit()

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