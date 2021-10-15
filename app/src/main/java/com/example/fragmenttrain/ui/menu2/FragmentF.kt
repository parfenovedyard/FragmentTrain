package com.example.fragmenttrain.ui.menu2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fragmenttrain.R
import com.example.fragmenttrain.databinding.FragmentFBinding

class FragmentF : Fragment(R.layout.fragment_f) {

    private val binding by viewBinding(FragmentFBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textFromFragE.text = "Text from fragment E is: ${arguments?.getString("text")}"

    }
}