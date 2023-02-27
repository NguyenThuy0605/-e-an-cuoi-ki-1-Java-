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
import model.SanPham;

/**
 *
 * @author vinhn
 */
public class ThongKeDao extends ConnectDB {

    public ThongKeDao() {
    }

    public ArrayList<SanPham> getSanPham() {
        Statement st = null;
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            st = conn.createStatement();

            String sql = ("SELECT * FROM san_pham where soluong < 10");
            ResultSet rs = null;

            rs = st.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("tensp");
                int sl = rs.getInt("soluong");
                double gia = rs.getDouble("gia");
                String ngay = rs.getString("ngaynhap");
                list.add(new SanPham(id, name, sl, gia, ngay));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

}
