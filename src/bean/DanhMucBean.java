/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class DanhMucBean {
    private String kind;
    private JPanel jpn;
    private JLabel jlb;

    public DanhMucBean(String kind, JPanel jpn, JLabel jlb) {
        this.kind = kind;
        this.jpn = jpn;
        this.jlb = jlb;
    }
    public DanhMucBean()
    {
        
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public JPanel getJpn() {
        return jpn;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }

    public JLabel getJlb() {
        return jlb;
    }

    public void setJlb(JLabel jlb) {
        this.jlb = jlb;
    }

    /* DanhMucBeanlà một lớp JavaBean đơn giản với ba thuộc tính:
    kind, jpn, và jlb. Các thuộc tính này được sử dụng để lưu trữ thông tin
    về một mục menu trong khung ứng dụng chính.

    Thuộc kindtính lưu trữ tên hoặc nhãn của mục menu, trong khi 
    thuộc tính jpnvà jlblưu trữ các tham chiếu đến JPanelvà JLabel
    các thành phần được sử dụng để hiển thị mục menu trong khung ứng dụng.

    Hàm tạo của lớp nhận ba đối số: kind, jpn, và jlb, và khởi tạo 
    các thuộc tính tương ứng của đối tượng. Lớp này cũng có các 
    phương thức getter và setter cho từng thuộc tính.

    Lớp này được sử dụng trong Mainlớp để tạo danh sách các 
    mục menu và các thành phần JPanelvà liên kết của chúng JLabel,
    sau đó được sử dụng để thiết lập menu và xử lý điều hướng trong ứng dụng */




    
}
