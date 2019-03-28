package com.biswatechs.biswadeepampal.toiletsnearme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SingleItemList extends ArrayAdapter<String> {

    Context c ;
    String[] name;
    public SingleItemList (Context context, String[] name) {
        super(context, R.layout.single_menu_item,R.id.textView2,name);
        this.c = context;
        this.name = name;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.single_item_list,parent,false);

        TextView title = (TextView) row.findViewById(R.id.textView15);

        title.setText(name[position]);

        return row;
    }
}
