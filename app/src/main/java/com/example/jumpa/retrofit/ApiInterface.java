package com.example.jumpa.retrofit;

import com.example.jumpa.model.AuthClass;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("login.php")
    Call<AuthClass> checkLogin(
            @Field("email") String email,
            @Field("password") String password
    );
}
