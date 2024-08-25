package com.example.listadetarefas.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listadetarefas.R
import com.example.listadetarefas.adapter.MyAdapter
import com.example.listadetarefas.databinding.FragmentListBinding
import com.example.listadetarefas.model.ToDoItem

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private val myAdapter by lazy { MyAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
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
        val lista = listOf(
            ToDoItem(false, "Estudar Kotlin", false),
            ToDoItem(false, "Estudar Android", false),
            ToDoItem(false, "Estudar Java", false),
            ToDoItem(
                false,
                "Estudar FlutterEstudar FlutterEstudar FlutterEsEstudar FlutterEstudar FlutterEstudar FlutterEstudar FlutterEstudar FlutterEstudar FlutterEstudar FlutterEstudar FlutterEstudar FlutterEstudar FlutterEstudar FlutterEstudar FlutterEstudar FlutterEstudar FlutterEstudar FlutterEstudar FlutterEstudar FlutterEstudar FlutterEstudar FlutterEstudar FlutterEstudar Fluttertudar FlutterEstudar FlutterEstudar Flutter",
                false
            ),
            ToDoItem(false, "Estudar React Native", false),
            ToDoItem(false, "Estudar Swift", false),
            ToDoItem(false, "Estudar Kotlin", false),
            ToDoItem(false, "Estudar Android", false),
            ToDoItem(false, "Estudar Java", false),
            ToDoItem(false, "Estudar Flutter", false),
            ToDoItem(false, "Estudar React Native", false),
            ToDoItem(false, "Estudar Swift", false),
            ToDoItem(false, "Estudar Kotlin", false),
            ToDoItem(false, "Estudar Android", false),
            ToDoItem(false, "Estudar Java", false),
            ToDoItem(false, "Estudar Flutter", false),
            ToDoItem(false, "Estudar React Native", false),
            ToDoItem(false, "Estudar Swift", false),
            ToDoItem(false, "Estudar Kotlin", false),
            ToDoItem(false, "Estudar Android", false),
            ToDoItem(false, "Estudar Java", false),
            ToDoItem(false, "Estudar Flutter", false),
            ToDoItem(false, "Estudar React Native", false),
            ToDoItem(false, "Estudar Swift", false)

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