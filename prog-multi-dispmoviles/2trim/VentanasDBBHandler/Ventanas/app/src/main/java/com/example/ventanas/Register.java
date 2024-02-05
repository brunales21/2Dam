package com.example.ventanas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    Button button2;
    EditText user,pss;
    Spinner spinner ;

    private MainActivity mainActivity;
    DBHandler claseBBDD = new DBHandler(Register.this, "usuarios", null, 1);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        button2 = findViewById(R.id.button2);
        user= findViewById(R.id.user);
        pss = findViewById(R.id.pss);
        mainActivity = new MainActivity();

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userText = String.valueOf(user.getText());
                String passwordText = String.valueOf(pss.getText());
                claseBBDD.addNewCourse(userText,passwordText);
                Toast.makeText(Register.this, "Course has been added.", Toast.LENGTH_SHORT).show();
                Intent paginaPrincipal = new Intent(Register.this, MainActivity.class);
                paginaPrincipal.putExtra("user",userText);
                paginaPrincipal.putExtra("pasword",passwordText);
                startActivity(paginaPrincipal);
            }
        });

        spinner = (Spinner) findViewById(R.id.spinner);
        String [] valores={"principiante","aficionado","exportar"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, valores);
        spinner.setAdapter(adapter);
    }
}
