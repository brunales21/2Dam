package com.example.formulariorestaurante;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class CuestionarioDAO {

    private SQLiteDatabase database;
    private DBHelper dbHelper;

    public CuestionarioDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void abrir() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void cerrar() {
        dbHelper.close();
    }

    public void insertarCuestionario(Cuestionario cuestionario) {
        try {
            abrir();
            ContentValues values = new ContentValues();
            values.put(DBHelper.COLUMN_ACERCA_DE, cuestionario.getAcercaDe());
            values.put(DBHelper.COLUMN_FECHA, cuestionario.getFecha());
            values.put(DBHelper.COLUMN_VALORACION, cuestionario.getValoracion());
            values.put(DBHelper.COLUMN_TELEFONO, cuestionario.getTelefono());
            values.put(DBHelper.COLUMN_NOMBRE, cuestionario.getNombre());
            values.put(DBHelper.COLUMN_SITUACION, cuestionario.getSituacion());

            // Insertar en la base de datos
            database.insert(DBHelper.TABLE_CUESTIONARIOS, null, values);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrar();
        }
    }

    @SuppressLint("Range")
    public List<Cuestionario> obtenerTodosCuestionarios() {
        List<Cuestionario> cuestionarios = new ArrayList<>();
        try {
            abrir();
            String[] columnas = {
                    DBHelper.COLUMN_ID,
                    DBHelper.COLUMN_ACERCA_DE,
                    DBHelper.COLUMN_FECHA,
                    DBHelper.COLUMN_VALORACION,
                    DBHelper.COLUMN_TELEFONO,
                    DBHelper.COLUMN_NOMBRE,
                    DBHelper.COLUMN_SITUACION
            };

            Cursor cursor = database.query(DBHelper.TABLE_CUESTIONARIOS, columnas, null, null, null, null, null);

            if (cursor != null && cursor.moveToFirst()) {
                do {
                    Cuestionario cuestionario = new Cuestionario();
                    cuestionario.setId(cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_ID)));
                    cuestionario.setAcercaDe(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_ACERCA_DE)));
                    cuestionario.setFecha(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_FECHA)));
                    cuestionario.setValoracion(cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_VALORACION)));
                    cuestionario.setTelefono(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_TELEFONO)));
                    cuestionario.setNombre(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_NOMBRE)));
                    cuestionario.setSituacion(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_SITUACION)));

                    cuestionarios.add(cuestionario);
                } while (cursor.moveToNext());

                // Cerrar el cursor después de obtener los datos
                cursor.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrar();
        }

        return cuestionarios;
    }

    // Agrega métodos adicionales según tus necesidades (porcentajeClientesEncantados, porcentajeClientesDetestaronServicio, etc.)
}
