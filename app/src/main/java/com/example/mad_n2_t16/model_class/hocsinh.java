package com.example.mad_n2_t16.model_class;

public class hocsinh {
    private int idHS;
    private String ngaySinh;
    private String email;
    private String name;
    private String address;

    public hocsinh(int idHS, String ngaySinh, String email, String name, String address) {
        this.idHS = idHS;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.name = name;
        this.address = address;
    }

    public hocsinh() {
    }

    public int getIdHS() {
        return idHS;
    }

    public void setIdHS(int idHS) {
        this.idHS = idHS;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
