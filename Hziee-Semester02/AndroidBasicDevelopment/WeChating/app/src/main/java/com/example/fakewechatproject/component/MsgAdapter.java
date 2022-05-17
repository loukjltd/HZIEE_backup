package com.example.fakewechatproject.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakewechatproject.R;
import com.example.fakewechatproject.domain.Msg;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    List<Msg> messages = new ArrayList<>();
    Context context;
    LayoutInflater inflater;

    public MsgAdapter(List<Msg> messages, Context context) {
        this.messages = messages;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MsgAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.activity_message_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MsgAdapter.ViewHolder holder, int position) {
        Msg msg = messages.get(position);
        if (msg.getType() == Msg.type_received) {
            if (position < 2)
                holder.left_layout.setVisibility(View.VISIBLE);
            else
                holder.left_layout.setVisibility(View.GONE);
            holder.right_layout.setVisibility(View.GONE);
            holder.left_msg.setText(msg.getContent());
        } else if (msg.getType() == Msg.type_sent) {
            holder.right_layout.setVisibility(View.VISIBLE);
            holder.left_layout.setVisibility(View.GONE);
            holder.right_msg.setText(msg.getContent());

        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView left_msg;
        TextView right_msg;
        LinearLayout left_layout;
        LinearLayout right_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            left_msg = itemView.findViewById(R.id.tvLeftMessage);
            right_msg = itemView.findViewById(R.id.tvRightMessage);
            left_layout = itemView.findViewById(R.id.llLeftLayout);
            right_layout = itemView.findViewById(R.id.llRightLayout);
        }
    }
}