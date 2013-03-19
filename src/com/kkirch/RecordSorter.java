package com.kkirch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RecordSorter {

    public Map<String,String> sortRecordsFromFileByKeyWithOutputFile(
        String inFileName, 
        Comparator<Record> comparator,
        String outFileName) throws FileNotFoundException, IOException {

        Map<String,String> performanceData = new LinkedHashMap<String,String>();

        File inFile = new File(inFileName);
        File outFile = new File(outFileName);

        BufferedReader br = new BufferedReader(new FileReader(inFile));
        List<Record> unsortedRecords = new ArrayList<Record>();
        List<Record> sortedRecords = null;

        int numberOfRecords = Integer.parseInt(br.readLine());

        String line;
        while((line = br.readLine()) != null) {
            Record r = new Record(line);
            unsortedRecords.add(r);
        }

        try {
            br.close();
        } catch (Exception e) {
            System.out.println("Failed to close buffered reader");
        }

        for (int i = 0; i < numberOfRecords; ++i) {
            List<Record> unsortedSublist = new ArrayList<Record>(unsortedRecords.subList(0, i + 1));
            long startTime = System.nanoTime();
            sortList(unsortedSublist, comparator);
            //unsortedSublist now sorted...
            long endTime = System.nanoTime();
            long totalTime = (endTime - startTime) / 1000; //convert to microseconds
            performanceData.put((i + 1) + "", totalTime + "");
            if ((i + 1) == numberOfRecords) {
                sortedRecords = new ArrayList<Record>(unsortedSublist);
            }
        }

        //write to disk

        if (!outFile.exists()) {
            outFile.createNewFile();
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
        bw.write(String.format("%d%n",numberOfRecords));
        for (Record r : sortedRecords) {
            bw.write(String.format("%s%n", r.toDelimitedString()));
        }

        try {
            bw.close();
        } catch (Exception e) {
            System.out.println("Failed to close buffered writer");
        }


        return performanceData;
    }

    private void sortList(List<Record> records, Comparator<Record> comparator) {
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
        int randPivot =  left + (int)(Math.random() * ((right - left) + 1));
        swap(records, right, randPivot);
        return partition(records, comparator, left, right);
    }

    private int partition(List<Record> records, Comparator<Record> comparator, int left, int right) {
 
        // Select pivot element
        Record pivot = records.get(right);
 
        int i = left - 1;
        for(int j = left; j < right; ++j) {
            int comparison = comparator.compare(records.get(j), pivot);
            if(comparison < 0) {
                i++;
                swap(records, i, j);
            }
        }
 
        // Move the pivot element in the middle of the array
        swap(records, i + 1, right);
 
        // Return the pivot element index
        return i + 1;
    }
 
    private void swap(List<Record> records, int a, int b ) {
        Record temp = records.get(a);
        records.set(a, records.get(b));
        records.set(b, temp);
    }

}