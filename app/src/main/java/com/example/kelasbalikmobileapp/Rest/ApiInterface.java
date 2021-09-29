package com.example.kelasbalikmobileapp.Rest;

import com.example.kelasbalikmobileapp.Model.Ebook.GetEbook;
import com.example.kelasbalikmobileapp.Model.Ebook.SearchEbook;
import com.example.kelasbalikmobileapp.Model.Tugas.GetTugas;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("TugasApi/get_tugas.php")
    Call<GetTugas> getTugas();

    @GET("EbookApi/get_ebook.php")
    Call<GetEbook> getEbook();

    @FormUrlEncoded
    @POST("EbookApi/get_ebook.php")
    Call<SearchEbook> searchEbook(@Field("judul") String judul);
}
