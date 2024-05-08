@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.android.kotlin)
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "dev.ivan_belyaev.products_info"
    compileSdk = 34

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(":celebrity:core"))
    implementation(project(":celebrity:coreui"))
    implementation(project(":celebrity:network"))
    implementation(project(":api:products_info_api"))
    implementation(project(":api:all_products_api"))

    api(libs.androidx.lifecycle.viewmodel.ktx)
    api(libs.androidx.lifecycle.runtime.ktx)

    kapt(libs.dagger.compiler)

    implementation(libs.retrofit)
    implementation(libs.retrofit2.converter.gson2)
    implementation("com.squareup.okhttp3:okhttp:3.14.9")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.github.bumptech.glide:glide:4.15.1")
    implementation(libs.dagger)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.core.ktx)
    implementation("androidx.fragment:fragment-ktx:1.6.2")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
}