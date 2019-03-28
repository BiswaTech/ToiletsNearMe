package com.biswatechs.biswadeepampal.toiletsnearme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class MenuAdapter extends ArrayAdapter<String>
{

    Context c ;
    int[] images;
    String[] menuTitles;
    String[] menuDetails;
    public MenuAdapter(Context context, String[] menuTitles, String menuDetails[], int images[]) {
        super(context, R.layout.single_menu_item_picture,R.id.textView2,menuTitles);
        this.c = context;
        this.images = images;
        this.menuTitles = menuTitles;
        this.menuDetails = menuDetails;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.single_menu_item_picture,parent,false);

        ImageView myImage = (ImageView) row.findViewById(R.id.imageView3);
        TextView title = (TextView) row.findViewById(R.id.textView2);
        TextView details = (TextView) row.findViewById(R.id.textView3);

        myImage.setImageResource(images[position]);
        title.setText(menuTitles[position]);
        details.setText(menuDetails[position]);

        return row;
    }
}