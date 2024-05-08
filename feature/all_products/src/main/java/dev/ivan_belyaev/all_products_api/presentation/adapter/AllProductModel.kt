package dev.ivan_belyaev.all_products_api.presentation.adapter

data class AllProductModel(
    val id: Int,
    val title: String,
    val description: String,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val price: Int,
    val thumbnail: String,
    val brand: String,
    val category: String,
    val image: List<String>
)