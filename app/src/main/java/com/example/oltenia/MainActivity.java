package com.example.oltenia;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.oltenia.Model.Users;
import com.example.oltenia.Prevalent.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    private Button joinNowButton, loginButton;
    ProgressDialog loadingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        joinNowButton=(Button)findViewById(R.id.main_join_btn);
        loginButton=(Button) findViewById(R.id.main_join_login_btn);
        loadingBar= new ProgressDialog(this);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }

        });
            Paper.init(this);

        joinNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        String UserPhoneKey=Paper.book().read(Prevalent.UserPhoneKey);
        String UserPasswordKey=Paper.book().read(Prevalent.UserPasswordKey);

        if(UserPhoneKey!="" && UserPasswordKey !="")
        {
            if(!TextUtils.isEmpty(UserPhoneKey)&& !TextUtils.isEmpty(UserPasswordKey))
            {
                AllowAccess(UserPhoneKey,UserPasswordKey);

                loadingBar.setTitle("Deja conectat");
                loadingBar.setMessage("Vă rugăm aşteptaţi...");
                loadingBar.setCanceledOnTouchOutside(false);
                loadingBar.show();

            }
        }


    }

    private void AllowAccess(final String phone, final String password) {
        final DatabaseReference RootRef;
        RootRef= FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if(! (dataSnapshot.child("Users").child(phone).exists())) {
                    Toast.makeText(MainActivity.this, "Contul cu acest număr " + phone+ " nu există ", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();

                    Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                    startActivity(intent);


                } else {

                    Users userData= dataSnapshot.child("Users").child(phone).getValue(Users.class);

                    if ( userData.getPhone().equals(phone)) {
                        if (userData.getPassword().equals(password)) {
                            Toast.makeText(MainActivity.this, "Logare cu succes", Toast.LENGTH_SHORT).show();
                            loadingBar.dismiss();

                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(intent);
                        }
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {


            }
        });

    }
}
