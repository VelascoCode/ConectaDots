package com.example.ivanmsp.conectadots.Splash;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.ivanmsp.conectadots.MainActivity;
import com.example.ivanmsp.conectadots.R;

import butterknife.Bind;

/**
 * Created by IvanMSP on 31/03/2016.
 */
public class splash extends Activity {
    protected boolean active=true;
    private MediaPlayer reproductor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.splash);
        reproductor=MediaPlayer.create(this,R.raw.sound);
        reproductor.setLooping(true);
        reproductor.start();

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
    protected void onDestroy(){
        super.onDestroy();
        if(reproductor.isPlaying())
        {
            reproductor.stop();
            reproductor.release();
        }
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        reproductor.start();
    }

    @Override
    protected void onPause(){
        super.onPause();
        reproductor.pause();
        finish();
    }
}
