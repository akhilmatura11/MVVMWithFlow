package com.flow.names.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.flow.names.data.names.Names
import com.flow.names.databinding.ItemNameBinding

class NamesListAdapter :
    ListAdapter<Names, NamesListAdapter.NamesListViewHolder>(DiffCallback()) {
    private class DiffCallback : DiffUtil.ItemCallback<Names>() {
        override fun areItemsTheSame(oldItem: Names, newItem: Names) =
            oldItem.fullName == newItem.fullName

        override fun areContentsTheSame(oldItem: Names, newItem: Names) =
            oldItem == newItem
    }

    private var namesList = mutableListOf<Names>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NamesListViewHolder {
        val binding = ItemNameBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return NamesListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NamesListViewHolder, position: Int) {
        holder.bind(namesList[position])
    }

    override fun getItemCount(): Int {
        return namesList.size
    }

    fun updateList(list: List<Names>) {
        namesList.clear()
        namesList.addAll(list)
        submitList(list)
    }

    class NamesListViewHolder(private val binding: ItemNameBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(names: Names) {
            binding.itemName.text = names.displayName()
        }
    }
}
