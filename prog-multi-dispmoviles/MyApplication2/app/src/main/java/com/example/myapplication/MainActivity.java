package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int contadorNegro = 0;
    private int contadorRojo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout gridLayout = findViewById(R.id.gridLayout);

        // Puedes repetir este bloque para el botón Rojo
        Button botonNegro = findViewById(R.id.botonNegro);
        Button botonReiniciar = findViewById(R.id.botonReiniciar);
        botonNegro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorNegro++;
                evaluarContadores();
            }
        });

        botonReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickReiniciarContadores();
            }
        });
    }

    private void evaluarContadores() {
        if (contadorNegro + contadorRojo == 3) {
            if (contadorNegro > contadorRojo) {
                mostrarMensaje("Estás pesimista");
            } else if (contadorRojo > contadorNegro) {
                mostrarMensaje("Estás optimista");
            } else {
                mostrarMensaje("No hay una tendencia clara");
            }
        }
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    private void onClickReiniciarContadores() {
        contadorNegro = 0;
        contadorRojo = 0;

        // Habilita todos los botones nuevamente
        Button botonNegro = findViewById(R.id.botonNegro);
        botonNegro.setEnabled(true);

        // Agrega el bloque correspondiente para el botón Rojo

        mostrarMensaje("Contadores reiniciados");
    }

    public void onClickBotonNegro(View view) {
        if (contadorNegro + contadorRojo < 3) {
            contadorNegro++;
            evaluarContadores();
            Button botonNegro = (Button) view;
            botonNegro.setEnabled(false); // Deshabilita el botón después de hacer clic
        } else {
            mostrarMensaje("Ya has alcanzado el límite de clics");
        }
    }

    public void onClickBotonRojo(View view) {
        if (contadorNegro + contadorRojo < 3) {
            contadorRojo++;
            evaluarContadores();
            Button botonRojo = (Button) view;
            botonRojo.setEnabled(false); // Deshabilita el botón después de hacer clic
        } else {
            mostrarMensaje("Ya has alcanzado el límite de clics");
        }
    }
}
