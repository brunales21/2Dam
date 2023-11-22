package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int contadorNegro = 0;
    private int contadorRojo = 0;
    private TextView mensajeTextView;

    private ImageButton botonNegro;
    private ImageButton botonRojo;
    private Button botonReiniciar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonNegro = findViewById(R.id.botonNegro);
        botonRojo = findViewById(R.id.botonRojo);
        botonReiniciar = findViewById(R.id.botonReiniciar);

        mensajeTextView = findViewById(R.id.mensajeTextView);

        botonNegro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (contadorNegro + contadorRojo < 3) {
                    contadorNegro++;
                    evaluarContadores();
                    botonNegro.setEnabled(true);
                } else {
                    mostrarMensaje("Ya has alcanzado el límite de clics");
                }
            }
        });

        botonRojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (contadorNegro + contadorRojo < 3) {
                    contadorRojo++;
                    evaluarContadores();
                    botonRojo.setEnabled(true);
                } else {
                    mostrarMensaje("Ya has alcanzado el límite de clics");
                }
            }
        });

        botonReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reiniciarContadores();
            }
        });
    }

    private void evaluarContadores() {
        if (contadorNegro + contadorRojo == 3) {
            if (contadorNegro > contadorRojo) {
                mostrarMensaje("Estás pesimista");
            } else if (contadorRojo > contadorNegro) {
                mostrarMensaje("Estás optimista");
            }
        }
    }

    private void reiniciarContadores() {
        contadorNegro = 0;
        contadorRojo = 0;

        ImageButton botonNegro = findViewById(R.id.botonNegro);
        botonNegro.setEnabled(true);

        ImageButton botonRojo = findViewById(R.id.botonRojo);
        botonRojo.setEnabled(true);

        mostrarMensaje("Contadores reiniciados");
    }
    private void mostrarMensaje(String mensaje) {
        mensajeTextView.setText(mensaje);
    }
}
