package com.example.formulariorestaurante;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "restaurante.db";
    public static final int DATABASE_VERSION = 1;

    // Definir la tabla de cuestionarios
    public static final String TABLE_CUESTIONARIOS = "cuestionarios";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ACERCA_DE = "acerca_de";
    public static final String COLUMN_FECHA = "fecha";
    public static final String COLUMN_VALORACION = "valoracion";
    public static final String COLUMN_TELEFONO = "telefono";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_SITUACION = "situacion";

    // Sentencia SQL para crear la tabla
    private static final String CREATE_TABLE_CUESTIONARIOS = "CREATE TABLE " + TABLE_CUESTIONARIOS + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_ACERCA_DE + " TEXT, " +
            COLUMN_FECHA + " TEXT, " +
            COLUMN_VALORACION + " INTEGER, " +
            COLUMN_TELEFONO + " TEXT, " +
            COLUMN_NOMBRE + " TEXT, " +
            COLUMN_SITUACION + " TEXT);";

    private static final String VACIAR_TABLA = "DELETE FROM nombre_de_tabla;\n";



    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CUESTIONARIOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CUESTIONARIOS);
        onCreate(db);
    }

}
