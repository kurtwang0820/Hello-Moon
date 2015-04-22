package com.ziliang.HelloMoon;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Kurt on 2/13/2015.
 */
public class HelloMoonFragment extends Fragment{
    private Button mPlayButton;
    private Button mStopButton;
    private Button mPauseButton;
    private Button mVideoButton;
    private AudioPlayer mPlayer=new AudioPlayer();
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_hello_moon,container,false);
        mPlayButton=(Button)v.findViewById(R.id.hellomoon_playButton);
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.play(getActivity());
            }
        });
        mPauseButton=(Button)v.findViewById(R.id.hellomoon_pauseButton);
        mPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.pause();
            }
        });
        mStopButton=(Button)v.findViewById(R.id.hellomoon_stopButton);
        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.stop();
            }
        });
        mVideoButton=(Button)v.findViewById(R.id.hellomoon_videoButton);
        mVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mPlayer.stop(); // audio may be playing when user presses the video button.
                Intent i = new Intent(getActivity(), VideoActivity.class);
                startActivity(i);
            }
        });
        return v;
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        mPlayer.stop();
    }
}
