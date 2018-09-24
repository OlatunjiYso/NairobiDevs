package com.olatunji.nairobijavadev;

import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.olatunji.nairobijavadev.util.EspressoIdlingResource;
import com.olatunji.nairobijavadev.view.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class ActivityMainTest {

    /**
     * Recycler view element's position.
     */
    private static final int SCROLL_POSITION = 40;

    /**
     * Component to be tested
     */
    @Rule
    public IntentsTestRule<MainActivity> mActivityTestRule =
            new IntentsTestRule<>(MainActivity.class);

    /**
     * Setup test suite.
     *
     * @throws Exception Exception
     */
    @Before
    public void setUp() throws Exception {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getIdlingResource());
    }

    /**
     * Teardown resources.
     *
     * @throws Exception Exception
     */
    @After
    public void tearDown() throws Exception {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getIdlingResource());
    }

    /**
     * Ensure recyclerview is displayed
     */
    @Test
    public void recylerViewShouldBeDisplayed() {
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()));
    }

    /**
     * Ensure recyclerview is scrollable
     */
    @Test
    public void recyclerViewIsScrollable() {
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.scrollToPosition(SCROLL_POSITION));
    }

    /**
     * Ensure refresh can be done by swiping
     */
    @Test
    public void swipeToRefeshdisplayed() {
        onView(withId(R.id.swipe_container)).check(matches(isDisplayed()));
    }

}
