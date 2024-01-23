package com.example.ventanas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {

    Button volver3;
    String path;
    TextView textView2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_view);
        volver3 = findViewById(R.id.volver3);
        textView2 = findViewById(R.id.textView2);
        path = getIntent().getStringExtra("Migas") + " > " + getClass().getSimpleName();
        String[] devolver = path.split(" > ");
        textView2.setText(path);
        path = devolver[0];
        String userName = getIntent().getStringExtra("UserName");
        volver3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paginaPrincipal = new Intent(Activity3.this, Activity2.class);
                paginaPrincipal.putExtra("Migas", path);
                paginaPrincipal.putExtra("UserName", userName);
                startActivity(paginaPrincipal);

            }
        });
    }


}
