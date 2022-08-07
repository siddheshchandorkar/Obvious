package com.siddhesh.obvioustest.viewmodels

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.siddhesh.network.RetrofitRepository
import com.siddhesh.obvioustest.R
import com.siddhesh.obvioustest.adapters.GridAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*
* Used to handle logic for Image Grid
* */
class ImageGridActivityViewModel(app: Application) : AndroidViewModel(app) {
    var gridAdapter = GridAdapter(ArrayList())
    var isApiLoading = MutableLiveData(true)
    var isError = MutableLiveData(false)

    init {
        callGetImageListApi()
    }

    /*
    * Mock Api called using Coroutine
    * */
    private fun callGetImageListApi() {
        isError.value = false
        isApiLoading.value = true
        if (isInternetAvailable()) {
            CoroutineScope(Dispatchers.IO).launch {
                delay(1000) //to display api is loading
                RetrofitRepository.instance.getListFromServer()
            }
        } else {
            isError.value = true
            isApiLoading.value = false
            Toast.makeText(
                getApplication(),
                getApplication<Application>().getString(R.string.error_internet_connectivity),
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    /*
    * If Error occurred option for retry
    * */
    fun retry() {
        callGetImageListApi()
    }

    /*
    * Check connectivity before api call
    * */
    private fun isInternetAvailable(): Boolean {
        val connectivityManager =
            getApplication<Application>().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val networkCapabilities =
            connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when {
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }
}