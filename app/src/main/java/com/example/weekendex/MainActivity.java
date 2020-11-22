package com.example.weekendex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    NavigationView navigationView;
    DrawerLayout layout;

    Button button;

    LinearLayout linearLayout;
    FrameLayout frameLayout;

    FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomView);
        layout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navView);
        frameLayout = findViewById(R.id.frameLayout);
        button = findViewById(R.id.BN);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TabActivity.class);
                startActivity(intent);
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.profile:
                        replaceFragment(new FirstFragment());
                        break;

                    case R.id.phone:
                        replaceFragment(new SecondFragment());
                        break;

                    case R.id.message:
                        replaceFragment(new ThirdFragment());
                        break;

                }
                return false;
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.movies:
                        replaceFragment(new FirstFragment());
                        layout.closeDrawers();
                        return true;

                    case R.id.heros:
                        replaceFragment(new SecondFragment());
                        layout.closeDrawers();
                        return true;

                    case R.id.directors:
                        replaceFragment(new ThirdFragment());
                        layout.closeDrawers();
                        return true;
                }

                return false;
            }
        });

        manager = getSupportFragmentManager();

        if (findViewById(R.id.frameLayout)!=null)
        {
            if (savedInstanceState!=null)
            {
                return;
            }

            FragmentTransaction fragmentTransaction = manager.beginTransaction();
            FirstFragment firstFragment = new FirstFragment();
            fragmentTransaction.add(R.id.frameLayout,firstFragment,null).commit();
        }

    }
    private void replaceFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        //FirstFragment firstFragment = new FirstFragment();
        fragmentTransaction.replace(R.id.frameLayout,fragment,null).commit();
    }
    }


