package dev.ivan_belyaev.all_products_api.data

import dev.ivan_belyaev.all_products_api.data.dto.all_products.ProductsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface AllProductsApi {

    @GET("/products")
    suspend fun fetchAllProducts(
        @Query("skip") skip: Int = 0,
        @Query("limit") limit: Int = 20,
    ): ProductsDto
}