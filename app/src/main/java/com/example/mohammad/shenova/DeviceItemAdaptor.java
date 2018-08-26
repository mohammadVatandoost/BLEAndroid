package com.example.mohammad.shenova;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DeviceItemAdaptor extends ArrayAdapter<TestDeviceItem> {

    Context dContext;
    ArrayList<TestDeviceItem> DviceItemList;

    public DeviceItemAdaptor(@NonNull Context context, ArrayList<TestDeviceItem> list) {
        super(context, 0 , list);
        dContext = context; DviceItemList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(dContext).inflate(R.layout.listitem_device,parent,false);

        TestDeviceItem deviceItem = DviceItemList.get(position);

        TextView voiceDurationTime = (TextView) listItem.findViewById(R.id.deviceName);
        voiceDurationTime.setText(deviceItem.deviceName);

        TextView voiceData = (TextView) listItem.findViewById(R.id.deviceId);
        voiceData.setText(deviceItem.deviceId);

        return listItem;

    }
}
