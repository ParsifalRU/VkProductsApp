package dev.ivan_belyaev.all_products_api.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.ivan_belyaev.all_products_api.presentation.viewmodel.AllProductsViewModel
import dev.ivan_belyaev.core.base.di.ViewModelKey

@Module
interface AllFilmsViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AllProductsViewModel::class)
    fun provideAllProductsViewModel(viewModel: AllProductsViewModel): ViewModel
}