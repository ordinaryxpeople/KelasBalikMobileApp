package com.example.kelasbalikmobileapp.Model.Tugas;

import com.google.gson.annotations.SerializedName;

public class Tugas {
    @SerializedName("judul_tugas")
    private String judul;

    @SerializedName("pengajar_tugas")
    private String pengajar;

    @SerializedName("keterangan_tugas")
    private String keterangan;

    @SerializedName("halaman_tugas")
    private String halaman;

    @SerializedName("dateline_tugas")
    private String dateline;

    @SerializedName("mapel_tugas")
    private String mapel;

    public Tugas(String judul, String pengajar, String keterangan, String halaman, String dateline, String mapel) {
        this.judul = judul;
        this.pengajar = pengajar;
        this.keterangan = keterangan;
        this.halaman = halaman;
        this.dateline = dateline;
        this.mapel = mapel;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public String getHalaman() {
        return halaman;
    }

    public String getDateline() {
        return dateline;
    }

    public String getMapel() {
        return mapel;
    }

    public String getJudul() {
        return judul;
    }
    public String getPengajar() {
        return pengajar;
    }
}
