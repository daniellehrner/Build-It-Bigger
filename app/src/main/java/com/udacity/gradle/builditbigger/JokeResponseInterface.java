package com.udacity.gradle.builditbigger;

/**
 * Created by Daniel Lehrner
 */
public interface JokeResponseInterface {
    void onJokeSuccess(String joke);
    void onJokeError();
}
