package com.example.listadetarefas

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.listadetarefas.fragments.AddFragment
import com.example.listadetarefas.fragments.ListFragment

class MyAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FavoritesFragment()
            1 -> ListFragment()
            2 -> AddFragment()
            // 3 -> BanheiroFragment()
            else -> ListFragment()
        }
    }
}