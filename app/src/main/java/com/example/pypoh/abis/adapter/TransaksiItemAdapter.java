package com.example.pypoh.abis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pypoh.abis.R;
import com.example.pypoh.abis.helper.Transaksi;
import com.example.pypoh.abis.model.TransaksiModel;

import java.util.List;

public class TransaksiItemAdapter extends RecyclerView.Adapter<TransaksiItemAdapter.ViewHolder> {

    private Context mContext;
    private List<Transaksi> mDataset;

    public TransaksiItemAdapter(Context mContext, List<Transaksi> mDataset) {
        this.mContext = mContext;
        this.mDataset = mDataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_transaksi, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
