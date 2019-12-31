package com.example.abc.girishsharma;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abc.girishsharma.Modal.Datum2;

import java.util.List;

public class RecyclerAC extends RecyclerView.Adapter<RecyclerAC.MyViewHolder> {

    List<Datum2> data;
    private LayoutInflater inflater;
    private Context context;

    public RecyclerAC(Context ctx, List<Datum2> data) {
        this.context = ctx;
        this.data = data;
    }


    @NonNull
    @Override
    public RecyclerAC.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate( R.layout.comments, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAC.MyViewHolder holder, int i) {

        holder.comments.setText(data.get(i).getComplaintCommentText());
        holder.commentby.setText(data.get(i).getAppusername());
        holder.commentdate.setText(data.get(i).getComplaintCommentDate());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView comments;
        TextView commentdate;
        TextView commentby;


        public MyViewHolder(View view) {
            super( view );

            commentby = itemView.findViewById( R.id.commentby );
            comments = itemView.findViewById( R.id.user );
            commentdate = itemView.findViewById( R.id.date );
        }
    }
}