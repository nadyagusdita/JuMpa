package com.example.jumpa;

public class History {
    private String tanggaltrk;
    private String status;

    public History(String tanggaltrk, String status) {
        this.tanggaltrk = tanggaltrk;
        this.status = status;
    }

    public String getTanggaltrk() {
        return tanggaltrk;
    }

    public void setTanggaltrk(String tanggaltrk) {
        this.tanggaltrk = tanggaltrk;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
