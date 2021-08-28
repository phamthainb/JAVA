package model;
import java.io.Serializable;
import java.util.Date;
 
public class User implements Serializable{
    private int id;
    private String name;
    private String address;
    private String role;
    private Date dateOfBirth;
    private int gender;
    private String username;
    private String password;

    public User(String name, String address, String role, Date dateOfBirth, int gender, String username, String password, String IDcard) {
        this.name = name;
        this.address = address;
        this.role = role;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.IDcard = IDcard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIDcard() {
        return IDcard;
    }

    public void setIDcard(String IDcard) {
        this.IDcard = IDcard;
    }
    private String IDcard;
     
    public User() {
        super();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}