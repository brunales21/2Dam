package com.example.tareadismoviles;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tareadismoviles.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText1 = findViewById(R.id.editText1);
        final EditText editText2 = findViewById(R.id.editText2);
        final EditText editText3 = findViewById(R.id.editText3);
        Button concatenateButton = findViewById(R.id.concatenateButton);

        concatenateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = editText1.getText().toString();
                String text2 = editText2.getText().toString();
                String text3 = editText3.getText().toString();
                String concatenatedText = text1 + " " + text2 + " " + text3;
                Toast.makeText(MainActivity.this, concatenatedText, Toast.LENGTH_LONG).show();
            }
        });
    }
}
