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

public class VoiceItemAdaptor extends ArrayAdapter<VoiceItem> {
    public Context vContext;
    public ArrayList<VoiceItem> VoiceItemList;

    public VoiceItemAdaptor(@NonNull Context context, ArrayList<VoiceItem> list) {
        super(context, 0 , list);
        vContext = context; VoiceItemList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(vContext).inflate(R.layout.listitem_voice,parent,false);

        VoiceItem currentVoiceItem = VoiceItemList.get(position);

        TextView voiceDurationTime = (TextView) listItem.findViewById(R.id.voiceDurationTime);
        voiceDurationTime.setText(currentVoiceItem.duration);

        TextView voiceData = (TextView) listItem.findViewById(R.id.Date);
        voiceData.setText(currentVoiceItem.dateRecorded);

        TextView timeRecorded = (TextView) listItem.findViewById(R.id.Time);
        timeRecorded.setText(currentVoiceItem.timeRecorded);

        return listItem;

    }
}
