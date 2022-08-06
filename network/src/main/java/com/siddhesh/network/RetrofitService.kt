package com.siddhesh.network

import retrofit2.Call
import retrofit2.http.GET


interface RetrofitService {

    @GET("getDetails")
    fun getList(): Call<String>
}