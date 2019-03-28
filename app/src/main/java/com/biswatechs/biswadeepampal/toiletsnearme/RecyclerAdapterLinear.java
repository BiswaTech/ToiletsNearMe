package com.biswatechs.biswadeepampal.toiletsnearme;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapterLinear extends RecyclerView.Adapter<RecyclerAdapterLinear.ImageViewHolder>
{

    private List<String> names,times,phones, emails;

    public RecyclerAdapterLinear(List <String> names,List <String> times,List <String> phones,List <String> emails)
    {
        this.names = names;
        this.times = times;
        this.phones = phones;
        this.emails = emails;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.text_view_layout,viewGroup,false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);

        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder viewHolder, int i) {
        viewHolder.name.setText(names.get(i));
        viewHolder.time.setText(times.get(i)+" Hours");
        viewHolder.phone.setText(phones.get(i));
        viewHolder.email.setText(emails.get(i));
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

//    public static class MyViewHolder extends RecyclerView.ViewHolder
//    {
//
//        TextView textView;
//        public MyViewHolder(@NonNull TextView itemView) {
//            super(itemView);
//            textView = itemView;
//        }
//    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder
    {
        TextView name, phone, email, time;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_of_user);
            phone = itemView.findViewById(R.id.textViewPhone);
            time = itemView.findViewById(R.id.textViewTime);
            email = itemView.findViewById(R.id.textViewEmail);

        }
    }
}
