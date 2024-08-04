package com.example.listadetarefas.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.listadetarefas.databinding.RowLayoutBinding
import com.example.listadetarefas.model.ToDoItem

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var myList = emptyList<ToDoItem>()

    class MyViewHolder(val binding: RowLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            RowLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int = myList.size


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            description.text = myList[position].description
        }
        holder.binding.rowLayout.setOnClickListener {
            Toast.makeText(
                holder.binding.rowLayout.context,
                "Cliquei no item ${myList[position].description}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: List<ToDoItem>) {
        myList = newList
        notifyDataSetChanged()
    }
}