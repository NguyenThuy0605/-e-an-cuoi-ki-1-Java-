/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author vinhn
 */
public class SanPham {
    private String maSP;
    private String tenSp;
    private int soluong;
    private double gia;
    private String ngay;

    public SanPham(String maSP, String tenSp, int soluong, double gia, String ngay) {
        this.maSP = maSP;
        this.tenSp = tenSp;
        this.soluong = soluong;
        this.gia = gia;
        this.ngay = ngay;
    }

    public SanPham() {
    }
    
    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }
    
    
}
