package com.biswatechs.biswadeepampal.toiletsnearme;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    int[] imagesForRecyclerView={R.drawable.rec_1,R.drawable.rec_2,R.drawable.rec_3,R.drawable.rec_4,R.drawable.rec_5,R.drawable.rec_6,R.drawable.rec_7,R.drawable.rec_8,R.drawable.rec_9,R.drawable.rec_10};
    ViewFlipper viewFlipper;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<String> list;
    RecyclerAdapter adapter;


    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView = getActivity().findViewById(R.id.recyclerview);
        viewFlipper = getActivity().findViewById(R.id.viewflipper);
        viewFlipper.setInAnimation(getContext(),R.anim.anim_slide_in_right_flipper);
        viewFlipper.setOutAnimation(getContext(),R.anim.anim_slide_out_left_flipper);

        list = Arrays.asList(getResources().getStringArray(R.array.recycler_items));
        adapter = new RecyclerAdapter(imagesForRecyclerView,list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);



        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(4500);
        viewFlipper.startFlipping();

    }

    /**
     * Init the fragment
     */


}
