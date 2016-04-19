package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import org.junit.Before;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Daniel Lehrner
 */
public class JokeEndpointAsyncTaskTest extends AndroidTestCase implements JokeResponseInterface {
    private CountDownLatch signal = null;
    private String joke = null;

    @Before
    public void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }

    public void testReturnJoke() {
        JokeEndpointAsyncTask jokeEndpoint = new JokeEndpointAsyncTask();
        jokeEndpoint.setJokeResponse(this);
        jokeEndpoint.execute();

        try {
            // wait until signal.countDown() is called either in
            // onJokeSuccess or onJokeError
            signal.await();
        }
        catch (InterruptedException e) {
            return;
        }

        assertTrue(joke != null);
        assertTrue(joke.length() > 0);
    }


    public void onJokeSuccess(String joke) {
        this.joke = joke;
        signal.countDown();
    }

    public void onJokeError() {
        signal.countDown();
    }
}