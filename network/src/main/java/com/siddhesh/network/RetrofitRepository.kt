package com.siddhesh.network

import androidx.lifecycle.MutableLiveData
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
        retrofitService.getList().enqueue(object : Callback<ArrayList<ImageDetailsModel>> {

            override fun onResponse(
                call: Call<ArrayList<ImageDetailsModel>>,
                response: Response<ArrayList<ImageDetailsModel>>
            ) {
                try {
                    response.body()?.let {
                        imageListLiveData.value=it
                    }?: run {
                        imageListLiveData.value = null
                    }
                } catch (t: Throwable) {
                    imageListLiveData.value = null
                    t.printStackTrace()
                }
            }

            override fun onFailure(call: Call<ArrayList<ImageDetailsModel>>, t: Throwable) {
                imageListLiveData.value = null
                t.printStackTrace()
            }
        })
    }
}





