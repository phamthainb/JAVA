/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author admin
 */
public class FineDetail {
    private int id;
    private double price;
    private int numberFault;
    private String note;
    private Fine fine;

    public Fine getFine() {
        return fine;
    }

    public void setFine(Fine fine) {
        this.fine = fine;
    }

    public FineDetail() {
    }

    public FineDetail(double price, int numberFault, String note, Fine fine) {
        this.price = price;
        this.numberFault = numberFault;
        this.note = note;
        this.fine = fine;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberFault() {
        return numberFault;
    }

    public void setNumberFault(int numberFault) {
        this.numberFault = numberFault;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
}
