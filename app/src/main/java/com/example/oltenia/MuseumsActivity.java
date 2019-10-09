package com.example.oltenia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MuseumsActivity extends AppCompatActivity {
    private ListView lv;
    private CustomAdapter adapter;
    private ArrayList<ImageModel> imageModelArrayList;
    private int[] myImageList = new int[]{R.drawable.ansamblul_cultural_constantin_brancusi, R.drawable.casa_baniei,
            R.drawable.casa_memoriala_constantin_brancusi, R.drawable.castrul_roman_drobeta
            , R.drawable.castrul_roman_pelendava, R.drawable.cetatea_severinului,
            R.drawable.muzeul_de_arta_craiova, R.drawable.muzeul_de_arta_targu_jiu};
    private String[] myImageNameList = new String[]{"Ansamblul Cultural Constantin Brâncuși", "Casa Băniei",
            "Casa Memorială Constantin Brâncuși", "Castrul Roman Drobeta-Turnu Severin"
            , "Castrul Roman Pelendava", "Cetatea Severinului",
            "Muzeul de Artă Craiova", "Muzeul de Artă Târgu Jiu"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museums2);
        getSupportActionBar().hide();

        lv = (ListView) findViewById(R.id.list_view);

        imageModelArrayList = populateList();
        Log.d("Parcs", imageModelArrayList.size() + "");
        adapter = new CustomAdapter(this, imageModelArrayList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(MuseumsActivity.this, ParculNicolaeRomanescu.class);
                    startActivity(intent);
                }
            }
        });

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
