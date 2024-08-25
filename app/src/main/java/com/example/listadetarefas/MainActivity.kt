package com.example.listadetarefas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.listadetarefas.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var tabTile = arrayOf("⭐", "Minhas tarefas", "+Nova Lista")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewPagerAndTabs()
    }

    private fun setupViewPagerAndTabs() {
        val adapter = MyAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTile[position]
        }.attach()
    }


}