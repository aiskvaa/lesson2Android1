package com.example.lesson2android1;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.location.GnssAntennaInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {
    ImageView imImageGallery;
    EditText etTransData;
    Button btnSendDataToMainActivity;
    Uri uri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        Listener();

    }

    private void initView() {
        imImageGallery = findViewById(R.id.im_image_gallery);
        etTransData = findViewById(R.id.et_trans_data);
        btnSendDataToMainActivity = findViewById(R.id.btn_send_data_to_main_activity);
    }

    private void Listener() {
        imImageGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA_SECURE);
                startActivity(intent);
                resultLauncher.launch("image/*");
            }
        });
        btnSendDataToMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = etTransData.getText().toString();
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.putExtra("key", data);
                intent.setData(uri);
                startActivity(intent);

            }
        });
        
    }

    ActivityResultLauncher<String> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    uri = result;
                    imImageGallery.setImageURI(uri);


                }
            });
}




