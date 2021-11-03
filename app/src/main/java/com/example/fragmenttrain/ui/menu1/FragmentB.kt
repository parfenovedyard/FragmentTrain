package com.example.fragmenttrain.ui.menu1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fragmenttrain.R
import com.example.fragmenttrain.databinding.FragmentBBinding


class FragmentB : Fragment(R.layout.fragment_b) {

    private val binding by viewBinding(FragmentBBinding::bind)
    private var text = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            text = savedInstanceState.getString("text").toString()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments?.isEmpty!!){
            binding.tvTextB.text = text
        }else {
            binding.tvTextB.text = arguments?.getString("textA")
        }

        binding.buttonBText.setOnClickListener{
            text = binding.editTextB.text.toString()
            binding.tvTextB.text = text
        }

        binding.buttonB.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_start, FragmentC(), "fragC")
                .setReorderingAllowed(true)
                .addToBackStack("stack1")
                .commit()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("text", text)
    }
}