package dev.ivan_belyaev.all_products_api.di

import dagger.Module
import dagger.Provides
import dev.ivan_belyaev.all_products_api.data.AllProductsApi
import retrofit2.Retrofit

@Module
class AllProductsApiModule {

    @Provides
    fun provideAllProductsApi(retrofit: Retrofit): AllProductsApi =
        retrofit.create(AllProductsApi::class.java)
}
