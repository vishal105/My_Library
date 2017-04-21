package com.example.vishal.my_library;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.vishal.my_library.Charts.Barchart;
import com.example.vishal.my_library.Charts.Bubblechart;
import com.example.vishal.my_library.Charts.Linechart;
import com.example.vishal.my_library.Charts.Piechart;
import com.example.vishal.my_library.Custom_Spinner_object.SpinnerWithObject;
import com.example.vishal.my_library.stikyheader.StickyHeader;
import com.example.vishal.my_library.swipe_and_undo.Swipe_Undo;


public class DashBoard extends AppCompatActivity implements View.OnClickListener {
    TextView barchart, bubblechart, piechart, linechart, customapinner,swiperecyclerview,stikyHeader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        barchart = (TextView) findViewById(R.id.tv_bar_chart);
        bubblechart = (TextView) findViewById(R.id.tv_bubble_chart);
        piechart = (TextView) findViewById(R.id.tv_pie_chart);
        linechart = (TextView) findViewById(R.id.tv_line_chart);
        customapinner = (TextView) findViewById(R.id.tv_spinner_object);
        swiperecyclerview = (TextView) findViewById(R.id.tv_swipeactivity);
        stikyHeader = (TextView) findViewById(R.id.tv_stikyheader);



        barchart.setOnClickListener(this);
        bubblechart.setOnClickListener(this);
        piechart.setOnClickListener(this);
        linechart.setOnClickListener(this);
        customapinner.setOnClickListener(this);
        swiperecyclerview.setOnClickListener(this);
        stikyHeader.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_bar_chart:
                startActivity(new Intent(DashBoard.this, Barchart.class));
                break;
            case R.id.tv_bubble_chart:
                startActivity(new Intent(DashBoard.this, Bubblechart.class));
                break;
            case R.id.tv_pie_chart:
                startActivity(new Intent(DashBoard.this, Piechart.class));
                break;
            case R.id.tv_line_chart:
                startActivity(new Intent(DashBoard.this, Linechart.class));
                break;
            case R.id.tv_spinner_object:
                startActivity(new Intent(DashBoard.this, SpinnerWithObject.class));
                break;
            case R.id.tv_swipeactivity:
                startActivity(new Intent(DashBoard.this, Swipe_Undo.class));
                break;
            case R.id.tv_stikyheader:
                startActivity(new Intent(DashBoard.this, StickyHeader.class));
                break;

        }

    }
}
