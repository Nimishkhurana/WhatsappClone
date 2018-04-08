package com.example.android.whatsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomChatAdapter extends ArrayAdapter<String> {
    private final Context context;
    private List<String> chatNames;
    private List<String> chatDescriptions;
    private List<String> chatDates;

    public CustomChatAdapter(@NonNull Context context, int resource, List<String> chatNames, ArrayList<String> chatDescriptionList, ArrayList<String> chatDatesList) {
        super(context, -1, chatNames);
        this.context = context;
        this.chatNames = chatNames;
        this.chatDescriptions = chatDescriptionList;
        this.chatDates = chatDatesList;
    }

    @SuppressLint("NewApi")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.sample_chat, parent, false);
        TextView chatNameText = (TextView) rowView.findViewById(R.id.Name);
        TextView chatDescriptionText = (TextView) rowView.findViewById(R.id.msg);
        TextView chatDateText = (TextView) rowView.findViewById(R.id.chat_date_txt);
        TextView chatNotifsText = (TextView) rowView.findViewById(R.id.chat_notifs_txt);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        chatNameText.setText(chatNames.get(position));
        chatDescriptionText.setText(chatDescriptions.get(position));
        chatDateText.setText(chatDates.get(position));
        if (getRandomNumber() < 2) {
            chatDateText.setTextColor(context.getColor(R.color.colorAccent));
            chatNotifsText.setVisibility(View.VISIBLE);
        } else
            chatNotifsText.setVisibility(View.INVISIBLE);
        // change the icon for Windows and iPhone
        if (position == 4) {
            chatDescriptionText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_check_black_24dp, 0, 0, 0);
        }
        if (position == 5) {
            chatDescriptionText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_photo_camera_black_24dp, 0, 0, 0);
        }
        String s = chatNames.get(position);
        return rowView;
    }

    private int getRandomNumber() {
        Random random = new Random();
        int x = random.nextInt(5);
        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        } else if (x == 2) {
            return 2;
        } else
            return 3;

    }
}
