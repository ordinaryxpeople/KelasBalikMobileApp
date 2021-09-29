package com.example.kelasbalikmobileapp.Adapter.Ebook;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kelasbalikmobileapp.EbookActivity;
import com.example.kelasbalikmobileapp.Model.Ebook.Ebook;
import com.example.kelasbalikmobileapp.Model.Tugas.Tugas;
import com.example.kelasbalikmobileapp.R;
import com.example.kelasbalikmobileapp.ReadWebview;
import com.github.barteksc.pdfviewer.PDFView;

import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class EbookAdapter extends RecyclerView.Adapter<EbookAdapter.MyViewHolder>{
    List<Ebook> mEbookList;
    private Context context;

    public EbookAdapter(List<Ebook> EbookList){
        mEbookList = EbookList;
    }

    @Override
    public EbookAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ebook_list, parent, false);
        EbookAdapter.MyViewHolder mViewHolder = new EbookAdapter.MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EbookAdapter.MyViewHolder holder, int position) {
        new DownloadImageFromInternet(holder.vivURLEbook).execute("https://admin.kelasbalik.id/assets/media/ebook/"+mEbookList.get(position).getGambar());
        String path="https://docs.google.com/viewer?url=admin.kelasbalik.id/assets/media/ebook/"+mEbookList.get(position).getUrl_ebook()+"&embedded=true";
        //String path=mEbookList.get(position).getUrl_ebook();
        holder.tvJudulEbook.setText(mEbookList.get(position).getJudul());
        holder.tvDeskripsiEbook.setText(mEbookList.get(position).getDeskripsi());
        holder.tvURLPengunggahEbook.setText(mEbookList.get(position).getPengunggah());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ReadWebview.class);
                intent.setType("text/plain");
                intent.putExtra("url_pdf",path);
                context.startActivities(new Intent[]{intent});
            }
        });


    }

    @Override
    public int getItemCount() {
        return mEbookList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView vivURLEbook;
        public TextView tvJudulEbook, tvDeskripsiEbook, tvURLPengunggahEbook;
        public CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            vivURLEbook = (ImageView) itemView.findViewById(R.id.ivURLEbook);
            tvURLPengunggahEbook = (TextView) itemView.findViewById(R.id.tvURLPengunggahEbook);
            tvJudulEbook = (TextView) itemView.findViewById(R.id.tvURLJudulEbook);
            tvDeskripsiEbook = (TextView) itemView.findViewById(R.id.tvURLDeskripsiEbook);
            cardView = (CardView) itemView.findViewById(R.id.cvEbookContainer);
            context = itemView.getContext();
        }
    }


}
class DownloadImageFromInternet extends AsyncTask<String, Void, Bitmap> {
    ImageView imageView;
    public DownloadImageFromInternet(ImageView imageView) {
        this.imageView=imageView;
    }
    protected Bitmap doInBackground(String... urls) {
        String imageURL=urls[0];
        Bitmap bimage=null;
        try {
            InputStream in=new java.net.URL(imageURL).openStream();
            bimage= BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error Message", e.getMessage());
            e.printStackTrace();
        }
        return bimage;
    }
    protected void onPostExecute(Bitmap result) {
        imageView.setImageBitmap(result);
    }
}



