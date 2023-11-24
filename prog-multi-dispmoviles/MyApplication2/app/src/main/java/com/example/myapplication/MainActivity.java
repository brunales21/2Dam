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

    private ImageButton botonNegro1, botonNegro2, botonNegro3, botonNegro4, botonNegro5;
    private ImageButton botonRojo1, botonRojo2, botonRojo3, botonRojo4;
    private Button botonReiniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mensajeTextView = findViewById(R.id.mensajeTextView);

        // Asignar botones Negro
        botonNegro1 = findViewById(R.id.botonNegro1);
        botonNegro2 = findViewById(R.id.botonNegro2);
        botonNegro3 = findViewById(R.id.botonNegro3);
        botonNegro4 = findViewById(R.id.botonNegro4);
        botonNegro5 = findViewById(R.id.botonNegro5);

        // Asignar botones Rojo
        botonRojo1 = findViewById(R.id.botonRojo1);
        botonRojo2 = findViewById(R.id.botonRojo2);
        botonRojo3 = findViewById(R.id.botonRojo3);
        botonRojo4 = findViewById(R.id.botonRojo4);

        botonReiniciar = findViewById(R.id.botonReiniciar);

        // Configurar Listeners
        configurarListeners();
    }

    private void configurarListeners() {
        // Configurar Listeners para los botones Negro
        configurarListenerBoton(botonNegro1);
        configurarListenerBoton(botonNegro2);
        configurarListenerBoton(botonNegro3);
        configurarListenerBoton(botonNegro4);
        configurarListenerBoton(botonNegro5);

        // Configurar Listeners para los botones Rojo
        configurarListenerBoton(botonRojo1);
        configurarListenerBoton(botonRojo2);
        configurarListenerBoton(botonRojo3);
        configurarListenerBoton(botonRojo4);

        // Configurar Listener para el botón Reiniciar
        botonReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reiniciarContadores();
            }
        });
    }

    private void configurarListenerBoton(final ImageButton boton) {
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (contadorNegro + contadorRojo < 3) {
                    if (boton.getId() == R.id.botonNegro1 || boton.getId() == R.id.botonNegro2 ||
                            boton.getId() == R.id.botonNegro3 || boton.getId() == R.id.botonNegro4 ||
                            boton.getId() == R.id.botonNegro5) {
                        contadorNegro++;
                    } else {
                        contadorRojo++;
                    }
                    evaluarContadores();
                    boton.setEnabled(false);
                } else {
                    mostrarMensaje("Ya has alcanzado el límite de clics", false);
                }
            }
        });
    }

    private void evaluarContadores() {
        if (contadorNegro + contadorRojo == 3) {
            if (contadorNegro > contadorRojo) {
                mostrarMensaje("Estás pesimista", false);
            } else if (contadorRojo > contadorNegro) {
                mostrarMensaje("Estás optimista", true);
            }
        }
    }

    private void reiniciarContadores() {
        contadorNegro = 0;
        contadorRojo = 0;

        // Habilita todos los botones nuevamente
        habilitarBotones();
        mostrarMensaje("Contadores reiniciados", true);
    }

    private void habilitarBotones() {
        botonNegro1.setEnabled(true);
        botonNegro2.setEnabled(true);
        botonNegro3.setEnabled(true);
        botonNegro4.setEnabled(true);
        botonNegro5.setEnabled(true);

        botonRojo1.setEnabled(true);
        botonRojo2.setEnabled(true);
        botonRojo3.setEnabled(true);
        botonRojo4.setEnabled(true);
    }

    private void mostrarMensaje(String mensaje, boolean optimista) {
        mensajeTextView.setText(mensaje);
        if (optimista) {
            mensajeTextView.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
        } else {
            mensajeTextView.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        }
    }
}
