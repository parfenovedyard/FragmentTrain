package com.example.fragmenttrain.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fragmenttrain.R
import com.example.fragmenttrain.databinding.FragmentStartBinding
import com.example.fragmenttrain.ui.menu1.FragmentA
import com.example.fragmenttrain.MainActivity





class FragmentStart : Fragment(R.layout.fragment_start) {

    private val binding by viewBinding(FragmentStartBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null){
            setupStartFragment(FragmentA())
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun setupStartFragment(frag: Fragment) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_start, frag)
            .commit()
    }

    private fun getVisibleFragment(): Fragment? {
        val fragmentManager = parentFragmentManager
        val fragments = fragmentManager.fragments
        if (fragments != null) {
            for (fragment in fragments) {
                if (fragment != null && fragment.isVisible) return fragment
            }
        }
        return null
    }
}