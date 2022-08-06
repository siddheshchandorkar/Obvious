package com.siddhesh.network

import com.siddhesh.commons.models.ImageDetailsModel
import retrofit2.Call
import retrofit2.http.GET


interface RetrofitService {

    @GET("getDetails")
    fun getList(): Call<ArrayList<ImageDetailsModel>>
}