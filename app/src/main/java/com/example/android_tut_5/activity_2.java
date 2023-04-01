package com.example.android_tut_5;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class activity_2 extends Activity {

    //declaring MediaPlayer variable globally
    MediaPlayer ourSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //as we already declared ourSong variable globally so we are using create method of MediaPlayer
        //passing some parameters in create method of MediaPlayer
        //activity_2.this means we are playing song on activity_2 layout
        //R.raw.sigma means we are fetching sigma.mp3 song from raw folder of res
        ourSong=MediaPlayer.create(activity_2.this, R.raw.sigma);
        ourSong.start();

        Thread timer = new Thread(){
            public void run(){
                try {
                    //playing song for 15sec
                    sleep(15000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent OpenMainActivity=new Intent("com.example.android_tut_5.MainActivity");
                    startActivity(OpenMainActivity);
                }
            }
        };
        timer.start();


    }

    @Override
    protected void onPause() {
        super.onPause();

        //release method will kill the song when activity_2 finishes
        ourSong.release();
        finish();

    }
}
