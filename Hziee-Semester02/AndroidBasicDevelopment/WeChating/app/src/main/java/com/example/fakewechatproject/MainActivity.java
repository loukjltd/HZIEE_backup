package com.example.fakewechatproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button signin;
    private Button newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        LitePal.initialize(this);

        signin = (Button) findViewById(R.id.btnChooseLogin);
        newUser = (Button) findViewById(R.id.btnChooseRegister);
        signin.setOnClickListener(this);
        newUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.getId() == R.id.btnChooseLogin) {//转到登录界面
            intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btnChooseRegister) {//转到注册界面
            intent = new Intent(MainActivity.this, RegistActivity.class);
            startActivity(intent);
        }
    }
}