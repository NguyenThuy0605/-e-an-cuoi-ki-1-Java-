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
public class KhachHang {
    private String ten;
    private String sdt;
    private String ngaySinh;

    public KhachHang() {
    }

    public KhachHang( String ten, String sdt, String ngay ) {
      
        this.ten = ten;
        this.sdt = sdt;
        this.ngaySinh = ngay;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

   
    
    
}
