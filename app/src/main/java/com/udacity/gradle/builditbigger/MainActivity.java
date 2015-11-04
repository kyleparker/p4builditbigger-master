package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

// DONE: Java library for supplying jokes
// DONE: Android library with an activity that displays jokes passed to it as intent extras.
// DONE: Google Cloud Endpoints module that supplies jokes from the Java library.
// DONE: Loads jokes from GCE module via an async task.
// DONE: Project contains connected tests to verify that the async task is indeed loading jokes.
// DONE: Project contains paid/free flavors. The paid flavor has no ads, and no unnecessary dependencies.
public class MainActivity extends AppCompatActivity {

    private AppCompatActivity mActivity;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActivity = this;
        setupToolbar();

        // For the "free" build, create an interstitial ad to display between the main activity and the joke display activity
        if (BuildConfig.FLAVOR == "free") {
            mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId(mActivity.getString(R.string.banner_ad_unit_id));

            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    requestNewInterstitial();

                    JokeEndpointsAsyncTask task = new JokeEndpointsAsyncTask(mActivity);
                    task.execute();
                }
            });

            requestNewInterstitial();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                // TODO: Refer to Android Monitor to retrieve the TestDeviceID: Use AdRequest.Builder.addTestDevice
                .addTestDevice("51142959BCC9A5F1589FC0E43238B025")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    /**
     * Setup the toolbar for the activity
     */
    private void setupToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.post(new Runnable() {
                @Override
                public void run() {
                    toolbar.setTitle(getString(R.string.app_name));
                }
            });
        }
    }

    /**
     * Handle the button click and launch the async task to display a joke
     *
     * @param view
     */
    public void tellJoke(View view) {
        if (mInterstitialAd != null && mInterstitialAd.isLoaded() && BuildConfig.FLAVOR == "free") {
            mInterstitialAd.show();
        } else {
            JokeEndpointsAsyncTask task = new JokeEndpointsAsyncTask(this);
            task.execute();
        }
    }
}
