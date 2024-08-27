package com.example.listadetarefas

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.listadetarefas.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        binding.txtConcluido.setOnClickListener {
           Toast.makeText(this, "Concluído", Toast.LENGTH_SHORT).show()
        }
        binding.btnClose.setOnClickListener {
            finish()
        }
    }
}