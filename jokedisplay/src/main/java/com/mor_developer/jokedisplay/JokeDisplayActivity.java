package com.mor_developer.jokedisplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {
    public final static String KEY_JOKE = "com.mor_developer.jokedisplay.key.joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        Intent intent = getIntent();
        String joke = intent.getStringExtra(KEY_JOKE);

        if ((joke != null) && (joke.length() > 0)) {
            TextView jokeTextView = (TextView) findViewById(R.id.jokeDisplayText);

            if (jokeTextView != null) {
                jokeTextView.setText(joke);
            }
        }
    }
}
