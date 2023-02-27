/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.HoaDon;
import model.KhachHang;
import model.SanPham;

/**
 *
 * @author vinhn
 */
public class HoaDonDao extends ConnectDB {

    public HoaDonDao() {
    }

    public SanPham getSanPham(String ma) {
        Statement st = null;
        SanPham sp = null;
        try {
            st = conn.createStatement();

            String sql = ("SELECT * FROM san_pham where id = '" + ma + "'");
            ResultSet rs = null;

            rs = st.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("tensp");
                int sl = rs.getInt("soluong");
                double gia = rs.getDouble("gia");
                String ngay = rs.getString("ngaynhap");
                sp = new SanPham(id, name, sl, gia, ngay);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sp;

    }

    public KhachHang getKhachHang(String ma) {
        Statement st = null;
        KhachHang kh = null;
        try {
            st = conn.createStatement();

            String sql = ("SELECT * FROM khach_hang where sdt = '" + ma + "'");
            ResultSet rs = null;

            rs = st.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("ten");
                String sdt = rs.getString("sdt");
                String email = rs.getString("ngaysinh");
                kh = new KhachHang(name, sdt, email);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return kh;

    }

    public void createHoaDon(HoaDon hoadon) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO hoadon(masp,makh,soluong,thanhtien,date) VALUES(?,?,?,?,?)");

            preparedStatement.setString(1, hoadon.getMaSp());
            preparedStatement.setString(2, hoadon.getMaKH());
            preparedStatement.setInt(3, hoadon.getSl());
            preparedStatement.setDouble(4, hoadon.getThanhTien());
            preparedStatement.setString(5, hoadon.getDate());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public void updateHoaDon(HoaDon hoadon) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("update hoadon set masp = ?,makh = ?,soluong =?,thanhtien =?,date=? where id = ?");

            preparedStatement.setString(1, hoadon.getMaSp());
            preparedStatement.setString(2, hoadon.getMaKH());
            preparedStatement.setInt(3, hoadon.getSl());
            preparedStatement.setDouble(4, hoadon.getThanhTien());
            preparedStatement.setString(5, hoadon.getDate());
              preparedStatement.setInt(6, hoadon.getId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteHoaDon(int ma) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("delete from hoadon where id = " + ma + "");
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateSP(String ma, int sl) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("update san_pham set soluong = ? where id =? ");

            preparedStatement.setInt(1, sl);
            preparedStatement.setString(2, ma);

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<HoaDon> getListHoaDon() {
        Statement st = null;
        ArrayList<HoaDon> list = new ArrayList<>();
        try {
            st = conn.createStatement();

            String sql = ("SELECT * FROM hoadon");
            ResultSet rs = null;

            rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String masp = rs.getString("masp");
                String makh = rs.getString("makh");
                int sl = rs.getInt("soluong");
                double thanhtien = rs.getDouble("thanhtien");
                String date = rs.getString("date");
                list.add(new HoaDon(id, masp, makh, sl, thanhtien, date));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

}
