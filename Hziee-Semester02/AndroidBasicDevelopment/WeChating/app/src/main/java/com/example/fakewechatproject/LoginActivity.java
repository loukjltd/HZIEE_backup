package com.example.fakewechatproject;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fakewechatproject.domain.User;
import com.example.fakewechatproject.utils.UserUtil;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameText;
    private EditText passwordText;
    private TextView errorTip;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button loginBtn = (Button) findViewById(R.id.btnLogin);
        CheckBox rememberCheckBox = (CheckBox) findViewById(R.id.cbSavePassword);
        usernameText = (EditText) findViewById(R.id.etUserNameLogin);
        passwordText = (EditText) findViewById(R.id.etPasswordLogin);
        errorTip = (TextView) findViewById(R.id.tvErrorMessage);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isRemember = sp.getBoolean("remember_password", false);
        if (isRemember) {
            String username = sp.getString("username", "");
            String password = sp.getString("password", "");
            usernameText.setText(username);
            passwordText.setText(password);
            rememberCheckBox.setChecked(true);
            Toast.makeText(this, "记住密码lo", Toast.LENGTH_SHORT).show();
        }


        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();
        usernameText.setText(username);
        passwordText.setText(password);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameText.getText().toString();
                String password = passwordText.getText().toString();
                User user = new User(username, password);
                boolean res = UserUtil.login(user);
                if (!res) { // 用户名或密码错误
                    errorTip.setText("您输入的用户名或密码有误！");
                } else { // 登陆成功
                    editor = sp.edit();
                    if (rememberCheckBox.isChecked()) {
                        editor.putBoolean("remember_password", true);
                        editor.putString("username", username);
                        editor.putString("password", password);
                    } else {
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this, Index.class);
                    startActivity(intent);
                }
            }
        });
    }
}
