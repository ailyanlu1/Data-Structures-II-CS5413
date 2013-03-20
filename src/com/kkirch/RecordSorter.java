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
        Sorter sorter,
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

        List<Record> unsortedSublist = new ArrayList<Record>();
        
        for (int i = 0; i < numberOfRecords; ++i) {
            unsortedSublist.add(unsortedRecords.get(i));
            long startTime = System.nanoTime();
            sorter.sortList(unsortedSublist, comparator);
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

    

}