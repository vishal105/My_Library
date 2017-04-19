package com.example.vishal.my_library.Custom_Spinner_object;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vishal.my_library.R;
import com.example.vishal.my_library.Support.Generic_Class;


public class SpinnerWithObject extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;

    static Spinner spinner;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_with_object);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        Generic_Class.drawactivity(this);

        spinner = (Spinner) findViewById(R.id.spinner);
        result = (TextView) findViewById(R.id.results);
        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, new State[]{
                new State(1, "Karnataka", "KR"),
                new State(2, "Tamil Nadu", "TN"),
                new State(50, "Kerala", "KL"),
                new State(69, "And", "HY")
        });
        spinner.setAdapter(spinnerArrayAdapter);
        spinner.setOnItemSelectedListener(this);

        Button button = (Button) this.findViewById(R.id.button01);
        button.setOnClickListener(this);


    }


    private void toastState(String prefix, State st) {

        if (st != null) {
            String desc = "Event: " + prefix + "\nstate: " + st.getName();
            desc += "\nabbreviation: " + st.getAbbrev() + "\nid: " + String.valueOf(st.getId());
            result.setText(desc);

            Toast.makeText(getApplicationContext(), desc, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {

        State st = (State) spinner.getSelectedItem();
        toastState("onClick", st);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        State st = (State) spinner.getSelectedItem();

        toastState("OnItemSelected", st);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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
