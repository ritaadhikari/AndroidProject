package com.example.firstandroidproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstandroidproject.R;
import com.example.firstandroidproject.database.model.FoodEntity;

import java.util.ArrayList;

public class FoodEntityAdapter extends RecyclerView.Adapter<FoodEntityAdapter.FoodEntityViewHolder> {
    private Context context;
    private ArrayList<FoodEntity> foodEntityArrayList;

    public FoodEntityAdapter(Context context ,ArrayList<FoodEntity> foodEntityArrayList){
        this.context = context;
        this.foodEntityArrayList = foodEntityArrayList;
    }

    @NonNull
    @Override
    public FoodEntityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_food,parent,false);
        return new FoodEntityViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull FoodEntityViewHolder holder, int position) {
        FoodEntity item = foodEntityArrayList.get(position);
        holder.tvName.setText(item.getName());
        holder.tvPrice.setText("Npr."+ item.getPrice());

    }

    @Override
    public int getItemCount() {
        return foodEntityArrayList.size();

    }

    public class FoodEntityViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPrice;
        public FoodEntityViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }

    public void update(ArrayList<FoodEntity> updatedList){
        foodEntityArrayList.clear();
        foodEntityArrayList.addAll(updatedList);
        this.notifyDataSetChanged();
    }
}
