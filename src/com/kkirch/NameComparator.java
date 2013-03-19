package com.kkirch;

import java.util.Comparator;

public class NameComparator implements Comparator<Record> {
    public int compare(Record a, Record b) {
        if (a == null && b == null) {
            return 0;
        } else if (
            (a == null && b != null)
            || (a != null && b == null)) {
            return a == null ? 1 : 0;
        } else {
            int recordCompare = a.lastName.compareToIgnoreCase(b.lastName);
            if (recordCompare == 0) {
                recordCompare = a.firstName.compareToIgnoreCase(b.firstName);
            } 
            return recordCompare;
        }
    }
}