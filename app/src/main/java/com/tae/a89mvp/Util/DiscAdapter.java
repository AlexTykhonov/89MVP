package com.tae.a89mvp.Util;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.tae.a89mvp.DB.Disc;
import com.tae.a89mvp.List.ListContract;
import com.tae.a89mvp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class DiscAdapter extends RecyclerView.Adapter<DiscAdapter.ViewHolder> {

    private List<Disc> discList;

    private ListContract.OnItemClickListener onItemClickListener;

    public DiscAdapter(ListContract.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        discList = new ArrayList();
    }

    public void setArrayList(ArrayList<Disc> arrayList) {
        this.discList = arrayList;
    }

    @NonNull
    @Override
    public DiscAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recview_example, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DiscAdapter.ViewHolder holder, int i) {
    Disc disc = discList.get(i);
    holder.mDisc = disc;
    holder.disc.setText(disc.getDisc());
    holder.album.setText(disc.getAlbum());

    holder.view.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onItemClickListener.clickItem(holder.mDisc);
        }
    });

    holder.view.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onItemClickListener.clickLongItem(holder.mDisc);
        }
    });
    }


    @Override
    public int getItemCount() {
        return discList.size();
    }


    public void setValues(List<Disc> values) {
        discList = values;
        notifyDataSetChanged();}

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView disc;
        TextView album;
        View view;
        Disc mDisc;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            disc = view.findViewById(R.id.disc);
            album = view.findViewById(R.id.album);
        }
    }
}
