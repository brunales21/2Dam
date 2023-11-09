package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etNombre, etEdad, etHoroscopo, etAnimalPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        etNombre=findViewById(R.id.etNombre);
        etEdad=findViewById(R.id.etEdad);
        etHoroscopo=findViewById(R.id.etHoroscopo);
        etAnimalPref=findViewById(R.id.etAnimalPref);


        Button ocultarTec=(Button)findViewById (R.id.btnOcultarTec);
        ocultarTec.setOnClickListener(new OnClickListener () {
            @Override
            public void onClick(View v) {
                ocultaTeclado ();
            }
        });
        Button aniadir=(Button)findViewById (R.id.btnAniadir);
        aniadir.setOnClickListener (new OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText (MainActivity.this,"usuario dado de alta".toString (),Toast.LENGTH_LONG).show ();
                PreferenciasPersona p=new PreferenciasPersona (etNombre.getText().toString(), Integer.parseInt(etEdad.getText().toString()), etHoroscopo.getText().toString(), etAnimalPref.getText().toString());
                String mensaje=p+ " fue dada de alta";
                Toast t= Toast.makeText (MainActivity.this,mensaje,Toast.LENGTH_LONG);
                t.show ();
                //Cambio el texto que aparece en el botón
                String textoBtnAniadir=aniadir.getText ().toString ();
                if (textoBtnAniadir.equals (getResources ().getString (R.string.alta_usuarios))){
                    aniadir.setText (getResources ().getString (R.string.anadir_button));
                }else{
                    aniadir.setText (getResources ().getString (R.string.alta_usuarios));

                }

            }
        });


    }

    public void ocultaTeclado(){
        InputMethodManager imm=(InputMethodManager)this.getSystemService (Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow (this.getWindow ().peekDecorView ().getWindowToken (), 0);

    }


}
