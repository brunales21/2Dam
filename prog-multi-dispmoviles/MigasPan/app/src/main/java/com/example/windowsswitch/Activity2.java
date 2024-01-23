package com.example.windowsswitch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.migaspan.R;


public class Activity2 extends AppCompatActivity {

    private TextView textViewBreadcrumb;
    private Button buttonBack;
    private String path;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        textViewBreadcrumb = findViewById(R.id.textViewBreadcrumb);
        buttonBack = findViewById(R.id.buttonBack);

        path = getIntent().getStringExtra("path2") +" > "+ this.getClass().getSimpleName();

        // Establecer las migas de pan para Activity2
        textViewBreadcrumb.setText(path);

        username = getIntent().getStringExtra("username1");


        // Mostrar "VOLVER" y configurar el clic para volver a Activity1
        buttonBack.setVisibility(View.VISIBLE);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity2.this, Activity1.class);
                intent.putExtra("pathback", path);
                intent.putExtra("username2", username);
                startActivity(intent);
            }
        });
    }
}
