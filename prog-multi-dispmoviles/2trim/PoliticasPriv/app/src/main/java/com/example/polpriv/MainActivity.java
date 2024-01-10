// MainActivity.java

package com.example.polpriv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_POLITICA_PRIVACIDAD = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAceptarPolitica = findViewById(R.id.btnAceptarPolitica);
        btnAceptarPolitica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar la actividad hija
                Intent intent = new Intent(MainActivity.this, ActivityHija.class);
                startActivityForResult(intent, REQUEST_CODE_POLITICA_PRIVACIDAD);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_POLITICA_PRIVACIDAD) {
            if (resultCode == RESULT_OK) {
                // Usuario aceptó la política de privacidad
                mostrarMensaje("Has aceptado nuestra Política de Privacidad");
            } else {
                // Usuario rechazó la política de privacidad
                mostrarMensaje("Lo sentimos, pero debes aceptar nuestra Política de Privacidad");
            }
        }
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
    }
}
