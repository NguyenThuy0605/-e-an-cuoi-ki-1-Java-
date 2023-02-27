/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.HoaDon;
import model.KhachHang;

/**
 *
 * @author vinhn
 */
public class TableHoaDon extends AbstractTableModel {

    private String name[] = {"ID", "Mã sản phẩm", "Mã khách hàng", "Số lượng", "Thành tiền", "Ngày tạo đơn"};
    private Class classes[] = {Integer.class, String.class, String.class, Integer.class, Double.class, String.class};
    ArrayList<HoaDon> dsSV = new ArrayList<>();

    public TableHoaDon(ArrayList<HoaDon> ds) {
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
                return dsSV.get(rowIndex).getId();

            case 1:
                return dsSV.get(rowIndex).getMaSp();

            case 2:
                return dsSV.get(rowIndex).getMaKH();
            case 3:
                return dsSV.get(rowIndex).getSl();
            case 4:
                return dsSV.get(rowIndex).getThanhTien();
            case 5:
                return dsSV.get(rowIndex).getDate();
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
