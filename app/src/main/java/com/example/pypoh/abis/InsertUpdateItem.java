package com.example.pypoh.abis;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class InsertUpdateItem extends Fragment {

    private Button tambahButton, perbaruiButton;

    public InsertUpdateItem() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert_update_item, container, false);

        tambahButton = view.findViewById(R.id.button_tambah);
        tambahButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Data Berhasil di tambah", Toast.LENGTH_SHORT).show();
            }
        });

        perbaruiButton = view.findViewById(R.id.button_perbarui);
        perbaruiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Data Berhasil di perbarui", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
