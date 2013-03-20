package com.kkirch;

import java.util.Comparator;

public class LastNameComparator implements Comparator<Record> {
    public int compare(Record a, Record b) {
        if (a == null && b == null) {
            return 0;
        } else if (
            (a == null && b != null)
            || (a != null && b == null)) {
            return a == null ? 1 : 0;
        } else {
            return a.lastName.compareToIgnoreCase(b.lastName);
        }
    }
}