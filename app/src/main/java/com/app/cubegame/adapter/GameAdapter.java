package com.app.cubegame.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.app.cubegame.R;
import com.app.cubegame.implementer.RecyclerViewItemClickListener;
import com.app.cubegame.model.GameData;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder> {

    private final List<GameData> list;

    public RecyclerViewItemClickListener listener;

    public void setOnRecyclerViewItemClickListener(RecyclerViewItemClickListener recyclerViewItemClickListener) {
        listener = recyclerViewItemClickListener;
    }

    public GameAdapter(List<GameData> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_game, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GameData result = list.get(position);

        holder.mainView.setText(String.valueOf(position + 1));

        if (result.getStrColor() != null) {
            if (result.getStrColor().equals("B")) {
                holder.mainView.setBackgroundColor(ContextCompat.getColor(holder.mainView.getContext(), R.color.blue));
            } else if (result.getStrColor().equals("R")) {
                holder.mainView.setBackgroundColor(ContextCompat.getColor(holder.mainView.getContext(), R.color.red));
            } else {
                holder.mainView.setBackgroundColor(ContextCompat.getColor(holder.mainView.getContext(), R.color.white));
            }
        } else {
            holder.mainView.setBackgroundColor(ContextCompat.getColor(holder.mainView.getContext(), R.color.white));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public MaterialTextView mainView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mainView = itemView.findViewById(R.id.mainView);
            mainView.setOnClickListener(view -> {
                if (listener != null) {
                    listener.onItemClick(getAdapterPosition(), 10, itemView);
                }
            });
        }
    }
}
