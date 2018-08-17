package com.mobileapps.jab.recyclelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
    }

    public void initRecyclerView() {
        RecyclerView recView = findViewById(R.id.recView);
        RecycleAdapter adapter = new RecycleAdapter();

        recView.setAdapter(adapter);
        recView.setLayoutManager(new LinearLayoutManager(this));
    }
}
