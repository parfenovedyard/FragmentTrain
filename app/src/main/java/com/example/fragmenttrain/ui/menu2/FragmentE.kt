package com.example.fragmenttrain.ui.menu2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fragmenttrain.R
import com.example.fragmenttrain.databinding.FragmentEBinding
import com.example.fragmenttrain.ui.menu1.FragmentBDirections

class FragmentE : Fragment(R.layout.fragment_e) {

    private val binding by viewBinding(FragmentEBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textFromFragD.text = "Text from fragment D is: ${arguments?.getString("text")}"

        binding.buttonE.setOnClickListener {
            val text = binding.editTextE.text.toString()
            val action = FragmentEDirections.actionFragEToFragF(text)
            findNavController().navigate(action)
        }

    }

}