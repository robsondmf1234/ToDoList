package com.example.listadetarefas.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listadetarefas.adapter.MyAdapter
import com.example.listadetarefas.databinding.FragmentDinamicBinding
import com.example.listadetarefas.databinding.FragmentListBinding
import com.example.listadetarefas.model.ToDoItem

class DinamicListFragment(private val listTasks: List<String>) : Fragment() {
    private lateinit var binding: FragmentDinamicBinding
    private val myAdapter by lazy { MyAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDinamicBinding.inflate(inflater, container, false)
        setupListeners()
        setupRecycler(binding.recyclerView)
        return binding.root
    }

    private fun setupListeners() {
        binding.fab.setOnClickListener {
          Toast.makeText(requireContext(), "Clicou no FAB", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupRecycler(recyclerView: RecyclerView) {
        val listaDinamica = listTasks
        val lista = listOf(
            ToDoItem(false, listaDinamica.first(),false),
        )
        myAdapter.setData(lista)
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        // Cria um objeto DividerItemDecoration
        val dividerItemDecoration =
            DividerItemDecoration(recyclerView.context, LinearLayoutManager.VERTICAL)

        // Adiciona o objeto ao RecyclerView
        recyclerView.addItemDecoration(dividerItemDecoration)


    }
}