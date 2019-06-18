package com.example.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.Modal.ApiModel;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private LayoutInflater inflater;
    private List<ApiModel> eventList;
    private Context context;

    public Adapter(Context ctx,List<ApiModel> eventList){

        this.context = ctx;
        this.eventList = eventList;
    }

    @Override
    public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list,parent,false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(Adapter.MyViewHolder holder, int position) {
        holder.ename.setText(eventList.get(position).getFname());
        holder.date.setText(eventList.get(position).getPin());
        holder.time.setText(eventList.get(position).getPhone());
        holder.location.setText(eventList.get(position).getCity());

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView ename,date,time,location;

        public MyViewHolder(View itemView) {
            super(itemView);

            ename = itemView.findViewById(R.id.ename);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
            location = itemView.findViewById(R.id.location);
        }

    }
}
