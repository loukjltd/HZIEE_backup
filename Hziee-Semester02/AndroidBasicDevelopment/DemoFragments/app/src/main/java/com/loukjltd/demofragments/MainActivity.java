package com.loukjltd.demofragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        NavHostFragment navHostFragment = (NavHostFragment) fragmentManager.findFragmentById(R.id.navHost);
        NavController navController = navHostFragment.getNavController();


        BottomNavigationView bnv = findViewById(R.id.bnv);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.itWx:
                        navController.navigate(R.id.wxFragment);
                        break;
                    case R.id.itContact:
                        navController.navigate(R.id.contactFragment);
                        break;
                    case R.id.itDiscover:
                        navController.navigate(R.id.discoverFragment);
                        break;
                    case R.id.itMe:
                        navController.navigate(R.id.meFragment);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }
}