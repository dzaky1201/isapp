package com.dzaky.fixisapp.instansi;

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

public class InstansiAdapter extends RecyclerView.Adapter<InstansiAdapter.ViewHolder> {
    private Context iCtx;
    private List<InstansiJSON> instansilist;

    public InstansiAdapter(Context iCtx, List<InstansiJSON> instansilist){
        this.iCtx = iCtx;
        this.instansilist = instansilist;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(iCtx);
        View view = inflater.inflate(R.layout.layout_instansi, null, true);
        return new InstansiAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InstansiAdapter.ViewHolder holder, int position) {
        InstansiJSON instansiJSON = instansilist.get(position);

        Glide.with(iCtx)
                .load("https://instansi.dzakyhdr.com/instansi/public/images/"+instansiJSON.getImage())
                .into(holder.imageView);

        holder.rvNama.setText(instansiJSON.getNamaInstansi());
        holder.rvJenis.setText(instansiJSON.getJenisLayanan());
        holder.rvLembaga.setText(instansiJSON.getLembaga());
        holder.rvAlamat.setText(instansiJSON.getAlamat());

    }

    @Override
    public int getItemCount() {
        return instansilist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView rvNama, rvJenis, rvLembaga, rvAlamat;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rvNama = itemView.findViewById(R.id.textViewNamaInstansi);
            rvJenis = itemView.findViewById(R.id.textViewJenisLayanan);
            rvLembaga = itemView.findViewById(R.id.textViewLembaga);
            rvAlamat = itemView.findViewById(R.id.textViewAlamatInstansi);
            imageView = itemView.findViewById(R.id.imageViewInstansi);
        }
    }
}
