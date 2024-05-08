package dev.ivan_belyaev.all_products_api.di

import dagger.Component
import dev.ivan_belyaev.all_products_api.presentation.fragment.AllProductsFragment
import dev.ivan_belyaev.core.app.ApplicationProvider

@Component(
    modules = [
        AllFilmsViewModelsModule::class,
        AllProductsApiModule::class,
        AllProductsMediatorsModule::class,
        AllProductsRepositoryModule::class,
    ],
    dependencies = [
        ApplicationProvider::class,
    ]
)

interface AllProductsComponent {

    companion object {

        fun init(applicationProvider: ApplicationProvider): AllProductsComponent {
            return DaggerAllProductsComponent.factory()
                .create(applicationProvider)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(applicationProvider: ApplicationProvider): AllProductsComponent
    }

    fun inject(fragment: AllProductsFragment)
}