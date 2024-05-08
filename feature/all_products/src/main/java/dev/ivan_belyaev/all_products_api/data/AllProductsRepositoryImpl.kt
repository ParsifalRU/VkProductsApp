package dev.ivan_belyaev.all_products_api.data

import dev.ivan_belyaev.all_products_api.data.mapper.AllProductsToDomainMapper
import dev.ivan_belyaev.all_products_api.domain.AllProductsRepository
import dev.ivan_belyaev.all_products_api.domain.model.AllProductsModel
import javax.inject.Inject

class AllProductsRepositoryImpl
@Inject constructor(
    private val api: AllProductsApi,
    private val allProductsToDomainMapper: AllProductsToDomainMapper
) : AllProductsRepository {

    override suspend fun getProducts(skip: Int, limit: Int): AllProductsModel {
        return allProductsToDomainMapper.invoke(
            api.fetchAllProducts(
                skip = skip,
                limit = limit,
            )
        )
    }
}