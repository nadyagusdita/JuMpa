package com.example.jumpa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.jumpa.model.EditTransaksi;
import com.example.jumpa.retrofit.ApiClient;
import com.example.jumpa.retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SelesaikanTransaksiActivity extends AppCompatActivity {
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selesaikan_transaksi);

        ImageButton arrow_back = findViewById(R.id.arrow_back);
        arrow_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        Button btnselesai = findViewById(R.id.btn_selesaitrk);
        btnselesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etKertas = findViewById(R.id.eTextKertas);
                EditText etPlastik = findViewById(R.id.eTextPlastik);
                EditText etBesiLogam = findViewById(R.id.eTextBesiLogam);
                EditText etElektronik = findViewById(R.id.eTextElektronik);
                EditText etKaca = findViewById(R.id.eTextKaca);
                EditText etKain = findViewById(R.id.eTextKain);
                EditText etKeramik = findViewById(R.id.eTextKeramik);

                Integer kertas = Integer.valueOf(etKertas.getText().toString());
                Integer plastik = Integer.valueOf(etPlastik.getText().toString());
                Integer besilogam = Integer.valueOf(etBesiLogam.getText().toString());
                Integer elektronik = Integer.valueOf(etElektronik.getText().toString());
                Integer kaca = Integer.valueOf(etKaca.getText().toString());
                Integer kain = Integer.valueOf(etKain.getText().toString());
                Integer keramik = Integer.valueOf(etKeramik.getText().toString());

                Integer berattotal = kertas+plastik+besilogam+elektronik+kaca+kain+keramik;
                Integer totalharga = (kertas*2500)+(plastik*3000)+(besilogam*5000)+(elektronik*30000)
                                    +(kaca*20000)+(kain*30000)+(keramik*10000);

                Integer ID = Integer.valueOf(getIntent().getStringExtra("ID"));
                String status = "Selesai";
                eTransaksi(ID,berattotal,totalharga,status);

                Intent intent = new Intent(getApplicationContext(), DetailHistoryActivity.class);
                startActivity(intent);
            }
        });
    }

    private void eTransaksi(Integer id, Integer berattotal, Integer totalharga, String status) {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<EditTransaksi> editTransaksiCall = apiInterface.eTransaksi(id,berattotal,totalharga,status);
        editTransaksiCall.enqueue(new Callback<EditTransaksi>() {
            @Override
            public void onResponse(Call<EditTransaksi> call, Response<EditTransaksi> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isError() != true){
                    Toast.makeText(SelesaikanTransaksiActivity.this, "Transaksi Selesai.", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), HistoryActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SelesaikanTransaksiActivity.this, "Transaksi Gagal.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<EditTransaksi> call, Throwable t) {
                Toast.makeText(SelesaikanTransaksiActivity.this, "Gagal terhubung ke server", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
