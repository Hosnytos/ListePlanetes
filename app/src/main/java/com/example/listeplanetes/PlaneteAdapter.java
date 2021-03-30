package com.example.listeplanetes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

class PlaneteAdapter extends BaseAdapter{
    private ArrayList<String> planetes;
    private static int verif=0;
    private final MainActivity acitivity;
    private Data data;

    public PlaneteAdapter(MainActivity mainActivity) {
        this.acitivity = mainActivity;
        this.data = new Data();
        this.planetes = data.getPlanetes();
    }

    @Override
    public int getCount() {
        return data.getPlanetes().size();
    }

    @Override
    public Object getItem(int arg0) {
        return data.getPlanetes().get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)    acitivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.listitem, null);
        }
        TextView nomPlanete = (TextView) itemView.findViewById(R.id.textView);
        final CheckBox checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        final Spinner spinner = (Spinner) itemView.findViewById(R.id.spinner);

        nomPlanete.setText(data.getPlanetes().get(position));

        //  installer l'adaptateur pour la liste déroulante (spinner)
        final ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(acitivity, android.R.layout.simple_spinner_item, data.getTaillePlanetes());
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinadapter);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                CheckBox checkBox = (CheckBox)  compoundButton.findViewById(R.id.checkbox);
                if (checkBox.isChecked()) {
                    verif++;
                } else {
                    verif--;
                }

                if (verif==planetes.size()){
                    Button btn = acitivity.findViewById(R.id.button2);
                    btn.setEnabled(true);
                }
            }
        });

        return itemView;
    }

}