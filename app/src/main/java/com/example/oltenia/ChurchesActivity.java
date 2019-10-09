package com.example.oltenia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ChurchesActivity extends AppCompatActivity {

    private ListView lv;
    private CustomAdapter adapter;
    private ArrayList<ImageModel> imageModelArrayList;
    private int[] myImageList = new int[]{R.drawable.biserica_adormirii_maici_domnului, R.drawable.biserica_mantuleasa,
            R.drawable.manastirea_bistrita, R.drawable.manastirea_cornetu
            , R.drawable.manastirea_lainici, R.drawable.manastirea_sfanta_ana,
            R.drawable.manastirea_stanisoara, R.drawable.manastirea_tismana};
    private String[] myImageNameList = new String[]{"Biserica Adormirii Maicii Domnului (Caracal,Olt)", "Biserica Mantuleasa (Craiova, Dolj)",
            "Mănăstirea Bistrița (Costești, Vâlcea)", "Mănăstirea Cornetu (Tuțulești Vâlcea)"
            , "Mănăstirea Lainici (Târgu-Jiu, Gorj)", "Mănăstirea Sfânta Ana (Orșova, Mehedinți)",
            "Mănăstirea Stanișoara (Călimănești Vâlcea)", "Mănăstirea Tismana (Tismana, Gorj)"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_churches);
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
                    Intent intent = new Intent(ChurchesActivity.this, ParculNicolaeRomanescu.class);
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

