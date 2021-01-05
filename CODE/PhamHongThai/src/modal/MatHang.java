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
public class MatHang implements Serializable {

    private int ma, giaMua, giaBan;
    private String ten, nhom;
    public static int id = 1000;

    public MatHang(int giaMua, int giaBan, String ten, String nhom) {
        this.ma = id++;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
        this.ten = ten;
        this.nhom = nhom;
    }

    public MatHang() {
    }

    public static String check(String giaMua, String giaBan, String ten, String nhom) {
        String mess = "";
        if (giaMua.isEmpty()) {
            mess += "Giá mua" + Text.REQUIRE;
        } else if (!giaMua.matches("^[0-9]+$")) {
            mess += "Giá mua " + Text.VALID;
        }
        if (giaBan.isEmpty()) {
            mess += "Giá bán" + Text.REQUIRE;
        } else if (!giaBan.matches("^[0-9]+$")) {
            mess += "Giá bán " + Text.VALID;
        }

        if (ten.isEmpty()) {
            mess += "Tên" + Text.REQUIRE;
        } else if (!ten.matches("^[a-zA-Z\\s]+$")) {
            mess += "Tên " + Text.VALID;
        }

        if (nhom.isEmpty()) {
            mess += "Nhóm " + Text.REQUIRE;
        }
        return mess;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public int getGiaMua() {
        return giaMua;
    }

    public void setGiaMua(int giaMua) {
        this.giaMua = giaMua;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNhom() {
        return nhom;
    }

    public void setNhom(String nhom) {
        this.nhom = nhom;
    }

}
