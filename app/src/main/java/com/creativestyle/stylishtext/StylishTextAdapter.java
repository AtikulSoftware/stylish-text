package com.creativestyle.stylishtext;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StylishTextAdapter extends RecyclerView.Adapter<StylishTextAdapter.StylishTextViewHolder> {

    private List<String> stylishTexts;

    public StylishTextAdapter(List<String> stylishTexts) {
        this.stylishTexts = stylishTexts;
    }

    public void updateStylishTexts(List<String> newStylishTexts) {
        stylishTexts.clear();
        stylishTexts.addAll(newStylishTexts);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StylishTextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new StylishTextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StylishTextViewHolder holder, int position) {
        holder.textView.setText(stylishTexts.get(position));
    }

    @Override
    public int getItemCount() {
        return stylishTexts.size();
    }

    static class StylishTextViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public StylishTextViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }
    }
}
