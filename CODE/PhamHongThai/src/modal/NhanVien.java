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
public class NhanVien implements Serializable {

    private int ma;
    private String ten, diaChi, sdt;
    public static int id = 1000;

    public NhanVien(String ten, String diaChi, String sdt) {
        this.ma = id++;
        this.ten = ten;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public NhanVien() {
    }

    // check
    public static String check(String ten, String diaChi, String sdt) {
        String mess = "";
        if (ten.isEmpty()) {
            mess += "Tên " + Text.REQUIRE;
        } else if (!ten.matches("^[a-zA-Z\\s]+$")) {
            mess += "Tên " + Text.VALID;
        }

        if (diaChi.isEmpty()) {
            mess += "Địa chỉ " + Text.REQUIRE;
        }

        if (sdt.isEmpty()) {
            mess += "Sđt " + Text.REQUIRE;
        } else if (!sdt.matches("^[0-9]+$")) {
            mess += "Sđt " + Text.VALID;
        }

        return mess;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

}
