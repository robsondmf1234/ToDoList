package com.example.listadetarefas

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.listadetarefas.databinding.ActivityAddBinding

const val TAG = "AddActivity"

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    private var list: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Recuperar a lista do Intent
        list = intent.getStringArrayListExtra("dinamicList") ?: mutableListOf()
        Log.d(TAG, "Lista Recuperada: $list")

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
            addTaskOnList()
            Toast.makeText(
                this,
                "Tarefa ${binding.edtTaskname.text} adicionada com sucesso!",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.btnClose.setOnClickListener {
            finish()
        }
    }

    private fun addTaskOnList() {
        list.add(binding.edtTaskname.text.toString())
        goBackToMainActivity()
    }

    private fun goBackToMainActivity() {
        val resultIntent = Intent()
        resultIntent.putStringArrayListExtra("updatedList", ArrayList(list))
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
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