package com.example.vishal.my_library.swipe_and_undo;


import android.content.DialogInterface;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


import com.example.mylibrary.swipeView.OnItemClickListener;
import com.example.mylibrary.swipeView.RecyclerViewAdapter;
import com.example.mylibrary.swipeView.Swipableiitemclicklistner;
import com.example.mylibrary.swipeView.SwipeToDismissTouchListener;
import com.example.vishal.my_library.R;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;


public class Swipe_Undo extends AppCompatActivity implements View.OnClickListener {
   /* DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;*/

    private ArrayList<String> countries = new ArrayList<>();
    private DataAdapter adapter;
    private RecyclerView recyclerView;
    private AlertDialog.Builder alertDialog;
    private EditText et_country;
    DataAdapter dataAdapter;
    private int edit_position;
    private View view;
    private boolean add = false;
    private Paint p = new Paint();
    private int TIME_TO_AUTOMATICALLY_DISMISS_ITEM = -3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe__undo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);*/
        //Generic_Class.drawactivity(this);

        countries.add("Australia");
        countries.add("India");
        countries.add("United States of America");
        countries.add("Germany");
        countries.add("Russia");
        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);

        initViews(recyclerView);
        initDialog();
       /* initViews();
        initDialog();*/
    }

    private void initViews(final RecyclerView recyclerView) {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(Swipe_Undo.this);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
       dataAdapter = new DataAdapter(countries);
        //dataAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(dataAdapter);

        final SwipeToDismissTouchListener<RecyclerViewAdapter> touchListener = new SwipeToDismissTouchListener<>(
                new RecyclerViewAdapter(recyclerView), new SwipeToDismissTouchListener.DismissCallbacks<RecyclerViewAdapter>() {
            @Override
            public boolean canDismiss(int position) {
                return true;
            }

            @Override
            public void onPendingDismiss(RecyclerViewAdapter recyclerView, int position) {

            }

            @Override
            public void onDismiss(RecyclerViewAdapter recyclerView, int position) {
                dataAdapter.notifyItemRemoved(position);
                //countries.remove(position);
                new DataAdapter(countries);

            }
        });
        touchListener.setDismissDelay(TIME_TO_AUTOMATICALLY_DISMISS_ITEM);
        recyclerView.setOnTouchListener(touchListener);

        recyclerView.addOnScrollListener((RecyclerView.OnScrollListener) touchListener.makeScrollListener());

        recyclerView.addOnItemTouchListener(new Swipableiitemclicklistner(this,
                new OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        if (view.getId() == R.id.txt_delete) {
                            touchListener.processPendingDismisses();
                            countries.remove(position);
                            recyclerView.setAdapter(new DataAdapter(countries));
                        } else if (view.getId() == R.id.txt_undo) {
                            touchListener.undoPendingDismiss();
                        } else { // R.id.txt_data
                            Toast.makeText(Swipe_Undo.this, "Position " + position, LENGTH_SHORT).show();
                        }
                    }
                }));

    }

    /* private void initViews() {
         FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
         fab.setOnClickListener(this);
         recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
         recyclerView.setHasFixedSize(true);
         RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
         recyclerView.setLayoutManager(layoutManager);
         adapter = new DataAdapter(countries);
         recyclerView.setAdapter(adapter);
         countries.add("Australia");
         countries.add("India");
         countries.add("United States of America");
         countries.add("Germany");
         countries.add("Russia");
         adapter.notifyDataSetChanged();
         initSwipe();


     }

     private void initSwipe() {
         ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

             @Override
             public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                 return false;
             }

             @Override
             public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                 int position = viewHolder.getAdapterPosition();
                 DataAdapter adapter = (DataAdapter) recyclerView.getAdapter();
                 if (direction == ItemTouchHelper.LEFT) {
                     //adapter.removeItem(position);

                     *//*int swipedPosition = viewHolder.getAdapterPosition();*//*
                    adapter = (DataAdapter) recyclerView.getAdapter();
                    adapter.pendingRemoval(position);
                } else {
                    removeView();
                    edit_position = position;
                    alertDialog.setTitle("Edit Country");
                    et_country.setText(countries.get(position));
                    alertDialog.show();
                }
            }

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

                Bitmap icon;
                if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {

                    View itemView = viewHolder.itemView;
                    float height = (float) itemView.getBottom() - (float) itemView.getTop();
                    float width = height / 3;

                    if (dX > 0) {
                        p.setColor(Color.parseColor("#388E3C"));
                        RectF background = new RectF((float) itemView.getLeft(), (float) itemView.getTop(), dX, (float) itemView.getBottom());
                        c.drawRect(background, p);
                        icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_edit_white);
                        RectF icon_dest = new RectF((float) itemView.getLeft() + width, (float) itemView.getTop() + width, (float) itemView.getLeft() + 2 * width, (float) itemView.getBottom() - width);
                        c.drawBitmap(icon, null, icon_dest, p);
                    } else {
                        p.setColor(Color.parseColor("#D32F2F"));
                        RectF background = new RectF((float) itemView.getRight() + dX, (float) itemView.getTop(), (float) itemView.getRight(), (float) itemView.getBottom());
                        c.drawRect(background, p);
                        icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_delete_white);
                        RectF icon_dest = new RectF((float) itemView.getRight() - 2 * width, (float) itemView.getTop() + width, (float) itemView.getRight() - width, (float) itemView.getBottom() - width);
                        c.drawBitmap(icon, null, icon_dest, p);
                    }
                }
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private void removeView() {
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    private void initDialog() {
        alertDialog = new AlertDialog.Builder(this);
        view = getLayoutInflater().inflate(R.layout.dialog_layout, null);
        alertDialog.setView(view);
        alertDialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (add) {
                    add = false;
                    adapter.addItem(et_country.getText().toString());
                    dialog.dismiss();
                } else {
                    countries.set(edit_position, et_country.getText().toString());
                    adapter.notifyDataSetChanged();
                    dialog.dismiss();
                }

            }
        });
        et_country = (EditText) view.findViewById(R.id.et_country);
    }*/

    private void initDialog() {
        alertDialog = new AlertDialog.Builder(this);
        view = getLayoutInflater().inflate(R.layout.dialog_layout, null);
        alertDialog.setView(view);
        alertDialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (add) {
                    add = false;
                    dataAdapter.addItem(et_country.getText().toString());
                    dialog.dismiss();
                } else {
                    countries.set(edit_position, et_country.getText().toString());
                    dataAdapter.notifyDataSetChanged();
                    dialog.dismiss();
                }

            }
        });
        et_country = (EditText) view.findViewById(R.id.et_country);
    }

    private void removeView() {
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                removeView();
                add = true;
                alertDialog.setTitle("Add Country");
                et_country.setText("");
                alertDialog.show();
                break;
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
       // actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        //drawerLayout.closeDrawers();
    }


}
