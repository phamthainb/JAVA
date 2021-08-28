/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author admin
 */
public class Returning implements Serializable{
    private int id;
    private Date dayReturn;
    private String note;
    private User user;
    private Reader reader;
    private ArrayList<BorrowedBook> listBorrowedBook;

    public Returning(Date dayReturn, String note, User user, Reader reader, ArrayList<BorrowedBook> listBorrowedBook, String des) {
        this.dayReturn = dayReturn;
        this.note = note;
        this.user = user;
        this.reader = reader;
        this.listBorrowedBook = listBorrowedBook;
        this.des = des;
    }
    private String des;
    

    public Returning() {
    }

    public Date getDayReturn() {
        return dayReturn;
    }

    public void setDayReturn(Date dayReturn) {
        this.dayReturn = dayReturn;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public ArrayList<BorrowedBook> getListBorrowedBook() {
        return listBorrowedBook;
    }

    public void setListBorrowedBook(ArrayList<BorrowedBook> listBorrowedBook) {
        this.listBorrowedBook = listBorrowedBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
    
    
}
