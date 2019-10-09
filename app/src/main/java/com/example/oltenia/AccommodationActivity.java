package com.example.oltenia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AccommodationActivity extends AppCompatActivity {
    private ListView lv;
    private CustomAdapter adapter;
    private ArrayList<ImageModel> imageModelArrayList;
    private int[] myImageList = new int[]{R.drawable.beau_sejour_conac_interbelic_teslui_olt, R.drawable.casa_de_vacanta_florinmehedinti_dubova,
            R.drawable.casa_de_vacanta_madonadubova, R.drawable.hotel_articus_craiova_dolj
            , R.drawable.maison_platanus_valcea, R.drawable.pensiunea_classs_drobeta_turnu_severin_mehedinti,
            R.drawable.pensiunea_iulia_scoarta_gorj, R.drawable.pensiunea_restaurant_cozia_calimanesti_valcea};
    private String[] myImageNameList = new String[]{"Beau Sejour-Conac Interbelic(Teslui,Olt)", "Casa de vacanţă Florin (Dubova,Mehedinţi)",
            "Casa de vacanță Madona (Dubova, Mehedinți)", "Hotel Articus(Craiova, Dolj)","Maison Platanus(Vâlcea)", "Pensiunea Classs (Drobeta-Turnu Severin, Mehedinţi)"
            , "Pensiunea Iulia (Scoarţa, Gorj)", "Pensiunea Restaurant Cozia (Călimănești, Vâlcea)",
            "Parcul Zăvoi", "Parcul Mircea Cel Bătrân"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accommodation);
        getSupportActionBar().hide();

        lv = (ListView) findViewById(R.id.list_view);

        imageModelArrayList = populateList();
        Log.d("Parcs", imageModelArrayList.size() + "");
        adapter = new CustomAdapter(this, imageModelArrayList);
        lv.setAdapter(adapter);


    }

    private ArrayList<ImageModel> populateList() {

        ArrayList<ImageModel> list = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            ImageModel imageModel = new ImageModel();
            imageModel.setName(myImageNameList[i]);
            imageModel.setImage_drawable(myImageList[i]);
            list.add(imageModel);
        }

        return list;
    }
    }

