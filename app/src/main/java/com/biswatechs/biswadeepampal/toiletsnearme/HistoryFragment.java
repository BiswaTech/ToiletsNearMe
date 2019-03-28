package com.biswatechs.biswadeepampal.toiletsnearme;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {


    ListView listView ;
    TextView textView;
    String[] menuTitles;
    String[] menuDetails1;
    String[] menuDetails2;
    String[] menuDetails3;
    String[] menuDetails4;
    ArrayList<String> listitems;

    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_listing, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Resources res = getResources();
        menuTitles = res.getStringArray(R.array.name_listing);
        menuDetails1 = res.getStringArray(R.array.gender_listing);
        menuDetails2 = res.getStringArray(R.array.number_listing);
        menuDetails3 = res.getStringArray(R.array.from_listing);
        menuDetails4 = res.getStringArray(R.array.to_listing);

        textView = getActivity().findViewById(R.id.header);

        textView.setText("Select Listing for History");

        listitems = new ArrayList<>(Arrays.asList(menuTitles));

        for(int i = 0; i < menuDetails3.length;i++)
        {
            menuDetails3[i] = menuDetails3[i] +" to " +menuDetails4[i];
        }
        listView = getActivity().findViewById(R.id.listview);


        MenuAdapterNoPicture adapter = new MenuAdapterNoPicture(getActivity(), listitems,menuDetails1,menuDetails2,menuDetails3);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HistoryDetailsFragment historyDetailsFragment = new HistoryDetailsFragment(menuTitles[i]);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.animator.slide_in_down,R.animator.slide_out_up,R.animator.slide_in_up,R.animator.slide_out_down);
                fragmentTransaction.replace(R.id.inner_container,historyDetailsFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }

}
