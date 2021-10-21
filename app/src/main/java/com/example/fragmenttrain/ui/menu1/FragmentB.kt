package com.example.fragmenttrain.ui.menu1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fragmenttrain.R
import com.example.fragmenttrain.databinding.FragmentBBinding


class FragmentB : Fragment(R.layout.fragment_b) {

    private val binding by viewBinding(FragmentBBinding::bind)
    private var text = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        text = arguments?.getString("text").toString()
        Log.e("ups", text)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.textFromFragA.text =
            "Text from fragment A is: $text"

        binding.buttonB.setOnClickListener {
            val text = binding.editTextB.text.toString()
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, FragmentC())
                .addToBackStack(null)
                .commit()
        }

    }

}