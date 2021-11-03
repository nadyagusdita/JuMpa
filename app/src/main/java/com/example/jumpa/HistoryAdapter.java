package com.example.jumpa;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    private ArrayList<History> listHistory;

    public HistoryAdapter(ArrayList<History> listHistory) {
        this.listHistory = listHistory;
    }

    @NonNull
    @Override
    public HistoryAdapter.HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_history, parent, false);

        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.HistoryViewHolder holder, int position) {
        holder.tvTanggaltrk.setText(listHistory.get(position).getTanggaltrk());
        holder.tvStatus.setText(listHistory.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return (listHistory!=null) ? listHistory.size() : 0;
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder{
        private TextView tvTanggaltrk, tvStatus;
        public HistoryViewHolder(View view){
            super(view);

            tvTanggaltrk = view.findViewById(R.id.tv_tanggaltrk);
            tvStatus = view.findViewById(R.id.tv_status);
        }
    }
}
