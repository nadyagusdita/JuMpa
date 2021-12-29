package com.example.jumpa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class DetailHistoryActivity extends AppCompatActivity {
    TextView tvid, tvtanggal, tvwaktu, tvnoponsel, tvkategorisampah, tvberattotal, tvtotalharga;
    String id, tanggal, waktu, noponsel, kategorisampah, berattotal, totalharga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_history);

        tvid = findViewById(R.id.tvId);
        tvtanggal = findViewById(R.id.tvTanggal);
        tvwaktu = findViewById(R.id.tvWaktu);
        tvnoponsel = findViewById(R.id.tvNoPonsel);
        tvkategorisampah = findViewById(R.id.tvkategori);
        tvberattotal = findViewById(R.id.tvBeratTotal);
        tvtotalharga = findViewById(R.id.tvTotalHarga);

        Bundle extras = getIntent().getExtras();
        id = extras.getString("ID");
        tanggal = extras.getString("tanggal");
        waktu = extras.getString("waktu");
        noponsel = extras.getString("noponsel");
        kategorisampah = extras.getString("kategorisampah");
        berattotal = extras.getString("berattotal");
        totalharga = extras.getString("totalharga");

        tvid.setText("SAM" + id);
        tvtanggal.setText(tanggal);
        tvwaktu.setText(waktu + " WIB");
        tvnoponsel.setText(noponsel);
        tvkategorisampah.setText(kategorisampah);
        tvberattotal.setText(berattotal + " Kg");
        tvtotalharga.setText("Rp" + totalharga);

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