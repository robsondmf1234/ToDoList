package com.example.listadetarefas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import androidx.lifecycle.lifecycleScope
import com.example.listadetarefas.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dataStore: DataStore<Preferences>
    private val listDefault = listOf("Tarefas", "Minhas tarefas", "Nova Lista")
    private var tabListTitle = emptyList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataStore = createDataStore("settings")
        prepareToSave()
        lifecycleScope.launch {
            prepareToRecover()
            setupViewPagerAndTabs(tabListTitle)
        }
    }

    private suspend fun prepareToRecover() {
        tabListTitle = recoveryListSaved()
    }

    private suspend fun recoveryListSaved(): List<String> {
        return readList("1") ?: listDefault
    }

    private fun prepareToSave() {
        lifecycleScope.launch {
            saveList(
                key = "1",
                list = listOf("⭐", "Minhas tarefas", "Minhas tarefas - 2",
                    "Minhas tarefas - 3", "Minhas tarefas - 4", "+Nova Lista")
            )
        }
    }

    private suspend fun saveList(key: String, list: List<String>) {
        val dataStoreKey = preferencesKey<String>(key)
        val json = Gson().toJson(list)
        dataStore.edit { settings ->
            settings[dataStoreKey] = json
        }
    }

    private suspend fun readList(key: String): List<String>? {
        val dataStoreKey = preferencesKey<String>(key)
        val preferences = dataStore.data.first()
        val json = preferences[dataStoreKey]
        return json?.let {
            val type = object : TypeToken<List<String>>() {}.type
            Gson().fromJson(it, type)
        }
    }

    private fun setupViewPagerAndTabs(tabListTitle: List<String>) {
        val adapter = MyAdapter(supportFragmentManager, lifecycle, tabListTitle)
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabListTitle[position]
        }.attach()
    }
}