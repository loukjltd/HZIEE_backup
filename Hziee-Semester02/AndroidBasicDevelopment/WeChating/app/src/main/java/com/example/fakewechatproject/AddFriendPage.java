package com.example.fakewechatproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.fakewechatproject.ui.friends.FriendsFragment;

public class AddFriendPage extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout l1;
    private LinearLayout l2;
    private EditText searchEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);
        Button search = (Button) findViewById(R.id.btnSearch);
        Button addFriendBtn = (Button) findViewById(R.id.btnAddNewFriend);
        l1 = (LinearLayout) findViewById(R.id.add_friend_page);
        l2 = (LinearLayout) findViewById(R.id.add_friend_page2);
        searchEdit = (EditText) findViewById(R.id.etAddFriend);
        l1.setVisibility(View.GONE);
        l2.setVisibility(View.GONE);
        search.setOnClickListener(this);
        addFriendBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSearch) {
            if (searchEdit.getText().toString().equals("lkj")) {
                l2.setVisibility(View.GONE);
                l1.setVisibility(View.VISIBLE);
            } else
                l2.setVisibility(View.VISIBLE);

        } else if (v.getId() == R.id.btnAddNewFriend) {
            Toast.makeText(AddFriendPage.this, "恭喜，添加成功!", Toast.LENGTH_LONG).show();
            FriendsFragment.update();
            Intent intent = new Intent(AddFriendPage.this, Index.class);
            intent.putExtra("flag", 2);
            startActivity(intent);
            AddFriendPage.this.finish();
        }
    }
}