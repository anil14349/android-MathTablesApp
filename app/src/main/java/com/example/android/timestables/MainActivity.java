package com.example.android.timestables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    public void createTimeTable(int timeTableNumber) {

        List<String> listContent = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
            listContent.add(Integer.toString(timeTableNumber)+" X "+Integer.toString(i)+" = "+Integer.toString(i * timeTableNumber));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listContent);

        listView.setAdapter(adapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = findViewById(R.id.timeTableSeekBar);
        listView = findViewById(R.id.timeTableListView);

        int max = 25;
        int defaultNum = 10;
        seekBar.setMax(max);
        seekBar.setProgress(defaultNum);

        createTimeTable(defaultNum);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timeTableNumber;
                if (progress < min) {
                    timeTableNumber = min;
                    seekBar.setProgress(min);
                } else {
                    timeTableNumber = progress;
                }

                //Log.i("SeekBar Val : ", Integer.toString(timeTableNumber));
                createTimeTable(timeTableNumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}