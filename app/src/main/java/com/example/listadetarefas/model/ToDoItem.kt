package com.example.listadetarefas.model

data class ToDoItem(
    val isDone: Boolean,
    val description: String,
    val isFavorite: Boolean
)
