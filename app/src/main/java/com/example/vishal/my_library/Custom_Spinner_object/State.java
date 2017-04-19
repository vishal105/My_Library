package com.example.vishal.my_library.Custom_Spinner_object;

/**
 * Created by Basavaraju on 4/8/2017.
 */

public class State {

    private int id = 0;
    private String name = "";
    private String abbrev = "";

    public State(int _id, String _name, String _abbrev) {
        this.id = _id;
        this.name = _name;
        this.abbrev = _abbrev;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public String toString(){
        return( name + " (" + abbrev + ")" );
    }
}
