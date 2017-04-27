package com.example.vishal.my_library.statusview_Hike;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.mylibrary.StatusView.Status;
import com.example.mylibrary.StatusView.StatusView;
import com.example.vishal.my_library.R;

public class StatusviewHike extends AppCompatActivity {
    Button complete;
    Button error;
    Button loading;
    Button idle;
    StatusView statusView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statusview_hike);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        statusView = (StatusView) findViewById(R.id.status);
        complete = (Button) findViewById(R.id.complete);
        error = (Button) findViewById(R.id.error);
        loading = (Button) findViewById(R.id.loading);
        idle = (Button) findViewById(R.id.idle);


        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statusView.setStatus(Status.COMPLETE);
            }
        });

        error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statusView.setStatus(Status.ERROR);
            }
        });

        loading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statusView.setStatus(Status.LOADING);
            }
        });

        idle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statusView.setStatus(Status.IDLE);
            }
        });
    }

}
