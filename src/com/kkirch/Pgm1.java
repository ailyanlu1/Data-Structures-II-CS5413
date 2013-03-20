package com.kkirch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;
import static java.util.Map.Entry;

public class Pgm1 {

    public static void main(String... args) throws Exception {
        
        Sorter<Record> sorter = new InsertionsortSorter();
        
        if (args.length != 1) {
            System.out.println("Invalid Usage -- please supply a filename as an argument");
            System.out.println("`java -jar pgm1-...jar 10.txt`");
        } else {
            String filename = args[0];
            //we have a filename, make sure file exists
            File file = new File(filename);
            if (!file.exists()) {
                System.out.println("The file you supplied doesn't seem to exist!");
            } else {
                //start processing
                System.out.println("Found file " + filename);

                String filename_number = filename.split("\\.")[0];

                RecordSorter recordSorter = new RecordSorter();

                String nameFileName = "name_" + filename;
                String lNameFileName = "lName_" + filename;
                Map<String, String> lNameSortPerformance = recordSorter.sortRecordsFromFileByKeyWithOutputFile(
                        filename, 
                        new LastNameComparator(), 
                        sorter,
                        lNameFileName);
                
                String fNameFileName = "fName_" + filename;
                Map<String, String> fNameSortPerformance = recordSorter.sortRecordsFromFileByKeyWithOutputFile(
                        lNameFileName, 
                        new FirstNameComparator(), 
                        sorter,
                        nameFileName);
                
                new File(lNameFileName).delete();


                File namePerformanceFile = new File("name_" + filename_number + "_time.txt");

                if (!namePerformanceFile.exists()) {
                    namePerformanceFile.createNewFile();
                }

                BufferedWriter bw = new BufferedWriter(new FileWriter(namePerformanceFile));
                for (Entry<String, String> entry : fNameSortPerformance.entrySet()) {
                    bw.write(String.format("%6s %s\n", entry.getKey(), entry.getValue()));
                }

                try {
                    bw.close();
                } catch (Exception e) {
                    System.out.println("Failed to close buffered writer");
                }


                String addressFileName = "address_" + filename;
                String stateFileName = "state_address_" + filename;
                String cityFileName = "city_address_" + filename;
                String zipFileName = "zip_address_" + filename;
                
                Map<String, String> stateSortPerformance = recordSorter.sortRecordsFromFileByKeyWithOutputFile(
                        nameFileName, 
                        new StateComparator(), 
                        sorter,
                        stateFileName);
                
                Map<String, String> citySortPerformance = recordSorter.sortRecordsFromFileByKeyWithOutputFile(
                        stateFileName, 
                        new CityComparator(), 
                        sorter,
                        cityFileName);
                
                Map<String, String> zipSortPerformance = recordSorter.sortRecordsFromFileByKeyWithOutputFile(
                        cityFileName, 
                        new ZipcodeComparator(), 
                        sorter,
                        zipFileName);
                
                Map<String, String> addressSortPerformance = recordSorter.sortRecordsFromFileByKeyWithOutputFile(
                        zipFileName, 
                        new AddressComparator(), 
                        sorter,
                        addressFileName);
                
                new File(stateFileName).delete();
                new File(cityFileName).delete();
                new File(zipFileName).delete();

                File addressPerformanceFile = new File("address_" + filename_number + "_time.txt");

                if (!addressPerformanceFile.exists()) {
                    addressPerformanceFile.createNewFile();
                }

                bw = new BufferedWriter(new FileWriter(addressPerformanceFile));
                for (Entry<String, String> entry : addressSortPerformance.entrySet()) {
                    bw.write(String.format("%6s %s\n", entry.getKey(), entry.getValue()));
                }

                try {
                    bw.close();
                } catch (Exception e) {
                    System.out.println("Failed to close buffered writer");
                }
            }
        }
    }
}