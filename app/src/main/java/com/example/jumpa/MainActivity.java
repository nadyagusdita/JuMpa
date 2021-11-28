package com.example.jumpa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(MainActivity.this);
        if(!sessionManager.isLoggedIn()){
            moveToLogin();
        }

//        txtuser = findViewById(R.id.txtuser);
//        username = sessionManager.getUserData().get("USERNAME");
//        txtuser.setText(username);

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
}
