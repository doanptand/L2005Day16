package com.t3h.storage;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private ImageView imgAssets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            InputStream stream = getAssets().open("ngoc_trinh.jpg");
            Bitmap bitmap = BitmapFactory.decodeStream(stream);
            imgAssets = findViewById(R.id.img_assets);
            imgAssets.setImageBitmap(bitmap);

            File file = new File(getFilesDir(), "my_folder");
            if(!file.exists()) {
                file.mkdirs();
            }
            File wFile = new File(file.getAbsolutePath() + "/abc.png");
            if(!wFile.exists()) {
                wFile.createNewFile();
            }
            FileOutputStream outputStream = new FileOutputStream(wFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}