package com.siddhesh.obvioustest.ui

import android.content.Context
import androidx.test.espresso.IdlingResource
import java.util.concurrent.atomic.AtomicBoolean


class IntentServiceIdlingResource(val context: Context) : IdlingResource{
    var resourceCallback: IdlingResource.ResourceCallback? = null
    private val mIsIdleNow: AtomicBoolean = AtomicBoolean(true)

    override fun getName(): String {
        return IntentServiceIdlingResource::class.java.name
    }

    override fun registerIdleTransitionCallback(callback: IdlingResource.ResourceCallback?) {
            resourceCallback=callback
    }

    override fun isIdleNow(): Boolean {
        return mIsIdleNow.get();
    }

    fun setIdleState(isIdleNow: Boolean) {
        mIsIdleNow.set(isIdleNow)
        if (isIdleNow && resourceCallback != null) {
            resourceCallback!!.onTransitionToIdle()
        }
    }

}