package com.example.ventanas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    Button button2;
    EditText user, pss;
    Spinner spinner;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_view);
        button2 = findViewById(R.id.button2);
        user = findViewById(R.id.user);
        pss = findViewById(R.id.pss);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paginaPrincipal = new Intent(Register.this, MainActivity.class);
                paginaPrincipal.putExtra("user", user.getText().toString());
                paginaPrincipal.putExtra("pasword", pss.getText().toString());
                startActivity(paginaPrincipal);
            }
        });

        spinner = (Spinner) findViewById(R.id.spinner);
        String[] valores = {"Principiante", "Aficionado", "Exportar"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores);
        spinner.setAdapter(adapter);
    }
}
