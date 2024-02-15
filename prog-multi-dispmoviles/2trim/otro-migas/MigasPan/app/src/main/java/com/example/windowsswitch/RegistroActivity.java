package com.example.windowsswitch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.migaspan.R;


public class RegistroActivity extends AppCompatActivity {

    private EditText editTextUsuario;
    private EditText editTextContraseña;
    private EditText editTextRepiteContraseña;
    private Spinner spinnerNivel;
    private Button btnAceptarRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        editTextUsuario = findViewById(R.id.editTextUsuario);
        editTextContraseña = findViewById(R.id.editTextContraseña);
        editTextRepiteContraseña = findViewById(R.id.editTextRepiteContraseña);
        spinnerNivel = findViewById(R.id.spinnerNivel);
        btnAceptarRegistro = findViewById(R.id.btnAceptarRegistro);

        // Rellenar el spinner con las opciones
        String[] niveles = {"principiante", "aficionado", "experto"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, niveles);
        spinnerNivel.setAdapter(adapter);

        btnAceptarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realizarRegistro();
            }
        });
    }

    private void realizarRegistro() {
        String usuario = editTextUsuario.getText().toString();
        String contraseña = editTextContraseña.getText().toString();
        String repiteContraseña = editTextRepiteContraseña.getText().toString();
        String nivelSeleccionado = spinnerNivel.getSelectedItem().toString();

        if (!contraseña.equals(repiteContraseña)) {
            // Contraseñas no coinciden, mostrar mensaje o manejar de acuerdo a tus necesidades
            return;
        }

        // Puedes hacer algo con la información (por ejemplo, enviarla a la actividad principal)
        Intent intent = new Intent();
        intent.putExtra("USUARIO", usuario);
        intent.putExtra("CONTRASEÑA", contraseña);
        intent.putExtra("NIVEL", nivelSeleccionado);

        setResult(RESULT_OK, intent);
        finish();  // Cierra la actividad de registro y vuelve a la actividad principal
    }
}
