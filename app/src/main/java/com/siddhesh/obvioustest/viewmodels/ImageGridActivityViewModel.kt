package com.siddhesh.obvioustest.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.siddhesh.network.RetrofitRepository
import com.siddhesh.obvioustest.adapters.GridAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*
* Used to handle logic for Image Grid
* */
class ImageGridActivityViewModel : ViewModel() {
    var gridAdapter = GridAdapter(ArrayList())
    var isApiLoading = MutableLiveData(true)

    init {
        callGetImageListApi()
    }

    /*
    * Mock Api called using Coroutine
    * */
    private fun callGetImageListApi() {
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000) //to display api is loading
            RetrofitRepository.instance.getListFromServer()
        }
    }
}