package com.biswatechs.biswadeepampal.toiletsnearme;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.widget.Toolbar;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

public class HomeActivity extends AppCompatActivity {


    private AHBottomNavigation bottomNavigation;

    AlertDialog.Builder builder;

//    ActionBar actionBar;


    AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.title_home,R.drawable.ic_home_black_24dp,R.color.tab1_color);
    AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.title_provider,R.drawable.service,R.color.tab2_color);
    AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.title_user,R.drawable.round_profile,R.color.tab3_color);
    AHBottomNavigationItem item4 = new AHBottomNavigationItem(R.string.account,R.drawable.ic_face_white_24dp,R.color.tab4_color);


    SharedPreferences sp1;
    static String unm, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean enabledTranslucentNavigation = getSharedPreferences("shared", Context.MODE_PRIVATE)
                .getBoolean("translucentNavigation", false);
        setContentView(R.layout.activity_home);
        builder = new AlertDialog.Builder(this);
        HomeFragment homeFragment = new HomeFragment();
//        actionBar = getSupportActionBar();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container,homeFragment,"Home");
        fragmentTransaction.commit();
        initUI();
//        actionBar.setTitle("Toilets Near Me");
//        actionBar.setSubtitle("Home");
//        ColorDrawable tab1Color = new ColorDrawable(getResources().getColor(R.color.tab1_color));
//        ColorDrawable tab2Color = new ColorDrawable(getResources().getColor(R.color.tab1_color));
//        ColorDrawable tab3Color = new ColorDrawable(getResources().getColor(R.color.tab1_color));
//        ColorDrawable tab4Color = new ColorDrawable(getResources().getColor(R.color.tab1_color));
//        actionBar.setBackgroundDrawable(tab1Color);
//

    }

    private void initUI() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        }

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

        bottomNavigation = findViewById(R.id.bottom_navigation);

        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
        bottomNavigation.addItem(item4);

        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));


        bottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        bottomNavigation.setInactiveColor(Color.parseColor("#F63D2B"));

        bottomNavigation.setForceTint(true);

        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);

        bottomNavigation.setColored(true);

        bottomNavigation.setBehaviorTranslationEnabled(false);

        bottomNavigation.setCurrentItem(0);

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                switch (position)
                {
                    case 0:
                        HomeFragment homeFragment = new HomeFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.setCustomAnimations(R.animator.slide_in_up,R.animator.slide_out_up);
                        fragmentTransaction.replace(R.id.container,homeFragment,"Home");
                        fragmentTransaction.commit();
                        break;
                    case 1:
                        if(unm==null || pass == null)
                        {
                            builder.setTitle("Login or SignUp");
                            builder.setMessage("Please Login or SignUp to continue to using our services");
                            builder.setPositiveButton("Login/SignUp", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });
                            AlertDialog alertDialog = builder.create();
                            alertDialog.setCancelable(false);
                            alertDialog.show();
                        }
                        else {
                            ProviderFragment providerFragment = new ProviderFragment();
                            android.support.v4.app.FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                            fragmentTransaction1.setCustomAnimations(R.animator.slide_in_up, R.animator.slide_out_up);
                            fragmentTransaction1.replace(R.id.container, providerFragment, "provider");
                            fragmentTransaction1.commit();
                        }
                        break;
                    case 2:
                        if(unm==null || pass == null)
                        {
                            builder.setTitle("Login or SignUp");
                            builder.setMessage("Please Login or SignUp to continue to using our services");
                            builder.setPositiveButton("Login/SignUp", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });
                            AlertDialog alertDialog = builder.create();
                            alertDialog.setCancelable(false);
                            alertDialog.show();
                        }
                        else {
                            UserFragment userFragment = new UserFragment();
                            android.support.v4.app.FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                            fragmentTransaction2.setCustomAnimations(R.animator.slide_in_up, R.animator.slide_out_up);
                            fragmentTransaction2.replace(R.id.container, userFragment, "user");
                            fragmentTransaction2.commit();
                        }
                        break;
                    case 3:
                        if(unm==null || pass == null)
                        {
                            builder.setTitle("Login or SignUp");
                            builder.setMessage("Please Login or SignUp to continue to using our services");
                            builder.setPositiveButton("Login/SignUp", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });
                            AlertDialog alertDialog = builder.create();
                            alertDialog.setCancelable(false);
                            alertDialog.show();
                        }
                        else {
                            AccountFragment accountFragment = new AccountFragment();
                            android.support.v4.app.FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                            fragmentTransaction3.setCustomAnimations(R.animator.slide_in_up, R.animator.slide_out_up);
                            fragmentTransaction3.replace(R.id.container, accountFragment, "account");
                            fragmentTransaction3.commit();
                        }
                        break;
                }

                return true;
            }
        });

    }

}
