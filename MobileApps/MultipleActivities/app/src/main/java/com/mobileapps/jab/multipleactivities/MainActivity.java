package com.mobileapps.jab.multipleactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startSecondActivity(View view) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra(Intent.EXTRA_TEXT, "Extra Text");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Extra Subject");

        startActivity(intent);
    }
}
