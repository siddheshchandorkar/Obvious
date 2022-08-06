package com.siddhesh.network

import android.arch.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RetrofitRepository {
    private val retrofitService = RetrofitFactory.makeRetrofitService()

    var imageListLiveData = MutableLiveData<ArrayList<String>>()


    private object HOLDER {
        val INSTANCE = RetrofitRepository()
    }

    companion object {
        val instance: RetrofitRepository by lazy { HOLDER.INSTANCE }
    }

    suspend fun getListFromServer() {
        retrofitService.getList().enqueue(object : Callback<String> {

            override fun onResponse(
                call: Call<String>,
                response: Response<String>
            ) {
                try {

                } catch (t: Throwable) {
                    imageListLiveData.value = null
                    t.printStackTrace()
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                imageListLiveData.value = null
                t.printStackTrace()

            }
        })
    }
}





