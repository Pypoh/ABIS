package com.example.pypoh.abis.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Date;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "abis.db";
    public static final String TRANSAKSI_TABLE_NAME = "transaksi.tb";
    public static final String TRANSAKSI_COLUMN_ID = "id";
    public static final String TRANSAKSI_COLUMN_JUMLAH_BARANG = "jumlah_barang";
    public static final String TRANSAKSI_COLUMN_TOTAL_HARGA = "total_harga";
    public static final String TRANSAKSI_TANGGAL = "tanggal";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
