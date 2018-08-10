package com.mobile.a1796146.firstproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView tvHello = findViewById(R.id.tvHello);
        final Button btnRandom = findViewById(R.id.btnRandom);
        final int[] studentIds = {100, 101, 102, 103, 104, 105 };

        btnRandom.setOnClickListener(new View.OnClickListener(

        ) {
            public void onClick(View v) {
                setRandomID(tvHello, studentIds);
            }
        });

    }
    private void setRandomID(TextView tvHello, int[] studentIds) {

        Random rand = new Random();
        int randomID = rand.nextInt(studentIds.length);
        tvHello.setText( studentIds[randomID] + "" );
    }
}
