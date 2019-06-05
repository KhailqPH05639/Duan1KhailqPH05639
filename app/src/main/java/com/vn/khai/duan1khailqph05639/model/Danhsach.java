package com.vn.khai.duan1khailqph05639.model;

import java.util.Date;

public class Danhsach {
    String id, chucvu, ten, gioitinh, tinhtrang, quoctich;
    int tuoi;
    double luong;
    Date date;

    public Danhsach(String id, String chucvu, String ten, String gioitinh, String tinhtrang, String quoctich, int tuoi, double luong, Date date) {
        this.id = id;
        this.chucvu = chucvu;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.tinhtrang = tinhtrang;
        this.quoctich = quoctich;
        this.tuoi = tuoi;
        this.luong = luong;
        this.date = date;
    }

    public Danhsach() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String getQuoctich() {
        return quoctich;
    }

    public void setQuoctich(String quoctich) {
        this.quoctich = quoctich;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
