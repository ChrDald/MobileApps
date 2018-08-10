package com.mobileapps.jab.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

import static com.mobileapps.jab.asynctask.NetworkUtility.getResponseFromHttpUrl;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getAsyncData(View view) {

        //Toast.makeText(this, "Getting Data", Toast.LENGTH_LONG).show();

        try {
            URL apiURL = new URL("https://jsonplaceholder.typicode.com/todos/1");
            new FetchData().execute(apiURL);

            Toast.makeText(this, "Fetching the data", Toast.LENGTH_LONG).show();

        }
        catch (MalformedURLException ex) {
            Log.e("Bad URL", ex.getMessage());
        }


    }

    public class FetchData extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls) {
            URL url = urls[0];
            String response = "";
            try {
                response = NetworkUtility.getResponseFromHttpUrl(url);
            }
            catch (Exception e) {
                e.printStackTrace();
                response = e.getMessage();
            }
            return response;
        }

        // method called when doInBackground is done, String s is the response you returned from that method
        @Override
        protected void onPostExecute(String s) {
            //super.onPostExecute(s);
            TextView txv = findViewById(R.id.txvAsyncResult);
            txv.setText(s);
        }
    }
}
