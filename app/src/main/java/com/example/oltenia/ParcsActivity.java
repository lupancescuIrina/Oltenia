package com.example.oltenia;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.AdapterView.*;


public class ParcsActivity extends AppCompatActivity {

    private ListView lv;
    private CustomAdapter adapter;
    private ArrayList<ImageModel> imageModelArrayList;
    private int[] myImageList = new int[]{R.drawable.parcnicolae, R.drawable.parculconstantin,
            R.drawable.parcultineretului, R.drawable.parculbotanic
            , R.drawable.parculbrancusi, R.drawable.parculinsulita,
            R.drawable.parculzavoi, R.drawable.parculmirceacelbatran};
    private String[] myImageNameList = new String[]{"Parcul Nicolae Romanescu", "Parcul Constantin Poroineanu",
            "Parcul Tineretului", "Grădina Botanică"
            , "Parcul Central Constantin Brâncuși", "Parcul Insulița",
            "Parcul Zăvoi", "Parcul Mircea Cel Bătrân"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcs);
        getSupportActionBar().hide();

        lv = (ListView) findViewById(R.id.list_view);

        imageModelArrayList = populateList();
        Log.d("Parcs", imageModelArrayList.size() + "");
        adapter = new CustomAdapter(this, imageModelArrayList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Intent intent = new Intent(ParcsActivity.this, ParculNicolaeRomanescu.class);
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

