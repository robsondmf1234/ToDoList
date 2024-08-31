package com.example.listadetarefas.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.listadetarefas.FavoritesFragment
import com.example.listadetarefas.fragments.DinamicListFragment
import com.example.listadetarefas.fragments.ListFragment

class MyTabLayoutAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val tabListTitle: List<String>
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return tabListTitle.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FavoritesFragment()
            1 -> ListFragment()
            //TODO("Passar para o DinamicListFragment o titulo da aba para recuperar no DataStore dentro do fragment")
            2 -> DinamicListFragment(tabListTitle)
           //  3 -> ListFragment()
            else -> ListFragment()
        }
    }
}