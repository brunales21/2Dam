package com.example.whatsupproyect;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        // Asociar el clic en el ícono de búsqueda a un listener
        MenuItem searchItem = menu.findItem(R.id.item11);
        searchItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                showKeyboard();
                return true;
            }
        });

        // Asociar el clic en el ícono de la cámara a un listener
        MenuItem cameraItem = menu.findItem(R.id.item22);
        cameraItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                showCameraError();
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int linea = item.getItemId();
        if (linea == R.id.item1) {
            Intent intent = new Intent(MainActivity.this, ActivityChild.class);
            startActivity(intent);
            Toast.makeText(this, "No me gusta nada", Toast.LENGTH_SHORT).show();
            return true;
        } else if (linea == R.id.item2) {
            Toast.makeText(this, "Me gusta a secas", Toast.LENGTH_SHORT).show();
            return true;
        } else if (linea == R.id.item3) {
            Toast.makeText(this, "Me chifla", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    // Método para mostrar el teclado
    private void showKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        }
    }

    // Método para mostrar mensaje de error al acceder a la cámara
    private void showCameraError() {
        Toast.makeText(this, "No se pudo acceder a la cámara", Toast.LENGTH_SHORT).show();
    }
}
