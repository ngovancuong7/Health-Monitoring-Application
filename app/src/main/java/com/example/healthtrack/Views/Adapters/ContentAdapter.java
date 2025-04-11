package com.example.healthtrack.Views.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthtrack.R;

import java.util.List;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.MyViewHolder> {
    private Context context;
    private List<String> listContent;

    public ContentAdapter(Context context, List<String> listContent) {
        this.context = context;
        this.listContent = listContent;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String content = listContent.get(position);
        holder.stepNumber.setText(String.valueOf(position + 1));
        holder.stepContent.setText(content);
    }

    @Override
    public int getItemCount() {
        return listContent.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView stepNumber;
        private TextView stepContent;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            stepNumber = itemView.findViewById(R.id.step_number);
            stepContent = itemView.findViewById(R.id.step_content);
        }
    }
}
