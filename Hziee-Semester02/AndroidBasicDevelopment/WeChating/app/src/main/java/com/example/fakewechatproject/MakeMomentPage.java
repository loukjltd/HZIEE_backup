package com.example.fakewechatproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fakewechatproject.ui.discover.DiscoverFragment;

public class MakeMomentPage extends AppCompatActivity {

    private Button makeMomentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_monent);


        makeMomentBtn=(Button)findViewById(R.id.btnPublishMoment);
        makeMomentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DiscoverFragment.update();
                Intent intent=new Intent(MakeMomentPage.this, Index.class);
                intent.putExtra("flag", 2);
                startActivity(intent);
                MakeMomentPage.this.finish();
            }
        });
    }

}