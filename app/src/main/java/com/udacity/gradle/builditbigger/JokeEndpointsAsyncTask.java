package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.gcmjokeserver.jokeApi.JokeApi;
import com.udacity.gradle.builditbigger.jokedisplay.JokeDisplayActivity;
import com.udacity.gradle.builditbigger.jokedisplay.utils.Constants;

import java.io.IOException;

// DONE: App retrieves jokes from Google Cloud Endpoints module and displays them via an Activity from the Android Library.
// DONE: The app displays a loading indicator while the joke is being fetched from the server.
// DONE: The free app variant displays interstitial ads between the main activity and the joke-displaying activity.
/**
 * Retrieve the jokes from the Cloud Endpoint and display the activity from the library
 *
 * Created by kyleparker on 11/3/2015.
 */
public class JokeEndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private JokeApi mJokeApiService = null;
    private Context mContext;
    private ProgressDialog mProgressDialog;

//    private JokeGetTaskListener mListener = null;
//    private Exception mError = null;

    public JokeEndpointsAsyncTask(Context context) {
        mContext = context;
    }

    @Override
    protected String doInBackground(Void... params) {
        try {
            if (mJokeApiService == null) {
                JokeApi.Builder builder;

                if (BuildConfig.DEBUG) {
                    builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                            // options for running against local devappserver
                            // - 10.0.2.2 is localhost's IP address in Android emulator
                            // - turn off compression when running against local devappserver
                            .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                            .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                                @Override
                                public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                    abstractGoogleClientRequest.setDisableGZipContent(true);
                                }
                            });
                } else {
                    // TODO: Update to use a deployed App Engine instance
                    builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                            .setRootUrl("UPDATE_WITH_BACKEND_BASED_ON_PROJECT_ID");
                }

                mJokeApiService = builder.build();
            }

            return mJokeApiService.getJoke().execute().getData();
        } catch (IOException e) {
//            mError = e;
            return e.getMessage();
        }
    }

    @Override
    protected void onPreExecute() {
        if (mContext != null) {
            mProgressDialog = new ProgressDialog(mContext);
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setTitle(R.string.content_loading_joke_title);
            mProgressDialog.setMessage(mContext.getString(R.string.content_loading_joke_message));
            mProgressDialog.show();
        }
    }

    @Override
    protected void onPostExecute(String result) {
//        if (mListener != null) {
//            mListener.onComplete(result, mError);
//        }

        if (mContext != null) {
            mProgressDialog.dismiss();

            // Launch the joke display activity (this is contained in the JokesDisplay library)
            Intent intent = new Intent(mContext, JokeDisplayActivity.class);
            intent.putExtra(Constants.EXTRA_JOKE, result);
            mContext.startActivity(intent);
        }
    }

//    @Override
//    protected void onCancelled() {
//        if (mListener != null) {
//            mError = new InterruptedException("AsyncTask cancelled");
//            mListener.onComplete(null, mError);
//        }
//    }
//
//    public JokeEndpointsAsyncTask setListener(JokeGetTaskListener listener) {
//        mListener = listener;
//        return this;
//    }
//
//    public interface JokeGetTaskListener {
//        void onComplete(String joke, Exception error);
//    }
}