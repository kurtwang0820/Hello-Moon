package com.ziliang.HelloMoon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Kurt on 2/13/2015.
 */
public class AudioPlayer {
    private MediaPlayer mediaPlayer;
    private boolean paused=false;
    public void stop(){
        if(mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }
    public void pause(){
        mediaPlayer.pause();
        paused=true;
    }
    public void play(Context c){
        if(paused&&mediaPlayer!=null){
            mediaPlayer.start();
            paused=false;
            return;
        }
        stop();
        mediaPlayer=MediaPlayer.create(c,R.raw.one_small_step);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });
        mediaPlayer.start();
    }
}
