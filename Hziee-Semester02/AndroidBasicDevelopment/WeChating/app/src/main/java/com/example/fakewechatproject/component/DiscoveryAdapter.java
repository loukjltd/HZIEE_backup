package com.example.fakewechatproject.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakewechatproject.R;
import com.example.fakewechatproject.domain.Friends;

import java.util.List;

public class DiscoveryAdapter extends RecyclerView.Adapter<DiscoveryAdapter.ViewHolder> {
    private Context mContext;
    private final List<Friends> mFriendList;
    private final List<Integer> profiles;
    private final List<String> nickname;
    private final List<List<Integer>> itemPictures;
    private final List<String> copyWriting;
    private final List<Integer> times;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView image1;
        ImageView profile;
        TextView nickname;
        TextView timeText;
        TextView copyWriting;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            image1 = (ImageView) view.findViewById(R.id.ivMomentImage);
            profile = (ImageView) view.findViewById(R.id.ivMomentAvatar);
            nickname = (TextView) view.findViewById(R.id.tvMomentName);
            timeText = (TextView) view.findViewById(R.id.tvMomentTime);
            copyWriting = (TextView) view.findViewById(R.id.tvMomentText);
        }
    }

    public DiscoveryAdapter(List<Friends> friendList, List<Integer> profiles,
                            List<String> nickname, List<List<Integer>> itemPictures,
                            List<String> copyWriting, List<Integer> times) {

        mFriendList = friendList;
        this.profiles = profiles;
        this.nickname = nickname;
        this.itemPictures = itemPictures;
        this.copyWriting = copyWriting;
        this.times = times;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_moment_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.profile.setImageResource(profiles.get(position));
        holder.nickname.setText(nickname.get(position));
        holder.copyWriting.setText(copyWriting.get(position));
        if (itemPictures.get(position).size() == 0) ;
        else if (itemPictures.get(position).size() == 1) {
            holder.image1.setImageResource(itemPictures.get(position).get(0));
        }



        int time = times.get(position);
        if (time > 0 && time < 9)
            holder.timeText.setText(time + "小时前");
        else if (time > 10)
            holder.timeText.setText(time + "分钟前");
        else holder.timeText.setText("刚刚");
    }

    @Override
    public int getItemCount() {
        return mFriendList.size();
    }

}
