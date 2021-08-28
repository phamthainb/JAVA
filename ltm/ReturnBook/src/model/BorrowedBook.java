/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author admin
 */
public class BorrowedBook {
    private int id;
    private String note;
    private Book book;
    private Date returnDay;
    private Date borrowedDay;
    private boolean returned= false;
    private ArrayList<FineDetail> listFineDetail;

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    

    public BorrowedBook(String note, Book book, Date returnDay, Date borrowedDay, boolean returned, ArrayList<FineDetail> listFineDetail) {
        this.note = note;
        this.book = book;
        this.returnDay = returnDay;
        this.borrowedDay = borrowedDay;
        this.returned = returned;
        this.listFineDetail = listFineDetail;
    }

    public Date getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(Date returnDay) {
        this.returnDay = returnDay;
    }

    public Date getBorrowedDay() {
        return borrowedDay;
    }

    public void setBorrowedDay(Date borrowedDay) {
        this.borrowedDay = borrowedDay;
    }

    public BorrowedBook() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Book getBook() {
        return book;
    }

    public ArrayList<FineDetail> getListFineDetail() {
        return listFineDetail;
    }

    public void setListFineDetail(ArrayList<FineDetail> listFineDetail) {
        this.listFineDetail = listFineDetail;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    
}
