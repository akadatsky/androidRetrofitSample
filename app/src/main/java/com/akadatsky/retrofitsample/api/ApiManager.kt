package com.akadatsky.retrofitsample.api

import com.akadatsky.retrofitsample.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {

    companion object {

        private val httpClient: OkHttpClient
            get() = OkHttpClient.Builder().apply {
                val logging = HttpLoggingInterceptor().apply {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                }
                if (BuildConfig.DEBUG) {
                    addInterceptor(logging)
                }
            }.build()

        private val retrofit: Retrofit
            get() {
                return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build()
            }

        val apiService: ApiService
            get() = retrofit.create(ApiService::class.java)

    }
}