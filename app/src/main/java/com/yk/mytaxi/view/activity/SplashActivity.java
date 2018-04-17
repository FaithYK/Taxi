package com.yk.mytaxi.view.activity;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.yk.mytaxi.R;

import static android.os.Build.VERSION.SDK;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            final AnimatedVectorDrawable animatedVectorDrawable = new AnimatedVectorDrawable();
            final ImageView logo = (ImageView) findViewById(R.id.iv_logo);
            logo.setImageDrawable(animatedVectorDrawable);
            animatedVectorDrawable.start();
        }
    }
}
