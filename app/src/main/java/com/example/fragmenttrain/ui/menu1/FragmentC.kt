package com.example.fragmenttrain.ui.menu1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fragmenttrain.R
import com.example.fragmenttrain.databinding.FragmentCBinding

class FragmentC : Fragment(R.layout.fragment_c) {

    private val binding by viewBinding(FragmentCBinding::bind)
    private var text = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            text = savedInstanceState.getString("text").toString()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvTextC.text = text

        binding.buttonCText.setOnClickListener{
            text = binding.editTextC.text.toString()
            binding.tvTextC.text = text
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("text", text)
    }
}