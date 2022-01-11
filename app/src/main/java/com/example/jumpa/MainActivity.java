package com.example.jumpa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jumpa.adapter.HistoryAdapter;
import com.example.jumpa.model.DashboardResponse;
import com.example.jumpa.model.DataItem;
import com.example.jumpa.model.History;
import com.example.jumpa.model.TransaksiResponse;
import com.example.jumpa.retrofit.ApiClient;
import com.example.jumpa.retrofit.ApiInterface;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView tvSaldo, tvBerat, txtuser;
    String saldo, berat, username;
    SessionManager sessionManager;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(MainActivity.this);
        if (!sessionManager.isLoggedIn()) {
            moveToLogin();
        }

        tvSaldo = findViewById(R.id.tv_saldo);
        tvBerat = findViewById(R.id.tv_berat);
        Integer user_id = sessionManager.getId();
        getData(user_id);

        txtuser = findViewById(R.id.txtuser);
        username = sessionManager.getUserData().get("USERNAME");
        txtuser.setText("Hai, " + username);

        Button btn_logout = findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                sessionManager.LogoutSession();
                moveToLogin();
            }
        });

        LinearLayout dropoffmenu = findViewById(R.id.dropoffmenu);
        dropoffmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DropOffActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout pickupmenu = findViewById(R.id.pickupmenu);
        pickupmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PickUpActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout historymenu = findViewById(R.id.historymenu);
        historymenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HistoryActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout daftarhargamenu = findViewById(R.id.daftarhargamenu);
        daftarhargamenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DaftarHargaActivity.class);
                startActivity(intent);
            }
        });
    }

    private void moveToLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

    public void getData(Integer user_id) {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<DashboardResponse> dashboardResponseCall = apiInterface.dataDashboard(user_id);
        dashboardResponseCall.enqueue(new Callback<DashboardResponse>() {
            @Override
            public void onResponse(Call<DashboardResponse> call, Response<DashboardResponse> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isError() != true) {
                    berat = response.body().getData().getBeratTotal();
                    saldo = response.body().getData().getTotalHarga();

                    tvSaldo.setText("Rp " + saldo);
                    tvBerat.setText(berat + " Kg");
<<<<<<< HEAD

=======
>>>>>>> 181ebd7de8b82a152648dd0a98d2b0c766ce28aa
                }
            }

            @Override
            public void onFailure(Call<DashboardResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal terhubung ke server", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
