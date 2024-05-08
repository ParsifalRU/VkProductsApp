package dev.ivan_belyaev.products_info.presentation

import dev.ivan_belyaev.core.base.BaseViewModel
import dev.ivan_belyaev.products_info.presentation.adapter.products_images.InfoProductsModel
import dev.ivan_belyaev.products_info.presentation.model.InfoProductsUiModel
import dev.ivan_belyaev.products_info_api.InfoAboutProductModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class InfoProductsViewModel @Inject constructor(
    private val filmIdNumber: InfoAboutProductModel
) : BaseViewModel() {

    private val _fragmentState = MutableStateFlow(getUiState())
    val state: StateFlow<InfoProductsUiModel> = _fragmentState

    private fun getUiState(): InfoProductsUiModel {
        val arrayListPosters = ArrayList<InfoProductsModel>()
        for (i in 0..filmIdNumber.image.lastIndex) {
            arrayListPosters.add(
                InfoProductsModel(
                    url = filmIdNumber.image[i]
                )
            )
        }
        return InfoProductsUiModel(
            id = filmIdNumber.id,
            brand = filmIdNumber.brand,
            category = filmIdNumber.category,
            description = filmIdNumber.description,
            discountPercentage = filmIdNumber.discountPercentage,
            rating = filmIdNumber.rating,
            stock = filmIdNumber.stock,
            image = arrayListPosters,
            price = filmIdNumber.price,
            title = filmIdNumber.title
        )
    }

    fun navigateToAllFilmsScreen() {
        navigateBack()
    }
}