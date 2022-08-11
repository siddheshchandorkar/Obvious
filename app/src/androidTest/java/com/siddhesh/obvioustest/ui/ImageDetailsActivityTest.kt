package com.siddhesh.obvioustest.ui

import androidx.test.espresso.Espresso
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.siddhesh.obvioustest.R
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ImageDetailsActivityTest {
    @Rule
    @JvmField
    val rule = ActivityScenarioRule(ImageDetailsActivity::class.java)


    @Before
    fun setUp() {
    }

    @Test
    fun checkDetails(){
        Espresso.onView(ViewMatchers.withId(R.id.iv_url_image))
        Espresso.onView(ViewMatchers.withId(R.id.tv_title))
        Espresso.onView(ViewMatchers.withId(R.id.tv_date))
        Espresso.onView(ViewMatchers.withId(R.id.tv_explanation))
        Espresso.onView(ViewMatchers.withId(R.id.btn_retry))
    }

    @After
    fun tearDown() {
    }
}