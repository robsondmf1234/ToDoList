package com.example.listadetarefas.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import androidx.lifecycle.lifecycleScope
import com.example.listadetarefas.adapter.MyTabLayoutAdapter
import com.example.listadetarefas.R
import com.example.listadetarefas.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dataStore: DataStore<Preferences>
    // Lista de títulos das abas
    private var listaNameTitleAbs = listOf("⭐")

    private var tabListTitle = emptyList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataStore = createDataStore("settings")
        lifecycleScope.launch {
            prepareToRecover()
            setupViewPagerAndTabs(listaNameTitleAbs)
        }
    }

    private suspend fun prepareToRecover() {
        tabListTitle = recoveryListSaved()
    }

    private suspend fun recoveryListSaved(): List<String> {
        return readList("1") ?: listaNameTitleAbs
    }

    private fun prepareToSave(dinamicList: List<String>) {
        lifecycleScope.launch {
            saveList(
                key = "1",
                list = dinamicList
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
        val adapter = MyTabLayoutAdapter(supportFragmentManager, lifecycle, tabListTitle)
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabListTitle[position]
        }.attach()

        // Adicionar botão ao último item do TabLayout
        addButtonToLastTab()
    }

    private fun addButtonToLastTab() {
        val tabLayout = binding.tabLayout
        val tab = tabLayout.newTab()
        val button = Button(this).apply {
            text = context.getString(R.string.new_list)
            setBackgroundColor(context.getColor(R.color.transparent))
            setOnClickListener {
                openAddTabActivity()
            }
        }
        tab.customView = button
        tabLayout.addTab(tab)
    }

    private fun openAddTabActivity() {
        val intent = Intent(this, AddActivity::class.java)
        intent.putStringArrayListExtra("dinamicList", ArrayList(listaNameTitleAbs))
        startActivityForResult(intent, REQUEST_CODE_ADD_ACTIVITY)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_ADD_ACTIVITY && resultCode == Activity.RESULT_OK) {
            data?.getStringArrayListExtra("updatedList")?.let {
                listaNameTitleAbs = it.toMutableList()
                setupViewPagerAndTabs(listaNameTitleAbs)
            }
        }
    }

    companion object {
        private const val REQUEST_CODE_ADD_ACTIVITY = 1
    }
}