package dev.ivan_belyaev.all_products_api.di

import dagger.Binds
import dagger.Module
import dev.ivan_belyaev.all_products_api.data.AllProductsRepositoryImpl
import dev.ivan_belyaev.all_products_api.domain.AllProductsRepository

@Module
interface AllProductsRepositoryModule {

    @Binds
    fun provideAllProductsRepository(repository: AllProductsRepositoryImpl): AllProductsRepository
}