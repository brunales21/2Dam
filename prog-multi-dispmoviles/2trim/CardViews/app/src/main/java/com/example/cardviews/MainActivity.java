package com.example.cardviews;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    DBHandler dbHandler;
    private LinearLayout container;
    private ImageView imageView1, imageView2;
    private TextView textViewName1, textViewName2, textViewCountry1, textViewCountry2, textViewActive1, textViewActive2;
    boolean isAdd;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHandler = new DBHandler(MainActivity.this, "cardViewDB", null, 1);
        textViewName1 = findViewById(R.id.textViewName1);
        textViewName2 = findViewById(R.id.textViewName2);

        textViewActive1 = findViewById(R.id.textViewActive1);
        textViewActive2 = findViewById(R.id.textViewActive2);

        textViewCountry1 = findViewById(R.id.textViewCountry1);
        textViewCountry2 = findViewById(R.id.textViewCountry2);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        container = findViewById(R.id.contenedor);


        String query = "select nombre, pais, activo from datos where id = 1 or id = 2";

        try (DBHandler claseBBDD = new DBHandler(MainActivity.this, "cardViewDB", null, 1);
             SQLiteDatabase bbdd = claseBBDD.getWritableDatabase();
             Cursor ejecucionConsulta = bbdd.rawQuery(query, null)) {
            if (ejecucionConsulta.moveToFirst()) {
                String nombre = ejecucionConsulta.getString(0);
                String pais = ejecucionConsulta.getString(1);
                String activo = ejecucionConsulta.getString(2);
                getTextViewName1().setText(nombre);
                getTextViewCountry1().setText(pais);
                getTextViewActive1().setText(activo);
                getImageView1().setImageResource(R.drawable.contacto);
                getImageView2().setImageResource(R.drawable.contacto2);

                ejecucionConsulta.moveToNext();
                String nombre2 = ejecucionConsulta.getString(0);
                String pais2 = ejecucionConsulta.getString(1);
                String activo2 = ejecucionConsulta.getString(2);
                getTextViewName2().setText(nombre2);
                getTextViewCountry2().setText(pais2);
                getTextViewActive2().setText(activo2);


            } else {
                Toast.makeText(MainActivity.this, "No existen datos", Toast.LENGTH_LONG).show();

            }

        }
    }


    public ImageView getImageView1() {
        return imageView1;
    }

    public ImageView getImageView2() {
        return imageView2;
    }

    public TextView getTextViewName1() {
        return textViewName1;
    }

    public TextView getTextViewName2() {
        return textViewName2;
    }

    public TextView getTextViewCountry1() {
        return textViewCountry1;
    }

    public TextView getTextViewCountry2() {
        return textViewCountry2;
    }


    public TextView getTextViewActive1() {
        return textViewActive1;
    }


    public TextView getTextViewActive2() {
        return textViewActive2;
    }

}
