package com.example.mohammad.shenova;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

public class ControlPanelActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ListView commonListView;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_panel);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for back button

        viewPager = (ViewPager) findViewById(R.id.viewPager_id);
        ViewPagerAdaptor adaptor = new ViewPagerAdaptor(getSupportFragmentManager());
        adaptor.addFragment(new VoicesFragment(),getString(R.string.VoicesTitleFragment));
        adaptor.addFragment(new DeviceSettingFragment(),getString(R.string.DeviceSettingTitleFragment));
        adaptor.addFragment(new AdminPanelFragment(),getString(R.string.AdminPanelFragment));
        commonListView = (ListView) findViewById(R.id.commonListView);

        viewPager.setAdapter(adaptor);

        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        tabLayout.setupWithViewPager(viewPager);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation_id);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_control_panel, menu);
        return true;
    }

}
