package com.loukjltd.demorecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {
    private ArrayList<Integer> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        initDate();

        RecyclerView rvAlbum = findViewById(R.id.rvAlbum);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(
                2, StaggeredGridLayoutManager.VERTICAL
        );
        rvAlbum.setLayoutManager(layoutManager);
        AlbumAdapter adapter = new AlbumAdapter(data);
        rvAlbum.setAdapter(adapter);
    }

    private void initDate() {
        data = new ArrayList<>(0);
        data.add(R.drawable.img1);
        data.add(R.drawable.img2);
        data.add(R.drawable.img1);
        data.add(R.drawable.img2);
    }
}
