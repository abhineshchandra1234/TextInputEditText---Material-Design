package com.example.textinputedittext_materialdesign

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.textinputedittext_materialdesign.databinding.FragmentFirstBinding


class FirstFragment : Fragment(R.layout.fragment_first) {
    private lateinit var binding: FragmentFirstBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentFirstBinding.bind(view)

        binding.textInputLayoutPassword.setEndIconOnClickListener {
            Toast.makeText(requireContext(), "Clicked", Toast.LENGTH_SHORT).show()
        }

        binding.textInputEditTextNumber.doOnTextChanged { text, start, before, count ->
            if (text!!.length > 10) {
                binding.textInputLayoutNumber.error = "No More!"
            } else if (text.length < 10) {
                binding.textInputLayoutNumber.error = null
            }
        }
    }
}