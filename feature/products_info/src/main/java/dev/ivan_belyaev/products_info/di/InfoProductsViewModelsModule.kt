package dev.ivan_belyaev.products_info.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.ivan_belyaev.core.base.di.ViewModelKey
import dev.ivan_belyaev.products_info.presentation.InfoProductsViewModel

@Module
interface InfoProductsViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(InfoProductsViewModel::class)
    fun provideInfoProductsViewModel(viewModel: InfoProductsViewModel): ViewModel
}