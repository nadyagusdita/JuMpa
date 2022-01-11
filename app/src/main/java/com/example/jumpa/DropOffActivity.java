package com.example.jumpa;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jumpa.model.SignUpClass;
import com.example.jumpa.model.TransactionClass;
import com.example.jumpa.retrofit.ApiClient;
import com.example.jumpa.retrofit.ApiInterface;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import java.util.Calendar;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DropOffActivity extends AppCompatActivity {
    DatePickerDialog picker;
    EditText eText;
    Button btnCamera;
    ImageView imageView;
    TextView textViewAlamat;

    CheckBox cbkertas, cbplastik, cbbesilogam, cbelektronik, cbkaca, cbkain, cbkermik;
    EditText eTextTanggal, eTextPonsel;
    Spinner spinner_time;
    ApiInterface apiInterface;
    SessionManager sessionManager;

    String alamat;
    private static final int ERROR_DIALOG_REQUEST = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_off);

        if(isServicesOK()){
            init();
        }

        textViewAlamat = findViewById(R.id.tViewAlamat);

        sessionManager = new SessionManager(DropOffActivity.this);
        Integer getId = sessionManager.getId();

        eTextPonsel = findViewById(R.id.eTextPonsel);
        spinner_time = findViewById(R.id.spinner_time);
        eTextTanggal = findViewById(R.id.eTextTanggal);

        eTextTanggal.setInputType(InputType.TYPE_NULL);
        eTextTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(DropOffActivity.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eTextTanggal.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        btnCamera = findViewById(R.id.btn_camera);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 101);
            }
        });

        Spinner dropDownTime = findViewById(R.id.spinner_time);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.item_time, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        dropDownTime.setAdapter(adapter);

        ImageButton arrow_back = findViewById(R.id.arrow_back);
        arrow_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        Button btnpesan = findViewById(R.id.btn_pesan);
        btnpesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cbkertas = findViewById(R.id.cbkertas);
                cbplastik = findViewById(R.id.cbplastik);
                cbbesilogam = findViewById(R.id.cbbesilogam);
                cbelektronik = findViewById(R.id.cbelektornik);
                cbkain = findViewById(R.id.cbkain);
                cbkaca = findViewById(R.id.cbkaca);
                cbkermik = findViewById(R.id.cbkeramik);

                String kategori_sampah = "";
                if (cbkertas.isChecked()) kategori_sampah = kategori_sampah + "," + cbkertas.getText();
                if (cbplastik.isChecked()) kategori_sampah = kategori_sampah + "," + cbplastik.getText();
                if (cbbesilogam.isChecked()) kategori_sampah = kategori_sampah + "," + cbbesilogam.getText();
                if (cbelektronik.isChecked()) kategori_sampah = kategori_sampah + "," + cbelektronik.getText();
                if (cbkain.isChecked()) kategori_sampah = kategori_sampah + "," + cbkain.getText();
                if (cbkaca.isChecked()) kategori_sampah = kategori_sampah + "," + cbkaca.getText();
                if (cbkermik.isChecked()) kategori_sampah = kategori_sampah + "," + cbkermik.getText();

                String tanggal = eTextTanggal.getText().toString();
                String waktu = spinner_time.getSelectedItem().toString();
                String no_ponsel = eTextPonsel.getText().toString();
                String alamat = textViewAlamat.getText().toString();
                String id = getId.toString();

                transactions(tanggal, waktu, no_ponsel, kategori_sampah, alamat, id);
            }
        });
    }

    private void init() {
        Button btnpilih = findViewById(R.id.btn_pilih);
        btnpilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CariOutletActivity.class);
                startActivityForResult(i, 123);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123) {
            if(resultCode == RESULT_OK) {
                String alamat = data.getStringExtra("address");
                textViewAlamat.setText(alamat);
            }
        }
        if(requestCode == 101) {
            imageView = findViewById(R.id.click_image);
            Bundle bundle = data.getExtras();
            Bitmap photo = (Bitmap) bundle.get("data");
            imageView.setImageBitmap(photo);
        }

    }

    private void transactions(String tanggal, String waktu, String no_ponsel, String kategori_sampah, String alamat, String id) {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<TransactionClass> transactionClassCall = apiInterface.insertTransaction(tanggal, waktu, no_ponsel, kategori_sampah, alamat, id);
        transactionClassCall.enqueue(new Callback<TransactionClass>() {
            @Override
            public void onResponse(Call<TransactionClass> call, Response<TransactionClass> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isError() != true){
                    Toast.makeText(DropOffActivity.this, "Pemesanan berhasil.", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), HistoryActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(DropOffActivity.this, "Pemesanan Gagal.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TransactionClass> call, Throwable t) {
                Toast.makeText(DropOffActivity.this, "Gagal terhubung ke server", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public boolean isServicesOK(){
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(DropOffActivity.this);

        if(available == ConnectionResult.SUCCESS){
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(DropOffActivity.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

}