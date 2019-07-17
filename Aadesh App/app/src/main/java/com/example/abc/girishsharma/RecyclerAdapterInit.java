package com.example.abc.girishsharma;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.abc.girishsharma.Modal.Dataimg;
import com.example.abc.girishsharma.Modal.Datum1;

import java.util.ArrayList;
import java.util.List;


public class RecyclerAdapterInit extends RecyclerView.Adapter<RecyclerAdapterInit.MyViewHolder> {
    List<Datum1> data;
    private LayoutInflater inflater;

    private Context context;

    public RecyclerAdapterInit(Context ctx, List<Datum1> data) {

        this.context = ctx;
        this.data = data;
    }

    @Override
    public RecyclerAdapterInit.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.initiative_list, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapterInit.MyViewHolder holder, int position) {
        holder.ename.setText(data.get(position).getIntiativeTitle());

        List<String> tokens = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            tokens.add("http://iamapp.incubatorsdwnmt.com/docs/clientminitiative/" + data.get(i).getInitiativeMediaPath());
        }
        Glide.with(context).load(tokens.get(position)).into(holder.img1);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView ename;
        ImageView img1;

        public MyViewHolder(View itemView) {
            super(itemView);

            ename = itemView.findViewById(R.id.texttitle);
            img1 = itemView.findViewById(R.id.images);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getLayoutPosition();
                    for (int i = 0; i < data.size(); i++) {
                        if (position == i) {
                            Bundle bundle = new Bundle();
                            bundle.putInt("position", i);
                            Fragment event_images = new Event_Images();
                            event_images.setArguments(bundle);
                            ((HomeActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, event_images).commit();
                        }
                    }
                }
            });
            itemView.setFocusableInTouchMode(true);
            itemView.requestFocus();
            itemView.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        ((HomeActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new GalleryFragment()).addToBackStack("tag").commit();
                        return false;
                    }
                    return false;
                }
            });
        }

    }
}
