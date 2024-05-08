package dev.ivan_belyaev.di

import dagger.Module
import dev.ivan_belyaev.all_products_api.di.AllProductsMediatorModule
import dev.ivan_belyaev.products_info.di.InfoProductsMediatorModule

@Module(
    includes = [
        InfoProductsMediatorModule::class,
        AllProductsMediatorModule::class,
    ]
)
internal interface ScreensBinding