package com.example.jumpa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HistoryAdapter historyAdapter;
    private ArrayList<History> historyArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        getData();

        recyclerView = findViewById(R.id.recyclerview);
        historyAdapter = new HistoryAdapter(historyArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HistoryActivity.this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(historyAdapter);
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