package com.example.kelasbalikmobileapp.Model.Tugas;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetTugas {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Tugas> listDataTugas;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public List<Tugas> getListDataTugas() {
        return listDataTugas;
    }
    public void setListDataTugas(List<Tugas> listDataTugas) {
        this.listDataTugas = listDataTugas;
    }
}
