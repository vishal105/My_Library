package com.example.vishal.my_library.swipe_and_undo;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.vishal.my_library.R;

import java.util.ArrayList;
import java.util.HashMap;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    //public final ArrayList<String> countries = new ArrayList<String>();
    private ArrayList<String> removeditem;

    int lastInsertedIndex;
    private static final int PENDING_REMOVAL_TIMEOUT = 300000;  //3sec

    private Handler handler = new Handler();
    HashMap<String, Runnable> pendingRunnables = new HashMap<>();

    private static final int SIZE = 100;

    private ArrayList<String> countries;

    DataAdapter(ArrayList<String> countries) {
        this.countries = countries;

    }

    /*DataAdapter() {
        countries.add("Australia");
        countries.add("India");
        countries.add("United States of America");
        countries.add("Germany");
        countries.add("Russia");
        //this.countries = countries;
        *//*removeditem = new ArrayList<>();*//*
    }*/

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.tv_country.setText(countries.get(position));
       /* final String item = countries.get(position);
        if (removeditem.contains(item)) {
            // we need to show the "undo" state of the row
            viewHolder.itemView.setBackgroundColor(Color.parseColor("#D32F2F"));
            viewHolder.tv_country.setVisibility(View.GONE);
            viewHolder.undoButton.setVisibility(View.VISIBLE);
            viewHolder.undoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // user wants to undo the removal, let's cancel the pending task
                    Runnable pendingRemovalRunnable = pendingRunnables.get(item);
                    pendingRunnables.remove(item);
                    if (pendingRemovalRunnable != null)
                        handler.removeCallbacks(pendingRemovalRunnable);
                    removeditem.remove(item);
                    // this will rebind the row in "normal" state
                    notifyItemChanged(countries.indexOf(item));
                }
            });
        }else{
            // we need to show the "normal" state
            viewHolder.itemView.setBackgroundColor(Color.WHITE);
            viewHolder.tv_country.setVisibility(View.VISIBLE);
            viewHolder.tv_country.setText(item);
            viewHolder.undoButton.setVisibility(View.GONE);
            viewHolder.undoButton.setOnClickListener(null);
        }*/
    }

    @Override
    public int getItemCount() {
            return countries.size();
    }
    public void addItem(String country) {
        countries.add(country);
        notifyItemInserted(countries.size());
    }
    public void removeItem(int position) {
        countries.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, countries.size());
    }


    /*public void addItem(String country) {
        countries.add(country);
        notifyItemInserted(countries.size());
    }*/

   /* public void removeItem(int position) {
        countries.remove(position);1
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, countries.size());
    }*/

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_country;
        //Button undoButton;

        public ViewHolder(View view) {
            super(view);

            tv_country = (TextView) view.findViewById(R.id.tv_country);
            //undoButton = (Button) view.findViewById(R.id.undo_button);
        }
    }

    /*public void pendingRemoval(int position) {
        final String item = countries.get(position);
        if (!removeditem.contains(item)) {
            removeditem.add(item);
            // this will redraw row in "undo" state
            notifyItemChanged(position);
            // let's create, store and post a runnable to remove the item
            Runnable pendingRemovalRunnable = new Runnable() {
                @Override
                public void run() {
                    remove(countries.indexOf(item));
                }
            };

            handler.postDelayed(pendingRemovalRunnable, PENDING_REMOVAL_TIMEOUT);
            pendingRunnables.put(item, pendingRemovalRunnable);
        }
    }*/

   /* public void remove(int position) {
        String item = countries.get(position);
        if (removeditem.contains(item)) {
            removeditem.remove(item);
        }
        if (countries.contains(item)) {
            countries.remove(position);
            notifyItemRemoved(position);
        }
    }*/
}