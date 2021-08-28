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
public class BorrowTicket {
    private int id;
    private Date createDate;
    private int totalBook;
    private String note;
    private ArrayList<BorrowedBook> listBorrowedBook;
    private Reader reader;
    private User user;

    public BorrowTicket() {
    }

    public BorrowTicket(Date createDate, int totalBook, String note, ArrayList<BorrowedBook> listBorrowedBook, Reader reader, User user) {
        this.createDate = createDate;
        this.totalBook = totalBook;
        this.note = note;
        this.listBorrowedBook = listBorrowedBook;
        this.reader = reader;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getTotalBook() {
        return totalBook;
    }

    public void setTotalBook(int totalBook) {
        this.totalBook = totalBook;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public ArrayList<BorrowedBook> getListBorrowedBook() {
        return listBorrowedBook;
    }

    public void setListBorrowedBook(ArrayList<BorrowedBook> listBorrowedBook) {
        this.listBorrowedBook = listBorrowedBook;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}
