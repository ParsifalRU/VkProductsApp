package dev.ivan_belyaev.products_info.presentation.model

import dev.ivan_belyaev.products_info.presentation.adapter.products_images.InfoProductsModel

data class InfoProductsUiModel(
    val id: Int,
    val title: String,
    val description: String,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val price: Int,
    val brand: String,
    val category: String,
    val image: List<InfoProductsModel>
)