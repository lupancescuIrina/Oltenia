package com.example.oltenia;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
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

import java.util.Objects;

import io.paperdb.Paper;

public class LoginActivity extends AppCompatActivity
{
    private EditText InputPhoneNumber, InputPassword;
    private Button LoginButton;
    ProgressDialog loadingBar;
    private String parentDbName = "Users";
    private CheckBox checkboxRememberMe;
    private TextView AdminLink, NotAdminLink;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Objects.requireNonNull(getSupportActionBar()).hide();

        LoginButton = findViewById(R.id.login_btn);
        InputPhoneNumber = findViewById(R.id.login_phone_number_input);
        InputPassword = findViewById(R.id.login_password_input);
        AdminLink = findViewById(R.id.admin_panel_link);
        checkboxRememberMe =  findViewById(R.id.remember_me_checkbox);
        loadingBar = new ProgressDialog(this);
        NotAdminLink = findViewById(R.id.not_admin_panel_link);


        Paper.init(this);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LoginUser();
            }
        });

        AdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginButton.setText(R.string.logheaza_te_ca_admin);
                AdminLink.setVisibility(View.INVISIBLE);
                NotAdminLink.setVisibility(View.VISIBLE);
                parentDbName = "Admins";

            }
        });

            NotAdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                LoginButton.setText(R.string.login);
                AdminLink.setVisibility(View.VISIBLE);
                NotAdminLink.setVisibility(View.INVISIBLE);
                parentDbName="Users";

            }
        });
    }

    private void LoginUser() {
        String phone=InputPhoneNumber.getText().toString();
        String password=InputPassword.getText().toString();

        if(TextUtils.isEmpty(phone))
        {
            Toast.makeText(this,"Introduceţi un număr de telefon...",Toast.LENGTH_SHORT).show();
        }

        else if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this,"Introduceţi o parolă",Toast.LENGTH_SHORT).show();
        }
        else
        {
            loadingBar.setTitle("Logarea contului");
            loadingBar.setMessage("Se asteaptă acreditarile...");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            AllowAccessToAccount(phone, password);

        }
    }

    private void AllowAccessToAccount(final String phone, final String password)
    {
        if(checkboxRememberMe.isChecked())
        {
           Paper.book().write(Prevalent.UserPhoneKey,phone);
           Paper.book().write(Prevalent.UserPasswordKey,password);
        }
        final DatabaseReference RootRef;
        RootRef= FirebaseDatabase.getInstance().getReference();
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                if(! (dataSnapshot.child(parentDbName).child(phone).exists())) {
                    Toast.makeText(LoginActivity.this, "Contul cu acest număr " + phone+ " nu există ", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();

                    Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivity(intent);
                } else {
                    Users userData= dataSnapshot.child(parentDbName).child(phone).getValue(Users.class);
                    if ( userData.getPhone().equals(phone)) {
                        if (userData.getPassword().equals(password)) {
                            if(parentDbName.equals("Admins")){
                                Toast.makeText(LoginActivity.this, "Logare cu succes", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                                Intent intent = new Intent(LoginActivity.this, AdminCategoryActivity.class);
                                startActivity(intent);
                            }
                            else if(parentDbName.equals("Users")){
                                Toast.makeText(LoginActivity.this, "Logare cu succes", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();

                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(intent);
                            }
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
