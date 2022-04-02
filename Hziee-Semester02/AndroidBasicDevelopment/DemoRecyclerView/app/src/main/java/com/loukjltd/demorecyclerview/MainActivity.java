package com.loukjltd.demorecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Contact> data;
    private ContactAdapter adapter;
    private IContactListener listener = new IContactListener() {
        @Override
        public void onClick(View view) {
            // 添加一个联系人
            data.add(new Contact("Tom", "10001", R.drawable.ic_launcher_background));
            adapter.notifyDataSetChanged();
        }

        @Override
        public boolean onLongClick(View view) {
            // 删除联系人
            Contact contact = (Contact) view.getTag();
            data.remove(contact);
            adapter.notifyDataSetChanged();
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

        findViewById(R.id.fabAdd).setOnClickListener(listener);

        RecyclerView rvContact = findViewById(R.id.rvContact);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false);
        rvContact.setLayoutManager(layoutManager);
        adapter = new ContactAdapter(data);
        adapter.setListener(listener);
        rvContact.setAdapter(adapter);
    }

    private void initData() {
        data = new ArrayList<>(0);
        data.add(new Contact("张三", "10086", R.drawable.ic_action_eye_open));
        data.add(new Contact("李四", "10010", R.drawable.ic_action_phone_start));
        data.add(new Contact("王五", "10000", R.drawable.ic_action_eye_open));
    }
}