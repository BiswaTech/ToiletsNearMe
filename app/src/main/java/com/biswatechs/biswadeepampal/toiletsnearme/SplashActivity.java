package com.biswatechs.biswadeepampal.toiletsnearme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    static int isLoggedIn;

    SharedPreferences sp1;
    String unm, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        try
        {
            sp1 = this.getSharedPreferences("Login", MODE_PRIVATE);
            unm = sp1.getString("Unm", null);
            pass = sp1.getString("Psw", null);
        }catch(NullPointerException e)
        {
            unm=null;
            pass=null;
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(unm==null || pass == null) {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                }
                else
                {
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                }
                SplashActivity.this.finish();
            }
        },3000);
    }
}
