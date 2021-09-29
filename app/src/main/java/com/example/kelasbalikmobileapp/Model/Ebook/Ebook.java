package com.example.kelasbalikmobileapp.Model.Ebook;

import com.google.gson.annotations.SerializedName;

public class Ebook {

    @SerializedName("judul_ebook")
    private String judul;

    @SerializedName("deskripsi_ebook")
    private String deskripsi;

    @SerializedName("pengunggah_ebook")
    private String pengunggah;

    @SerializedName("gambar_ebook")
    private String gambar;

    @SerializedName("url_ebook")
    private String url_ebook;

    @SerializedName("mapel_ebook")
    private String mapel;

    public Ebook(String judul, String deskripsi, String pengunggah, String gambar, String url_ebook, String mapel) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.pengunggah = pengunggah;
        this.gambar = gambar;
        this.url_ebook = url_ebook;
        this.mapel = mapel;
    }

    public String getJudul() {
        return judul;
    }

    public String getMapel() {
        return mapel;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getGambar() {
        return gambar;
    }

    public String getPengunggah() {
        return pengunggah;
    }

    public String getUrl_ebook() {
        return url_ebook;
    }
}
