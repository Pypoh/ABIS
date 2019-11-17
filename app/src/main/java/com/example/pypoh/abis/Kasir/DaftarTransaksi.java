package com.example.pypoh.abis.Kasir;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pypoh.abis.R;
import com.example.pypoh.abis.adapter.TransaksiItemAdapter;
import com.example.pypoh.abis.model.TransaksiModel;

import java.util.ArrayList;
import java.util.List;


public class DaftarTransaksi extends Fragment {

    private RecyclerView transaksiRecycler;
    private TransaksiItemAdapter transaksiAdapter;
    private List<TransaksiModel> tempData = new ArrayList<>();

    public DaftarTransaksi() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_daftar_transaksi, container, false);

        if (tempData.isEmpty()) {
            setupData();
        }

        transaksiRecycler = view.findViewById(R.id.recycler_transaksi);
        transaksiRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        transaksiAdapter = new TransaksiItemAdapter(getContext(), tempData);
        transaksiRecycler.setAdapter(transaksiAdapter);

        return view;
    }

    private void setupData() {

        tempData.add(new TransaksiModel());
        tempData.add(new TransaksiModel());
        tempData.add(new TransaksiModel());
        tempData.add(new TransaksiModel());
    }


}
