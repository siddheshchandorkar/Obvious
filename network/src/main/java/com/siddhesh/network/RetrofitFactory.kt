package com.siddhesh.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
* Retrofit Service Class
*/
object RetrofitFactory {

    private const val BASE_URL = "https://62ee15d4a785760e677399e1.mockapi.io/siddhesh/v1/"

    fun makeRetrofitService(): RetrofitService {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build().create(RetrofitService::class.java)
    }


}