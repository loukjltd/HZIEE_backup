package com.example.fakewechatproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fakewechatproject.component.MessageHelper;
import com.example.fakewechatproject.domain.Messages;
import com.github.xubo.statusbarutils.StatusBarUtils;

import java.util.ArrayList;
import java.util.List;

public class ChatPage extends AppCompatActivity {

    List<Messages> list = new ArrayList<>();
    RecyclerView recyclerView;
    Toolbar toolbar;
    MessageHelper messageHelper;
    Context context = ChatPage.this;
    EditText msg_say;
    TextView send;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        recyclerView = findViewById(R.id.rvList);
        toolbar = findViewById(R.id.tbMessage);
        msg_say = findViewById(R.id.etTypeWords);
        send = findViewById(R.id.btnSendMessage);
        linearLayout = findViewById(R.id.linear);
        initData();
        initView();
    }


    private void initData() {
        Intent intent = getIntent();
        toolbar.setTitle(intent.getStringExtra("nickname"));

        Messages msg0 = new Messages("这是一条接受的信息", Messages.type_received);
        list.add(msg0);
        Messages msg1 = new Messages("这是一条发送的信息", Messages.type_sent);
        list.add(msg1);
    }

    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        messageHelper = new MessageHelper(list, context);
        recyclerView.setAdapter(messageHelper);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        msg_say.addTextChangedListener(textWatcher);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (msg_say.getEditableText().length() >= 1) {
                    String content = msg_say.getText().toString();
                    if (!"".equals(content)) {
                        Messages msg = new Messages(content, Messages.type_sent);
                        list.add(msg);
                        Messages msg1 = new Messages(content, Messages.type_received);
                        list.add(msg1);
                        messageHelper.notifyItemInserted(list.size() - 1);
                        recyclerView.scrollToPosition(list.size() - 1);
                        msg_say.setText("");
                    }
                }
            }
        });
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @SuppressLint("ResourceAsColor")
        @Override
        public void afterTextChanged(Editable s) {
            if (msg_say.getEditableText().length() >= 1) {
                send.setText("发送");
            }
        }
    };
}