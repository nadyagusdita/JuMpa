package com.example.jumpa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HistoryAdapter historyAdapter;
    private ArrayList<History> historyArrayList;
    private HistoryAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        setOnClickListener();
        getData();
        recyclerView = findViewById(R.id.recyclerview);
        historyAdapter = new HistoryAdapter(historyArrayList, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HistoryActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(historyAdapter);
    }

    private void setOnClickListener() {
        listener = new HistoryAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), DetailHistoryActivity.class);
                startActivity(intent);
            }
        };
    }

    public void getData(){
        historyArrayList = new ArrayList<>();
        historyArrayList.add(new History("23 April 2021", "Selesai"));
        historyArrayList.add(new History("5 Mei 2021", "Selesai"));
        historyArrayList.add(new History("31 Juni 2022", "Selesai"));
        historyArrayList.add(new History("13 Juli 2022", "Selesai"));
        historyArrayList.add(new History("13  Agustus 2022", "Selesai"));
        historyArrayList.add(new History("23 September 2021", "Selesai"));
        historyArrayList.add(new History("23 November 2021", "Selesai"));
        historyArrayList.add(new History("23 Desember 2021", "Selesai"));
        historyArrayList.add(new History("30 Desember 2021", "Selesai"));
    }
}