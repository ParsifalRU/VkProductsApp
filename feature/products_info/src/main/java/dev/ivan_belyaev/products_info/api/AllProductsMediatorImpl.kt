package dev.ivan_belyaev.products_info.api

import androidx.core.os.bundleOf
import dev.ivan_belyaev.core.navigation.NavData
import dev.ivan_belyaev.products_info.R
import dev.ivan_belyaev.products_info_api.AllProductsMediator
import dev.ivan_belyaev.products_info_api.InfoAboutProductModel
import javax.inject.Inject

class AllProductsMediatorImpl @Inject constructor() : AllProductsMediator {

    override fun getInfoProductScreenNavData(model: InfoAboutProductModel): NavData {
        return NavData(
            R.id.feature_products_info_nav_graph,
            bundleOf(AllProductsMediator.MODEL_ID_EXTRA to model)
        )
    }
}