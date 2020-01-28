package com.dzaky.fixisapp.masjid;

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

public class MasjidAdapter extends RecyclerView.Adapter<MasjidAdapter.ViewHolder> {

    private Context mCtx;
    private List<MasjidJSON> masjidlist;

    public MasjidAdapter(Context mCtx, List<MasjidJSON> masjidlist){
        this.mCtx = mCtx;
        this.masjidlist = masjidlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_masjid, null, true);
        return new MasjidAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MasjidAdapter.ViewHolder holder, int position) {

        MasjidJSON masjidJSON = masjidlist.get(position);

        Glide.with(mCtx)
                .load("https://masjid.dzakyhdr.com/masjid/public/images/"+masjidJSON.getImage())
                .into(holder.imageView);
        holder.textViewNamaMasjid.setText(masjidJSON.getNamaMasjid());
        holder.textViewAlamat.setText(masjidJSON.getAlamat());
    }

    @Override
    public int getItemCount() {
        return masjidlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewNamaMasjid, textViewAlamat;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNamaMasjid = itemView.findViewById(R.id.textViewNamaMasjid);
            textViewAlamat  =   itemView.findViewById(R.id.textViewAlamat);
            imageView   = itemView.findViewById(R.id.imageView);


        }
    }
}
