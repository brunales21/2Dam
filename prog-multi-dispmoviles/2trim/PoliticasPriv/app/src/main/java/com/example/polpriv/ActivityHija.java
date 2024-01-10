// ActivityHija.java

package com.example.polpriv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityHija extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hija);

        TextView textViewPolitica = findViewById(R.id.textViewPolitica);
        CheckBox checkBoxAcepto = findViewById(R.id.checkBoxAcepto);
        Button btnConfirmar = findViewById(R.id.btnConfirmar);

        // Texto de la política de privacidad
        String textoPolitica = "Aquí va el texto de la política de privacidad.\n\n" +
                "Por favor, lea y acepte los términos.";
        textViewPolitica.setText(textoPolitica);

        // Configurar el clic del botón "Confirmar"
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBoxAcepto.isChecked()) {
                    // El usuario aceptó la política de privacidad
                    setResult(RESULT_OK);
                } else {
                    // El usuario no aceptó la política de privacidad
                    setResult(RESULT_CANCELED);
                }

                // Cerrar la actividad hija
                finish();
            }
        });
    }
}
