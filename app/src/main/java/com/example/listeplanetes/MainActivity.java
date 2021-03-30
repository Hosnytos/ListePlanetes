package com.example.listeplanetes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    protected ArrayList<String> planetes;
    ListView listview;
    PlaneteAdapter adapter;
    Button btn;
    Data data;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button2);
        listview = (ListView) findViewById(R.id.listView);

        data = new Data();
        adapter = new PlaneteAdapter(this);
        listview.setAdapter(adapter);

        btn.setEnabled(false);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                int score = 0;

                String[] taillesPlanetes = data.getTaillePlanetes();

                for (int i = 0; i < taillesPlanetes.length; i++){
                    View vw =listview.getChildAt(i); //On récupère la vue
                    spinner = vw.findViewById(R.id.spinner);
                    if(spinner.getSelectedItem().toString().equals(taillesPlanetes[i])){ //si le texte selectionner correspond au contenu de la reponse
                        score+=1;
                    }
                }
                Toast.makeText(MainActivity.this, "Score: "+score+"/"+taillesPlanetes.length, Toast.LENGTH_SHORT).show(); //On affiche le résultat de l'utilisateur
            }
        });

    }





}