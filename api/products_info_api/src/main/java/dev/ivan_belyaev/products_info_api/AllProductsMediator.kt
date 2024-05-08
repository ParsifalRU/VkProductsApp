package dev.ivan_belyaev.products_info_api

import dev.ivan_belyaev.core.navigation.NavData

interface AllProductsMediator {

    companion object {
        const val MODEL_ID_EXTRA = "ALL_PRODUCTS_NAV_DATA_MODEL_ID_EXTRA"
    }

    fun getInfoProductScreenNavData(model: InfoAboutProductModel): NavData
}