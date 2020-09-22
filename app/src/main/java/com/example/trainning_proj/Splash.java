package com.example.trainning_proj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    ImageView imageView,imageView_name;
    Animation animation,animation1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageView = findViewById(R.id.image_splash);
        imageView_name = findViewById(R.id.image_splash_name);

        animation = AnimationUtils.loadAnimation(Splash.this, R.anim.anim);
        animation1 = AnimationUtils.loadAnimation(Splash.this, R.anim.anim1);
        imageView.startAnimation(animation);
        imageView_name.startAnimation(animation1);


        // when you start user see it frist
         new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(Splash.this, SignIn.class);
                startActivity(intent);
                finish();

            }
        }, 2000);

    }
}