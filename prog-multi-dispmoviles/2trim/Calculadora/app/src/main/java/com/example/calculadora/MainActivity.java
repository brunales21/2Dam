package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.udojava.evalex.Expression;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
    }

    public void onButtonClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        String currentText = editText.getText().toString();

        switch (buttonText) {
            case "=":
                try {
                    // Evalúa la expresión matemática y muestra el resultado
                    double result = Controlador.resolverExpresion(currentText);
                    editText.setText(String.valueOf(result));
                } catch (Exception e) {
                    editText.setText("Error");
                }
                break;

            case "C":
                // Borra el último carácter
                if (currentText.length() > 0) {
                    editText.setText(currentText.substring(0, currentText.length() - 1));
                }
                break;

            case "DEL":
                // Borra todo el contenido
                editText.setText("");
                break;

            default:
                // Agrega el texto del botón al EditText
                editText.setText(currentText + buttonText);
                break;
        }
    }


}
