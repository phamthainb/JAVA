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
public class MonHoc implements Serializable {

    private int ma, tin;
    private String ten, loai;
    public static int id = 100;

    public MonHoc(String ten, int tin, String loai) {
        this.ma = id++;
        this.tin = tin;
        this.ten = ten;
        this.loai = loai;
    }

    public static String check(String ten, String tin, String loai) {
        String mess = "";

        if (ten.isEmpty()) {
            mess += "Ten " + Text.REQUIRER;
        } else {
            if (!ten.matches("^[a-zA-Z]*$")) {
                mess += "Ten " + Text.VALIDR;
            }
        }

        if (tin.isEmpty()) {
            mess += "So tin " + Text.REQUIRER;
        } else {
            if (!tin.matches("^[0-9]+$")) {
                mess += "So tin " + Text.VALIDR;
            }
        }

        if (loai.isEmpty()) {
            mess += "Loai " + Text.REQUIRER;
        }

        return mess;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public int getTin() {
        return tin;
    }

    public void setTin(int tin) {
        this.tin = tin;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

}
