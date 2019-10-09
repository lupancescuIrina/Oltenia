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

public class FunActivity extends AppCompatActivity {

    private ListView lv;
    private CustomAdapter adapter;
    private ArrayList<ImageModel> imageModelArrayList;
    private int[] myImageList = new int[]{R.drawable.anna_super_2000_caffe_lounge_targu_jiu, R.drawable.cafe_teatru_play_craiova_dolj,
            R.drawable.caractere_club_cafe, R.drawable.club_300_craiova_dolj
            , R.drawable.club_imperium_carcal_olt, R.drawable.club_paka_caracal_olt,
            R.drawable.club_q_craiova_dolj, R.drawable.towers_cafe_targu_jiu};
    private String[] myImageNameList = new String[]{"Anna Super 2000 Caffe Lounge (Târgu Jiu, Gorj) ", "Cafe Teatru Play (Craiova, Dolj)",
            "Caractere Club Cafe (Târgu Jiu, Gorj)", "Club 300 (Craiova, Dolj)"
            , "Club Imperium (Caracal, Olt)", "Club Paka (Caracal, Olt)",
            "Club Q (Craiova, Dolj)", "Towers Cafe (Târgu Jiu, Gorj)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun);
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
                    Intent intent = new Intent(FunActivity.this, ParculNicolaeRomanescu.class);
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

