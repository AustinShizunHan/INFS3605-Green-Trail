package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements Filterable {

    private List<Plant> plants;
    private List<Plant> filteredPlants;
    private Context context;

    public RecyclerViewAdapter(List<Plant> plants, Context context) {
        this.plants = plants;
        this.context = context;
        this.filteredPlants = new ArrayList<>(plants);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plant_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Plant plant = filteredPlants.get(position);
        holder.plantNameTextView.setText(plant.getName());
        holder.plantDetailsTextView.setText(plant.getDetails());
        holder.plantImageView.setImageResource(plant.getImageResourceId());
    }

    @Override
    public int getItemCount() {
        return filteredPlants.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String query = constraint.toString().toLowerCase().trim();

                if (query.isEmpty()) {
                    filteredPlants = new ArrayList<>(plants);
                } else {
                    List<Plant> filteredList = new ArrayList<>();
                    for (Plant plant : plants) {
                        if (plant.getName().toLowerCase().contains(query) || plant.getDescription().toLowerCase().contains(query)) {
                            filteredList.add(plant);
                        }
                    }
                    filteredPlants = filteredList;
                }

                FilterResults results = new FilterResults();
                results.values = filteredPlants;
                return results;
            }
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredPlants = (List<Plant>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public void sortByName(boolean ascending) {
        if (ascending) {
            Collections.sort(filteredPlants, new Comparator<Plant>() {
                @Override
                public int compare(Plant p1, Plant p2) {
                    return p1.getName().compareTo(p2.getName());
                }
            });
        } else {
            Collections.sort(filteredPlants, new Comparator<Plant>() {
                @Override
                public int compare(Plant p1, Plant p2) {
                    return p2.getName().compareTo(p1.getName());
                }
            });
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView plantNameTextView;
        public TextView plantDetailsTextView;
        public ImageView plantImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            plantNameTextView = itemView.findViewById(R.id.plant_name_text_view);
            plantDetailsTextView = itemView.findViewById(R.id.plant_details_text_view);
            plantImageView = itemView.findViewById(R.id.plant_image_view);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Plant plant = filteredPlants.get(position);
            Intent intent = new Intent(context, PlantDetailActivity.class);
            intent.putExtra("name", plant.getName());
            intent.putExtra("description", plant.getDescription());
            context.startActivity(intent);
        }
    }
}
