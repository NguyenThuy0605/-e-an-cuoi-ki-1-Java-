
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
public class SanPhamDao extends ConnectDB {

    public SanPhamDao() {
    }

    public void createSanPham(SanPham sanPham) {
        /*chèn một bản ghi sản phẩm mới vào bảng*/
        try {

            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO san_pham VALUES(?,?,?,?,?)");
            preparedStatement.setString(1, sanPham.getMaSP());
            preparedStatement.setString(2, sanPham.getTenSp());
            preparedStatement.setInt(3, sanPham.getSoluong());
            preparedStatement.setDouble(4, sanPham.getGia());
            preparedStatement.setString(5, sanPham.getNgay());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void editSanPham(SanPham sanPham) {
        /*cập nhật một bản ghi sản phẩm hiện có trong bảng*/
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("update san_pham set tensp = ?,soluong= ?,gia = ?,ngaynhap =? where id =?");
            preparedStatement.setString(5, sanPham.getMaSP());
            preparedStatement.setString(1, sanPham.getTenSp());
            preparedStatement.setInt(2, sanPham.getSoluong());
            preparedStatement.setDouble(3, sanPham.getGia());
            preparedStatement.setString(4, sanPham.getNgay());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteSanPham(String id) {
//        xóa bản ghi sản phẩm khỏi bảng
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("delete from san_pham where id =?");
            preparedStatement.setString(1, id);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<SanPham> getSanPham() {
//        lấy tất cả các bản ghi sản phẩm từ bảng
        Statement st = null;
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            st = conn.createStatement();

            String sql = ("SELECT * FROM san_pham");
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
    
     public ArrayList<SanPham> searchSanPham(String name1) {
//         lấy các bản ghi sản phẩm khớp với từ khóa tìm kiếm từ bảng
        Statement st = null;
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            st = conn.createStatement();

            String sql = ("SELECT * FROM san_pham where ten like '%"+name1+"%'");
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
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }
}
