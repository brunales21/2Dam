package com.example.formulariorestaurante;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultadosActivity extends AppCompatActivity {

    private TextView tvResultados;
    private Button btnVolverCuestionario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        tvResultados = findViewById(R.id.tvResultados);
        btnVolverCuestionario = findViewById(R.id.btnVolverCuestionario);

        // Obtengo los resultados de la actividad anterior
        Intent intent = getIntent();
        String resultados = intent.getStringExtra("resultados");

        // Muestra los resultados en el TextView
        tvResultados.setText(resultados);

        // Configura el clic del botón para volver al cuestionario
        btnVolverCuestionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volverAlCuestionario();
            }
        });
    }

    // Método para manejar el clic del botón y volver al cuestionario
    public void volverAlCuestionario() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish(); // Cierra la actividad actual para evitar volver a ella desde el cuestionario
    }
}
