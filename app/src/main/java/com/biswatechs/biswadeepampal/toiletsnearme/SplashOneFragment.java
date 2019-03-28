package com.biswatechs.biswadeepampal.toiletsnearme;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class SplashOneFragment extends Fragment {


    Button btn;


    public SplashOneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash_one, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btn = getActivity().findViewById(R.id.btnStarted);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentLogin fragment2 = new FragmentLogin();
                android.support.v4.app.FragmentTransaction fragmentTransaction2 = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction2.setCustomAnimations(R.anim.anim_slide_in_left,R.anim.anim_slide_out_left,R.anim.anim_slide_in_right,R.anim.anim_slide_out_right);
                fragmentTransaction2.replace(R.id.container_splash,fragment2);
                fragmentTransaction2.addToBackStack(null);
                fragmentTransaction2.commit();
            }
        });

    }
}
