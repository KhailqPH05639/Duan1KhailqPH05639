package com.example.khai.duan1khailqph05639.model;

public class LineAB {
    String id,vitri,ten;
    int soao,chiso;

    public LineAB(String id, String vitri, String ten, int soao, int chiso) {
        this.id = id;
        this.vitri = vitri;
        this.ten = ten;
        this.soao = soao;
        this.chiso = chiso;
    }

    public LineAB() {

    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
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


