package com.example.fragmenttrain.ui.menu2

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fragmenttrain.R
import com.example.fragmenttrain.databinding.FragmentDBinding
import com.example.fragmenttrain.ui.menu1.FragmentADirections

class FragmentD : Fragment(R.layout.fragment_d) {

    private val binding by viewBinding(FragmentDBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonD.setOnClickListener {
            val text = binding.editTextD.text.toString()
            val action = FragmentDDirections.actionFragDToFragE(text)
            findNavController().navigate(action)
        }
    }


}