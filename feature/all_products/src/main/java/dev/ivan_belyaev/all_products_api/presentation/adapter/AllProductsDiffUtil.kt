package dev.ivan_belyaev.all_products_api.presentation.adapter

import androidx.recyclerview.widget.DiffUtil

object AllProductsDiffUtil : DiffUtil.ItemCallback<AllProductModel>() {
    override fun areItemsTheSame(oldItem: AllProductModel, newItem: AllProductModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: AllProductModel, newItem: AllProductModel): Boolean {
        return oldItem == newItem
    }
}