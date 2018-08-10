package com.mobile.a1796146.studentidlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> studentIDList = new ArrayList<>();
    HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //final TextView txvHello = findViewById(R.id.txvHello);
        //final Button btnRandomID = findViewById(R.id.btnRandomID);

        for (int i = 0; i < 10; i++) {
            studentIDList.add(i + 100);
            hashMap.put(i, "Student" + (i + 1 + ""));
        }

//        btnRandomID.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                setRandomID();
//            }
//        });

    }
    private void setRandomID() {

        TextView txvHello = findViewById(R.id.txvHello);
        Random rand = new Random();
        int randomID = rand.nextInt(studentIDList.size());
        txvHello.setText( studentIDList.get(randomID) + "" );
    }
    private void setRandomStudentName() {

        TextView txvHello = findViewById(R.id.txvHello);
        Random rand = new Random();
        int randomID = rand.nextInt(hashMap.size());
        txvHello.setText( hashMap.get(randomID) );
    }

    // called when the menu is create (necessary if you want the menu to show)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    // called when a menu item is clicked
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int selectedItemID = item.getItemId();
        String tag = "";
        String msg = "";

        switch (selectedItemID) {

            case R.id.firstItem:

                setRandomID();
//                tag = "FirstItem";
//                msg = "First Item Clicked";
//                Log.i(tag, msg);
                return true;
            case R.id.secondItem:
                setRandomStudentName();
//                tag = "SecondItem";
//                msg = "Second Item Clicked";
                Log.i(tag, msg);
                return true;
            default:
                Log.e("Error", "No Item Selected");
        }
        return super.onOptionsItemSelected(item);
    }
}
