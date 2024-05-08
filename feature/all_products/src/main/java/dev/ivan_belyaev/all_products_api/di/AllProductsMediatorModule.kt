package dev.ivan_belyaev.all_products_api.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dev.ivan_belyaev.all_products_api.AllProductsMediator
import dev.ivan_belyaev.all_products_api.api.AllProductsMediatorImpl
import dev.ivan_belyaev.core.navigation.MediatorsQualifier

@Module
interface AllProductsMediatorModule {

    @Binds
    fun bindMediator(mediator: AllProductsMediatorImpl): AllProductsMediator

    @Binds
    @IntoMap
    @MediatorsQualifier
    @ClassKey(AllProductsMediator::class)
    fun bindProductsFilmsMediator(mediator: AllProductsMediator): Any
}