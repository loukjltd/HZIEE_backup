package com.loukjltd.demolifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        findViewById(R.id.btnOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etName = findViewById(R.id.etName);
                EditText etAge = findViewById(R.id.etAge);
                String name = etName.getText().toString();
                int age = Integer.parseInt(etAge.getText().toString());

                Intent intent = new Intent();
                intent.putExtra("Name", name);
                intent.putExtra("Age", age);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}