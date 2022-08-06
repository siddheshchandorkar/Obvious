package com.siddhesh.network

import android.arch.lifecycle.MutableLiveData
import com.siddhesh.commons.models.ImageDetailsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RetrofitRepository {
    private val retrofitService = RetrofitFactory.makeRetrofitService()

    var imageListLiveData = MutableLiveData<ArrayList<ImageDetailsModel>>()


    private object HOLDER {
        val INSTANCE = RetrofitRepository()
    }

    companion object {
        val instance: RetrofitRepository by lazy { HOLDER.INSTANCE }
    }

    suspend fun getListFromServer() {
        retrofitService.getList().enqueue(object : Callback<List<ImageDetailsModel>> {

            override fun onResponse(
                call: Call<List<ImageDetailsModel>>,
                response: Response<List<ImageDetailsModel>>
            ) {
                try {

                } catch (t: Throwable) {
                    imageListLiveData.value = null
                    t.printStackTrace()
                }
            }

            override fun onFailure(call: Call<List<ImageDetailsModel>>, t: Throwable) {
                imageListLiveData.value = null
                t.printStackTrace()
            }
        })
    }
}





