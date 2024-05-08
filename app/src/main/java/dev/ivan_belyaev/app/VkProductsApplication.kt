package dev.ivan_belyaev.app

import android.app.Application
import dev.ivan_belyaev.core.app.App
import dev.ivan_belyaev.core.app.ApplicationProvider
import dev.ivan_belyaev.di.ApplicationComponent

internal class VkProductsApplication : Application(), App {

    private lateinit var appComponent: ApplicationProvider

    override fun onCreate() {
        super.onCreate()
        appComponent = ApplicationComponent.init(this)
    }

    override fun getApplicationProvider(): ApplicationProvider {
        return appComponent
    }
}