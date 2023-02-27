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
public class HoaDon {
    private int id;
    private String maSp;
    private String maKH;
    private int sl;
    private double thanhTien;
    private String date;

    public HoaDon() {
    }

    public HoaDon(int id, String maSp, String maKH, int sl, double thanhTien, String date) {
        this.id = id;
        this.maSp = maSp;
        this.maKH = maKH;
        this.sl = sl;
        this.thanhTien = thanhTien;
        this.date = date;
    }
    
    

    public HoaDon(String maSp, String maKH, int sl, double thanhTien, String date) {
        this.maSp = maSp;
        this.maKH = maKH;
        this.sl = sl;
        this.thanhTien = thanhTien;
        this.date = date;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
