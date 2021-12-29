package com.example.jumpa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.jumpa.model.DataItem;
import com.example.jumpa.model.History;
import com.example.jumpa.model.TransaksiResponse;
import com.example.jumpa.retrofit.ApiInterface;

import java.util.List;
import java.util.StringJoiner;

public class DetailHistoryActivity extends AppCompatActivity {
    TextView tvid,tvtanggal,tvwaktu,tvnoponsel,tvkategorisampah,tvberattotal,tvtotalharga;
    String id,tanggal,waktu,noponsel,kategorisampah,berattotal,totalharga;
    private List<DataItem> listTransaksi;
    private TransaksiResponse transaksiResponse;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_history);

        tvid = findViewById(R.id.tvid);
        tvtanggal = findViewById(R.id.tvtanggal);
        tvwaktu = findViewById(R.id.tvwaktu);
        tvnoponsel = findViewById(R.id.tvnoponsel);
        tvkategorisampah = findViewById(R.id.tvkategorisampah);
        tvberattotal = findViewById(R.id.tvberattotal);
        tvtotalharga = findViewById(R.id.tvtotalharga);

        Bundle extras = getIntent().getExtras();
        id = extras.getString("id");
        tanggal = extras.getString("tanggal");
        waktu = extras.getString("waktu");
        noponsel = extras.getString("noponsel");
        kategorisampah = extras.getString("kategorisampah");
        berattotal = extras.getString("berattotal");
        totalharga = extras.getString("totalharga");

        tvid.setText(id);
        tvtanggal.setText(tanggal);
        tvwaktu.setText(waktu);
        tvnoponsel.setText(noponsel);
        tvkategorisampah.setText(kategorisampah);
        tvberattotal.setText(berattotal);
        tvtotalharga.setText(totalharga);

        ImageButton arrow_back = findViewById(R.id.arrow_back);
        arrow_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}