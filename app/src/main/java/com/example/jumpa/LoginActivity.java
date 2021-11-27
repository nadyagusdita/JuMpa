package com.example.jumpa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jumpa.model.AuthClass;
import com.example.jumpa.retrofit.ApiClient;
import com.example.jumpa.retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    EditText inputEmail;
    EditText inputPassword;
    String email, password;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                inputEmail = findViewById(R.id.inputEmail);
                inputPassword = findViewById(R.id.inputPassword);

                email = inputEmail.getText().toString();
                password = inputPassword.getText().toString();
                login(email, password);
            }
        });

        Button btn_daftar = findViewById(R.id.btn_daftar);
        btn_daftar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(i);
            }
        });

        TextView lupaPass = findViewById(R.id.txtLupaPassword);
        lupaPass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), LupaPasswordActivity.class);
                startActivity(i);
            }
        });

    }

    private void login(String email, String password) {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<AuthClass> authClassCall = apiInterface.checkLogin(email, password);
        authClassCall.enqueue(new Callback<AuthClass>() {
            @Override
            public void onResponse(Call<AuthClass> call, Response<AuthClass> response) {
                if (response.body() != null && response.isSuccessful() && response.body().getError() != true){
                    Toast.makeText(LoginActivity.this, "Login berhasil.", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Email/Password anda salah.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AuthClass> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Gagal terhubung ke server", Toast.LENGTH_SHORT).show();
            }
        });



    }
}