package com.example.ventanas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    Button button;
    EditText usuario, contrasenia;
    TextView migas1, textView3;
    String path = "";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainview);
        button =findViewById(R.id.button);
        usuario = findViewById(R.id.usuario);
        contrasenia = findViewById(R.id.contrasenia);
        migas1 = findViewById(R.id.migas1);
        textView3 = findViewById(R.id.textView3);
        path = getClass().getSimpleName();
        migas1.setText(path);

        String user = getIntent().getStringExtra("user");
        String pass = getIntent().getStringExtra("pasword");
        usuario.setText(user);
        contrasenia.setText(pass);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usuario.getText().toString().equals("FEDERICO")&& contrasenia.getText().toString().equals("alumno@")) {
                    Intent intento = new Intent(MainActivity.this, SecActivity.class);
                    intento.putExtra("UserName",usuario.getText().toString());
                    intento.putExtra("Migas", path);
                    startActivity(intento);

                }else {
                    Toast.makeText(getApplicationContext(),"Datos incorrectos",Toast.LENGTH_SHORT).show();
                }
            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paginaRegistro = new Intent(MainActivity.this, Register.class);
                startActivity(paginaRegistro);
            }
        });
    }


}