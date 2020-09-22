package com.patrick.cathayholding_android.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.patrick.cathayholding_android.data.AnimalCategory
import com.patrick.cathayholding_android.data.DisplayArea
import com.patrick.cathayholding_android.databinding.ItemHomeDisplayAreaBinding


class HomeAdapter(val onClickListener: OnClickListener) :
    ListAdapter<AnimalCategory, HomeAdapter.ItemViewHolder>(DiffCallback) {

    class ItemViewHolder(private var binding: ItemHomeDisplayAreaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(animalCategory: AnimalCategory) {
            binding.animalCategory = animalCategory
            binding.executePendingBindings()

        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<AnimalCategory>() {
        override fun areContentsTheSame(oldItem: AnimalCategory, newItem: AnimalCategory): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: AnimalCategory, newItem: AnimalCategory): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemHomeDisplayAreaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val menu = getItem(position)
        holder.bind(menu)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(menu)
        }
    }

    class OnClickListener(val clickListener: (animalCategory: AnimalCategory) -> Unit) {
        fun onClick(animalCategory: AnimalCategory) = clickListener(animalCategory)
    }
}