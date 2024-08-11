package com.example.listadetarefas.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.listadetarefas.R
import com.example.listadetarefas.databinding.FragmentAddBinding

class AddFragment : Fragment() {
    private var isFavorite = false

    private lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        setupListeners()
        return binding.root
    }

    private fun setupListeners() {
        binding.imageView.setOnClickListener {
            toggleFavorite()
            checkFavorite()
        }
        binding.saveBtn.setOnClickListener {
            val description = binding.descriptionEt.text.toString()
            val favorite = isFavorite
            showInformations(description, favorite)
        }
    }

    private fun checkFavorite() {
        if (isFavorite) {
            binding.imageView.setImageResource(R.drawable.baseline_favorite_24)
        } else {
            binding.imageView.setImageResource(R.drawable.baseline_favorite_border_24)
        }
    }

    private fun showInformations(description: String, favorite: Boolean) {
        Toast.makeText(
            requireContext(),
            "Descrição: $description, Favorito: $favorite",
            Toast.LENGTH_SHORT
        ).show()

    }

    private fun toggleFavorite() {
        isFavorite = !isFavorite
    }
}