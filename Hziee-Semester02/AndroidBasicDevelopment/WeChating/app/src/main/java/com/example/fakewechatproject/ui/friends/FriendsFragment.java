package com.example.fakewechatproject.ui.friends;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.fakewechatproject.ChatPage;
import com.example.fakewechatproject.R;
import com.example.fakewechatproject.component.FriendsSlideLayout;
import com.example.fakewechatproject.domain.Friends;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FriendsFragment extends Fragment {

    private ListView listView;
    private ArrayList<Friends> list;
    private ArrayList<Integer> idList;
    private final Set<FriendsSlideLayout> sets = new HashSet();
    private static boolean flag = false;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FriendsViewModel friendsViewModel = new ViewModelProvider(this).get(FriendsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_friends, container, false);
        friendsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        listView = (ListView) root.findViewById(R.id.lvFriends);
        initData();
        return root;
    }


    class MyAdapter extends BaseAdapter {
        private Context content;
        private ArrayList<Friends> datas;

        private MyAdapter(Context context, ArrayList<Friends> datas) {
            this.content = context;
            this.datas = datas;
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @SuppressLint("InflateParams")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            final Friends friends = datas.get(position);
            //final Integer p_id = idList.get(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(content).inflate(R.layout.activity_friend_list, null);
                viewHolder = new ViewHolder();
                viewHolder.nameView = (TextView) convertView.findViewById(R.id.tvFriendName);
                viewHolder.catalogView = (TextView) convertView.findViewById(R.id.tvCatalog);
                //viewHolder.menuView = (TextView) convertView.findViewById(R.id.menu_friends);
                viewHolder.profile = (ImageView) convertView.findViewById(R.id.ivFriendAvatar);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.profile.setImageResource(idList.get(position));
            viewHolder.nameView.setText(datas.get(position).getName());


            String catalog = list.get(position).getFirstLetter();

            if (position == getPositionForSection(catalog)) {
                viewHolder.catalogView.setVisibility(View.VISIBLE);
                viewHolder.catalogView.setText(friends.getFirstLetter().toUpperCase());
            } else {
                viewHolder.catalogView.setVisibility(View.GONE);
            }


            String nickname = viewHolder.nameView.getText().toString();
            viewHolder.nameView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(content, "click " + ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), ChatPage.class);
                    intent.putExtra("nickname", nickname);
                    startActivity(intent);
                }
            });

            FriendsSlideLayout slideLayout = (FriendsSlideLayout) convertView;
            slideLayout.setOnStateChangeListener(new MyOnStateChangeListener());


            return convertView;
        }

        public FriendsSlideLayout slideLayout = null;

        class MyOnStateChangeListener implements FriendsSlideLayout.OnStateChangeListener {
            /**
             * 滑动后每次手势抬起保证只有一个item是open状态，加入sets集合中
             **/
            @Override
            public void onOpen(FriendsSlideLayout layout) {
                slideLayout = layout;
                if (sets.size() > 0) {
                    for (FriendsSlideLayout s : sets) {
                        s.closeMenu();
                        sets.remove(s);
                    }
                }
                sets.add(layout);
            }

            @Override
            public void onMove(FriendsSlideLayout layout) {
                if (slideLayout != null && slideLayout != layout) {
                    slideLayout.closeMenu();
                }
            }

            @Override
            public void onClose(FriendsSlideLayout layout) {
                if (sets.size() > 0) {
                    sets.remove(layout);
                }
                if (slideLayout == layout) {
                    slideLayout = null;
                }
            }
        }

        public int getPositionForSection(String catalog) {
            for (int i = 0; i < getCount(); i++) {
                String sortStr = list.get(i).getFirstLetter();
                if (catalog.equalsIgnoreCase(sortStr)) {
                    return i;
                }
            }
            return -1;
        }
    }

    static class ViewHolder {
        public TextView catalogView;
        public TextView menuView;
        public TextView nameView;
        public ImageView profile;
    }

    private void initData() {
        list = new ArrayList<>();
        list.add(new Friends("暗哑于秋"));
        list.add(new Friends("Farewell"));
        list.add(new Friends("阿芙乐尔"));
        list.add(new Friends("月亮是指路牌"));
        list.add(new Friends("五亿个小铃铛"));
        list.add(new Friends("海棠未眠"));
        list.add(new Friends("九千七"));
        list.add(new Friends("半夜汽笛"));
        list.add(new Friends("黑夜的海"));
        list.add(new Friends("山原"));
        list.add(new Friends("遥遥万里"));
        list.add(new Friends("不是山谷"));
        list.add(new Friends("封锁飞船"));
        list.add(new Friends("盐焗小星球"));
        list.add(new Friends("出售星辰之书的书商"));

        if (flag)
            list.add(new Friends("旅客君"));
        Collections.sort(list);
        MyAdapter myAdapter = new MyAdapter(getActivity().getApplicationContext(), list);
        listView.setAdapter(myAdapter);

        idList = new ArrayList<>();
        idList.add(R.drawable.afterclap_1);
        idList.add(R.drawable.afterclap_2);
        idList.add(R.drawable.afterclap_3);
        idList.add(R.drawable.afterclap_4);
        idList.add(R.drawable.afterclap_5);
        idList.add(R.drawable.afterclap_6);
        idList.add(R.drawable.afterclap_7);
        idList.add(R.drawable.afterclap_8);
        idList.add(R.drawable.afterclap_9);
        idList.add(R.drawable.afterclap_1);
        idList.add(R.drawable.afterclap_2);
        idList.add(R.drawable.afterclap_3);
        idList.add(R.drawable.afterclap_4);
        idList.add(R.drawable.afterclap_5);
        idList.add(R.drawable.afterclap_6);

        if (flag) {
            idList.add(R.drawable.afterclap_7);
            idList.add(R.drawable.afterclap_8);
            idList.add(R.drawable.afterclap_7);
        }


    }

    public static void update() {
        flag = true;
    }

}