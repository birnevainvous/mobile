package com.example.mad_n2_t16.model_class;

import java.io.Serializable;

public class taikhoan implements Serializable {

    private int id;
    private String taiKhoan;
    private String matKhau;
    private String hoTen;

    public taikhoan(int id, String taiKhoan, String matKhau, String hoTen) {
        this.id = id;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
    }

    public taikhoan() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }}