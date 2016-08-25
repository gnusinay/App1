package com.mercury.gnusin.app1;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

public class SplashActivity extends Activity {
    private boolean isRunHomeScreen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_splash);
        if (savedInstanceState != null) {
            isRunHomeScreen = savedInstanceState.getBoolean("isRunHomeScreen", false);
        }

        //getSupportActionBar().hide();

        if (!isRunHomeScreen) {
            isRunHomeScreen = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                    SplashActivity.this.startActivity(intent);
                    SplashActivity.this.finish();
                }
            }, 2000);
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean("isRunHomeScreen", isRunHomeScreen);
        super.onSaveInstanceState(outState);
    }
}
