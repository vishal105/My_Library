package com.example.vishal.my_library.stikyheader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mylibrary.StikyHeader.DividerDecoration;
import com.example.mylibrary.StikyHeader.StickyHeaderDecoration;
import com.example.vishal.my_library.R;

public class StickyHeader extends AppCompatActivity implements RecyclerView.OnItemTouchListener {
    private RecyclerView mList;
    private StickyHeaderDecoration decor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticky_header);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mList = (RecyclerView) findViewById(R.id.list);

        final DividerDecoration divider = new DividerDecoration.Builder(this)
                .setHeight(R.dimen.default_divider_height)
                .setPadding(R.dimen.default_divider_padding)
                .setColorResource(R.color.default_header_color)
                .build();

        mList.setHasFixedSize(true);
        mList.setLayoutManager(new LinearLayoutManager(this));
        mList.addItemDecoration(divider);

        //setAdapterAndDecor(mList);
        final StickyTestAdapter adapter = new StickyTestAdapter(this);
        decor = new StickyHeaderDecoration(adapter);
        //setHasOptionsMenu(true);

        mList.setAdapter(adapter);
        mList.addItemDecoration(decor, 1);
        mList.addOnItemTouchListener(this);

    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View v = rv.findChildViewUnder(e.getX(), e.getY());
        return v == null;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        // only use the "UP" motion event, discard all others
        if (e.getAction() != MotionEvent.ACTION_UP) {
            return;
        }

        // find the header that was clicked
        View view = decor.findHeaderViewUnder(e.getX(), e.getY());

        if (view instanceof TextView) {
            Toast.makeText(this, ((TextView) view).getText() + " clicked", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
// do nothing
    }
    //protected abstract void setAdapterAndDecor(RecyclerView list);
}
