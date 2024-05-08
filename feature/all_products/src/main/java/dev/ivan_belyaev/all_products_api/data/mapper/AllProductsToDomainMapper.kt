package dev.ivan_belyaev.all_products_api.data.mapper

import dev.ivan_belyaev.all_products_api.data.dto.all_products.ProductsDto
import dev.ivan_belyaev.all_products_api.domain.model.AllProductsInfoModel
import dev.ivan_belyaev.all_products_api.domain.model.AllProductsModel
import javax.inject.Inject

class AllProductsToDomainMapper @Inject constructor() {

    operator fun invoke(filmByNameDto: ProductsDto) = with(filmByNameDto) {
        val productsInfoModel = products.map { productsInfoModel ->
            AllProductsInfoModel(
                id = productsInfoModel.id,
                title = productsInfoModel.title,
                price = productsInfoModel.price,
                description = productsInfoModel.description,
                discountPercentage = productsInfoModel.discountPercentage,
                rating = productsInfoModel.rating,
                stock = productsInfoModel.stock,
                category = productsInfoModel.category,
                thumbnail = productsInfoModel.thumbnail,
                brand = productsInfoModel.brand,
                images = productsInfoModel.images
            )
        }
        AllProductsModel(
            products = productsInfoModel
        )
    }
}