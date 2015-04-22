package com.ziliang.HelloMoon;

import android.app.Fragment;

/**
 * Created by Kurt on 4/21/2015.
 */
public class VideoActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new HelloMoonVideoFragment();
    }
}
