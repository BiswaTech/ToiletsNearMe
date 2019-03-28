package com.biswatechs.biswadeepampal.toiletsnearme;


import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowListingFragment extends Fragment {
    ListView listView ;
    String[] menuTitles;
    String[] menuDetails1;
    String[] menuDetails2;
    String[] menuDetails3;
    MenuAdapterNoPicture adapter;
    ArrayList<String> listitems;
    String[] menuDetails4;
    EditText etSearch;
    ListRecyclerAdapter listRecyclerAdapter;
    RecyclerView.LayoutManager layoutManager;


    public ShowListingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_listing, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateListingFragment createListingFragment = new CreateListingFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction1 = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.setCustomAnimations(R.animator.slide_in_up,R.animator.slide_out_up,R.animator.slide_in_down,R.animator.slide_out_down);
                fragmentTransaction1.replace(R.id.inner_container,createListingFragment);
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });

        Resources res = getResources();
        menuTitles = res.getStringArray(R.array.name_listing);
        menuDetails1 = res.getStringArray(R.array.gender_listing);
        menuDetails2 = res.getStringArray(R.array.number_listing);
        menuDetails3 = res.getStringArray(R.array.from_listing);
        menuDetails4 = res.getStringArray(R.array.to_listing);
        etSearch = getActivity().findViewById(R.id.search_bar);

        listitems = new ArrayList<>(Arrays.asList(menuTitles));

        for(int i = 0; i < menuDetails3.length;i++)
        {
            menuDetails3[i] = menuDetails3[i] +" to " +menuDetails4[i];
        }
        listView = getActivity().findViewById(R.id.listview);


        adapter = new MenuAdapterNoPicture(getActivity(), listitems,menuDetails1,menuDetails2,menuDetails3);
        listView.setAdapter(adapter);

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.equals(""))
                {
                    listView.setAdapter(adapter);
                }
                else
                {
                    searchItem(charSequence.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
    public void searchItem(String search)
    {
        for(String item:menuTitles)
        {
            if(!item.contains(search))
            {
                listitems.remove(item);
            }
        }
        adapter.notifyDataSetChanged();

    }
}
