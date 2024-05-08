package dev.ivan_belyaev.all_products_api.presentation.model

import android.view.View

data class AllProductsUiModel(
    val products: List<AllProductsUiDetailModel>,
    val rootLayoutVisibility: Int = View.GONE,
    val downloadLayoutVisibility: Int = View.VISIBLE
)