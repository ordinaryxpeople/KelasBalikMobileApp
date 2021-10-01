package com.example.kelasbalikmobileapp;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kelasbalikmobileapp.Adapter.Ebook.EbookAdapter;
import com.example.kelasbalikmobileapp.Adapter.Tugas.TugasAdapter;
import com.example.kelasbalikmobileapp.Model.Ebook.Ebook;
import com.example.kelasbalikmobileapp.Model.Ebook.GetEbook;
import com.example.kelasbalikmobileapp.Model.Ebook.SearchEbook;
import com.example.kelasbalikmobileapp.Model.Tugas.GetTugas;
import com.example.kelasbalikmobileapp.Model.Tugas.Tugas;
import com.example.kelasbalikmobileapp.Rest.ApiClient;
import com.example.kelasbalikmobileapp.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EbookActivity extends AppCompatActivity {


    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static EbookActivity ebookActivity;
    EditText etSearchEbook;
    ImageView imageViewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);
        mRecyclerView = (RecyclerView) findViewById(R.id.rvEbook);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ebookActivity=this;
        imageViewBack = (ImageView) findViewById(R.id.ivBackButtonEbook);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        refresh();

        etSearchEbook = findViewById(R.id.etSearchEbook);
        etSearchEbook.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                sEbook(etSearchEbook.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void refresh() {
        Call<GetEbook> ebookCall = mApiInterface.getEbook();
        ebookCall.enqueue(new Callback<GetEbook>() {
            @Override
            public void onResponse(Call<GetEbook> call, Response<GetEbook> response) {
                List<Ebook> EbookList = response.body().getListDataEbook();
                Log.d("Retrofit Get", "Jumlah data Tugas: " +
                        String.valueOf(EbookList.size()));
                mAdapter = new EbookAdapter(EbookList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetEbook> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

    public void sEbook(String judul){
        Call<SearchEbook> callSearch = mApiInterface.searchEbook(judul);
        callSearch.enqueue(new Callback<SearchEbook>() {
            @Override
            public void onResponse(Call<SearchEbook> call, Response<SearchEbook> response) {
                List<Ebook> EbookList = response.body().getListDataEbook();
                Log.d("Retrofit Get", "Jumlah data Tugas: " +
                        String.valueOf(EbookList.size()));
                mAdapter = new EbookAdapter(EbookList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<SearchEbook> call, Throwable t) {
                Toast.makeText(EbookActivity.this, "Jaringan Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}