package com.olatunji.nairobijavadev;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DevListAdapter extends RecyclerView.Adapter<DevListAdapter.ViewHolder> {

    private List<Developers> developersList;
    private Context context;

    public DevListAdapter(List<Developers> developersList, Context context){
        this.developersList = developersList;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        public TextView usernameTextview;

        public ViewHolder(View itemView){
            super(itemView);
            usernameTextview = itemView.findViewById(R.id.username);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        Developers developer = developersList.get(position);
        final String username = developer.getUsername();
        final String github = "github/url";
        holder.usernameTextview.setText(username);

        holder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("USERNAME", username);
                intent.putExtra("GITHUB", github);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount(){
        return developersList.size();
    }
}
