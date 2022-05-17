package com.example.fakewechatproject.ui.discover;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fakewechatproject.MakeMomentPage;
import com.example.fakewechatproject.R;
import com.example.fakewechatproject.component.DiscoveryAdapter;
import com.example.fakewechatproject.domain.Friends;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;

public class DiscoverFragment extends Fragment implements View.OnClickListener {

    private DiscoverViewModel newsViewModel;
    private List<Friends> list;
    private static DiscoveryAdapter adapter;
    private ImageView goMakeMoment;
    private List<Integer> profiles;
    private List<String> nickname;
    private List<List<Integer>> itemPictures;
    private List<Integer> itemPicture;
    private List<String> copyWriting;
    private List<Integer> times;
    private static boolean flag = false;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        newsViewModel = new ViewModelProvider(this).get(DiscoverViewModel.class);
        View root = inflater.inflate(R.layout.fragment_discover, container, false);
        newsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });


        AppBarLayout appBarLayout = root.findViewById(R.id.ablBackgroundImage);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                CollapsingToolbarLayout collapsingToolbar = root.findViewById(R.id.ctlBack);
                int color = Color.argb(200, 0, 0, 0);
                collapsingToolbar.setCollapsedTitleTextColor(color);
                ImageView imageView = root.findViewById(R.id.ivMyAvatar);
                if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) { // 折叠状态
                    imageView.setVisibility(View.GONE);
                } else { // 非折叠状态
                    collapsingToolbar.setTitle("");
                    imageView.setVisibility(View.VISIBLE);
                }
            }
        });
        initFriends();
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.rvAllMoments);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new DiscoveryAdapter(list, profiles, nickname, itemPictures, copyWriting, times);
        recyclerView.setAdapter(adapter);


        goMakeMoment = root.findViewById(R.id.ivPublishIcon);
        goMakeMoment.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), MakeMomentPage.class);
        startActivity(intent);

    }


    private void initFriends() {
        list = new ArrayList<>();
        if (flag)
            list.add(new Friends("暗哑于秋"));
        list.add(new Friends("Farewell"));
        list.add(new Friends("阿芙乐尔"));
        list.add(new Friends("月亮是指路牌"));
        list.add(new Friends("五亿个小铃铛"));
        list.add(new Friends("海棠未眠"));
        list.add(new Friends("九千七"));
        list.add(new Friends("半夜汽笛"));
        list.add(new Friends("黑夜的海"));

        nickname = new ArrayList<>();
        if (flag)
            nickname.add("楼可嘉");
        nickname.add("Farewell");
        nickname.add("阿芙乐尔");
        nickname.add("月亮是指路牌");
        nickname.add("五亿个小铃铛");
        nickname.add("海棠未眠");
        nickname.add("九千七");
        nickname.add("半夜汽笛");
        nickname.add("黑夜的海");

        profiles = new ArrayList<>();//朋友圈好友的头像
        if (flag)
            profiles.add(R.drawable.mello);
        profiles.add(R.drawable.afterclap_2);
        profiles.add(R.drawable.afterclap_3);
        profiles.add(R.drawable.afterclap_8);
        profiles.add(R.drawable.afterclap_9);
        profiles.add(R.drawable.afterclap_7);
        profiles.add(R.drawable.afterclap_2);
        profiles.add(R.drawable.afterclap_4);
        profiles.add(R.drawable.afterclap_3);

        times = new ArrayList<>();//发布动态距离现在的时间
        if (flag)
            times.add(0);
        times.add(35);
        times.add(45);
        times.add(59);
        times.add(31);
        times.add(22);
        times.add(15);
        times.add(7);
        times.add(18);


        itemPictures = new ArrayList<>();
        itemPicture = new ArrayList<>();
        if (flag) {
            itemPicture.add(R.drawable.moment_09);
            itemPictures.add(itemPicture);
        }

        itemPicture = new ArrayList<>();
        itemPicture.add(R.drawable.moment_01);
        itemPictures.add(itemPicture);

        itemPicture = new ArrayList<>();
        itemPicture.add(R.drawable.moment_02);
        itemPictures.add(itemPicture);

        itemPicture = new ArrayList<>();
        itemPicture.add(R.drawable.moment_03);
        itemPictures.add(itemPicture);

        itemPicture = new ArrayList<>();
        itemPicture.add(R.drawable.moment_04);
        itemPictures.add(itemPicture);

        itemPicture = new ArrayList<>();
        itemPicture.add(R.drawable.moment_05);
        itemPictures.add(itemPicture);

        itemPicture = new ArrayList<>();
        itemPicture.add(R.drawable.moment_06);
        itemPictures.add(itemPicture);

        itemPicture = new ArrayList<>();
        itemPicture.add(R.drawable.moment_07);
        itemPictures.add(itemPicture);

        itemPicture = new ArrayList<>();
        itemPicture.add(R.drawable.moment_08);
        itemPictures.add(itemPicture);


        copyWriting = new ArrayList<>();
        if (flag)
            copyWriting.add("hello");
        copyWriting.add("如果你有一段时间非常开心 最好在那段时间反复听几首歌曲 这样以后听这几首歌曲的时候就会想起那段开心时间");
        copyWriting.add("祝愿冬季的各种所爱都漫长且愉快。");
        copyWriting.add("生活需要一点童话，在这里你不用长大。");
        copyWriting.add("昨天很爱你，今天不爱了，明天看心情。");
        copyWriting.add("要开心/要带好面具。");
        copyWriting.add("外面风大，和我回家");
        copyWriting.add("拼命的努力加油/最后都如愿以偿。");
        copyWriting.add("有趣的友情胜过敷衍的爱情。");

    }

    @SuppressLint("NotifyDataSetChanged")
    public static void update() {
        flag = true;
        adapter.notifyDataSetChanged();
    }

}




