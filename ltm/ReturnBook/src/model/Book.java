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
import java.io.Serializable;
import java.util.Date;
 
public class Book  implements Serializable{
    private int id;
    private String name;
    private String author;
    private String type;
    private int number;
    private Date publicYear;
    private String publisher;
    private double price;
    private String des;
     
    public Book() {
        super();
    }   

    public Book(String name, String author, String type, int number, Date publicYear, String publisher, double price, String des) {
        this.name = name;
        this.author = author;
        this.type = type;
        this.number = number;
        this.publicYear = publicYear;
        this.publisher = publisher;
        this.price = price;
        this.des = des;
    }
    
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getPublicYear() {
        return publicYear;
    }

    public void setPublicYear(Date publicYear) {
        this.publicYear = publicYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getDes() {
        return des;
    }
    public void setDes(String des) {
        this.des = des;
    }
}