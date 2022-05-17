package com.example.fakewechatproject.ui.index;

import android.annotation.SuppressLint;
import android.content.Context;
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

import com.example.fakewechatproject.R;
import com.example.fakewechatproject.component.MessageSlideLayout;
import com.example.fakewechatproject.domain.Friends;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class IndexFragment extends Fragment {

    private IndexViewModel indexViewModel;
    private ListView listView;
    private ArrayList<Friends> mDatas;
    private ArrayList<Integer> idList;
    private MyAdapter myAdapter;
    private Set<MessageSlideLayout> sets = new HashSet();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        indexViewModel =
                new ViewModelProvider(this).get(IndexViewModel.class);
        View root = inflater.inflate(R.layout.fragment_index, container, false);
        indexViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });


        listView = (ListView) root.findViewById(R.id.lvIndex);
        initData();
        return root;
    }

    public void initData() {
        mDatas = new ArrayList<>();
        mDatas.add(new Friends("暗哑于秋"));
        mDatas.add(new Friends("Farewell"));
        mDatas.add(new Friends("阿芙乐尔"));
        mDatas.add(new Friends("月亮是指路牌"));
        mDatas.add(new Friends("五亿个小铃铛"));
        mDatas.add(new Friends("海棠未眠"));
        mDatas.add(new Friends("九千七"));

        myAdapter = new MyAdapter(getActivity().getApplicationContext(), mDatas);
        listView.setAdapter(myAdapter);

        idList = new ArrayList();
        idList.add(R.drawable.afterclap_2);
        idList.add(R.drawable.afterclap_8);
        idList.add(R.drawable.afterclap_7);
        idList.add(R.drawable.afterclap_4);
        idList.add(R.drawable.afterclap_3);
        idList.add(R.drawable.afterclap_5);
        idList.add(R.drawable.afterclap_9);

    }

    class MyAdapter extends BaseAdapter {
        private final Context content;
        private final ArrayList<Friends> friendsData;

        private MyAdapter(Context context, ArrayList<Friends> datas) {
            this.content = context;
            this.friendsData = datas;
        }

        @Override
        public int getCount() {
            return friendsData.size();
        }

        @Override
        public Object getItem(int position) {
            return friendsData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @SuppressLint("InflateParams")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(content).inflate(R.layout.activity_item, null);
                viewHolder = new ViewHolder();
                viewHolder.contentView = (TextView) convertView.findViewById(R.id.tvContent);
                viewHolder.menuView = (TextView) convertView.findViewById(R.id.tvDelete);
                viewHolder.profile = (ImageView) convertView.findViewById(R.id.ivFriendAvatar);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.profile.setImageResource(idList.get(position));
            viewHolder.contentView.setText(friendsData.get(position).getName());

            viewHolder.contentView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(content, "click " + ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
                }
            });
            final Friends myContent = friendsData.get(position);
            final Integer p_id = idList.get(position);

            viewHolder.menuView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MessageSlideLayout slideLayout = (MessageSlideLayout) v.getParent();
                    slideLayout.closeMenu(); //解决删除item后下一个item变成open状态问题
                    friendsData.remove(myContent);
                    idList.remove(p_id);
                    notifyDataSetChanged();
                }
            });

            MessageSlideLayout slideLayout = (MessageSlideLayout) convertView;
            slideLayout.setOnStateChangeListener(new MyOnStateChangeListener());


            return convertView;
        }

        public MessageSlideLayout slideLayout = null;

        class MyOnStateChangeListener implements MessageSlideLayout.OnStateChangeListener {
            /**
             * 滑动后每次手势抬起保证只有一个item是open状态，加入sets集合中
             **/
            @Override
            public void onOpen(MessageSlideLayout layout) {
                slideLayout = layout;
                if (sets.size() > 0) {
                    for (MessageSlideLayout s : sets) {
                        s.closeMenu();
                        sets.remove(s);
                    }
                }
                sets.add(layout);
            }

            @Override
            public void onMove(MessageSlideLayout layout) {
                if (slideLayout != null && slideLayout != layout) {
                    slideLayout.closeMenu();
                }
            }

            @Override
            public void onClose(MessageSlideLayout layout) {
                if (sets.size() > 0) {
                    sets.remove(layout);
                }
                if (slideLayout == layout) {
                    slideLayout = null;
                }
            }
        }
    }

    static class ViewHolder {
        public TextView contentView;
        public TextView menuView;
        public ImageView profile;
    }

}