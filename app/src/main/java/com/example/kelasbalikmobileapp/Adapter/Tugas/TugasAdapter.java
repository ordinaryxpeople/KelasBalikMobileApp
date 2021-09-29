package com.example.kelasbalikmobileapp.Adapter.Tugas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kelasbalikmobileapp.Model.Tugas.Tugas;
import com.example.kelasbalikmobileapp.R;

import java.util.List;

public class TugasAdapter extends RecyclerView.Adapter<TugasAdapter.MyViewHolder>{
    List<Tugas> mTugasList;

    public TugasAdapter(List<Tugas> TugasList){
        mTugasList = TugasList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.tugas_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mTextViewJudul.setText(mTugasList.get(position).getJudul());
        holder.mTextViewPengajar.setText(mTugasList.get(position).getPengajar());
        holder.mTextViewKeterangan.setText(mTugasList.get(position).getKeterangan());
        holder.mTextViewHalaman.setText(mTugasList.get(position).getHalaman());
        holder.mTextViewDateline.setText(mTugasList.get(position).getDateline());
        holder.getmTextViewMapel.setText(mTugasList.get(position).getMapel());
    }

    @Override
    public int getItemCount () {
        return mTugasList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewJudul, mTextViewPengajar, mTextViewKeterangan,
                mTextViewHalaman , mTextViewDateline, getmTextViewMapel;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewJudul = (TextView) itemView.findViewById(R.id.tvJudulTugas);
            mTextViewPengajar = (TextView) itemView.findViewById(R.id.tvPengajarTugas);
            mTextViewKeterangan = (TextView) itemView.findViewById(R.id.tvKeteranganTugas);
            mTextViewHalaman = (TextView) itemView.findViewById(R.id.tvHalamanTugas);
            mTextViewDateline = (TextView) itemView.findViewById(R.id.tvDatelineTugas);
            getmTextViewMapel = (TextView) itemView.findViewById(R.id.tvMapelTugas);
        }
    }

}
