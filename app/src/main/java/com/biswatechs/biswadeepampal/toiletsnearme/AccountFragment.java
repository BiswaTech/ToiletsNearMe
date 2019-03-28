package com.biswatechs.biswadeepampal.toiletsnearme;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;


public class AccountFragment extends Fragment {

    ListView listView;
    SharedPreferences sp;
    SharedPreferences.Editor Ed;
    AlertDialog.Builder builder;
    public AccountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = getActivity().findViewById(R.id.list_view_account);
        Resources res = getResources();
        String items[] = res.getStringArray(R.array.account_items);

        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        builder = new AlertDialog.Builder(getContext());
        sp= getActivity().getSharedPreferences("Login", MODE_PRIVATE);
        Ed = sp.edit();

        SingleItemList adapter = new SingleItemList(getActivity(), items);
        listView.setAdapter(adapter);



       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               switch (i)
               {
                   case 0:
                       break;
                   case 1:
                       break;
                   case 2:
                       break;
                   case 3:
                       break;
                   case 4:
                       break;
                   case 5:
                       builder.setTitle("Logging Out");
                       builder.setMessage("Are you sure you want to log out ?");
                       builder.setPositiveButton("Log Out", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               Ed.putString("Unm",null );
                               Ed.putString("Psw",null);
                               Ed.commit();
                               Toast.makeText(getContext(),"Logged out Successfully !",Toast.LENGTH_SHORT).show();
                               Intent i = new Intent(getContext(), LoginActivity.class);
                               startActivity(i);
                               getActivity().finish();
                           }
                       });
                       AlertDialog alertDialog = builder.create();
                       alertDialog.show();
                       break;
                   default:
                       break;

               }
           }
       });
    }
}
