package com.mobileapps.jab.jabapppractice;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    // called when a menu item is clicked
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int selectedItemID = item.getItemId();
        String tag = "";
        String msg = "";

        switch (selectedItemID) {

            case R.id.mapLocation:
                showOnMap();

                return true;
            case R.id.about:

                showAboutPage();
                return true;
            case R.id.webLink:

                showOnBrowser();
                return true;
            default:
                Log.e("Error", "No Item Selected");
        }
        return super.onOptionsItemSelected(item);
    }

    // show on map
    public void showOnMap() {
        final double COLLEGE_LONG = 45.405952;
        final double COLLEGE_LAT = -73.9418622;

        // this is actually specifically (explicit) for google maps
        // Create a Uri from an intent string. Use the result to create an Intent.
        Uri mapsURI = Uri.parse("google.streetview:cbll=" + COLLEGE_LONG + "," + COLLEGE_LAT);

        // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapsURI);
        // Make the Intent explicit by setting the Google Maps package

        mapIntent.setPackage("com.google.android.apps.maps");

        // Attempt to start an activity that can handle the Intent
        startActivity(mapIntent);

    }

    public void showOnBrowser() {
        Uri jabURI = Uri.parse("http://www.johnabbott.omnivox.ca/");
        Intent intent = new Intent(Intent.ACTION_VIEW, jabURI);

        // in case the package manager cant find the activity
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    public void showAboutPage() {
        Intent intent = new Intent(MainActivity.this, AboutUsActivity.class);
        startActivity(intent);
    }
}
