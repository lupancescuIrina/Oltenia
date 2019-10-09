package com.example.oltenia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.paperdb.Paper;

public class HomeActivity extends AppCompatActivity {

    private Button LogoutButton;
    private Button accommodation ;
    private Button churches ;
    private Button museums ;
    private Button restaurants ;
    private Button fun ;
    private Button utils ;
    private Button parcs ;
    private Button infos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        LogoutButton=(Button) findViewById(R.id.logoutBtn);
        accommodation=(Button) findViewById(R.id.cazare_btn);
        churches=(Button) findViewById(R.id.churchBtn);
        museums=(Button) findViewById(R.id.museumBtn);
        restaurants=(Button) findViewById(R.id.restBtn);
        fun=(Button) findViewById(R.id.frt_btn);
        utils=(Button) findViewById(R.id.utilBtn);
        parcs=(Button) findViewById(R.id.parcuri_btn);
        infos=(Button) findViewById(R.id.info);


        LogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Paper.book().destroy();
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        accommodation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HomeActivity.this,AccommodationActivity.class);
                intent.putExtra("category", "accommodation");
                startActivity(intent);
            }
        });

        churches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HomeActivity.this,ChurchesActivity.class);
                intent.putExtra("category", "churches");
                startActivity(intent);
            }
        });

        museums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HomeActivity.this,MuseumsActivity.class);
                intent.putExtra("category", "museums");
                startActivity(intent);
            }
        });

        parcs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HomeActivity.this,ParcsActivity.class);
                intent.putExtra("category", "parcs");
                startActivity(intent);
            }
        });

        restaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HomeActivity.this,RestaurantsActivity.class);
                intent.putExtra("category", "restaurants");
                startActivity(intent);
            }
        });

        utils.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HomeActivity.this,UtilsActivity.class);
                intent.putExtra("category", "utils");
                startActivity(intent);
            }
        });

        fun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HomeActivity.this,FunActivity.class);
                intent.putExtra("category", "fun");
                startActivity(intent);
            }
        });

        infos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(HomeActivity.this,InfoActivity.class);
                intent.putExtra("category", "infos");
                startActivity(intent);
            }
        });





    }
}
