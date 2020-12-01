package bai7.sort;

import bai7.Subject;

import java.util.Comparator;

public class SortById implements Comparator<Subject> {
    public int compare(Subject p1, Subject p2){
        return p1.getId() - p2.getId();
    }
}
