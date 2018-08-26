package com.example.mohammad.shenova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ScandDevicesActivity extends AppCompatActivity {

    Toolbar toolbar;
    ListView devicesList ;
    ArrayList<TestDeviceItem> deviceArray;
    DeviceItemAdaptor deviceArrayAdaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scand_devices);

        toolbar = (Toolbar) findViewById(R.id.scanToolbar_id);
        setSupportActionBar(toolbar);


        deviceArray = new ArrayList<TestDeviceItem>();
        deviceArray.add(new TestDeviceItem("Dialog1","abcd1111-0000-1000-8000-00805f9b34fb"));
        deviceArray.add(new TestDeviceItem("Dialog2","abcd1111-0000-1000-8000-00805f9b34fb"));
        deviceArray.add(new TestDeviceItem("Dialog3","abcd1111-0000-1000-8000-00805f9b34fb"));
        deviceArray.add(new TestDeviceItem("Dialog4","abcd1111-0000-1000-8000-00805f9b34fb"));
        deviceArrayAdaptor = new DeviceItemAdaptor(this,deviceArray);
        devicesList = (ListView) findViewById(R.id.deviceListItem) ;
        devicesList.setAdapter(deviceArrayAdaptor);

        devicesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                testButton();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_device_scan, menu);
        return true;
    }

    public void testButton() {
        Intent test = new Intent(this,ControlDeviceActivity.class);
        startActivity(test);
    }
}
