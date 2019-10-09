package com.example.oltenia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.oltenia.Prevalent.Prevalent;

import io.paperdb.Paper;

public class ParculNicolaeRomanescu extends AppCompatActivity {



    private Button VisitButton;
    private Button name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcul_nicolae_romanescu);
        getSupportActionBar().hide();
        name=findViewById(R.id.buttonparcRoman);
        VisitButton=findViewById(R.id.buttonVisit);

        VisitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("geo:44.301338, 23.803390"));
                startActivity(i);

            }
        });




    }
}
