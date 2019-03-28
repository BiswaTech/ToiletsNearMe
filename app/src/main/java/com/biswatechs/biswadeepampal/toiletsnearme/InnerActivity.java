package com.biswatechs.biswadeepampal.toiletsnearme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class InnerActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    TextView tvTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner);

        relativeLayout = findViewById(R.id.inner_container);
        int i;
//        tvTest = findViewById(R.id.test);

//        tvTest.setText("From " + getIntent().getStringExtra("fragmentName")+" Fragment, Selection id "+getIntent().getIntExtra("selection",0));

        if(getIntent().getStringExtra("fragmentName").equals("user"))
        {
            i = getIntent().getIntExtra("selection",12);
            switch (i)
            {

            }

        }
        else
        {
            i = getIntent().getIntExtra("selection",12);
            switch (i)
            {
                case 0:
                    ShowListingFragment showListingFragment = new ShowListingFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.setCustomAnimations(R.animator.slide_in_up,R.animator.slide_out_up);
                    fragmentTransaction.replace(R.id.inner_container,showListingFragment,"Listings");
                    fragmentTransaction.commit();
                    break;

                case 1:
                    EditListingFragment editListingFragment = new EditListingFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.setCustomAnimations(R.animator.slide_in_up,R.animator.slide_out_up);
                    fragmentTransaction2.replace(R.id.inner_container,editListingFragment,"EditListings");
                    fragmentTransaction2.commit();
                    break;

                case 2:
                    HistoryFragment historyFragment = new HistoryFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.setCustomAnimations(R.animator.slide_in_up,R.animator.slide_out_up);
                    fragmentTransaction3.replace(R.id.inner_container,historyFragment,"History");
                    fragmentTransaction3.commit();
                    break;

                case 4:
                    CreateListingFragment createListingFragment = new CreateListingFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.setCustomAnimations(R.animator.slide_in_up,R.animator.slide_out_up);
                    fragmentTransaction1.replace(R.id.inner_container,createListingFragment,"Add Listing");
                    fragmentTransaction1.commit();
                    break;
            }
        }
    }
}
