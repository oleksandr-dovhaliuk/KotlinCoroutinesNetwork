package com.oleksandrdovhaliuk.coroutinesnetwork.di

import com.oleksandrdovhaliuk.coroutinesnetwork.BuildConfig
import com.oleksandrdovhaliuk.coroutinesnetwork.data.network.RecipeApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val TIME_OUT = 30L

val networkModule = module {
    single { provideRecipeApi(get()) }
    single { provideRetrofit(get()) }
    single { provideOkHttpClient() }
}

fun provideRecipeApi(retrofit: Retrofit): RecipeApi {
    return retrofit.create(RecipeApi::class.java)
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        .addNetworkInterceptor(getHttpLoggingInterceptor())
        .build()
}

private fun getHttpLoggingInterceptor() = if (BuildConfig.DEBUG) {
    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
} else {
    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
}