package dev.ivan_belyaev.products_info.di

import dagger.BindsInstance
import dagger.Component
import dev.ivan_belyaev.core.app.ApplicationProvider
import dev.ivan_belyaev.products_info.presentation.InfoProductsFragment
import dev.ivan_belyaev.products_info_api.InfoAboutProductModel

@Component(
    modules = [
        InfoProductsViewModelsModule::class,
    ],
    dependencies = [
        ApplicationProvider::class,
    ]
)

interface InfoProductsComponent {

    companion object {

        fun init(
            applicationProvider: ApplicationProvider,
            infoAboutProductModel: InfoAboutProductModel
        ): InfoProductsComponent {
            return DaggerInfoProductsComponent.factory()
                .create(applicationProvider, infoAboutProductModel)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(
            applicationProvider: ApplicationProvider,
            @BindsInstance infoAboutProductModel: InfoAboutProductModel

        ): InfoProductsComponent
    }

    fun inject(fragment: InfoProductsFragment)
}