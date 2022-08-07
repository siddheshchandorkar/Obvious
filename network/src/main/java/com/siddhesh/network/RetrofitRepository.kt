package com.siddhesh.network

import androidx.lifecycle.MutableLiveData
import com.siddhesh.commons.models.ImageDetailsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/*
* All the api calls should handled here
* */
class RetrofitRepository {
    private val retrofitService = RetrofitFactory.makeRetrofitService()
    var imageListLiveData = MutableLiveData<ArrayList<ImageDetailsModel>?>()

    private object HOLDER {
        val INSTANCE = RetrofitRepository()
    }

    companion object {
        val instance: RetrofitRepository by lazy { HOLDER.INSTANCE }
    }

    /*
    * Api call handled to get all image details
    * */
    suspend fun getListFromServer() {
        retrofitService.getAllDetails().enqueue(object : Callback<ArrayList<ImageDetailsModel>> {

            override fun onResponse(
                call: Call<ArrayList<ImageDetailsModel>>,
                response: Response<ArrayList<ImageDetailsModel>>
            ) {
                try {
                    response.body()?.let {
                        imageListLiveData.value=it
                    }
                } catch (t: Throwable) {
                    //set null list in case of crash
                    imageListLiveData.value = null
                    t.printStackTrace()
                }
            }

            override fun onFailure(call: Call<ArrayList<ImageDetailsModel>>, t: Throwable) {
                //set null list in case of failure
                imageListLiveData.value = null
                t.printStackTrace()
            }
        })
    }
}





