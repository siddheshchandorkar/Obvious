package com.siddhesh.obvioustest.viewmodels

import android.arch.lifecycle.ViewModel
import com.siddhesh.network.RetrofitRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ImageGridActivityViewModel : ViewModel() {

    public fun callGetImageListApi() {
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            RetrofitRepository.instance.getListFromServer()
        }
    }
}