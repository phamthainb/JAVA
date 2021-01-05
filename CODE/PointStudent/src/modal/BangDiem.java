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
public class BangDiem implements Serializable {

    private SinhVien sv;
    private MonHoc mh;
    private Float diem;

    public BangDiem(SinhVien sv, MonHoc mh, Float diem) {
        this.sv = sv;
        this.mh = mh;
        this.diem = diem;
    }

    public static String check(String diem) {
        String mess = "";

        if (diem.isEmpty()) {
            mess += "Diem " + Text.REQUIRER;
        } else {
            Float t = Float.valueOf(diem);
            if (0 > t || t > 10) {
                mess += "Diem " + Text.VALIDR;
            }
        }

        return mess;
    }

    public SinhVien getSv() {
        return sv;
    }

    public void setSv(SinhVien sv) {
        this.sv = sv;
    }

    public MonHoc getMh() {
        return mh;
    }

    public void setMh(MonHoc mh) {
        this.mh = mh;
    }

    public Float getDiem() {
        return diem;
    }

    public void setDiem(Float diem) {
        this.diem = diem;
    }

}
