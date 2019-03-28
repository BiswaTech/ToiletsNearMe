package com.biswatechs.biswadeepampal.toiletsnearme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SplashOneFragment fragment2 = new SplashOneFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction2.setCustomAnimations(R.anim.anim_slide_in_left,R.anim.anim_slide_out_left,R.anim.anim_slide_in_right,R.anim.anim_slide_out_left);
        fragmentTransaction2.replace(R.id.container_splash,fragment2);
        fragmentTransaction2.commit();
    }
}
