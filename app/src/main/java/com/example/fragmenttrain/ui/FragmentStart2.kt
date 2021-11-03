package com.example.fragmenttrain.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fragmenttrain.R
import com.example.fragmenttrain.databinding.FragmentStart2Binding
import com.example.fragmenttrain.ui.menu1.FragmentA
import com.example.fragmenttrain.ui.menu2.FragmentD


class FragmentStart2 : Fragment(R.layout.fragment_start2) {

    private val binding by viewBinding(FragmentStart2Binding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null){
            setupStartFragment(FragmentD())
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun setupStartFragment(frag: Fragment) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_start_2, frag)
            .commit()
    }
}