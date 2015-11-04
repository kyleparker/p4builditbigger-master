package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.content.Context;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.MediumTest;
import android.text.TextUtils;
import android.util.Log;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 * Reviewed http://marksunghunpark.blogspot.ru/2015/05/how-to-test-asynctask-in-android.html as foundation for testing
 * the AsyncTask - in the end, this method did not work. Reverted to an example provided by Jeremy on the discussion board:
 * https://discussions.udacity.com/t/writing-tests-for-async-task/25482/8
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

//    private CountDownLatch mSignal = null;
//    private Exception mError = null;
//    private String mJoke = null;

    public ApplicationTest() {
        super(Application.class);
    }

    // NOTE: Attempted this route, but unable to get it working
//    @Override
//    protected void setUp() throws Exception {
//        super.setUp();
//        mSignal = new CountDownLatch(1);
//    }
//
//    @Override
//    protected void tearDown() throws Exception {
//        mSignal.countDown();
//    }

    // https://plus.google.com/+AndroidDevelopers/posts/TPy1EeSaSg8
    // In the event it takes longer than 2 seconds communicate with the AppEngine backend, the @LargeTest annotation was selected
    @LargeTest
    public void testJokeAsyncTask() {
        String joke = null;
        Exception error = null;

        try {
            JokeEndpointsAsyncTask task = new JokeEndpointsAsyncTask(null);
            task.execute();

            joke = task.get(30, TimeUnit.SECONDS);
        } catch (Exception ex) {
            error = ex;
        }

        // NOTE: Attempted this route, but unable to get it working
//        JokeEndpointsAsyncTask task = new JokeEndpointsAsyncTask(null);
//        task.setListener(new JokeEndpointsAsyncTask.JokeGetTaskListener() {
//            @Override
//            public void onComplete(String joke, Exception error) {
//                mJoke = joke;
//                mError = error;
//                mSignal.countDown();
//            }
//        }).execute();
//
//        try {
//            mSignal.await(10, TimeUnit.SECONDS);
//        } catch (Exception ex) {
//            mError = ex;
//        }

        assertNull(error);
        assertFalse(TextUtils.isEmpty(joke));
    }
}