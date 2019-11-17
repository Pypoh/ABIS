package com.example.pypoh.abis.Kasir;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pypoh.abis.R;
import com.example.pypoh.abis.adapter.DashboardItemAdapter;
import com.example.pypoh.abis.adapter.InvoiceItemAdapter;
import com.example.pypoh.abis.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class DashboardKasir extends Fragment {

    private RecyclerView recyclerItem;
    private RecyclerView recyclerInvoice;

    private DashboardItemAdapter dashboardItemAdapter;
    private InvoiceItemAdapter invoiceItemAdapter;

    private List<ItemModel> dummyData = new ArrayList<>();
    private List<ItemModel> dummyInvoice = new ArrayList<>();

    public DashboardKasir() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dashboard_kasir, container, false);

        setupViews(view);

        setupDummyData();

        setupRV();

        return view;
    }

    private void setupRV() {
        recyclerItem.setLayoutManager(new GridLayoutManager(this.getContext(), 4));
        dashboardItemAdapter = new DashboardItemAdapter(getContext(), dummyData);
        recyclerItem.setAdapter(dashboardItemAdapter);

        // Listener for Dashboard's Item
        dashboardItemAdapter.setOnItemClickListener(new DashboardItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ItemModel itemModel) {
                int quantityAdded = itemModel.getQuantity();
                if (quantityAdded == 0) {
                    if (!dummyInvoice.isEmpty()) {
                        for (ItemModel item : dummyInvoice) {
                            Log.d("editItemRemove", item.getName() + " : " + itemModel.getName());
                            if (item.getName().equalsIgnoreCase(itemModel.getName())) {
                                dummyInvoice.remove(item);
                                Toast.makeText(getContext(), "Item Removed", Toast.LENGTH_SHORT).show();
                                dashboardItemAdapter.notifyDataSetChanged();
                                invoiceItemAdapter.notifyDataSetChanged();
                                return;
                            }
                        }
                        Toast.makeText(getContext(), "This item is not added in cart", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (!dummyInvoice.isEmpty()) {
                        for (ItemModel item : dummyInvoice) {
                            if (item.getName().equalsIgnoreCase(itemModel.getName())) {
                                item.setQuantity(quantityAdded);
                                dashboardItemAdapter.notifyDataSetChanged();
                                invoiceItemAdapter.notifyDataSetChanged();
                                return;
                            }
                        }
                        dummyInvoice.add(itemModel);
                    }
                }

                dashboardItemAdapter.notifyDataSetChanged();
                invoiceItemAdapter.notifyDataSetChanged();
            }
        });

        recyclerInvoice.setLayoutManager(new LinearLayoutManager(this.getContext()));
        invoiceItemAdapter = new InvoiceItemAdapter(getContext(), dummyInvoice);
        recyclerInvoice.setAdapter(invoiceItemAdapter);
    }

    private void setupViews(View view) {
        recyclerItem = view.findViewById(R.id.recycler_dashboard);
        recyclerInvoice = view.findViewById(R.id.recycler_invoice);
    }

    private void setupDummyData() {
        dummyData.add(new ItemModel(null, "Item 1", 10000, 0, 10));
        dummyData.add(new ItemModel(null, "Item 2", 10000, 0, 10));
        dummyData.add(new ItemModel(null, "Item 3", 10000, 0, 10));
        dummyData.add(new ItemModel(null, "Item 4", 10000, 0, 10));
        dummyData.add(new ItemModel(null, "Item 5", 10000, 0, 10));
        dummyData.add(new ItemModel(null, "Item 6", 10000, 0, 10));
        dummyData.add(new ItemModel(null, "Item 7", 10000, 0, 10));
        dummyData.add(new ItemModel(null, "Item 8", 10000, 0, 10));
        dummyData.add(new ItemModel(null, "Item 9", 10000, 0, 10));
        dummyData.add(new ItemModel(null, "Item 10", 10000, 0, 10));

        dummyInvoice.add(new ItemModel(null, "Item 10", 10000, 0, 10));
        dummyInvoice.add(new ItemModel(null, "Item 10", 10000, 0, 10));
    }

}
