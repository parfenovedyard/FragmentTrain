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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.textFromFragA.text =
            "Text from fragment A is: ${arguments?.get("text")}"

        binding.buttonB.setOnClickListener {
            val text = binding.editTextB.text.toString()
            val bundle = Bundle()
            bundle.putString("text", text)

            val fragC = FragmentC()
            fragC.arguments = bundle

            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragC)
                .addToBackStack(null)
                .commit()
        }

    }

}