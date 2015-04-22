package com.ziliang.HelloMoon;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

/**
 * an abstract activity template
 * Created by Kurt on 2/9/2015.
 */
public abstract class SingleFragmentActivity extends Activity {
    protected abstract Fragment createFragment();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager fm=getFragmentManager();
        Fragment fragment=fm.findFragmentById(R.id.fragmentContainer);
        if(fragment==null){
            fragment=createFragment();
            fm.beginTransaction().add(R.id.fragmentContainer,fragment).commit();
        }
    }
}
