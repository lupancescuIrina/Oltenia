package com.example.oltenia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class UtilsActivity extends AppCompatActivity {

    private ListView lv;
    private CustomAdapter adapter;
    private ArrayList<ImageModel> imageModelArrayList;
    private int[] myImageList = new int[]{R.drawable.primaria_caracal, R.drawable.primaria_craiova,
            R.drawable.primaria_drobeta_turnu_severin, R.drawable.primaria_slatina
            , R.drawable.primaria_targu_jiu, R.drawable.ipj_dolj,
            R.drawable.ipj_mehedinti, R.drawable.ipj_olt};
    private String[] myImageNameList = new String[]{"Primăria Caracal(Olt)", "Primăria Craiova",
            "Primăria Drobeta-Turnu Severin", "Primăria Slatina"
            , "Primăria Târgu Jiu", "IPJ Dolj",
            "IPJ Mehedinți" ,"IPJ Olt"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utils);
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
                    Intent intent = new Intent(UtilsActivity.this, ParculNicolaeRomanescu.class);
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
