package com.example.weekendex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class TabActivity extends AppCompatActivity {

    private TabLayout layout;
    private Toolbar toolbar;
    private TabItem tabMovies;
    private TabItem tabDirectors;
    private TabItem tabHeros;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        layout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        //toolbar = findViewById(R.id.toolBar);
        tabMovies = findViewById(R.id.tabMovies);
        tabDirectors = findViewById(R.id.tabDirectors);
        tabHeros = findViewById(R.id.tabHeros);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),layout.getTabCount());
        viewPager.setAdapter(viewPagerAdapter);

        layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(layout));
    }
}
