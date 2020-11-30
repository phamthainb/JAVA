package bai7.sort;

import bai7.Subject;

import java.util.Comparator;

public class SortByCredits implements Comparator<Subject> {
    public int compare(Subject p1, Subject p2){
        return (int)(p2.getCredits() - p1.getCredits());
    }
}
