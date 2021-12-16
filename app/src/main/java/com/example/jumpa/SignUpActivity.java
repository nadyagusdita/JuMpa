package com.example.jumpa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jumpa.model.SignUpClass;
import com.example.jumpa.retrofit.ApiClient;
import com.example.jumpa.retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    EditText inputEmail, inputUsername, inputPassword;
    String email, username, password;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button btn_daftar = findViewById(R.id.btn_daftar);
        btn_daftar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                inputEmail = findViewById(R.id.inputEmail);
                inputUsername = findViewById(R.id.inputUsername);
                inputPassword = findViewById(R.id.inputPassword);

                email = inputEmail.getText().toString();
                username = inputUsername.getText().toString();
                password = inputPassword.getText().toString();
                signUp(email, username, password);
            }
        });

        ImageButton arrow_back = findViewById(R.id.arrow_back);
        arrow_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void signUp(String email, String username, String password) {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<SignUpClass> signUpClassCall = apiInterface.checkSignUp(email, username, password);
        signUpClassCall.enqueue(new Callback<SignUpClass>() {
            @Override
            public void onResponse(Call<SignUpClass> call, Response<SignUpClass> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isError() != true){
                    Toast.makeText(SignUpActivity.this, "Sign Up berhasil.", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SignUpActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(SignUpActivity.this, "Sign Up Gagal.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SignUpClass> call, Throwable t) {
                Toast.makeText(SignUpActivity.this, "Gagal terhubung ke server", Toast.LENGTH_SHORT).show();
            }
        });

    }
}