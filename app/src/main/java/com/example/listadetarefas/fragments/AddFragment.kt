package com.example.listadetarefas.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
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

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.add_fragment_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    //R.id.menu_add -> insertDataDb()
                    R.id.menu_add -> prepareToSaveInformations()
                    android.R.id.home -> requireActivity().onBackPressed()
                }
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.STARTED)
    }

/*    private fun insertDataDb() {

        val mTitle = binding.titleEt.text.toString()
        val mPriority = binding.prioritiesSpinner.selectedItem.toString()
        val mDescription = binding.descriptionEt.text.toString()

        val validation = mSharedViewModel.verifyDataFromUser(mTitle, mDescription)
        if (validation) {
            //Insert Data to Database
            val newData = ToDoData(
                0,
                mTitle,
                mSharedViewModel.parsePriorityToInt(mPriority),
                mDescription
            )
            mToDoViewModel.insertData(newData)
            Toast.makeText(requireContext(), "Successfuly added", Toast.LENGTH_SHORT).show()
            //Navigate back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all field.", Toast.LENGTH_SHORT)
                .show()
        }
    }*/

    private fun prepareToSaveInformations() {
        val (description, favorite) = colectInformations()
        showInformations(description, favorite)
    }

    private fun setupListeners() {
        binding.imageView.setOnClickListener {
            toggleFavorite()
            checkFavorite()
        }
    }

    private fun colectInformations(): Pair<String, Boolean> {
        val description = binding.descriptionEt.text.toString()
        val favorite = isFavorite
        return Pair(description, favorite)
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