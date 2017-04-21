package com.example.vishal.my_library.Support;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.vishal.my_library.Charts.Barchart;
import com.example.vishal.my_library.Charts.Bubblechart;
import com.example.vishal.my_library.Charts.Linechart;
import com.example.vishal.my_library.Charts.Piechart;
import com.example.vishal.my_library.Custom_Spinner_object.SpinnerWithObject;
import com.example.vishal.my_library.FloatingWithAnimation.PathAnimation;
import com.example.vishal.my_library.FloatingWithAnimation.TumblrAnimation;
import com.example.vishal.my_library.R;
import com.example.vishal.my_library.stikyheader.StickyHeader;
import com.example.vishal.my_library.swipe_and_undo.Swipe_Undo;


/**
 * Created by VISHAL on 4/8/2017.
 */

public class Generic_Class {
    public static void  drawactivity(final Context context){
        final TextView barchartdraw,bubblechartdraw,piechartdraw,linechartdraw,customapinnerdraw,swipeundodraw,
                stikyheaderdraw,floatdraw,float2draw;
        barchartdraw =(TextView)((Activity)context).findViewById(R.id.tv_bar_chart_draw);
        bubblechartdraw =(TextView)((Activity)context).findViewById(R.id.tv_bubble_chart_draw);
        piechartdraw =(TextView)((Activity)context).findViewById(R.id.tv_pie_chart_draw);
        linechartdraw =(TextView)((Activity)context).findViewById(R.id.tv_line_chart_draw);
        customapinnerdraw =(TextView)((Activity)context).findViewById(R.id.tv_spinner_object_draw);
        swipeundodraw = (TextView) ((Activity) context).findViewById(R.id.tv_swipeactivitydraw);
        stikyheaderdraw = (TextView) ((Activity) context).findViewById(R.id.tv_stikyheader_draw);
        floatdraw = (TextView) ((Activity) context).findViewById(R.id.tv_floatanimationdraw);
        float2draw = (TextView) ((Activity) context).findViewById(R.id.tv_floatanimation2draw);

        barchartdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)context).startActivity(new Intent(context, Barchart.class));
                ((Activity) context).finish();
            }
        });
        bubblechartdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)context).startActivity(new Intent(context, Bubblechart.class));
                ((Activity) context).finish();
            }
        });
        piechartdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)context).startActivity(new Intent(context, Piechart.class));
                ((Activity) context).finish();
            }
        });
        linechartdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)context).startActivity(new Intent(context, Linechart.class));
                ((Activity) context).finish();
            }
        });
        customapinnerdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)context).startActivity(new Intent(context, SpinnerWithObject.class));
                ((Activity) context).finish();
            }
        });
        swipeundodraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)context).startActivity(new Intent(context, Swipe_Undo.class));
                ((Activity) context).finish();
            }
        });
        stikyheaderdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, StickyHeader.class));
                ((Activity) context).finish();
            }
        });
        floatdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, PathAnimation.class));
                ((Activity) context).finish();
            }
        });
        float2draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, TumblrAnimation.class));
                ((Activity) context).finish();
            }
        });
    }
}
