package com.example.oltenia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AdminCategoryActivity extends AppCompatActivity {


    private Button accommodation ;
    private Button churches ;
    private Button museums ;
    private Button restaurants ;
    private Button fun ;
    private Button utils ;
    private Button parcs ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);
        getSupportActionBar().hide();


        accommodation = (Button) findViewById(R.id.cazare_btn);
        churches = (Button) findViewById(R.id.churchBtn);
        museums = (Button) findViewById(R.id.museumBtn);
        restaurants = (Button) findViewById(R.id.restBtn);
        fun = (Button) findViewById(R.id.frt_btn);
        utils = (Button) findViewById(R.id.utilBtn);
        parcs = (Button)  findViewById(R.id.parcuri_btn);

        accommodation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(AdminCategoryActivity.this,AdminActivity.class);
                intent.putExtra("category", "accommodation");
                startActivity(intent);
            }
        });

        churches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(AdminCategoryActivity.this,AdminActivity.class);
                intent.putExtra("category", "churches");
                startActivity(intent);
            }
        });
        museums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(AdminCategoryActivity.this,AdminActivity.class);
                intent.putExtra("category", "museums");
                startActivity(intent);
            }
        });

        parcs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(AdminCategoryActivity.this,AdminActivity.class);
                intent.putExtra("category", "parcs");
                startActivity(intent);
            }
        });

        restaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(AdminCategoryActivity.this,AdminActivity.class);
                intent.putExtra("category", "restaurants");
                startActivity(intent);
            }
        });

        fun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(AdminCategoryActivity.this,AdminActivity.class);
                intent.putExtra("category", "fun");
                startActivity(intent);
            }
        });

        utils.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(AdminCategoryActivity.this,AdminActivity.class);
                intent.putExtra("category", "utils");
                startActivity(intent);
            }
        });







    }
}
