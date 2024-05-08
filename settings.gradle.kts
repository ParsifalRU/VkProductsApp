pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://www.jitpack.io") }
    }
}
//PROJECT
rootProject.name = "VkProductsApp"
//APP
include(":app")
//FOLDERS
include(":api")
include(":celebrity")
include(":feature")
//CELEBRITY
include(":celebrity:core")
include(":celebrity:core_factory")
include(":celebrity:core_impl")
include(":celebrity:coreui")
include(":celebrity:network")
//API
include(":api:products_info_api")
include(":api:all_products_api")
//FEATURE
include(":feature:products_info")
include(":feature:all_products")
