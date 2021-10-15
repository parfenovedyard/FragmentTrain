package com.example.fragmenttrain.ui.menu1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fragmenttrain.R
import com.example.fragmenttrain.databinding.FragmentBBinding


class FragmentB : Fragment(R.layout.fragment_b) {

    private val binding by viewBinding(FragmentBBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textFromFragA.text = "Text from fragment A is: ${arguments?.getString("text")}"

        binding.buttonB.setOnClickListener {
            val text = binding.editTextB.text.toString()
            val action = FragmentBDirections.actionFragBToFragC(text)
            findNavController().navigate(action)
        }

    }

}