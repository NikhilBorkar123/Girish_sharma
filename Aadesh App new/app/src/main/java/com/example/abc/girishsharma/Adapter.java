package com.example.abc.girishsharma;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abc.girishsharma.Modal.ApiModel;
import com.example.abc.girishsharma.Modal.Dataimg;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    List<Dataimg> imgData;
    ImageView Map;
    private LayoutInflater inflater;
//    private List<ApiModel> eventList;
    private Context context;

    public Adapter(Context ctx, List<Dataimg> imgData){

        this.context = ctx;
        this.imgData = imgData;
    }

    @Override
    public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Adapter.MyViewHolder holder, int position) {
        holder.ename.setText(imgData.get(position).getClientMediaTitle());
        holder.date.setText(imgData.get(position).getUploadedDate());
//        holder.time.setText(imgData.get(position).getPhone());
//        holder.location.setText(imgData.get(position).getCity());

    }

    @Override
    public int getItemCount() {
        return imgData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView ename,date,time,location;
        ImageView Map;

        public MyViewHolder(View itemView) {
            super(itemView);
            Map = itemView.findViewById(R.id.map);
            ename = itemView.findViewById(R.id.ename);
            date = itemView.findViewById(R.id.date);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getLayoutPosition();
                    for(int i=0;i<imgData.size();i++){
                        if(position==i){
                            Bundle bundle=new Bundle();
                            bundle.putInt("position",i);
                            Fragment samuhik =new SamuhikVivah();
                            samuhik.setArguments(bundle);
                            ((HomeActivity)context).getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,samuhik).commit();
                        }
                    }
                }
            });

            Map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,MapsActivity.class);
                    context.startActivity(intent);
                }
            });



//            time = itemView.findViewById(R.id.time);
//            location = itemView.findViewById(R.id.location);
        }

    }
}
