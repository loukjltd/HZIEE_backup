package com.loukjltd.demomenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvHello = findViewById(R.id.tvHello);
        tvHello.setOnClickListener(this);

        // registerForContextMenu(tvHello);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itCopy:
                Toast.makeText(this, "已选中了：" + item.getTitle(),
                        Toast.LENGTH_SHORT).show();
            case R.id.itPaste:
                Toast.makeText(this, "已选中了：" + item.getTitle(),
                        Toast.LENGTH_SHORT).show();
            default:
                break;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        MenuInflater menuInflater = popupMenu.getMenuInflater();
        menuInflater.inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.ctx_menu, menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itDownload:
                Toast.makeText(this, "已选中了：" + item.getTitle(),
                        Toast.LENGTH_SHORT).show();
            case R.id.itUpload:
                Toast.makeText(this, "已选中了：" + item.getTitle(),
                        Toast.LENGTH_SHORT).show();
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }
}