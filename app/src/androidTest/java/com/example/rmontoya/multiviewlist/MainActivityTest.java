package com.example.rmontoya.multiviewlist;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.rmontoya.multiviewlist.recyclerview.RecyclerViewMatcher;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testRecyclerViewHeaders() {
        onView(withRecyclerView(R.id.heterogeneos_list).atPosition(0))
                .check(matches(withText("First Header")));

        onView(withRecyclerView(R.id.heterogeneos_list).atPosition(5))
                .check(matches(withText("Second Header")));

        onView(withRecyclerView(R.id.heterogeneos_list).atPosition(8))
                .check(matches(withText("Final Header")));
    }

    @Test
    public void testRecyclerViewRows() {
        onView(withRecyclerView(R.id.heterogeneos_list).atPosition(1))
                .check(matches(hasDescendant(withText("First row"))));

        onView(withRecyclerView(R.id.heterogeneos_list).atPosition(2))
                .check(matches(hasDescendant(withText("Second row"))));

        onView(withRecyclerView(R.id.heterogeneos_list).atPosition(3))
                .check(matches(hasDescendant(withText("Third row"))));

        onView(withRecyclerView(R.id.heterogeneos_list).atPosition(4))
                .check(matches(hasDescendant(withText("Four row"))));

        onView(withRecyclerView(R.id.heterogeneos_list).atPosition(6))
                .check(matches(hasDescendant(withText("Fifth row"))));

        onView(withRecyclerView(R.id.heterogeneos_list).atPosition(7))
                .check(matches(hasDescendant(withText("Sixth row"))));
    }

}