package com.example.fakewechatproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        LitePal.initialize(this);

        Button signIn = findViewById(R.id.btnChooseLogin);
        Button newUser = findViewById(R.id.btnChooseRegister);
        signIn.setOnClickListener(this);
        newUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.getId() == R.id.btnChooseLogin) {
            intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btnChooseRegister) {
            intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        }
    }
}