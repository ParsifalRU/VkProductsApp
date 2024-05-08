package dev.ivan_belyaev.network.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dev.ivan_belyaev.network.okhttp.OkHttpInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkSetting {
    const val BASE_URL = "https://dummyjson.com/"
}

@Module
class NetworkModule {

    @Provides
    fun provideOkHttpClient(
        interceptor: OkHttpInterceptor
    ): OkHttpClient {

        return OkHttpClient.Builder()
            .let { builder ->
                builder.addInterceptor(interceptor)
                builder.addInterceptor(
                    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                )
            }
            .build()
    }

    @Provides
    fun providesGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }

    @Provides
    fun provideRetrofitForCinemaService(
        gson: Gson,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .baseUrl(NetworkSetting.BASE_URL)
            .build()
    }
}