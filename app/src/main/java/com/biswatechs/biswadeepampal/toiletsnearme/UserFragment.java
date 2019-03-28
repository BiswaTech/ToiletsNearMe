package com.biswatechs.biswadeepampal.toiletsnearme;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {

    private int[] menuIcons = {R.drawable.ic_search_black_24dp, R.drawable.ic_near_me_black_24dp, R.drawable.ic_history_black_24dp,R.drawable.ic_report_black_24dp, R.drawable.ic_face_black_24dp,R.drawable.ic_feedback_black_24dp};
    private List<String> menuTitles;
    private List<String> menuDetails;
    RecyclerView recyclerView;
    Fragment currentFragment;
    ListRecyclerAdapter listRecyclerAdapter;
    RecyclerView.LayoutManager layoutManager;

    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView = getActivity().findViewById(R.id.recyclerview2);
        recyclerView.setHasFixedSize(true);

        Resources res = getResources();
        menuTitles = Arrays.asList(getResources().getStringArray(R.array.client_menu_items));
        menuDetails = Arrays.asList(getResources().getStringArray(R.array.client_menu_item_details));
        currentFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.container);
//listView = (ListView) getActivity().findViewById(R.id.listview2);
        listRecyclerAdapter = new ListRecyclerAdapter(menuTitles,menuDetails,menuIcons,getContext(),currentFragment);

        recyclerView.setAdapter(listRecyclerAdapter);

        recyclerView.setLayoutManager(layoutManager);



    }
}