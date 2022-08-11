package com.siddhesh.obvioustest.ui

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isRoot
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.siddhesh.commons.models.ImageDetailsModel
import com.siddhesh.obvioustest.R
import com.siddhesh.obvioustest.adapters.GridAdapter
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ImageGridActivityTest {

    @Rule
    @JvmField
    val gridActivityRule = ActivityScenarioRule(ImageGridActivity::class.java)

    @Rule
    @JvmField
    val detailsActivityRule = ActivityScenarioRule(ImageDetailsActivity::class.java)

//    private val idlingResource =
//        IntentServiceIdlingResource(ApplicationProvider.getApplicationContext())

    @Before
    fun setUp() {
        ActivityScenario.launch(ImageGridActivity::class.java)
//        IdlingRegistry.getInstance().register(idlingResource)

    }

    @Test
    fun checkUI() {
        onView(ViewMatchers.withId(R.id.rcv_image))
        onView(ViewMatchers.withId(R.id.progressBar))
        onView(ViewMatchers.withId(R.id.tv_error_text))
        onView(ViewMatchers.withId(R.id.btn_retry))
    }

    @Test
    fun checkDetailsScreenLaunchWithEmptyDetails() {
        val intent =
            Intent(ApplicationProvider.getApplicationContext(), ImageDetailsActivity::class.java)
        intent.putExtra(ImageDetailsActivity.KEY_IMAGE_DETAILS, ImageDetailsModel())
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        ActivityCompat.startActivity(ApplicationProvider.getApplicationContext(), intent, null)
    }


    @Test
    fun checkDetailsScreenLaunchWithNullDetails() {
        val imageDetailsModel = ImageDetailsModel()
        imageDetailsModel.url = null
        imageDetailsModel.hdURL = null
        imageDetailsModel.explanation = null
        imageDetailsModel.title = null
        imageDetailsModel.date = null

        val intent =
            Intent(ApplicationProvider.getApplicationContext(), ImageDetailsActivity::class.java)
        intent.putExtra(ImageDetailsActivity.KEY_IMAGE_DETAILS, imageDetailsModel)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        ActivityCompat.startActivity(ApplicationProvider.getApplicationContext(), intent, null)
        onView(isRoot()).perform(waitFor(3000))

    }

    @Test
    fun checkDetailsScreenLaunchWithActualDetails() {
        val imageDetailsModel = ImageDetailsModel()
        imageDetailsModel.url = "https://apod.nasa.gov/apod/image/1912/M27_Mazlin_960.jpg"
        imageDetailsModel.hdURL = "https://apod.nasa.gov/apod/image/1912/M27_Mazlin_2000.jpg"
        imageDetailsModel.explanation =
            "Is this what will become of our Sun? Quite possibly.  The first hint of our Sun's future was discovered inadvertently in 1764. At that time, Charles Messier was compiling a list of diffuse objects not to be confused with comets. The 27th object on Messier's list, now known as M27 or the Dumbbell Nebula, is a planetary nebula, the type of nebula our Sun will produce when nuclear fusion stops in its core. M27 is one of the brightest planetary nebulae on the sky, and can be seen toward the constellation of the Fox (Vulpecula) with binoculars. It takes light about 1000 years to reach us from M27, featured here in colors emitted by hydrogen and oxygen. Understanding the physics and significance of M27 was well beyond 18th century science. Even today, many things remain mysterious about bipolar planetary nebula like M27, including the physical mechanism that expels a low-mass star's gaseous outer-envelope, leaving an X-ray hot white dwarf.   APOD across world languages: Arabic, Catalan, Chinese (Beijing), Chinese (Taiwan), Croatian, Czech, Dutch, Farsi, French, French, German, Hebrew, Indonesian, Japanese, Korean, Montenegrin, Polish, Russian, Serbian, Slovenian,  Spanish and Ukrainian"
        imageDetailsModel.title = "M27: The Dumbbell Nebula"
        imageDetailsModel.date = "2019-12-03"
        val intent =
            Intent(ApplicationProvider.getApplicationContext(), ImageDetailsActivity::class.java)
        intent.putExtra(ImageDetailsActivity.KEY_IMAGE_DETAILS, imageDetailsModel)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        ActivityCompat.startActivity(ApplicationProvider.getApplicationContext(), intent, null)
        onView(isRoot()).perform(waitFor(5000))
    }

    @Test
    fun checkRecyclerviewItemClick() {
        val viewInteraction = onView(ViewMatchers.withId(R.id.rcv_image))
        onView(isRoot()).perform(waitFor(7000))
        viewInteraction.inRoot(
            RootMatchers.withDecorView(
                Matchers.`is`(
                    getActivity()?.window?.decorView
                )
            )
        )
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<GridAdapter.ViewHolder>(
                    1, click()
                )
            )
        onView(isRoot()).perform(waitFor(5000))

    }

    @Test
    fun checkRecyclerviewScroll() {
        val viewInteraction = onView(ViewMatchers.withId(R.id.rcv_image))
        onView(isRoot()).perform(waitFor(7000))
        val imageRecyclerView = getActivity()?.findViewById<RecyclerView>(R.id.rcv_image)
        val itemCount = imageRecyclerView?.adapter?.itemCount
        viewInteraction.inRoot(
            RootMatchers.withDecorView(
                Matchers.`is`(
                    getActivity()?.window?.decorView
                )
            )
        )
            .perform(RecyclerViewActions.scrollToPosition<GridAdapter.ViewHolder>(itemCount!! - 1))
        onView(isRoot()).perform(waitFor(5000))
    }

    @Test
    fun checkRecyclerviewItemVisibility() {
        val viewInteraction = onView(ViewMatchers.withId(R.id.rcv_image))
        onView(isRoot()).perform(waitFor(7000))
        viewInteraction.inRoot(
            RootMatchers.withDecorView(
                Matchers.`is`(
                    getActivity()?.window?.decorView
                )
            )
        )
        viewInteraction.check(
            matches(
                withViewAtPosition(
                    1, Matchers.allOf(
                        ViewMatchers.withId(R.id.cv_row), isDisplayed()
                    )
                )
            )
        )
        onView(isRoot()).perform(waitFor(5000))
    }


    @After
    fun tearDown() {
//        IdlingRegistry.getInstance().unregister(idlingResource)
    }

    private fun waitFor(delay: Long): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> = isRoot()
            override fun getDescription(): String = "wait for $delay milliseconds"
            override fun perform(uiController: UiController, v: View?) {
                uiController.loopMainThreadForAtLeast(delay)
            }
        }
    }

    private fun getActivity(): Activity? {
        var activity: Activity? = null
        gridActivityRule.scenario.onActivity {
            activity = it
        }
        return activity
    }

    private fun withViewAtPosition(position: Int, itemMatcher: Matcher<View>): Matcher<View> {
        return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
            override fun describeTo(description: Description?) {
                itemMatcher.describeTo(description)
            }

            override fun matchesSafely(recyclerView: RecyclerView): Boolean {
                val viewHolder = recyclerView.findViewHolderForAdapterPosition(position)
                return viewHolder != null && itemMatcher.matches(viewHolder.itemView)
            }
        }
    }
}