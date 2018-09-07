package com.olatunji.nairobijavadev;

import android.content.Context;
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
        public TextView username;

        public ViewHolder(View itemView){
            super(itemView);
            username = itemView.findViewById(R.id.username);
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
        holder.username.setText(developer.getUsername());
    }

    @Override
    public int getItemCount(){
        return developersList.size();
    }
}
