package model;

import java.io.Serializable;
import java.util.Vector;

public class Custumer implements Serializable {

    private int id;
    private String name;
    private String idCard;
    private String address;
    private String tel;
    private String email;
    private String note;

    public Custumer() {
    }

    public Custumer(int id, String name, String idCard, String address, String tel, String email, String note) {
        this.id = id;
        this.name = name;
        this.idCard = idCard;
        this.address = address;
        this.tel = tel;
        this.email = email;
        this.note = note;
    }

    public Custumer(Vector data) {
        this.id = Integer.parseInt(data.get(0) + "");
        this.name = data.get(1) + "";
        this.idCard = data.get(2) + "";
        this.address = data.get(3) + "";
        this.tel = data.get(4) + "";
        this.email = data.get(5) + "";
        this.note = data.get(6) + "";
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return name + " " + email + " " + id;
    }

}
