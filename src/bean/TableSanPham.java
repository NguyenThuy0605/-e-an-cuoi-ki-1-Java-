/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.KhachHang;
import model.SanPham;

/**
 *
 * @author vinhn
 */
public class TableSanPham extends AbstractTableModel {

    //Khai báo xâu chứa tiêu đề của bảng.
    private String name[] = {"Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá", "Ngày nhập"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[] = {String.class, String.class, Integer.class, Double.class, String.class};
    //Tạo một đối tượng arrayList có tên dsSV.
    ArrayList<SanPham> dsSV = new ArrayList<>();

    public TableSanPham(ArrayList<SanPham> ds) {
        dsSV = ds;
    }

    @Override
    public int getRowCount() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return dsSV.size();
    }

    @Override
    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            //Cột mã
            case 0:
                return dsSV.get(rowIndex).getMaSP();
            //Cột họ tên
            case 1:
                return dsSV.get(rowIndex).getTenSp();

            case 2:
                return dsSV.get(rowIndex).getSoluong();

            case 3:
                return dsSV.get(rowIndex).getGia();
            case 4:
                return dsSV.get(rowIndex).getNgay();

            default:
                return null;
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return name[column];
    }
}
