package com.example.imageload;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        Button butOK=findViewById(R.id.butOK);
        butOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText text=findViewById(R.id.editText);
                ImageView image=findViewById(R.id.imageView);
                Drawable newImage;
                if((newImage=Drawable.createFromPath(text.getText().toString()))==null) {
                    Toast.makeText(getApplicationContext(),"Изображение не найдено",Toast.LENGTH_SHORT).show();
                }else{
                    image.setImageDrawable(newImage);
                    findViewById(R.id.inputForm).setVisibility(View.GONE);
                    image.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
