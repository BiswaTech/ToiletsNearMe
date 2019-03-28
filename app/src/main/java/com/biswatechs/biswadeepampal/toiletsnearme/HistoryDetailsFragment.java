package com.biswatechs.biswadeepampal.toiletsnearme;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class HistoryDetailsFragment extends Fragment {


    private String title;
    TextView textView;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapterLinear adapter;

    String[] names= {"Ram Singh","Shyam Singh","Tarak Mehta","Shah Rukh Khan","Salman Khan","Amir Khan"};
    String[] times = {"9:47","12:34","15:44","10:19","1:00","14:22"};
    String[] emails = {"accd@xyz.com","abb@gmail.com","hh@yahoo.co.in","iamsrk@gmail.com","salman@gmail.com","amir@yahoo.co.in"};
    String[] phones = {"9988776655","9977664433","9922110044","8877663322","8989282837","9090212199"};

    List<String> name, time, email, phone;

    public HistoryDetailsFragment(String title) {
        // Required empty public constructor
        this.title = title;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history_details, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView = getActivity().findViewById(R.id.recyclerViewHistory);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        textView = getActivity().findViewById(R.id.textView18);

        textView.setText(title);

        name = Arrays.asList(names);
        time = Arrays.asList(times);
        email = Arrays.asList(emails);
        phone = Arrays.asList(phones);

        recyclerView.setHasFixedSize(true);

        adapter = new RecyclerAdapterLinear(name, time,email, phone);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}
