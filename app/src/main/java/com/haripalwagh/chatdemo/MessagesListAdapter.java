package com.haripalwagh.chatdemo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.haripalwagh.chatdemo.Models.MessageCell;

/**
 * Created by haripal on 7/25/17.
 */

public class MessagesListAdapter extends ArrayAdapter<MessageCell> {
    MessageCell[] cellItem = null;
    Context context;
    public MessagesListAdapter(Context context, MessageCell[] resource) {
        super(context, R.layout.message_cell, resource);
        // TODO Auto-generated constructor stub
        this.context = context;
        this.cellItem = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();

        if (cellItem[position].getSender()) {
            convertView = inflater.inflate(R.layout.sender_message_cell, parent, false);
        } else {
            convertView = inflater.inflate(R.layout.message_cell, parent, false);
        }

        TextView sender = (TextView) convertView.findViewById(R.id.photoName);
        sender.setText(cellItem[position].getMessageSender());

        TextView wish = (TextView) convertView.findViewById(R.id.wishMessage);
        wish.setText(cellItem[position].getMessageText());

        TextView dateTime = (TextView) convertView.findViewById(R.id.dateTime);
        dateTime.setText(cellItem[position].getMessageDateTime());

        return convertView;
    }
}