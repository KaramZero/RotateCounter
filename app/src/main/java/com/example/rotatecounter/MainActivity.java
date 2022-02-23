package com.example.rotatecounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int count=0;
    public static final String countKey="count";
    TextView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null){
            count=savedInstanceState.getInt(countKey);
        }

        setContentView(R.layout.activity_main);

        view = findViewById(R.id.counter);
        String out = count+"";
        view.setText(out);


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(countKey,count);
        super.onSaveInstanceState(outState);
    }


    @Override
    protected void onStop() {
        super.onStop();
        count++;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
       if(count>0)
           count--;
    }
}