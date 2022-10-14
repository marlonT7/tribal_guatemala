package com.example.marlon.prueba

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marlon.prueba.databinding.CategoryItemBinding

class CategoryAdapter(
    private val data: MutableList<String> = mutableListOf(),
    private val onClickAction: (data: String) -> Unit = {}
) :
    RecyclerView.Adapter<CategoryAdapter.TextViewHolder>() {
    fun dataHasChanged(data: List<String>) {
        this.data.clear()
        this.data.addAll(data)
        notifyItemRangeInserted(0, data.size)
    }

    inner class TextViewHolder(val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val binding = CategoryItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return TextViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        val binding = holder.binding
        binding.category.text = data[position]
        binding.root.setOnClickListener { onClickAction.invoke(data[position]) }
    }

    override fun getItemCount(): Int = data.size
}