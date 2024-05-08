package dev.ivan_belyaev.all_products_api.api

import dev.ivan_belyaev.all_products_api.AllProductsMediator
import dev.ivan_belyaev.core.navigation.NavData
import javax.inject.Inject

class AllProductsMediatorImpl @Inject constructor() : AllProductsMediator {

    override fun getAllProductsScreenNavData(): NavData {
        return NavData(
            dev.ivan_belyaev.all_products.R.id.feature_all_products_nav_graph
        )
    }
}