package com.loukjltd.demorecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Contact> data;
    private ContactAdapter adapter;
    private static final String[] choices = new String[]{"Tom", "Jerry", "Sam"};
    private static boolean[] stated = new boolean[]{false, true, false};
    private int index = 1;

    private final IContactListener listener = new IContactListener() {
        @Override
        public void onClick(View v) {
            // 添加一个联系人
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            View view = inflater.inflate(R.layout.dlg_contact, null, false);

            EditText etName = view.findViewById(R.id.etName);
            EditText etPhone = view.findViewById(R.id.etPhone);

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("添加联系人")
                    .setView(view)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String name = etName.getText().toString();
                            String phone = etPhone.getText().toString();
                            Contact contact = new Contact(name, phone, R.drawable.ic_launcher_background);
                            data.add(contact);
                            adapter.notifyDataSetChanged();
                        }
                    })
                    .setNegativeButton("取消", null)
                    .create()
                    .show();
        }

        @Override
        public boolean onLongClick(View v) {
            // 删除联系人
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("提示")
                    .setIcon(R.drawable.ic_launcher_background)
                    .setMessage("确定删除吗？")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Contact contact = (Contact) v.getTag();
                            data.remove(contact);
                            adapter.notifyDataSetChanged();
                        }
                    })
                    .setNegativeButton("取消", null)
                    .create()
                    .show();

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.wx_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, "点击了「" + item.getTitle() + "」", Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.itAdd:
                break;
            case R.id.itChat:
                break;
            case R.id.itScan:
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}