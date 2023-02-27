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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KhachHang;
import model.User;

/**
 *
 * @author vinhn
 */
public class KhachHangDao extends ConnectDB {

    public KhachHangDao() {
    }

    public void createKhachHang(KhachHang khachHang) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Khach_Hang VALUES(?,?,?)");
           
            preparedStatement.setString(1, khachHang.getTen());
            preparedStatement.setString(2, khachHang.getSdt());
            preparedStatement.setString(3, khachHang.getNgaySinh());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void editKhachHang(KhachHang khachHang) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("update khach_hang set ten = ?,email = ? where sdt= ?");
            preparedStatement.setString(1, khachHang.getTen());
            preparedStatement.setString(2, khachHang.getNgaySinh());
            preparedStatement.setString(3, khachHang.getSdt());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteKhachHang(KhachHang khachHang) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("delete from khach_hang where sdt= ?");
            preparedStatement.setString(1, khachHang.getSdt());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<KhachHang> getKhachHang() {
        Statement st = null;
        ArrayList<KhachHang> list = new ArrayList<>();
        try {
            st = conn.createStatement();

            String sql = ("SELECT * FROM khach_hang");
            ResultSet rs = null;

            rs = st.executeQuery(sql);

            while (rs.next()) {
     
                String name = rs.getString("ten");
                String sdt = rs.getString("sdt");
                String email = rs.getString("ngaysinh");
                list.add(new KhachHang( name, sdt, email));
            }

               conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }
    
     public ArrayList<KhachHang> searchKhachHang(String name1) {
        Statement st = null;
        ArrayList<KhachHang> list = new ArrayList<>();
        try {
            st = conn.createStatement();

            String sql = ("SELECT * FROM khach_hang where ten like '%"+name1+"%'");
            ResultSet rs = null;

            rs = st.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("ten");
                String sdt = rs.getString("sdt");
                String email = rs.getString("ngaysinh");
                list.add(new KhachHang( name, sdt, email));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }
}
