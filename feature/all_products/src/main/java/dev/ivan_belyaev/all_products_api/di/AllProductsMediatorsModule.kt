package dev.ivan_belyaev.all_products_api.di

import dagger.Module
import dagger.Provides
import dev.ivan_belyaev.core.navigation.MediatorsMap
import dev.ivan_belyaev.core.navigation.MediatorsQualifier
import dev.ivan_belyaev.core.navigation.getMediator
import dev.ivan_belyaev.products_info_api.AllProductsMediator

@Module
object AllProductsMediatorsModule {

    @Provides
    fun provideProductByIdMediator(
        @MediatorsQualifier mediatorsMap: MediatorsMap
    ): AllProductsMediator {
        return mediatorsMap.getMediator()
    }
}