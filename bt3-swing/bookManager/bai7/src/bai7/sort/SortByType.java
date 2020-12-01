package bai7.sort;

import bai7.Subject;

import java.util.Comparator;

public class SortByType implements Comparator<Subject> {
    public int compare(Subject p1, Subject p2){
        return p1.getType().compareTo(p2.getType());
    }
}
