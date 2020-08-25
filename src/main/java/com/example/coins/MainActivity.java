package com.example.coins;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN=5000;

    //variables
    Animation topanimation,buttomanimation;
    ImageView image;
    TextView inno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        topanimation= AnimationUtils.loadAnimation(this,R.anim.splash_top_animation);
        buttomanimation=AnimationUtils.loadAnimation(this,R.anim.splash_buttom_animation);

        //hooks
        image=findViewById(R.id.imageview);
        inno=findViewById(R.id.textView);

        image.setAnimation(topanimation);
        inno.setAnimation(buttomanimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}
