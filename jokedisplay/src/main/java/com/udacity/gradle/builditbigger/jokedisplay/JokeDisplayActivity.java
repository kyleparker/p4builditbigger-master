package com.udacity.gradle.builditbigger.jokedisplay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.udacity.gradle.builditbigger.jokedisplay.utils.Constants;

/**
 * Basic activity to display the joke
 *
 * Created by kyleparker on 11/2/2015.
 */
public class JokeDisplayActivity extends AppCompatActivity {
    private String mJoke;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lib_activity_joke_display);

        getExtras();
        setupToolbar();
        displayJoke();
    }

    private void displayJoke() {
        ((TextView) findViewById(R.id.lib_joke)).setText(TextUtils.isEmpty(mJoke) ?
                getString(R.string.lib_content_no_joke) : mJoke);
    }

    private void setupToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.lib_toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.drawable.ic_action_up);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
            toolbar.post(new Runnable() {
                @Override
                public void run() {
                    toolbar.setTitle("");
                }
            });
        }
    }

    /**
     * Get extras from the intent bundle
     */
    private void getExtras() {
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            mJoke = extras.getString(Constants.EXTRA_JOKE);
        }
    }
}
