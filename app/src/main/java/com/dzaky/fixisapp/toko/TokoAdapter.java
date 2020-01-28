package com.dzaky.fixisapp.toko;

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
import com.dzaky.fixisapp.masjid.MasjidAdapter;

import java.util.List;

public class TokoAdapter extends RecyclerView.Adapter<TokoAdapter.ViewHolder> {
    private Context tCtx;
    private List<TokoJSON>tokolist;

    public TokoAdapter(Context tCtx, List<TokoJSON> tokolist){
        this.tCtx = tCtx;
        this.tokolist = tokolist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(tCtx);
        View view = inflater.inflate(R.layout.layout_toko, null, true);
        return new TokoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TokoAdapter.ViewHolder holder, int position) {
        TokoJSON tokoJSON = tokolist.get(position);

        Glide.with(tCtx)
                .load("https://toko.dzakyhdr.com/toko/public/images/"+tokoJSON.getImage())
                .into(holder.imgToko);

        holder.tvNama.setText(tokoJSON.getJenis());
        holder.tvJenis.setText(tokoJSON.getNamaToko());
        holder.alamat.setText(tokoJSON.getAlamat());
        holder.noHp.setText(tokoJSON.getNomorHp());
    }

    @Override
    public int getItemCount() {
        return tokolist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama, tvJenis, noHp, alamat;
        ImageView imgToko;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.textViewNamaPemilik);
            noHp = itemView.findViewById(R.id.textViewNomorHP);
            tvJenis = itemView.findViewById(R.id.textViewJenisDagangan);
            alamat = itemView.findViewById(R.id.textViewAlamat);
            imgToko = itemView.findViewById(R.id.imageViewToko);
        }
    }
}
