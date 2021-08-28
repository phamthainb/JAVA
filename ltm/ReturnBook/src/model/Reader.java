/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author admin
 */
public class Reader implements Serializable{
    private int id;
    private String name;
    private String address;
    private String type;
    private Date dateOfBirth;
    private String IDcard;
    private int gender;
    private Date dateActiveCard;
    private String cardNumber= "";

    public Reader(String name, String address, String type, Date dateOfBirth, String IDcard, int gender, Date dateActiveCard, String cardNumber) {
        super();
        this.name = name;
        this.address = address;
        this.type = type;
        this.dateOfBirth = dateOfBirth;
        this.IDcard = IDcard;
        this.gender = gender;
        this.dateActiveCard = dateActiveCard;
        this.cardNumber = cardNumber;
    }

    public Reader() {
        super();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIDcard() {
        return IDcard;
    }

    public void setIDcard(String IDcard) {
        this.IDcard = IDcard;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getDateActiveCard() {
        return dateActiveCard;
    }

    public void setDateActiveCard(Date dateActiveCard) {
        this.dateActiveCard = dateActiveCard;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    /**
     * Get the value of type
     *
     * @return the value of type
     */
    public String getType() {
        return type;
    }

    /**
     * Set the value of type
     *
     * @param type new value of type
     */
    public void setType(String type) {
        this.type = type;
    }
}
