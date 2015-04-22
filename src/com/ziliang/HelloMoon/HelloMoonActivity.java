package com.ziliang.HelloMoon;

import android.app.Fragment;

public class HelloMoonActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new HelloMoonFragment();
    }
}
