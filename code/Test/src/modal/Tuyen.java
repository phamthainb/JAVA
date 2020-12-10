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
public class Tuyen implements Serializable {

    private int maTuyen, khoangCach, soDiemDung;

    public Tuyen(int maTuyen, int khoangCach, int soDiemDung) {
        this.maTuyen = maTuyen;
        this.khoangCach = khoangCach;
        this.soDiemDung = soDiemDung;
    }

    public Tuyen() {
    }

    public int getMaTuyen() {
        return maTuyen;
    }

    public int getKhoangCach() {
        return khoangCach;
    }

    public int getSoDiemDung() {
        return soDiemDung;
    }

    public void setMaTuyen(int maTuyen) {
        this.maTuyen = maTuyen;
    }

    public void setKhoangCach(int khoangCach) {
        this.khoangCach = khoangCach;
    }

    public void setSoDiemDung(int soDiemDung) {
        this.soDiemDung = soDiemDung;
    }

}
