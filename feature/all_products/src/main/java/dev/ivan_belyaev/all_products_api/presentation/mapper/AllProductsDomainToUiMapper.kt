package dev.ivan_belyaev.all_products_api.presentation.mapper

import dev.ivan_belyaev.all_products_api.domain.model.AllProductsModel
import dev.ivan_belyaev.all_products_api.presentation.model.AllProductsUiDetailModel
import dev.ivan_belyaev.all_products_api.presentation.model.AllProductsUiModel
import javax.inject.Inject

class AllProductsDomainToUiMapper @Inject constructor() {

    operator fun invoke(allProductsModel: AllProductsModel) = with(allProductsModel) {
        val allProductsUiDetailModel = products.map { allProductsDetailModel ->
            AllProductsUiDetailModel(
                id = allProductsDetailModel.id,
                title = allProductsDetailModel.title,
                price = allProductsDetailModel.price,
                category = allProductsDetailModel.category,
                thumbnail = allProductsDetailModel.thumbnail,
                discountPercentage = allProductsDetailModel.discountPercentage,
                rating = allProductsDetailModel.rating,
                stock = allProductsDetailModel.stock,
                description = allProductsDetailModel.description,
                brand = allProductsDetailModel.brand,
                images = allProductsDetailModel.images,
            )
        }
        AllProductsUiModel(
            products = allProductsUiDetailModel,
        )
    }
}