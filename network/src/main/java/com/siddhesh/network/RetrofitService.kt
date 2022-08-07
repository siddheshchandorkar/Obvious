package com.siddhesh.network

import com.siddhesh.commons.models.ImageDetailsModel
import retrofit2.Call
import retrofit2.http.GET

/*
* Retrofit Api Service
* */
interface RetrofitService {

    // Get All Details Calls
    @GET("getDetails")
    fun getAllDetails(): Call<ArrayList<ImageDetailsModel>>
}