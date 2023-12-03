package com.example.prac18;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GroupsAdapter extends RecyclerView.Adapter<GroupsAdapter.ViewHolder>{
    private RecyclerInterface recyclerInterface;

    private Context context;
    private ArrayList<Group> list;



    public GroupsAdapter(Context context, ArrayList<Group> list, RecyclerInterface recyclerInterface) {
        this.recyclerInterface = recyclerInterface;
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view, recyclerInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Group groups = list.get(position);
        holder.name.setText(groups.getName());
        holder.author.setText(groups.getAuthor());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView author;
        ViewHolder(View view, RecyclerInterface recyclerInterface){
            super(view);
            name = view.findViewById(R.id.name_txt);
            author = view.findViewById(R.id.m_author);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(GroupsAdapter.this.recyclerInterface !=null){
                        int pos= getAdapterPosition();
                        if (pos !=RecyclerView.NO_POSITION){
                            GroupsAdapter.this.recyclerInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
