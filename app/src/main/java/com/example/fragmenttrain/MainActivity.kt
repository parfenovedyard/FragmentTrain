package com.example.fragmenttrain

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fragmenttrain.databinding.ActivityMainBinding
import com.example.fragmenttrain.ui.menu1.FragmentA

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

    override fun onDestroy() {
        super.onDestroy()
        Log.e("ups", "onDestroy")
    }

}