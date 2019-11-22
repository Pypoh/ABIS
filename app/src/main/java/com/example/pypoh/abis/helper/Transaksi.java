package com.example.pypoh.abis.helper;

public class Transaksi {

    public static final String TABLE_NAME = "transaksi";

    public static final String TRANSAKSI_COLUMN_ID = "id";
    public static final String TRANSAKSI_COLUMN_JUMLAH_BARANG = "jumlah_barang";
    public static final String TRANSAKSI_COLUMN_TOTAL_HARGA = "total_harga";
    public static final String TRANSAKSI_TANGGAL = "tanggal";

    private String id;
    private int jumlahBarang;
    private int totalHarga;
    private String tanggal;

    // Sql Query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                + TRANSAKSI_COLUMN_ID + " TEXT PRIMARY KEY,"
                + TRANSAKSI_COLUMN_JUMLAH_BARANG + " INTEGER,"
                + TRANSAKSI_COLUMN_TOTAL_HARGA + " INTEGER,"
                + TRANSAKSI_TANGGAL + " DATETIME DEFAULT CURENT_TIMESTAMP"
                + ")";

    public Transaksi() {
    }

    public Transaksi(String id, int jumlahBarang, int totalHarga, String tanggal) {
        this.id = id;
        this.jumlahBarang = jumlahBarang;
        this.totalHarga = totalHarga;
        this.tanggal = tanggal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
