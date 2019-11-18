package com.example.pypoh.abis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pypoh.abis.R;
import com.example.pypoh.abis.model.ItemModel;

import java.util.List;

public class InvoiceItemAdapter extends  RecyclerView.Adapter<InvoiceItemAdapter.ViewHolder>{

    private Context mContext;
    private List<ItemModel> dataSet;

    public InvoiceItemAdapter(Context mContext, List<ItemModel> dataSet) {
        this.mContext = mContext;
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_invoice, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemModel data = dataSet.get(position);

        holder.textName.setText(data.getName());
        holder.textPrice.setText(data.getPrice() + "");
        holder.textQuantity.setText(data.getQuantity() + "");
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textQuantity, textName, textPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textQuantity = itemView.findViewById(R.id.text_quantity_invoice);
            textName = itemView.findViewById(R.id.text_name_item_invoice);
            textPrice = itemView.findViewById(R.id.text_price_item_invoice);
        }
    }
}
