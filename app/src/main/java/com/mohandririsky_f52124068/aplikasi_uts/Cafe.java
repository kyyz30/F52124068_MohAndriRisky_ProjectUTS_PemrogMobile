
package com.mohandririsky_f52124068.aplikasi_uts;

public class Cafe {

    private String nama;
    private String lokasi;
    private String harga;
    private String deskripsi;
    private int gambar;

    public Cafe(String nama, String lokasi, String harga,
                String deskripsi, int gambar) {
        this.nama = nama;
        this.lokasi = lokasi;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public String getLokasi() {
        return lokasi;
    }

    public String getHarga() {
        return harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public int getGambar() {
        return gambar;
    }
}