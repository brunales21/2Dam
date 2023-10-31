package com.example.finalextra

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usuario = findViewById<EditText>(R.id.campo_Nick)
        val contraseña = findViewById<EditText>(R.id.campo_contraseña)
        val telefono = findViewById<EditText>(R.id.campo_telefono)
        val enviar = findViewById<Button>(R.id.Boton_enviar)

        enviar.setOnClickListener{
            if (usuario.getText().toString().isEmpty()||contraseña.getText().toString().isEmpty()){
                Toast.makeText(this, "campo obligatorio vacio", Toast.LENGTH_LONG).show();
            }else{
               if (usuario.getText().toString() != "luis"){
                   Toast.makeText(this, "el campo Nick no es correcto", Toast.LENGTH_LONG).show();
               }else{
                   if (contraseña.getText().toString() != "admin"){
                       Toast.makeText(this, "el campo Contraseña no es correcto", Toast.LENGTH_LONG).show();
                   }else{
                       startActivity(Intent(this, Pantalla2::class.java))
                   }
               }
            }
        }
    }
}