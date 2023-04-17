package com.example.infs3634.timeline;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3634.R;

import java.util.ArrayList;

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.MyViewHolder> {
    private ArrayList<TimelineModel> timelineArrayList;

    public TimelineAdapter(ArrayList<TimelineModel> timelineArrayList){
        this.timelineArrayList = timelineArrayList;
    }

    @NonNull
    @Override
    public TimelineAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.timeline_row_version_two, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimelineAdapter.MyViewHolder holder, int position) {
        int itemPosition = position;
        final TimelineModel TimelineModel = timelineArrayList.get(position);
        holder.eventDate.setText(TimelineModel.getEventDate());
        holder.content.setText(TimelineModel.getContent());
    }

    @Override
    public int getItemCount() {
        return timelineArrayList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView eventDate;
        public TextView content;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            eventDate = itemView.findViewById(R.id.eventDate);
            content = itemView.findViewById(R.id.content);
        }
    }
}