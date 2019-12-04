package com.example.pypoh.abis;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.pypoh.abis.Auth.AuthActivity;
import com.example.pypoh.abis.Kasir.DaftarTransaksi;
import com.example.pypoh.abis.Kasir.DashboardKasir;
import com.google.android.material.navigation.NavigationView;

public class KasirActivity extends AppCompatActivity {

    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerKasir;
    private NavigationView navigationViewKasir;

    private DashboardKasir dashboardKasir = new DashboardKasir();
    private DaftarTransaksi daftarTransaksi = new DaftarTransaksi();
    private InsertUpdateItem insertUpdateItem = new InsertUpdateItem();

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kasir);

        Toolbar toolbar = findViewById(R.id.toolbar_kasir);
        setSupportActionBar(toolbar);

        drawerKasir = findViewById(R.id.drawer_kasir);
        drawerToggle = new ActionBarDrawerToggle(this, drawerKasir, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerKasir.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);

//        getSupportActionBar().setHomeButtonEnabled(true);

        setFragment(dashboardKasir);

        navigationViewKasir = findViewById(R.id.nav_view_kasir);
        navigationViewKasir.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                Toast.makeText(getApplicationContext(), "Item Zero", Toast.LENGTH_SHORT).show();
                switch (menuItem.getItemId()) {
                    case R.id.nav_item_one:
//                        Toast.makeText(getApplicationContext(), "Item One", Toast.LENGTH_SHORT).show();
                        setFragment(dashboardKasir);
                        break;
                    case R.id.nav_item_two:
//                        Toast.makeText(getApplicationContext(), "Item Two", Toast.LENGTH_SHORT).show();
                        setFragment(daftarTransaksi);
                        break;
                    case R.id.nav_item_three:
//                        Toast.makeText(getApplicationContext(), "Item Three", Toast.LENGTH_SHORT).show();
                        Toast.makeText(KasirActivity.this, "Anda telah keluar", Toast.LENGTH_SHORT).show();
                        Intent toLogin = new Intent(KasirActivity.this, AuthActivity.class);
                        startActivity(toLogin);
                        finish();
                        break;
                    case R.id.nav_item_four:
                        setFragment(insertUpdateItem);

                }
                drawerKasir.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        drawerToggle.syncState();
    }

//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        drawerToggle.onConfigurationChanged(newConfig);
//    }

    @Override
    public void onBackPressed() {
        if (drawerKasir.isDrawerOpen(GravityCompat.START)) {
            drawerKasir.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    public void setFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_frame_kasir, fragment, "MAIN_FRAGMENT");
        ft.addToBackStack(null);
        ft.commit();
    }
}
