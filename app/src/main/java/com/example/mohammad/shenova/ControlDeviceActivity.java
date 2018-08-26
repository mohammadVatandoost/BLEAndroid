package com.example.mohammad.shenova;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class ControlDeviceActivity extends AppCompatActivity {

    Toolbar toolbar;
    ArrayList<VoiceItem> voiceItems;
    VoiceItemAdaptor voiceItemAdaptor;
    ListView commonListView;
    BottomNavigationView bottomNavigationView;
    LinearLayout settingsLayout,adminPanelLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_device);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for back button
        voiceItems = new ArrayList<>();
        voiceItems.add(new VoiceItem("03:34", "1397/05/28", "12:42"));
        voiceItems.add(new VoiceItem("03:34", "1397/05/28", "12:42"));
        voiceItems.add(new VoiceItem("03:34", "1397/05/28", "12:42"));
        voiceItems.add(new VoiceItem("03:34", "1397/05/28", "12:42"));
        voiceItems.add(new VoiceItem("03:34", "1397/05/28", "12:42"));
        voiceItemAdaptor = new VoiceItemAdaptor(this,voiceItems);
        commonListView = (ListView) findViewById(R.id.commonListView);
        commonListView.setAdapter(voiceItemAdaptor);

        settingsLayout = (LinearLayout) findViewById(R.id.deviceSettings);
        settingsLayout.setVisibility(View.GONE);

        adminPanelLayout = (LinearLayout) findViewById(R.id.adminPanel_id);
        adminPanelLayout.setVisibility(View.GONE);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation_id);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.voices_id:
                        commonListView.setVisibility(View.VISIBLE);
                        settingsLayout.setVisibility(View.GONE);
                        adminPanelLayout.setVisibility(View.GONE);
                        Log.i("menu", "voice_id");
                        break;
                    case R.id.setting_id:
                        commonListView.setVisibility(View.GONE);
                        settingsLayout.setVisibility(View.VISIBLE);
                        adminPanelLayout.setVisibility(View.GONE);
                        Log.i("menu","setting_id");
                        break;
                    case R.id.admin_id:
                        commonListView.setVisibility(View.GONE);
                        settingsLayout.setVisibility(View.GONE);
                        adminPanelLayout.setVisibility(View.VISIBLE);
                        Log.i("menu","admin_id");
                        break;
                    default:
                        break;
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

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
