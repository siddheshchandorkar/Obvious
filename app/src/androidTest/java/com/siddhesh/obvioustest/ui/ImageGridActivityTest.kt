package com.siddhesh.obvioustest.ui

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.siddhesh.obvioustest.R
import kotlinx.coroutines.delay
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ImageGridActivityTest {

    @Rule
    @JvmField
    val rule = ActivityScenarioRule(ImageGridActivity::class.java)

    @Before
    fun setUp() {
    }

    @Test
    fun check(){
       val button = Espresso.onView(ViewMatchers.withId(R.id.btn_retry))
        button.perform(click())
    }

    @After
    fun tearDown() {
    }
}