package com.ziliang.HelloMoon;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by Kurt on 2/13/2015.
 */
public class HelloMoonVideoFragment extends Fragment {
    private VideoView video;
    private Button mPlayButton;
    private Button mStopButton;
    private Button mPauseButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_hello_moon_video,container,false);
        MediaController mediaController=new MediaController(getActivity());
        video=(VideoView)v.findViewById(R.id.hellomoon_videoview);
       mediaController.setMediaPlayer(video);
        Uri videoUri=Uri.parse("android.resource://com.ziliang.HelloMoon/raw/apollo_17_stroll");
        video.setVideoURI(videoUri);
        video.setMediaController(mediaController);
        mPlayButton=(Button)v.findViewById(R.id.hellomoon_playButton);
        mPlayButton.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                playVideo();
            }
        });
        mStopButton=(Button)v.findViewById(R.id.hellomoon_stopButton);
        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopVideo();
            }
        });
        mPauseButton=(Button)v.findViewById(R.id.hellomoon_pauseButton);
        mPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseVideo();
            }
        });
        return v;
    }
    private void playVideo(){
        if(video==null){
            return;
        }
        video.start();
    }
    private void pauseVideo(){
        if(video==null||!video.canPause()){
            return;
        }
        video.pause();
    }
    private void stopVideo(){
        video.seekTo(0);
        video.pause();
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        stopVideo();
    }
}
