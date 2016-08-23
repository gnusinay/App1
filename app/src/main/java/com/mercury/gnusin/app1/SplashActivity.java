package com.mercury.gnusin.app1;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toolbar;

public class SplashActivity extends Activity {
    public static boolean isRunHomeScreen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //getSupportActionBar().hide();
        Log.d(getClass().getSimpleName(), String.valueOf(isRunHomeScreen));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!isRunHomeScreen) {
                    isRunHomeScreen = true;
                    Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                    SplashActivity.this.startActivity(intent);
                    SplashActivity.this.finish();
                }
            }
        }, 4000);

    }
}
