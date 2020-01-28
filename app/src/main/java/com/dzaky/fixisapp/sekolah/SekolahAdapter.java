package com.dzaky.fixisapp.sekolah;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dzaky.fixisapp.R;

import java.util.List;

public class SekolahAdapter extends RecyclerView.Adapter<SekolahAdapter.ViewHolder> {

    private Context jCtx;
    private List<SekolahJSON> sekolahlist;

    public SekolahAdapter(Context jCtx, List<SekolahJSON> sekolahlist){
        this.sekolahlist = sekolahlist;
        this.jCtx = jCtx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(jCtx);
        View view = inflater.inflate(R.layout.layout_sekolah, null, true);
        return new SekolahAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SekolahAdapter.ViewHolder holder, int position) {
        SekolahJSON sekolahJSON = sekolahlist.get(position);

        Glide.with(jCtx)
                .load("https://sekolah.dzakyhdr.com/sekolah/public/images/"+ sekolahJSON.getImages())
                .into(holder.imgSekolah);

        holder.rvNama.setText(sekolahJSON.getNamaSekolah());
        holder.rvAlamat.setText(sekolahJSON.getAlamat());
        holder.rvNomor.setText(sekolahJSON.getNomorHp());

    }

    @Override
    public int getItemCount() {
        return sekolahlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView rvNama, rvNomor, rvAlamat;
        ImageView imgSekolah;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rvNama = itemView.findViewById(R.id.textViewNamaSekolah);
            rvNomor = itemView.findViewById(R.id.textViewNomorSekolah);
            rvAlamat = itemView.findViewById(R.id.textViewAlamatSekolah);
            imgSekolah = itemView.findViewById(R.id.imageViewSekolah);
        }
    }
}
