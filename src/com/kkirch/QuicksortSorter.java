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
public class QuicksortSorter implements Sorter<Record> {

    public void sortList(List<Record> records, Comparator<Record> comparator) {
        sortList(records, comparator, 0, records.size() - 1);
    }

    private void sortList(List<Record> records, Comparator<Record> comparator, int left, int right) {
        if (left < right) {
            int pivotIndex = randPartition(records, comparator, left, right);
            sortList(records, comparator, left, pivotIndex - 1);
            sortList(records, comparator, pivotIndex + 1, right);
        }
    }

    private int randPartition(List<Record> records, Comparator<Record> comparator, int left, int right) {
        int randPivot = left + (int) (Math.random() * ((right - left) + 1));
        swap(records, right, randPivot);
        return partition(records, comparator, left, right);
    }

    private int partition(List<Record> records, Comparator<Record> comparator, int left, int right) {

        // Select pivot element
        Record pivot = records.get(right);

        int i = left - 1;
        for (int j = left; j < right; ++j) {
            int comparison = comparator.compare(records.get(j), pivot);
            if (comparison < 0) {
                i++;
                swap(records, i, j);
            }
        }

        // Move the pivot element in the middle of the array
        swap(records, i + 1, right);

        // Return the pivot element index
        return i + 1;
    }

    private void swap(List<Record> records, int a, int b) {
        Record temp = records.get(a);
        records.set(a, records.get(b));
        records.set(b, temp);
    }
}
