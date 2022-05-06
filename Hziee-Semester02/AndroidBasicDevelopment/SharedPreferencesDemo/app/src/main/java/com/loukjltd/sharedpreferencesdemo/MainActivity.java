package com.loukjltd.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etPassWord;
    private CheckBox cbRemember;
    private SharedPreferences preferences;
    //用于密码存储
    private final String PREF_FILENAME = "setting";
    private final int MODE = MODE_PRIVATE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //密码存储有关，待研究
        preferences = getSharedPreferences(PREF_FILENAME,MODE);

        //赋值
        etName = findViewById(R.id.etName);
        etPassWord = findViewById(R.id.etPassword);
        cbRemember = findViewById(R.id.cbRemember);
        //判断登录按钮
        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }

    //假设第二次打开，密码账号要有保存显示
    @Override
    protected void onStart() {
        super.onStart();
        String name = preferences.getString("USER_NAME","Kevin");//看有没有USER_NAME,没有给默认值Kevin
        String password = preferences.getString("USER_PASSWORD","");
        boolean isRemember = preferences.getBoolean("IS_REMEMBER",true);
        if (isRemember) {
            etName.setText(name);
            etPassWord.setText(password);
        }
        cbRemember.setChecked(isRemember);
    }

    private void attemptLogin(){
        String name = etName.getText().toString();
        String password = etPassWord.getText().toString();
        SharedPreferences.Editor editor = preferences.edit();
        //如果检查框是勾上的保存账号密码
        if (cbRemember.isChecked()){
            editor.putString("USER_NAME",name);
            editor.putString("USER_PASSWORD",password);
            editor.putBoolean("IS_REMEMBER",true);
        }else{
            editor.remove("USER_NAME");
            editor.remove("USER_PASSWORD");
            editor.putBoolean("IS_REMEMBER",false);
        }
        editor.apply();//数据返回
        //登入过程

    }
}