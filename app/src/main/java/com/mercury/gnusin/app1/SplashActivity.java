package com.mercury.gnusin.app1;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;

public class SplashActivity extends Activity {
    private static int count = 0;
    private boolean isRunHomeScreen = false;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = ++count;
        Log.d("AGn SplashActivity_" + id, "create");
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("AGn SplashActivity_" + id, "destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("AGn SplashActivity_" + id, "pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("AGn SplashActivity_" + id, "stop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("AGn SplashActivity_" + id, "resume");
    }
}
