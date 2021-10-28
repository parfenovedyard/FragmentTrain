package com.example.fragmenttrain.ui.menu1

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fragmenttrain.R
import com.example.fragmenttrain.databinding.FragmentABinding

class FragmentA : Fragment(R.layout.fragment_a) {

    private val binding by viewBinding(FragmentABinding::bind)
    private var text = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            text = savedInstanceState.getString("text").toString()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvTextA.text = text

        binding.buttonAText.setOnClickListener{
            text = binding.editTextA.text.toString()
            binding.tvTextA.text = text
        }

        binding.buttonA.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("textA", binding.editTextA.text.toString())
            val fragB = FragmentB()
            fragB.arguments = bundle
            Log.e("ups", "fragB bundle is: ${fragB.arguments}")

            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragB, "fragB")
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("text", text)
    }
}