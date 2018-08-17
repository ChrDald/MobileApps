package com.mobileapps.jab.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("OnCreate", "On Create Called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("OnStart", "On Start Called");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("OnResume", "On Resume Called");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("OnPause", "On Pause Called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("OnStop", "On Stop Called");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("OnDestroy", "On Destroy Called");

    }
}
