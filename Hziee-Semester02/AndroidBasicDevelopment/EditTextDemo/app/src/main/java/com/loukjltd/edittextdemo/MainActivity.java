package com.loukjltd.edittextdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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