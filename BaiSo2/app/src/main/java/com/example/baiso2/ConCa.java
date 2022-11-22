package com.example.baiso2;

public class ConCa {
    private String id, tenKH, bietDanh, dacTinh, mauCa;
    private int hinh;

    public ConCa(){}

    @Override
    public String toString() {
        return "ConCa{" +
                "tenKH='" + tenKH + '\'' +
                ", bietDanh='" + bietDanh + '\'' +
                ", dacTinh='" + dacTinh + '\'' +
                ", mauCa='" + mauCa + '\'' +
                ", hinh=" + hinh +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ConCa(String tenKH, String bietDanh, String dacTinh, String mauCa, int hinh) {
        this.tenKH = tenKH;
        this.bietDanh = bietDanh;
        this.dacTinh = dacTinh;
        this.mauCa = mauCa;
        this.hinh = hinh;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getBietDanh() {
        return bietDanh;
    }

    public void setBietDanh(String bietDanh) {
        this.bietDanh = bietDanh;
    }

    public String getDacTinh() {
        return dacTinh;
    }

    public void setDacTinh(String dacTinh) {
        this.dacTinh = dacTinh;
    }

    public String getMauCa() {
        return mauCa;
    }

    public void setMauCa(String mauCa) {
        this.mauCa = mauCa;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
