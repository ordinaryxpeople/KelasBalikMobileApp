package com.example.kelasbalikmobileapp.Model.Ebook;

import com.example.kelasbalikmobileapp.Model.Tugas.Tugas;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetEbook {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Ebook> listDataEbook;
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
    public List<Ebook> getListDataEbook() {
        return listDataEbook;
    }
    public void setListDataEbook(List<Ebook> listDataEbook) {
        this.listDataEbook = listDataEbook;
    }
}
