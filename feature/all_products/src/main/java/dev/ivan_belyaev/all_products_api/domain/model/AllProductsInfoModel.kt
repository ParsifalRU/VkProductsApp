package dev.ivan_belyaev.all_products_api.domain.model

data class AllProductsInfoModel(
    val id: Int,
    val title: String,
    val price: Int,
    val description: String,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val category: String,
    val thumbnail: String,
    val brand: String,
    val images: List<String>,
)