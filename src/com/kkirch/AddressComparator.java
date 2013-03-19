package com.kkirch;

import java.util.Comparator;

public class AddressComparator implements Comparator<Record> {
    public int compare(Record a, Record b) {
        if (a == null && b == null) {
            return 0;
        } else if (
            (a == null && b != null)
            || (a != null && b == null)) {
            return a == null ? 1 : -1;
        } else {
            int recordCompare = a.state.compareToIgnoreCase(b.state);
            if (recordCompare == 0) {
                recordCompare = a.city.compareToIgnoreCase(b.city);
            } 
            if (recordCompare == 0) {
                if (a.zipcode > b.zipcode) {
                    recordCompare = 1;
                } else if (a.zipcode < b.zipcode) {
                    recordCompare = -1;
                } else {
                    recordCompare = 0;
                }
            } 
            if (recordCompare == 0) {
                recordCompare = a.address.compareToIgnoreCase(b.address);
            } 
            return recordCompare;
        }
    }
}