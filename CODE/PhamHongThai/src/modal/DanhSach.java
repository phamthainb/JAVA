/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import contant.Text;
import java.io.Serializable;

/**
 *
 * @author phamthainb
 */
public class DanhSach implements Serializable {

    private NhanVien nv;
    private MatHang mh;
    private int soLuong;

    public DanhSach(NhanVien nv, MatHang mh, int soLuong) {
        this.nv = nv;
        this.mh = mh;
        this.soLuong = soLuong;
    }

    public DanhSach() {
    }

    // check
    public static String check(String sl) {
        String mess = "";
        if (sl.isEmpty()) {
            mess += "Số lượng " + Text.REQUIRE;
        } else if (!sl.matches("^[0-9]+$")) {
            mess += "Số lượng " + Text.VALID;
        }
        return mess;
    }

    public NhanVien getNv() {
        return nv;
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }

    public MatHang getMh() {
        return mh;
    }

    public void setMh(MatHang mh) {
        this.mh = mh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}
