package dev.ivan_belyaev.all_products_api.presentation.model

data class AllProductsUiDetailModel(
    val id: Int,
    val title: String,
    val description: String,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val price: Int,
    val category: String,
    val thumbnail: String,
    val brand: String,
    val images: List<String>,
)