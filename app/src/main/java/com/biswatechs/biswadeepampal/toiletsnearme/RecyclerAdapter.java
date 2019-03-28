package com.biswatechs.biswadeepampal.toiletsnearme;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ImageViewHolder>
{

    private List<String> list;
    private int[] images;

    public RecyclerAdapter(int images[], List <String> list)
    {
        this.images = images;
        this.list = list;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album_layout,viewGroup,false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);

        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder viewHolder, int i) {
        int imageid= images[i];
        viewHolder.albumImage.setImageResource(imageid);
        viewHolder.albumTitle.setText(list.get(i));
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView textView;
        public MyViewHolder(@NonNull TextView itemView) {
            super(itemView);
            textView = itemView;
        }
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder
    {
        ImageView albumImage;
        TextView albumTitle;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            albumImage = itemView.findViewById(R.id.image_album);
            albumTitle = itemView.findViewById(R.id.title_album);

        }
    }
}
