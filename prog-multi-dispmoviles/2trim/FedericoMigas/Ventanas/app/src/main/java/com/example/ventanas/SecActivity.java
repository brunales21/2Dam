package com.example.ventanas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecActivity extends AppCompatActivity {

    Button volver,actividad3;
    String path;
    TextView textView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.secondview);
        volver= findViewById(R.id.volver);
        actividad3=findViewById(R.id.actividad3);
        textView=findViewById(R.id.textView);

        path = getIntent().getStringExtra("Migas");
        path=path+" > "+getClass().getSimpleName();

        String userName = getIntent().getStringExtra("UserName");

        textView.setText("Hola "+userName+ " "+ path);


        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paginaPrincipal = new Intent(SecActivity.this,MainActivity.class);
                startActivity(paginaPrincipal);
            }
        });

        actividad3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paginaSecundaria = new Intent(SecActivity.this,ThirdActivity.class);
                paginaSecundaria.putExtra("Migas",path);
                paginaSecundaria.putExtra("UserName",userName);
                startActivity(paginaSecundaria);
            }
        });


    }
}