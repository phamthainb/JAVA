package bai7;

import java.io.Serializable;
import java.util.Vector;

public class Subject implements Serializable {
    private int id, credits;
    private String name, type;

    public Subject() {
        id = 1000;
    }

    public Subject(int id, String name, String type, int credits) {
        this.id = id;
        this.credits = credits;
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
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

    public String toString() {
        return "" + id + " - " + name + " - " + type + " - " + credits;
    }

    public Vector<String> toVector(Subject subject) {
        Vector<String> vector = new Vector<>();
        vector.add(String.valueOf(subject.id));
        vector.add(subject.name);
        vector.add(subject.type);
        vector.add(String.valueOf(subject.credits));
        return vector;
    }
}
