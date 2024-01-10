package com.example.menuscontextuales;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView txtModificable;
    private Bundle savedInstanceState;
    View cero, blancos;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        //Cojo el TextView del Layout
        txtModificable=(TextView)findViewById (R.id.txtModificable);
        //Avido a Android que txtModificable vá a tener un menú contextual
        registerForContextMenu (txtModificable);
        cero = findViewById(R.id.cero);
        blancos = findViewById(R.id.blancos);

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu (menu, v, menuInfo);
        //MenuInflater creadorDelMenu=getMenuInflater ();
        getMenuInflater().inflate(R.menu.menu_contextual,menu);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId () == R.id.cero) {
                Toast.makeText (this,"Atención : Voy a dejar esta caja de texto con un 0",Toast.LENGTH_SHORT).show ();
                return true;

        } else {
            Toast.makeText (this,"Atención : Voy a dejar esta caja de texto en blanco",Toast.LENGTH_SHORT).show ();
            return true;
        }
        return super.onContextItemSelected (item);

    }
}