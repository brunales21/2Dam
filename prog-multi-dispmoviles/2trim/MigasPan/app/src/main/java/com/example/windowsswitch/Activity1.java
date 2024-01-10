// Activity1.java

package com.example.windowsswitch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity1 extends AppCompatActivity {

    private TextView textViewWelcome;
    private TextView textViewBreadcrumb;
    private Button buttonBack;
    private Button buttonGoToActivity2;
    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);

        textViewWelcome = findViewById(R.id.textViewWelcome);
        textViewBreadcrumb = findViewById(R.id.textViewBreadcrumb);
        buttonBack = findViewById(R.id.buttonBack);
        buttonGoToActivity2 = findViewById(R.id.buttonGoToActivity2); // Agregado

        String username = getIntent().getStringExtra("USERNAME");

        // Mostrar el nombre de usuario en la pantalla de bienvenida
        textViewWelcome.setText("¡Bienvenido, " + username + "!");

        String s = getIntent().getStringExtra("pathback");
        if (s != null) {
            String[] aux = s.split(" > ");
            path = aux[0] + " > " + aux[1];
        } else {
            // Obtener el nombre de usuario de los extras del Intent
            path = getIntent().getStringExtra("path1") +" > "+this.getClass().getSimpleName();
        }

        textViewBreadcrumb.setText(path);


        // Mostrar "VOLVER" y configurar el clic para volver a la pantalla de inicio
        buttonBack.setVisibility(View.VISIBLE);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity1.this, MainActivity.class);
                intent.putExtra("path2", path);
                startActivity(intent);
            }
        });

        // Configurar el clic del botón "Ir a Actividad 2"
        buttonGoToActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity1.this, Activity2.class);
                intent.putExtra("path2", path);
                startActivity(intent);
            }
        });
    }
}
