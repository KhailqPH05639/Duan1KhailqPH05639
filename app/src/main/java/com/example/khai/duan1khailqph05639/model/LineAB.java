package com.example.khai.duan1khailqph05639.model;

public class LineAB {
    String vitri,ten;
    int id,soao,chiso;

    public LineAB(int id) {
        this.id = id;
    }

    public LineAB(String vitri, String ten, int soao, int chiso) {
        this.vitri = vitri;
        this.ten = ten;
        this.soao = soao;
        this.chiso = chiso;

    }

    public LineAB() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVitri() {
        return vitri;
    }

    public void setVitri(String vitri) {
        this.vitri = vitri;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoao() {
        return soao;
    }

    public void setSoao(int soao) {
        this.soao = soao;
    }

    public int getChiso() {
        return chiso;
    }

    public void setChiso(int chiso) {
        this.chiso = chiso;
    }
}
