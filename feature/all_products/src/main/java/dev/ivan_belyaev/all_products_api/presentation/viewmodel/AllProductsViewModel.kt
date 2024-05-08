package dev.ivan_belyaev.all_products_api.presentation.viewmodel

import android.util.Log
import android.view.View
import dev.ivan_belyaev.all_products_api.domain.AllProductsRepository
import dev.ivan_belyaev.all_products_api.presentation.adapter.AllProductModel
import dev.ivan_belyaev.all_products_api.presentation.mapper.AllProductsDomainToUiMapper
import dev.ivan_belyaev.all_products_api.presentation.model.AllProductsUiModel
import dev.ivan_belyaev.core.base.BaseViewModel
import dev.ivan_belyaev.products_info_api.AllProductsMediator
import dev.ivan_belyaev.products_info_api.InfoAboutProductModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class AllProductsViewModel @Inject constructor(
    private val allProductsMediator: AllProductsMediator,
    private val allProductsDomainToUiMapper: AllProductsDomainToUiMapper,
    private val filmByNameRepository: AllProductsRepository
) : BaseViewModel() {

    private val _fragmentState = MutableStateFlow(getUiState())
    val state: StateFlow<AllProductsUiModel> = _fragmentState

    private fun getUiState(): AllProductsUiModel {
        return AllProductsUiModel(
            products = emptyList()
        )
    }

    init {
        launch {
            onStartUpdateProducts()
        }
    }

    private suspend fun onStartUpdateProducts() {
        _fragmentState.update {
            _fragmentState.value.copy(
                rootLayoutVisibility = View.GONE,
                downloadLayoutVisibility = View.VISIBLE
            )
        }
        try {
            runBlocking {
                val updateProducts1 = async {
                    allProductsDomainToUiMapper.invoke(filmByNameRepository.getProducts(0, 20))
                }
                val updateProducts2 = async {
                    allProductsDomainToUiMapper.invoke(filmByNameRepository.getProducts(20, 20))
                }
                val (res1, res2) = awaitAll(updateProducts1, updateProducts2)
                _fragmentState.update {
                    _fragmentState.value.copy(
                        products = res1.products + res2.products,
                        rootLayoutVisibility = View.VISIBLE,
                        downloadLayoutVisibility = View.GONE
                    )
                }
            }
        } catch (e: Exception) {
            Log.d("LOGTAG", e.cause.toString() + e.message + e.stackTrace)
            delay(5000)
            onStartUpdateProducts()
        }
    }

    fun recyclerViewPagingManager(position: Int) {
        runBlocking {
            val updateProducts = async {
                allProductsDomainToUiMapper.invoke(filmByNameRepository.getProducts(position, 20))
            }
            val result = updateProducts.await()
            _fragmentState.update {
                _fragmentState.value.copy(
                    products = result.products
                )
            }
        }
    }

    fun navigateToFilmByIdScreen(infoProductModel: AllProductModel) {
        with(infoProductModel) {
            navigate(
                allProductsMediator.getInfoProductScreenNavData(
                    InfoAboutProductModel(
                        id = id,
                        title = title,
                        description = description,
                        price = price,
                        discountPercentage = discountPercentage,
                        rating = rating,
                        stock = stock,
                        brand = brand,
                        category = category,
                        image = image
                    )
                )
            )
        }
    }
}