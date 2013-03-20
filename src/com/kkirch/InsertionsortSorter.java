/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kkirch;

import java.util.Comparator;
import java.util.List;

/**
 *
 * @author kkirch
 */
public class InsertionsortSorter implements Sorter<Record> {

    public void sortList(List<Record> records, Comparator<Record> comparator) {
        int j;
        Record key;
        int i;

        for (j = 1; j < records.size(); j++)
        {
            key = records.get(j);
            for (i = j - 1; (i >= 0) && comparator.compare(key, records.get(i)) < 0; i--) 
            {
                records.set(i + 1, records.get(i));
            }

            records.set(i + 1, key);
        }
    }
}
