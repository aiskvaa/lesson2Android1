package com.example.lesson2android1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imImage;
    TextView tvMeaning;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imImage = findViewById(R.id.im_image);
        tvMeaning = findViewById(R.id.tv_meaning);
        btnAdd = findViewById(R.id.btn_open_second_activity);
        getInfo();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);

            }
        });
    }

    private void getInfo() {
        Intent intent = getIntent();
        String Data = intent.getStringExtra("key");
        tvMeaning.setText(Data);
        Uri getData = intent.getData();
        imImage.setImageURI(getData);
       
    }
}