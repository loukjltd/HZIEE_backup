package com.loukjltd.edittextdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String choice = "男";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View listenerView) {
                processLogin(listenerView);
            }
        });

        RadioGroup rgSex = findViewById(R.id.rgSex);
        rgSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rbMale:
                        choice = "男";
                        Toast.makeText(MainActivity.this,"您的性别是：" + choice, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbFemale:
                        choice = "女";
                        Toast.makeText(MainActivity.this,"您的性别是：" + choice, Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        choice = "无性别";
                        Toast.makeText(MainActivity.this,"您的性别是：" + choice, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    public void processLogin(View loginView) {
        EditText etPhone = findViewById(R.id.etPhone);
        String phone = etPhone.getText().toString();
        EditText etPassword = findViewById(R.id.etPassword);
        String password = etPassword.getText().toString();

        CheckBox cbRemember = findViewById(R.id.cbRemember);
        Boolean isRemember = cbRemember.isChecked();

        if (phone.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "手机号或密码未输入！", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,"您的号码是：" + phone + "，是否记住密码：" + isRemember, Toast.LENGTH_LONG).show();
        }
    }
}