package com.kkirch.generator;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import com.kkirch.Record;

public class RecordGenerator {
    public static void main(String ... args) throws Exception {
        if (args.length != 1) {
            System.out.println("Invalid Usage -- please supply the number of records to generate");
            System.out.println("`java -cp pgm1-...jar com.kkirch.generator.RecordGenerator 500`");
        } else {
            int numberOfRecords = Integer.parseInt(args[0]);

            List<Record> records = new ArrayList<Record>();

            NameGenerator nameGenerator = new NameGenerator();
            AddressGenerator addressGenerator = new AddressGenerator();

            for (int i = 0; i < numberOfRecords; ++i) {
                Record r = new Record(nameGenerator.generateName(),
                    nameGenerator.generateName(),
                    addressGenerator.generateAddress(),
                    addressGenerator.generateCity(),
                    addressGenerator.generateState(),
                    addressGenerator.generateZipCode());
                records.add(r);
            }

            String outFile = numberOfRecords + ".txt";

            BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
            bw.write(String.format("%d%n",numberOfRecords));
            for (Record r : records) {
                bw.write(String.format("%s%n", r.toDelimitedString()));
            }

            try {
                bw.close();
            } catch (Exception e) {
                System.out.println("Failed to close buffered writer");
            }
        }
    }
}