/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.io.Serializable;

/**
 *
 * @author phamthainb
 */
public class LaiXe implements Serializable{
    private int maLX, trinhDo;
    private String hoTen, diaChi;

    public void setMaLX(int maLX) {
        this.maLX = maLX;
    }

    public void setTrinhDo(int trinhDo) {
        this.trinhDo = trinhDo;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public LaiXe(int maLX, int trinhDo, String hoTen, String diaChi) {
        this.maLX = maLX;
        this.trinhDo = trinhDo;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
    }

    public LaiXe() {
    }

    public int getMaLX() {
        return maLX;
    }

    public int getTrinhDo() {
        return trinhDo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }
    
    
}
