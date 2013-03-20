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
public interface Sorter<T> {
    void sortList(List<T> records, Comparator<T> comparator);
}
