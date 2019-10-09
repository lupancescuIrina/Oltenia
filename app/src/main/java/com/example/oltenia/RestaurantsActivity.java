package com.example.oltenia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantsActivity extends AppCompatActivity {

    private ListView lv;
    private CustomAdapter adapter;
    private ArrayList<ImageModel> imageModelArrayList;
    private int[] myImageList = new int[]{R.drawable.coquette_cafe_bistro_caracal_olt, R.drawable.restaurant_royal_craiova_dolj,
            R.drawable.rsz_restaurant_cadrul_din_stele_beharca_dolj, R.drawable.rsz_restaurantul_casa_alba_ramnicul_valcea, R.drawable.rsz_restaurant_diamantul_de_sare_ramnicul_valcea
            , R.drawable.rsz_restaurant_evrica_costesti_horezu, R.drawable.rsz_restaurant_max_dragasani_valcea,
            R.drawable.rsz_restaurant_simfonia_ramnicu_valcea};
    private String[] myImageNameList = new String[]{"Coquette Cafe Bistro (Caracal, Olt)", "Restaurant_Royal (Craiova, Dolj)",
            "Restaurant Cadrul din Stele (Beharca, Dolj)", "Restaurantul Casa Albă (Râmnicul Vâlcea, Vâlcea)"
            , "Restaurantul Diamantul de Sare (Râmnicul Vâlcea, Vâlcea)", "Restaurantul Evreica (Costești, Horezu)",
            "Restaurant Max (Drăgășani, Olt)", "Restaurant Simfonia (Râmnicul Vâlcea, Vâlcea)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        getSupportActionBar().hide();
        lv = (ListView) findViewById(R.id.list_view);
        imageModelArrayList = populateList();
        Log.d("Parcs", imageModelArrayList.size() + "");
        adapter = new CustomAdapter(this, imageModelArrayList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Intent intent = new Intent(RestaurantsActivity.this, ParculNicolaeRomanescu.class);
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

