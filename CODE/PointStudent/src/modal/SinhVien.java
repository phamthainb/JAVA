/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import contants.Text;
import java.io.Serializable;

/**
 *
 * @author phamthainb
 */
public class SinhVien implements Serializable {

    private int ma;
    private String hoTen, diaChi, ngaySinh, lop;
    private static int id = 10000;

    // validate
    public static String check(String hoTen, String diaChi, String ngaySinh, String lop) {
        String mess = "";

        if (hoTen.isEmpty()) {
            mess += "Họ tên " + Text.REQUIRER;
        } else {
            if (!hoTen.matches("^[a-zA-Z]*$")) {
                mess += "Họ tên" + Text.VALIDR;
            }
        }

        if (diaChi.isEmpty()) {
            mess += "Địa chỉ" + Text.REQUIRER;
        }

        if (ngaySinh.isEmpty()) {
            mess += "Ngay sinh" + Text.REQUIRER;
        }

        if (lop.isEmpty()) {
            mess += "Lop" + Text.REQUIRER;
        }

        return mess;
    }

    public SinhVien(String hoTen, String diaChi, String ngaySinh, String lop) {
        this.ma = id++;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.lop = lop;
    }

    public SinhVien() {
    }

    public int getMa() {
        return ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getLop() {
        return lop;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

}
