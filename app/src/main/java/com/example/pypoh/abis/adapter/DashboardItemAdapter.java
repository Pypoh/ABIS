package com.example.pypoh.abis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pypoh.abis.R;
import com.example.pypoh.abis.model.ItemModel;

import java.util.List;

public class DashboardItemAdapter extends RecyclerView.Adapter<DashboardItemAdapter.ViewHolder> {

    private Context mContext;
    private List<ItemModel> dataSet;
    private OnItemClickListener onItemClickListener;

    public DashboardItemAdapter(Context mContext, List<ItemModel> dataSet) {
        this.mContext = mContext;
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dashboard, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final ItemModel data = dataSet.get(position);
        holder.bind(data, onItemClickListener);
        holder.itemQuantity.setText(data.getQuantity() + "");
        holder.itemName.setText(data.getName());
        holder.itemPrice.setText(data.getPrice() + "");


        holder.imageMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateBarang(holder.imageMin, data);
                holder.itemQuantity.setText(data.getQuantity() + "");

//               if (data.getQuantity() > 0) {
//                   data.setQuantity(data.getQuantity()-1);
//                   holder.itemQuantity.setText(data.getQuantity() + "");
//               }
            }
        });

        holder.imagePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                data.setQuantity(data.getQuantity()+1);
                updateBarang(holder.imagePlus, data);
                holder.itemQuantity.setText(data.getQuantity() + "");
            }
        });
    }

    private void updateBarang(View view, ItemModel data) {
        if (view.getId() == R.id.image_min) {
            if (data.getQuantity() > 0) {
                //tambahBarang()
                data.setQuantity(data.getQuantity() - 1);
            }
        } else {
            //kurangBarang()
            data.setQuantity(data.getQuantity() + 1);
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public interface OnItemClickListener {
        void onItemClick(ItemModel itemModel);
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Views
        private ImageView itemImage;
        private TextView itemName;
        private TextView itemPrice;
        private TextView itemQuantity;
        private Button updateBtn;

        private ImageView imageMin, imagePlus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image_dashboard);
            itemName = itemView.findViewById(R.id.item_text_name);
            itemPrice = itemView.findViewById(R.id.item_text_price);
            itemQuantity = itemView.findViewById(R.id.item_text_quantity);
            updateBtn = itemView.findViewById(R.id.item_button_update);

            imageMin = itemView.findViewById(R.id.image_min);
            imagePlus = itemView.findViewById(R.id.image_plus);

        }

        public void bind(final ItemModel itemModel, final OnItemClickListener listener) {
            updateBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(itemModel);
                }
            });
        }
    }
}
