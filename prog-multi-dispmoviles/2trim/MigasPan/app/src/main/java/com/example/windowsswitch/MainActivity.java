// MainActivity.java

package com.example.windowsswitch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_REGISTRO = 2;

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;
    private TextView textViewBreadcrumb;
    private Button buttonBack;
    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewBreadcrumb = findViewById(R.id.textViewBreadcrumb);
        buttonBack = findViewById(R.id.buttonBack);

        path = this.getClass().getSimpleName();

        // Establecer las migas de pan para MainActivity
        textViewBreadcrumb.setText(path);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                // Verificar las credenciales
                if (username.equals("FEDERICO") && password.equals("alumno@")) {
                    // Iniciar la actividad 1 y pasar el nombre de usuario como parámetro
                    Intent intent = new Intent(MainActivity.this, Activity1.class);
                    intent.putExtra("username1", username);
                    intent.putExtra("path1", path);

                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Ocultar "VOLVER" en la pantalla de inicio
        buttonBack.setVisibility(View.GONE);
    }

    public void mostrarRegistro(View view) {
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivityForResult(intent, REQUEST_CODE_REGISTRO);
    }
}
