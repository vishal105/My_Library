package com.example.vishal.my_library.Charts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.vishal.my_library.R;
import com.example.vishal.my_library.Support.Generic_Class;
import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Bubblechart extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;

   BubbleChart bubbleChart ;
    ArrayList<BubbleEntry> BARENTRY ;
    ArrayList<String> BubbleEntryLabels ;
    BubbleDataSet Bubbledataset ;
    BubbleData BUBBLEDATA ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble_chart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        Generic_Class.drawactivity(this);

        bubbleChart = (BubbleChart) findViewById(R.id.bubble_chart);
        BARENTRY = new ArrayList<>();
        BubbleEntryLabels = new ArrayList<String>();
        AddValuesToBARENTRY();
        AddValuesToBarEntryLabels();
        Bubbledataset = new BubbleDataSet(BARENTRY, "Projects");
        BUBBLEDATA = new BubbleData(BubbleEntryLabels,  Bubbledataset);
        Bubbledataset.setColors(ColorTemplate.COLORFUL_COLORS);
        bubbleChart.setData(BUBBLEDATA);
        bubbleChart.animateY(3000);

    }
    public void AddValuesToBARENTRY(){

        BARENTRY.add(new BubbleEntry(0,2f,2f));
        BARENTRY.add(new BubbleEntry(1,4f,4.5f));
        BARENTRY.add(new BubbleEntry(2,5f,3f));
        BARENTRY.add(new BubbleEntry(3,1f,6f));
        BARENTRY.add(new BubbleEntry(4,4f,6f));
        BARENTRY.add(new BubbleEntry(5,6f,7f));

    }

    public void AddValuesToBarEntryLabels(){

        BubbleEntryLabels.add("January");
        BubbleEntryLabels.add("February");
        BubbleEntryLabels.add("March");
        BubbleEntryLabels.add("April");
        BubbleEntryLabels.add("May");
        BubbleEntryLabels.add("June");

    }
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        drawerLayout.closeDrawers();
    }
}