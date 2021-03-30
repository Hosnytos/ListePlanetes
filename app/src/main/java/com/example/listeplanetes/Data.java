package com.example.listeplanetes;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Data {

    private ArrayList<String> planetes;
    protected String[] taillePlanetes = {"4900", "12000", "12800", "6800", "144000", "120000", "52000", "50000"};


    public String[] getTaillePlanetes() {
        return taillePlanetes;
    }

    public ArrayList<String> getPlanetes() {
        return planetes;
    }

    public Data() {

        nomPlanetes();
    }

    protected void nomPlanetes() {
        planetes = new ArrayList<String>();
        planetes.add("Mercure");
        planetes.add("Venus");
        planetes.add("Terre");
        planetes.add("Mars");
        planetes.add("Jupiter");
        planetes.add("Saturne");
        planetes.add("Uranus");
        planetes.add("Neptune");
    }


}
