package com.example.listadetarefas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.listadetarefas.databinding.FragmentFavoriteBinding

class FavoritesFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true)

        return binding.root
    }
}
