package com.example.pypoh.abis.Kasir;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pypoh.abis.R;
import com.example.pypoh.abis.adapter.DashboardItemAdapter;
import com.example.pypoh.abis.adapter.InvoiceItemAdapter;
import com.example.pypoh.abis.helper.DBHelper;
import com.example.pypoh.abis.helper.Transaksi;
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

    private DBHelper db;

    // Views
    Button buttonCheckout;

    public DashboardKasir() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dashboard_kasir, container, false);

        setupViews(view);

        if (dummyData.isEmpty()) {
            setupDummyData();
        }

        setupRV();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        db = new DBHelper(this.getContext());

        buttonCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Insert Data
                insertTransaksiToDB();
            }
        });

    }

    private void insertTransaksiToDB() {
        int totalHarga = 0;
        for (ItemModel item : dummyInvoice) {
            totalHarga += item.getPrice();
        }

        db.insertTransaksi(new Transaksi("INV/0101012019", invoiceItemAdapter.getItemCount(), totalHarga, ""));
        Toast.makeText(getContext(), "Transaksi Berhasil Dimasukkan", Toast.LENGTH_SHORT).show();
    }

    private void setupRV() {
        recyclerItem.setLayoutManager(new GridLayoutManager(this.getContext(), 4));
        dashboardItemAdapter = new DashboardItemAdapter(getContext(), dummyData);
        recyclerItem.setAdapter(dashboardItemAdapter);

        // Listener for Dashboard's Item
        dashboardItemAdapter.setOnItemClickListener(new DashboardItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ItemModel itemModel) {
//                Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(getContext(), "Item Updated", Toast.LENGTH_SHORT).show();
                                dashboardItemAdapter.notifyDataSetChanged();
                                invoiceItemAdapter.notifyDataSetChanged();
                                return;
                            }
                        }
                        Toast.makeText(getContext(), "Item Added", Toast.LENGTH_SHORT).show();
                        dummyInvoice.add(itemModel);
                    } else {
                        dummyInvoice.add(itemModel);
                        Toast.makeText(getContext(), "Item Added", Toast.LENGTH_SHORT).show();

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
        buttonCheckout = view.findViewById(R.id.button_checkout);
    }

    private void setupDummyData() {
        dummyData.add(new ItemModel(null, "Conton nama barang 1", 10000, 0, 10));
        dummyData.add(new ItemModel(null, "Contoh nama barang 2", 10000, 0, 10));
        dummyData.add(new ItemModel(null, "Contoh nama barang 3", 10000, 0, 10));
        dummyData.add(new ItemModel(null, "COntoh nama barang 4", 10000   , 0, 10));
        dummyData.add(new ItemModel(null, "Contoh nama barang 5", 10000, 0, 10));
        dummyData.add(new ItemModel(null, "Contoh nama barang 6", 10000, 0, 10));
        dummyData.add(new ItemModel(null, "Contoh nama barang 7", 10000, 0, 10));
        dummyData.add(new ItemModel(null, "Contoh nama barang 8", 10000, 0, 10));
        dummyData.add(new ItemModel(null, "Contoh nama barang 9", 10000, 0, 10));
        dummyData.add(new ItemModel(null, "Item 10", 10000, 0, 10));

    }

}
