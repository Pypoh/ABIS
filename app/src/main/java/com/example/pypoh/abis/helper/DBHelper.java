package com.example.pypoh.abis.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "abis.db";
    public static final int DATABASE_VERSION = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Transaksi.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Transaksi.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public void insertTransaksi(Transaksi transaksi) {
        // Get Database
        SQLiteDatabase db = this.getWritableDatabase();

        // Set Values
        ContentValues values = new ContentValues();
        values.put(Transaksi.TRANSAKSI_COLUMN_ID, transaksi.getId());
        values.put(Transaksi.TRANSAKSI_COLUMN_JUMLAH_BARANG, transaksi.getJumlahBarang());
        values.put(Transaksi.TRANSAKSI_COLUMN_TOTAL_HARGA, transaksi.getTotalHarga());

        // Insert Query
        db.insert(Transaksi.TABLE_NAME, null, values);

        // Close Connection
        db.close();
    }

    public Transaksi getTransaksi(String id) {
        // Get Database
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(Transaksi.TABLE_NAME,
                new String[]{Transaksi.TRANSAKSI_COLUMN_ID, Transaksi.TRANSAKSI_COLUMN_JUMLAH_BARANG, Transaksi.TRANSAKSI_COLUMN_TOTAL_HARGA, Transaksi.TRANSAKSI_TANGGAL},
                Transaksi.TRANSAKSI_COLUMN_ID + "=?",
                new String[]{id}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Transaksi transaksi = new Transaksi(
                cursor.getString(cursor.getColumnIndex(Transaksi.TRANSAKSI_COLUMN_ID)),
                cursor.getInt(cursor.getColumnIndex(Transaksi.TRANSAKSI_COLUMN_JUMLAH_BARANG)),
                cursor.getInt(cursor.getColumnIndex(Transaksi.TRANSAKSI_COLUMN_TOTAL_HARGA)),
                cursor.getString(cursor.getColumnIndex(Transaksi.TRANSAKSI_TANGGAL)));

        cursor.close();

        return transaksi;
    }

    public List<Transaksi> getAllTransaksi() {
        List<Transaksi> daftarTransaksi = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Transaksi.TABLE_NAME + " ORDER BY " +
                Transaksi.TRANSAKSI_TANGGAL + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Transaksi transaksi = new Transaksi();
                transaksi.setId(cursor.getString(cursor.getColumnIndex(Transaksi.TRANSAKSI_COLUMN_ID)));
                transaksi.setJumlahBarang(cursor.getInt(cursor.getColumnIndex(Transaksi.TRANSAKSI_COLUMN_JUMLAH_BARANG)));
                transaksi.setTotalHarga(cursor.getInt(cursor.getColumnIndex(Transaksi.TRANSAKSI_COLUMN_TOTAL_HARGA)));
                transaksi.setTanggal(cursor.getString(cursor.getColumnIndex(Transaksi.TRANSAKSI_TANGGAL)));


                daftarTransaksi.add(transaksi);
            } while (cursor.moveToNext());
        }

        db.close();

        return daftarTransaksi;
    }
}
