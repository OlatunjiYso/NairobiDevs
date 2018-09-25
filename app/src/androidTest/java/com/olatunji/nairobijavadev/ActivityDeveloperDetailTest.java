package com.olatunji.nairobijavadev;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.olatunji.nairobijavadev.view.DetailActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)

public class ActivityDeveloperDetailTest {

    @Rule
    public ActivityTestRule<DetailActivity> mActivityTestRule =
            new ActivityTestRule<>(DetailActivity.class);

    @Test
    public void developerAvatarShouldBeDisplayed() {
        onView(withId(R.id.iv_profile_image)).check(matches(isDisplayed()));
    }

    @Test
    public void developerNameShouldBeDisplayed() {
        onView(withId(R.id.tv_username)).check(matches(isDisplayed()));
    }

    @Test
    public void githubTextViewShouldBeDisplayed() {
        onView(withId(R.id.tv_giturl)).check(matches(isDisplayed()));
    }

    @Test
    public void shareIconShouldBeDisplayed() {
        onView(withId(R.id.iv_share_button)).check(matches(isDisplayed()));
    }

    @Test
    public void shareButtonIsClickable() {
        onView(withId(R.id.iv_share_button)).check(matches(isClickable()));
    }

}
