package com.example.fragmenttrain.ui.menu1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fragmenttrain.R
import com.example.fragmenttrain.databinding.FragmentABinding

class FragmentA : Fragment(R.layout.fragment_a) {

    private val binding by viewBinding(FragmentABinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAText.setOnClickListener{
            val text = binding.editTextA.text.toString()
            val bundle = Bundle()
            bundle.putString("text", text)
            val frag = FragmentA()
            frag.arguments = bundle
            binding.tvTextA.text = text
        }

        binding.buttonA.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, FragmentB(), "fragB")
                .addToBackStack(null)
                .commit()
        }
    }
}