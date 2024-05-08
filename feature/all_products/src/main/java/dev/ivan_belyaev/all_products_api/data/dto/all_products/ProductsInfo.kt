package dev.ivan_belyaev.all_products_api.data.dto.all_products

data class ProductsInfo(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val discountPercentage: Double = 0.0,
    val rating: Double = 0.0,
    val stock: Int = 0,
    val price: Int = 0,
    val brand: String = "",
    val category: String = "",
    val thumbnail: String = "",
    val images: List<String>,
)