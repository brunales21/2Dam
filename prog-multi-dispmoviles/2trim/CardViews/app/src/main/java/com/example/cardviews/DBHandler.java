package com.example.cardviews;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DBHandler extends SQLiteOpenHelper {

        private static final String DB_NAME = "cardViewDB";

        private static final int DB_VERSION = 1;

        private static final String NOMBRE_TABLA = "datos";

        private static final String ID_COL = "id";

        private static final String NOMBRE = "nombre";
        private static final String PAIS = "pais";
        private static final String ACTIVO = "activo";



        public DBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE IF NOT EXISTS " + NOMBRE_TABLA + " ("
                    + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + NOMBRE +" VARCHAR(50), "
                    + PAIS + " VARCHAR(50), "
                    + ACTIVO + " VARCHAR(50))";

            db.execSQL(query);
        }

        public void addNewCourse(String nombre, String pais, String activo) {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(NOMBRE, nombre);
            values.put(PAIS, pais);
            values.put(ACTIVO,activo);

            db.insert(NOMBRE_TABLA, null, values);

            db.close();
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + NOMBRE_TABLA);
            onCreate(db);
        }


    }


