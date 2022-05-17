package com.loukjltd.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DbActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText etUserName;
    private EditText etUserAge;
    private EditText etUserHeight;
    private EditText etId;
    private TextView tvResult;

    private SQLiteDatabase sqLiteDatabase;
    private void initDatabase(){
        DBOpenHelper helper = new DBOpenHelper(this,
                DBOpenHelper.DB_NAME, null, 1);
        try {
            sqLiteDatabase = helper.getWritableDatabase();
        } catch (Exception e) {
            sqLiteDatabase = helper.getReadableDatabase();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        initDatabase();

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
        String name = etUserName.getText().toString();
        int age = Integer.parseInt(etUserAge.getText().toString());
        float height = Float.parseFloat(etUserHeight.getText().toString());

        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.COLLUM_NAME, name);
        values.put(DBOpenHelper.COLLUM_AGE, age);
        values.put(DBOpenHelper.COLLUM_HEIGHT, height);
        long id = sqLiteDatabase.insert(DBOpenHelper.TABLE_NAME, null, values);
        Toast.makeText(this, "添加成功，id为：" + id, Toast.LENGTH_SHORT).show();
    }

    private void queryAll() {
        @SuppressLint("Recycle") Cursor cursor = sqLiteDatabase.query(DBOpenHelper.TABLE_NAME,
                null, null, null, null,
                null, null, null);
        StringBuffer buffer = new StringBuffer();
        while (cursor != null && cursor.moveToNext()){
            @SuppressLint("Range") long id = cursor.getLong(
                    cursor.getColumnIndex(DBOpenHelper.COLLUM_ID));
            @SuppressLint("Range") String name = cursor.getString(
                    cursor.getColumnIndex(DBOpenHelper.COLLUM_NAME));
            @SuppressLint("Range") int age = cursor.getInt(
                    cursor.getColumnIndex(DBOpenHelper.COLLUM_AGE));
            @SuppressLint("Range") float height = cursor.getFloat(
                    cursor.getColumnIndex(DBOpenHelper.COLLUM_HEIGHT));
            buffer.append("#").append(id).append("，name：").append(name).append("，age：")
                    .append(age).append("，height：").append(height).append("\n");
        }
        tvResult.setText(buffer.toString());
    }

    private void deleteAll() {
        sqLiteDatabase.delete(DBOpenHelper.TABLE_NAME, null, null);
        Toast.makeText(this, "删除全部成功", Toast.LENGTH_SHORT).show();
    }

    private void queryById() {
        String ids = etId.getText().toString();
        @SuppressLint("Recycle") Cursor cursor = sqLiteDatabase.query(DBOpenHelper.TABLE_NAME, null,
                "_id=" + ids, null, null,
                null, null, null);
        StringBuffer buffer = new StringBuffer();
        while(cursor != null && cursor.moveToNext()){
            @SuppressLint("Range") long id = cursor.getLong(
                    cursor.getColumnIndex(DBOpenHelper.COLLUM_ID));
            @SuppressLint("Range") String name = cursor.getString(
                    cursor.getColumnIndex(DBOpenHelper.COLLUM_NAME));
            @SuppressLint("Range") int age = cursor.getInt(
                    cursor.getColumnIndex(DBOpenHelper.COLLUM_AGE));
            @SuppressLint("Range") float height = cursor.getFloat(
                    cursor.getColumnIndex(DBOpenHelper.COLLUM_HEIGHT));
            buffer.append("#").append(id).append("，name：").append(name).append("，age：")
                    .append(age).append("，height：").append(height).append("\n");
        }
        tvResult.setText(buffer.toString());
    }

    private void deleteById() {
        String ids = etId.getText().toString();
        sqLiteDatabase.delete(DBOpenHelper.TABLE_NAME, "_id=" + ids, null);
        Toast.makeText(this, "删除成功：#" + ids, Toast.LENGTH_SHORT).show();
    }

    private void updateById() {
        String ids = etId.getText().toString();
        String name = etUserName.getText().toString();
        int age = Integer.parseInt(etUserAge.getText().toString());
        float height = Float.parseFloat(etUserHeight.getText().toString());
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.COLLUM_NAME, name);
        values.put(DBOpenHelper.COLLUM_AGE, age);
        values.put(DBOpenHelper.COLLUM_HEIGHT, height);
        sqLiteDatabase.update(DBOpenHelper.TABLE_NAME, values, "_id=" + ids, null);
        Toast.makeText(this, "更新成功：#" + ids, Toast.LENGTH_SHORT).show();
    }
}