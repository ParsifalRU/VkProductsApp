package dev.ivan_belyaev.products_info.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dev.ivan_belyaev.core.navigation.MediatorsQualifier
import dev.ivan_belyaev.products_info.api.AllProductsMediatorImpl
import dev.ivan_belyaev.products_info_api.AllProductsMediator

@Module
interface InfoProductsMediatorModule {

    @Binds
    fun bindMediator(mediator: AllProductsMediatorImpl): AllProductsMediator

    @Binds
    @IntoMap
    @MediatorsQualifier
    @ClassKey(AllProductsMediator::class)
    fun bindInfoProductsMediator(mediator: AllProductsMediator): Any
}