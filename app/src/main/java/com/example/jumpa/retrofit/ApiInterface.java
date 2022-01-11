package com.example.jumpa.retrofit;

import com.example.jumpa.model.AuthClass;
import com.example.jumpa.model.DashboardResponse;
import com.example.jumpa.model.EditTransaksi;
import com.example.jumpa.model.SignUpClass;
import com.example.jumpa.model.TransactionClass;
import com.example.jumpa.model.TransaksiResponse;

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

    @FormUrlEncoded
    @POST("register.php")
    Call<SignUpClass> checkSignUp(
            @Field("email") String email,
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("transaksi.php")
    Call<TransactionClass> insertTransaction(
            @Field("tanggal") String tanggal,
            @Field("waktu") String waktu,
            @Field("no_ponsel") String no_ponsel,
            @Field("kategori_sampah") String kategori_sampah,
            @Field("alamat") String alamat,
            @Field("user_id") String user_id
    );

    @FormUrlEncoded
    @POST("getTransaksi.php")
    Call<TransaksiResponse> getTransaksi(
            @Field("user_id") Integer user_id
    );

    @FormUrlEncoded
    @POST("eTransaksi.php")
    Call<EditTransaksi> eTransaksi(
            @Field("id") Integer id,
            @Field("berat_total") Integer berat_total,
            @Field("total_harga") Integer total_harga,
            @Field("status") String status
    );

    @FormUrlEncoded
    @POST("dataDashboard.php")
    Call<DashboardResponse> dataDashboard(
            @Field("user_id") Integer user_id
    );

}
