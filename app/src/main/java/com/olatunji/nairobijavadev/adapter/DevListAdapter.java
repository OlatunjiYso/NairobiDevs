package com.olatunji.nairobijavadev.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.olatunji.nairobijavadev.R;
import com.olatunji.nairobijavadev.model.Developers;
import com.olatunji.nairobijavadev.view.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Olatunji on 09/11/2018.
 */

public class DevListAdapter extends RecyclerView.Adapter<DevListAdapter.ViewHolder> {

    private final List<Developers> developersList;
    private final Context context;

    public DevListAdapter(List<Developers> developersList, Context context) {
        this.developersList = developersList;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        public TextView usernameTextview;
        public ImageView displayPictureImageview;

        public ViewHolder(View itemView) {
            super(itemView);
            usernameTextview = itemView.findViewById(R.id.list_username);
            displayPictureImageview = itemView.findViewById(R.id.list_profile_image);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Developers developer = developersList.get(position);
        final String username = developer.getUsername();
        final String github = developer.getGithub();
        final String imageUrl = developer.getImageUrl();

        holder.usernameTextview.setText(username);
        Picasso.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.dev)
                .into(holder.displayPictureImageview);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("USERNAME", username);
                intent.putExtra("GITHUB", github);
                intent.putExtra("IMAGE_URL", imageUrl);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return developersList.size();
    }
}
