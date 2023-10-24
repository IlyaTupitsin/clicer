package com.example.uroc3;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "StartActivity";

    private Integer counter = 0;
    private Integer slogaemoe = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (counter < 10){findViewById(R.id.button2).setEnabled(false);}

    }
    public void onClickBtnAddshifts(View view)
    {
        counter = counter + slogaemoe;
        TextView counterView = findViewById(R.id.txt_counter);
        counterView.setText(counter.toString());
        if (counter < 10){findViewById(R.id.button2).setEnabled(false);}
        else {findViewById(R.id.button2).setEnabled(true);}
    }
    public void onClickBtnAddshiftsUpgrader(View view)
    {
        counter = counter - 10;
        slogaemoe++;
        TextView counterView = findViewById(R.id.txt_counter);
        counterView.setText(counter.toString());
        if (counter < 10){findViewById(R.id.button2).setEnabled(false);}
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null &&
                savedInstanceState.containsKey("counter")) {
            counter = savedInstanceState.getInt("counter");
            TextView counterView = findViewById(R.id.txt_counter);
            counterView.setText(counter.toString());
        }
        Log.d(TAG, "onRestoreInstanceState");
    }

    }

