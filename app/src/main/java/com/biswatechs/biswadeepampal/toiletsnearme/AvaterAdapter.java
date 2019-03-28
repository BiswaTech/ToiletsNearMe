package com.biswatechs.biswadeepampal.toiletsnearme;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AvaterAdapter extends ArrayAdapter<AvaterSpinnerViewHolder>
{
    public AvaterAdapter(Context context, ArrayList<AvaterSpinnerViewHolder> avaterList) {
        super(context, 0, avaterList);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }
    private View initView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.custom_spinner, parent, false
            );
        }
        ImageView imageViewAvater = convertView.findViewById(R.id.avaterImage);
        TextView textViewName = convertView.findViewById(R.id.avater_name);

        AvaterSpinnerViewHolder currentItem = getItem(position);
        if (currentItem != null) {
            imageViewAvater.setImageResource(currentItem.getmAvater());
            textViewName.setText(currentItem.getmName());
        }

        return convertView;
    }

}
