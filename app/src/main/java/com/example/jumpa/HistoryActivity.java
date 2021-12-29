package com.example.jumpa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.jumpa.adapter.HistoryAdapter;
import com.example.jumpa.model.DataItem;
import com.example.jumpa.model.History;
import com.example.jumpa.model.TransactionClass;
import com.example.jumpa.model.TransaksiResponse;
import com.example.jumpa.retrofit.ApiClient;
import com.example.jumpa.retrofit.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HistoryAdapter historyAdapter;
    private ArrayList<History> historyArrayList;
    private HistoryAdapter.RecyclerViewClickListener listener;
    private List<DataItem> listTransaksi;
    private History history;
    private TransaksiResponse transaksiResponse;

    ApiInterface apiInterface;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        sessionManager = new SessionManager(HistoryActivity.this);
        Integer user_id = sessionManager.getId();

        ImageButton back = findViewById(R.id.arrow_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        getData(user_id);
        setOnClickListener();
    }

    private void setOnClickListener() {
        listener = new HistoryAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                String status = historyArrayList.get(position).getStatus();
                if(status.equals("Selesai")){
                    Intent intent = new Intent(getApplicationContext(), DetailHistoryActivity.class);
                    intent.putExtra("id", listTransaksi.get(position).getId());
                    intent.putExtra("tanggal", listTransaksi.get(position).getTanggal());
                    intent.putExtra("waktu", listTransaksi.get(position).getWaktu());
                    intent.putExtra("noponsel", listTransaksi.get(position).getNoPonsel());
                    intent.putExtra("katgorisampah", listTransaksi.get(position).getKategoriSampah());
                    intent.putExtra("berattotal", listTransaksi.get(position).getBeratTotal().toString());
                    intent.putExtra("totalharga", listTransaksi.get(position).getTotalHarga().toString());
                    startActivity(intent);
                } else if (status.equals("Menunggu")){
                    Intent intent = new Intent(getApplicationContext(), SelesaikanTransaksiActivity.class);
                    startActivity(intent);
                }
            }
        };
    }

    public void getData(Integer user_id){
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<TransaksiResponse> transaksiResponseCall = apiInterface.getTransaksi(user_id);
        transaksiResponseCall.enqueue(new Callback<TransaksiResponse>() {
            @Override
            public void onResponse(Call<TransaksiResponse> call, Response<TransaksiResponse> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isError() != true) {
                    transaksiResponse = response.body();
                    listTransaksi = transaksiResponse.getData();
                    historyArrayList = new ArrayList<>();
                    for (DataItem dataItem : listTransaksi) {
                        history = new History(dataItem.getTanggal(), (String) dataItem.getStatus());
                        historyArrayList.add(history);
                    }
                    recyclerView = findViewById(R.id.recyclerview);
                    historyAdapter = new HistoryAdapter(historyArrayList, listener);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HistoryActivity.this);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(historyAdapter);
                }
            }

            @Override
            public void onFailure(Call<TransaksiResponse> call, Throwable t) {
                Toast.makeText(HistoryActivity.this, "Gagal terhubung ke server", Toast.LENGTH_SHORT).show();

            }
        });



//        historyArrayList = new ArrayList<>();
//        historyArrayList.add(new History("23 April 2021", "Selesai"));
//        historyArrayList.add(new History("5 Mei 2021", "Selesai"));
//        historyArrayList.add(new History("31 Juni 2022", "Selesai"));
//        historyArrayList.add(new History("13 Juli 2022", "Selesai"));
//        historyArrayList.add(new History("13 Agustus 2022", "Selesai"));
//        historyArrayList.add(new History("23 September 2021", "Selesai"));
//        historyArrayList.add(new History("23 November 2021", "Selesai"));
//        historyArrayList.add(new History("23 Desember 2021", "Selesai"));
//        historyArrayList.add(new History("30 Desember 2021", "Selesai"));
    }
}