package dev.ivan_belyaev.products_info_api

import java.io.Serializable

data class InfoAboutProductModel(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val brand: String,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val category: String,
    val image: List<String>
) : Serializable