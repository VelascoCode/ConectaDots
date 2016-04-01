package com.example.ivanmsp.conectadots.Splash;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

import com.example.ivanmsp.conectadots.MainActivity;
import com.example.ivanmsp.conectadots.R;

import butterknife.Bind;

/**
 * Created by IvanMSP on 31/03/2016.
 */
public class splash extends Activity {
    protected boolean active=true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash);

        Thread timerTread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(splash.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerTread.start();
    }
    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }
}
