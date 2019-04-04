package com.panch.mvvmstarterapp.data.rest

import com.panch.mvvmstarterapp.BuildConfig
import com.panch.mvvmstarterapp.data.apiBaseUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit

fun createRestClient(): RestApi {
    val logging = HttpLoggingInterceptor()
    if (BuildConfig.DEBUG)
        logging.level = HttpLoggingInterceptor.Level.BODY
    else
        logging.level = HttpLoggingInterceptor.Level.NONE

    val client = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(logging)
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(apiBaseUrl)
        .client(client)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    Timber.e("Created Api Retrofit RestClient.")

    return retrofit.create(RestApi::class.java)
}