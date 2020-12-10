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
public class PhanCong implements Serializable{
    private LaiXe laiXe;
    private Tuyen tuyen;
    private int count;

    public PhanCong() {
    }

    public PhanCong(LaiXe laiXe, Tuyen tuyen, int count) {
        this.laiXe = laiXe;
        this.tuyen = tuyen;
        this.count = count;
    }

    public void setLaiXe(LaiXe laiXe) {
        this.laiXe = laiXe;
    }

    public void setTuyen(Tuyen tuyen) {
        this.tuyen = tuyen;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public LaiXe getLaiXe() {
        return laiXe;
    }

    public Tuyen getTuyen() {
        return tuyen;
    }

    public int getCount() {
        return count;
    }
    
    
}
