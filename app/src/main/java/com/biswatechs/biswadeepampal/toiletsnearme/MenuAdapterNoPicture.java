package com.biswatechs.biswadeepampal.toiletsnearme;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

class MenuAdapterNoPicture extends ArrayAdapter<String>
{

    Context c ;
    ArrayList<String> name;
    String[] detail1;
    String[] detail2;
    String[] detail3;
    public MenuAdapterNoPicture(Context context, ArrayList<String> name, String detail1[], String detail2[], String detail3[]) {
        super(context, R.layout.single_menu_item,R.id.textView2,name);
        this.c = context;
        this.name = name;
        this.detail1 = detail1;
        this.detail2 = detail2;
        this.detail3 = detail3;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.single_menu_item,parent,false);

        TextView title = (TextView) row.findViewById(R.id.textView2);
        TextView details1 = (TextView) row.findViewById(R.id.textView3);
        TextView details2 = (TextView) row.findViewById(R.id.textView4);
        TextView details3 = (TextView) row.findViewById(R.id.textView5);

        title.setText(name.get(position));
        details1.setText(getContext().getResources().getString(R.string.gender_specification)+detail1[position]);
        details2.setText(getContext().getResources().getString(R.string.contact_number)+detail2[position]);
        details3.setText(getContext().getResources().getString(R.string.available_time)+detail3[position]+" hours");

        return row;
    }
}