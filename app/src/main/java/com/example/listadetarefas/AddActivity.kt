package com.example.listadetarefas

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.listadetarefas.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupStateButton()
        setupListeners()
        setupTextWatcher()
    }

    private fun setupStateButton() {
        binding.buttonFinish.isEnabled = false
        binding.buttonFinish.setTextColor(getColor(R.color.gray))
    }

    private fun setupListeners() {
        binding.buttonFinish.setOnClickListener {
            Toast.makeText(
                this,
                "Tarefa ${binding.edtTaskname.text} com sucesso!",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.btnClose.setOnClickListener {
            finish()
        }
    }

    private fun setupTextWatcher() {
        binding.edtTaskname.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Não é necessário implementar
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Habilitar o botão quando o texto não estiver vazio
                val isNotEmpty = !s.isNullOrEmpty()
                binding.buttonFinish.isEnabled = isNotEmpty
                binding.buttonFinish.setTextColor(
                    if (isNotEmpty) getColor(R.color.black) else getColor(R.color.gray)
                )
            }

            override fun afterTextChanged(s: Editable?) {
                // Não é necessário implementar
            }
        })
    }
}