package dev.ivan_belyaev.products_info.presentation.adapter.products_images

import androidx.recyclerview.widget.DiffUtil

object InfoProductsDiffUtil : DiffUtil.ItemCallback<InfoProductsModel>() {
    override fun areItemsTheSame(oldItem: InfoProductsModel, newItem: InfoProductsModel): Boolean {
        return oldItem.url == newItem.url
    }

    override fun areContentsTheSame(
        oldItem: InfoProductsModel,
        newItem: InfoProductsModel
    ): Boolean {
        return oldItem == newItem
    }
}