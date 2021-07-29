package com.akadatsky.retrofitsample.api

import com.akadatsky.retrofitsample.model.Exchange
import com.akadatsky.retrofitsample.model.PrivatApi
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

const val BASE_URL = "https://api.privatbank.ua/p24api/"

interface ApiService {

    @GET("exchange_rates?json")
    suspend fun getExchangeRatesHistory(@Query("date") date: String): PrivatApi

    @GET("pubinfo?exchange&json")
    suspend fun getTodayRates(@Query("coursid") courseId: Int): List<Exchange>

    @POST("pubinfo?exchange&json")
    suspend fun sendSomeData(data: Exchange)



}