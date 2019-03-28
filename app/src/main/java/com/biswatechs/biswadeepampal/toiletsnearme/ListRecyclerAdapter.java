package com.biswatechs.biswadeepampal.toiletsnearme;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListRecyclerAdapter extends RecyclerView.Adapter<ListRecyclerAdapter.ListMenuHolder> {

    private Context context;

    private List<String> titles;
    private List<String> details;
    private int[] images;
    Fragment currentFragment;

    public ListRecyclerAdapter(List<String> title, List<String> details, int images[], Context context, Fragment currentFragment)
    {
        this.titles=title;
        this.details = details;
        this.images = images;
        this.context = context;
        this.currentFragment = currentFragment;
    }

    @NonNull
    @Override
    public ListMenuHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.menu_recycler_layout,viewGroup,false);
        ListMenuHolder listMenuHolder =  new ListMenuHolder(view,context, images,titles,details,currentFragment);

        return listMenuHolder;
    }

//    public void onBindViewHolder(ImageViewHolder viewHolder, int i) {
//        int imageid= images[i];
//        viewHolder.albumImage.setImageResource(imageid);
//        viewHolder.albumTitle.setText(list.get(i));
//    }

    @Override
    public void onBindViewHolder(@NonNull ListMenuHolder listMenuHolder, int i) {
        int imageid = images[i];
        listMenuHolder.icon.setImageResource(imageid);
        listMenuHolder.title.setText(titles.get(i));
        listMenuHolder.definition.setText(details.get(i));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public static class ListMenuHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView icon;
        TextView title, definition;
        Context context;
        int images[];
        Fragment currentFragment;
        List<String> names, def;

        public ListMenuHolder(@NonNull View itemView, Context context, int[] images, List<String> names, List<String> def, Fragment currentFragment) {
            super(itemView);
            icon = itemView.findViewById(R.id.menu_icon);
            title = itemView.findViewById(R.id.title_text_menu);
            definition = itemView.findViewById(R.id.def_text_menu);
            this.context= context;
            this.names = names;
            this.def = def;
            this.images = images;
            this.currentFragment = currentFragment;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(context, InnerActivity.class);
            if(currentFragment instanceof UserFragment)
            {
                intent.putExtra("fragmentName","user");
                intent.putExtra("selection",getAdapterPosition());
            }
            else {
                intent.putExtra("fragmentName","provider");
                intent.putExtra("selection",getAdapterPosition());
            }
            context.startActivity(intent);

        }
    }
}
