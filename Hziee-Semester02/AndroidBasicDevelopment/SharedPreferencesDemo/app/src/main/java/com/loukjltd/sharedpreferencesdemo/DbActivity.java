package com.loukjltd.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DbActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText etUserName;
    private EditText etUserAge;
    private EditText etUserHeight;
    private EditText etId;
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        etUserName = findViewById(R.id.etUserName);
        etUserAge = findViewById(R.id.etUserAge);
        etUserHeight = findViewById(R.id.etUserHeight);
        etId = findViewById(R.id.etId);
        tvResult = findViewById(R.id.tvResult);

        findViewById(R.id.btnAdd).setOnClickListener(this);
        findViewById(R.id.btnAll).setOnClickListener(this);
        findViewById(R.id.btnDelAll).setOnClickListener(this);
        findViewById(R.id.btnQueryById).setOnClickListener(this);
        findViewById(R.id.btnDeleteById).setOnClickListener(this);
        findViewById(R.id.btnUpdateById).setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAdd:
                addOne();
                break;
            case R.id.btnAll:
                queryAll();
                break;
            case R.id.btnDelAll:
                deleteAll();
                break;
            case R.id.btnQueryById:
                queryById();
                break;
            case R.id.btnDeleteById:
                deleteById();
                break;
            case R.id.btnUpdateById:
                updateById();
                break;
            default:
                break;
        }
    }

    private void addOne() {

    }

    private void queryAll() {

    }

    private void deleteAll() {

    }

    private void queryById() {

    }

    private void deleteById() {

    }

    private void updateById() {

    }
}