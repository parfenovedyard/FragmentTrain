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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonA.setOnClickListener {
            val text = binding.editTextA.text.toString()
            val bundle = Bundle()
            bundle.putString("text", text)

            val fragB = FragmentB()
            fragB.arguments?.putString("text", text)

            val log = fragB.arguments?.getString("text")
            if (log != null) {
                Log.e("ups", log)
            }

            parentFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragB)
                .addToBackStack(null)
                .commit()
        }
    }


}