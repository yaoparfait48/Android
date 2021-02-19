package com.example.tp2sigl3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private static  int SPLASH_SCREEN = 3000;

    Animation topAnim, bottomAnim;
    ImageView img;
    TextView team7, can_2023;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        img = findViewById(R.id.drapeau);
        team7 = findViewById(R.id.team7);
        can_2023 = findViewById(R.id.can_2023);

        img.setAnimation(topAnim);
        team7.setAnimation(bottomAnim);
        can_2023.setAnimation(topAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, Acceuil.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);
    }
}