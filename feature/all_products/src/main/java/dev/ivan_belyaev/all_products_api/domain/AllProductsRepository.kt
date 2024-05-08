package dev.ivan_belyaev.all_products_api.domain

import dev.ivan_belyaev.all_products_api.domain.model.AllProductsModel

interface AllProductsRepository {

    suspend fun getProducts(skip: Int, limit: Int): AllProductsModel
}