package com.example.whatsupproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // MenuInflater miMenu=getMenuInflater ();
        getMenuInflater ().inflate (R.menu.menu,menu);
        return true;
        //return super.onCreateOptionsMenu (menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int linea = item.getItemId ();
        if (linea == R.id.item1) {
            Intent intent = new Intent(MainActivity.this, ActivityChild.class);
            startActivity(intent);
            Toast.makeText (this, "No me gusta nada", Toast.LENGTH_SHORT).show ();
            return true;
        } else if (linea == R.id.item2) {
            Toast.makeText (this, "Me gusta a secas", Toast.LENGTH_SHORT).show ();
            return true;

        } else if (linea == R.id.item3) {
            Toast.makeText (this, "Me chifla", Toast.LENGTH_SHORT).show ();
            return true;
        } else {
            return super.onOptionsItemSelected (item);
        }
    }
}