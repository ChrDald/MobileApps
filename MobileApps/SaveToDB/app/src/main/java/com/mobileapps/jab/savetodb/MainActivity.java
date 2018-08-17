package com.mobileapps.jab.savetodb;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Stetho.initializeWithDefaults(this);
        new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
    }

    public void saveData(View view) {

        EditText edtName = findViewById(R.id.name);
        EditText edtAddress = findViewById(R.id.address);
        EditText edtPhone = findViewById(R.id.phone);



        if (edtName.getText().toString().equals("") || edtAddress.getText().toString().equals("") || edtPhone.getText().toString().equals("")) {
            Log.e("Blank Field", "All fields must be filled");
            return;
        }
        else {
            String name = edtName.getText().toString();
            String address = edtAddress.getText().toString();
            String phone = edtPhone.getText().toString();

            saveToDB(name, address, phone);
        }
    }

    // not sure if this should be here
    public void saveToDB(String name, String address, String phone) {

        DbHelper dbHelper = new DbHelper(this, "Users", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("address", address);
        values.put("phone", phone);

        long rowID = db.insert("user", null, values);
        if ( rowID == 0) {
            Log.e("Error", "Error inserting into database");
        }
        else {
            Log.e("Success", "Row inserted: " + rowID);
        }
    }

    public void getAllEntriesFromDB() {
        DbHelper dbHelper = new DbHelper(this, "Users", null, 1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        ContentValues row = new ContentValues();

        String[] cols = {"name", "address", "phone"};

        Cursor cursor = db.query("user", cols, null, null, null, null, null);

        while (cursor.moveToNext()) {
            row.put("name", cursor.getString(0));
            row.put("address", cursor.getString(1));
            row.put("phone", cursor.getString(2));

             Log.e("Row", row.toString());

             //cursor.moveToNext();
        }
        cursor.close();
        db.close();


    }

    public void showAllEntries(View view) {
        getAllEntriesFromDB();
    }
}
