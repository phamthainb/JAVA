/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class Driver implements Serializable {
    private int id;
    private String name;
    private String address;
    private String level;
    private static int sId = 10000;

    public Driver() {
        this.id = sId++;
    }

    public Driver(String name, String address, String level) {
        this.id = sId++;
        this.name = name;
        this.address = address;
        this.level = level;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(St/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class Driver implements Serializable {
    private int id;
    private String name;
    private String address;
    private String level;
    private static int sId = 10000;

    public Driver() {
        this.id = sId++;
    }

    public Driver(String name, String address, String level) {
        this.id = sId++;
        this.name = name;
        this.address = address;
        this.level = level;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public static int getsId() {
        return sId;
    }

    public static void setsId(int sId) {
        Driver.sId = sId;
    }
    
}
