package com.example.kelasbalikmobileapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kelasbalikmobileapp.Adapter.Tugas.TugasAdapter;
import com.example.kelasbalikmobileapp.Model.Tugas.GetTugas;
import com.example.kelasbalikmobileapp.Model.Tugas.Tugas;
import com.example.kelasbalikmobileapp.Rest.ApiClient;
import com.example.kelasbalikmobileapp.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TugasFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    //CRUD
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static TugasFragment tugasFragment;


    public TugasFragment() {
        // Required empty public constructor
    }

    public static TugasFragment newInstance(String param1, String param2) {
        TugasFragment fragment = new TugasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tugas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rvTugasTugas);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        tugasFragment=this;
        refresh();
    }

    public void refresh() {
        Call<GetTugas> tugasCall = mApiInterface.getTugas();
        tugasCall.enqueue(new Callback<GetTugas>() {
            @Override
            public void onResponse(Call<GetTugas> call, Response<GetTugas> response) {
                List<Tugas> TugasList = response.body().getListDataTugas();
                Log.d("Retrofit Get", "Jumlah data Tugas: " +
                        String.valueOf(TugasList.size()));
                mAdapter = new TugasAdapter(TugasList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetTugas> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}