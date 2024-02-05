package com.example.ventanas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText usuario, contrasenia;
    private TextView migas1, textView3;
    private String path = "";

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
                    String user = usuario.getText().toString();
                    String password =  contrasenia.getText().toString();
                String consultaSQL = "select user,password from credentials where user='" + user + "';";

                try (DBHandler claseBBDD = new DBHandler(MainActivity.this, "usuarios", null, 1);
                     SQLiteDatabase bbdd = claseBBDD.getWritableDatabase();
                     Cursor ejecucionConsulta = bbdd.rawQuery(consultaSQL, null)) {
                    if (ejecucionConsulta.moveToFirst()) {
                        String contraseniaBBDD = ejecucionConsulta.getString(1);
                        if (contraseniaBBDD.equals(password)) {
                            Intent acceso = new Intent(MainActivity.this, SecActivity.class);
                            acceso.putExtra("Migas", MainActivity.this.getLocalClassName());
                            acceso.putExtra("UserName", usuario.getText().toString());

                            MainActivity.this.startActivity(acceso);
                        } else {
                            Toast.makeText(MainActivity.this, "Los datos son incorrectos", Toast.LENGTH_LONG).show();

                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Los datos son incorrectos", Toast.LENGTH_LONG).show();

                    }
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