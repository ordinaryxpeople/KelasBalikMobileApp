package com.example.kelasbalikmobileapp.Model.Ebook;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchEbook {
    String searchEbook;
    @SerializedName("result")
    List<Ebook> listDataEbook;
    public String getSearchEbook() {
        return searchEbook;
    }
    @SerializedName("status")
    String status;
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
