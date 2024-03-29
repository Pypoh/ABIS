package com.example.pypoh.abis.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pypoh.abis.Gudang.GudangActivity;
import com.example.pypoh.abis.KasirActivity;
import com.example.pypoh.abis.Manager.ManagerActivity;
import com.example.pypoh.abis.R;

public class LoginFragment extends Fragment {

    private EditText inputUsername, inputPassword;
    private Button buttonLogin;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        inputUsername = view.findViewById(R.id.input_username);
        inputPassword = view.findViewById(R.id.input_password);
        buttonLogin = view.findViewById(R.id.button_login);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = inputUsername.getText().toString();
                String password = inputPassword.getText().toString();

                AuthenticateUser(username, password);
            }
        });
    }

    private void AuthenticateUser(String username, String password) {
        if (username.equals("kasir") && password.equals("kasir")) {
            toMain();
        } else if (username.equals("manager") && password.equals("manager")) {
            toManager();
        } else if (username.equals("gudang") && password.equals("gudang")) {
            toGudang();
        } else {
            Toast.makeText(getContext(), "Username atau password salah", Toast.LENGTH_SHORT).show();
        }

    }

    private void toGudang() {
        Intent toMainIntent = new Intent(getActivity(), GudangActivity.class);
        startActivity(toMainIntent);
        getActivity().finish();
    }

    private void toManager() {
        Intent toMainIntent = new Intent(getActivity(), ManagerActivity.class);
        startActivity(toMainIntent);
        getActivity().finish();
    }

    private void toMain() {
        Intent toMainIntent = new Intent(getActivity(), KasirActivity.class);
        startActivity(toMainIntent);
        getActivity().finish();
    }
}
