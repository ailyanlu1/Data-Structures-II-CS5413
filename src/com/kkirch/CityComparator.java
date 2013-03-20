package com.kkirch;

import java.util.Comparator;

public class CityComparator implements Comparator<Record> {

    public int compare(Record a, Record b) {
        if (a == null && b == null) {
            return 0;
        } else if ((a == null && b != null)
                || (a != null && b == null)) {
            return a == null ? 1 : -1;
        } else {
            return a.city.compareToIgnoreCase(b.city);
        }
    }
}