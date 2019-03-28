package com.biswatechs.biswadeepampal.toiletsnearme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FragmentLogin fragment2 = new FragmentLogin();
        android.support.v4.app.FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction2.setCustomAnimations(R.animator.slide_in_up,R.animator.slide_out_up);
        fragmentTransaction2.replace(R.id.container_splash,fragment2);
        fragmentTransaction2.commit();
    }
}
