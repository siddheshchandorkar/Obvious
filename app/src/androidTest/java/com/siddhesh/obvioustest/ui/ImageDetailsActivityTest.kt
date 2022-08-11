package com.siddhesh.obvioustest.ui

import android.os.Bundle
import android.view.View
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.siddhesh.commons.models.ImageDetailsModel
import com.siddhesh.obvioustest.R
import org.hamcrest.Matcher
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ImageDetailsActivityTest {

    @Rule
    @JvmField
    val rule = ActivityScenarioRule(ImageDetailsActivity::class.java)


    @Before
    fun setUp() {

    }


    @Test
    fun checkUI() {
        onView(ViewMatchers.withId(R.id.iv_url_image))
        onView(ViewMatchers.withId(R.id.tv_title))
        onView(ViewMatchers.withId(R.id.tv_date))
        onView(ViewMatchers.withId(R.id.tv_explanation))
        onView(ViewMatchers.withId(R.id.btn_details_retry))
    }


    @After
    fun tearDown() {

    }

}