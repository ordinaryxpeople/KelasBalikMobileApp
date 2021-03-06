package com.example.kelasbalikmobileapp.Adapter.Tugas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kelasbalikmobileapp.Model.Tugas.Tugas;
import com.example.kelasbalikmobileapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        String d1,d2;
        holder.mTextViewJudul.setText(mTugasList.get(position).getJudul());
        holder.mTextViewPengajar.setText(mTugasList.get(position).getPengajar());
        holder.mTextViewKeterangan.setText(mTugasList.get(position).getKeterangan());
        holder.mTextViewHalaman.setText(mTugasList.get(position).getHalaman());
//        holder.mTextViewDateline.setText(mTugasList.get(position).getDateline());
        holder.getmTextViewMapel.setText(mTugasList.get(position).getMapel());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try{

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = sdf.parse(mTugasList.get(position).getDateline());
            Date date2 = sdf.parse(formatter.format(date));
//            System.out.println("Date1"+sdf.format(date1));
//            System.out.println("Date2"+sdf.format(date2));System.out.println();


            if(date1.after(date2)){
                holder.mTextViewDateline.setText(mTugasList.get(position).getDateline());
                holder.mTextViewDateline.setTextColor(ContextCompat.getColor(holder.vContext, R.color.green));
            }
            if(date1.before(date2)){
                holder.mTextViewDateline.setText(mTugasList.get(position).getDateline());
                holder.mTextViewDateline.setTextColor(ContextCompat.getColor(holder.vContext, R.color.red));
            }
            if(date1.equals(date2)){
                holder.mTextViewDateline.setText(mTugasList.get(position).getDateline());
                holder.mTextViewDateline.setTextColor(ContextCompat.getColor(holder.vContext, R.color.green));
            }
        }
        catch(ParseException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public int getItemCount () {
        return mTugasList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewJudul, mTextViewPengajar, mTextViewKeterangan,
                mTextViewHalaman , mTextViewDateline, getmTextViewMapel;
        Context vContext = itemView.getContext();

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
