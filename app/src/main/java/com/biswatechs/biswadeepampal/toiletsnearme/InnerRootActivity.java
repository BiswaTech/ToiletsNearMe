package com.biswatechs.biswadeepampal.toiletsnearme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class InnerRootActivity extends AppCompatActivity {

    public int index = MainRoot.indexOfSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root_inner);

        Log.i("Inner root index : ", index+"");
        switch (index)
        {
            case 0:
                ShowListingFragment showListingFragment = new ShowListingFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left,R.anim.enter_from_left,R.anim.exit_to_right);
                fragmentTransaction.replace(R.id.container,showListingFragment,"Show Listing");
                fragmentTransaction.commit();
                break;
            case 5:
                CreateListingFragment createListingFragment = new CreateListingFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left,R.anim.enter_from_left,R.anim.exit_to_right);
                fragmentTransaction1.replace(R.id.container,createListingFragment,"Create Listing");
                fragmentTransaction1.commit();
                break;
        }


    }
}
