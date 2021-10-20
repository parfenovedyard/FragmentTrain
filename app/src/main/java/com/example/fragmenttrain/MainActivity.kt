package com.example.fragmenttrain

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fragmenttrain.databinding.ActivityMainBinding
import com.example.fragmenttrain.ui.menu1.FragmentA
import com.example.fragmenttrain.ui.menu1.FragmentB
import com.example.fragmenttrain.ui.menu2.FragmentD
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind)
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

       /* navController = findNavController(R.id.fragment_container)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.frag_a,
                R.id.frag_d
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNavigation.setupWithNavController(navController)
        */

        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
             when (item.itemId) {
                R.id.frag_a -> {
                    //setActiveTab(Tab.Menu1)

                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, FragmentA())
                        .commit()

                    true
                }
                R.id.frag_d -> {
                    //setActiveTab(Tab.Menu2)

                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, FragmentD())
                        .commit()
                    true
                }else -> false
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun loadFragments(fragment: Fragment): Boolean {

        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

        return true
    }


    /*override fun onNavigationItemSelected(item: MenuItem): Boolean {

        var fragment: Fragment? = null

        when (item.itemId) {

            R.id.frag_a ->{
                fragment = FragmentA()
            }

            R.id.frag_d ->{
                fragment = FragmentD()
            }

        }

        return loadFragments(fragment!!)
    }*/

}