package com.example.wallpaperchange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnChangeWallpaper,bright,bleft,bselect;
    ImageView iView;
    boolean running;
    int i=0;
    int[] ia=new int[]{
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChangeWallpaper = (Button) findViewById(R.id.btn_wallpaper);
        btnChangeWallpaper.setOnClickListener(this);

        bright=(Button) findViewById(R.id.button2);
        bright.setOnClickListener(this);

        bleft=(Button) findViewById(R.id.button3);
        bleft.setOnClickListener(this);

        bselect=(Button) findViewById(R.id.button4);
        bselect.setOnClickListener(this);

        iView= (ImageView) findViewById(R.id.imageView);
    }
    public void onClick(View v){
        if(v.equals(btnChangeWallpaper)) {
            if (!running) {
                new Timer().schedule(new MyTimer(), 0, 3000);
                running = true;
            }
        }
        if(v.equals(bright)){
            if(i>=0){
                iView.setImageResource(ia[i++]);
            }
        }
        if(v.equals(bleft)){
            if(i<6){
                iView.setImageResource(ia[i--]);
            }
        }
        

    }
    class MyTimer extends TimerTask
    {
        public void run()
        {
            try{
                WallpaperManager wallpaperManager=WallpaperManager.getInstance(getBaseContext());
                Random random=new Random();
                wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(), ia[random.nextInt(5)]));
            } catch (Exception e){

            }
        }
    }
}