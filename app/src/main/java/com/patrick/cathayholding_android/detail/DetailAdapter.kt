package com.patrick.cathayholding_android.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.patrick.cathayholding_android.data.PlantItem
import com.patrick.cathayholding_android.databinding.ItemHomeDisplayAreaBinding
import com.patrick.cathayholding_android.databinding.ItemPlantInfoBinding

class DetailAdapter(val onClickListener: OnClickListener) :
    ListAdapter<PlantItem, DetailAdapter.ItemViewHolder>(DiffCallback) {

    class ItemViewHolder(private var binding: ItemPlantInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(plantItem: PlantItem) {
            binding.plantItem = plantItem
            binding.executePendingBindings()

        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<PlantItem>() {
        override fun areContentsTheSame(oldItem: PlantItem, newItem: PlantItem): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: PlantItem, newItem: PlantItem): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemPlantInfoBinding.inflate(
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

    class OnClickListener(val clickListener: (plantItem: PlantItem) -> Unit) {
        fun onClick(plantItem: PlantItem) = clickListener(plantItem)
    }
}