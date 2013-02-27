
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RecordSorter {

    public Map<String,String> sortRecordsFromFileByKeyWithOutputFile(
        String inFileName, 
        String recordKey,
        String outFileName) throws FileNotFoundException, IOException {

        Map<String,String> performanceData = new HashMap<String,String>();

        File inFile = new File(inFileName);
        File outFile = new File(outFileName);

        BufferedReader br = new BufferedReader(new FileReader(inFile));

        int numberOfRecords = Integer.parseInt(br.readLine());

        int currentLine = 0;
        String line;
        while((line = br.readLine()) != null) {
            currentLine++;
            Record r = new Record(line);
            
        }

        try {
            br.close();
        } catch (Exception e) {
            System.out.println("Failed to close buffered reader");
        }

        return performanceData;
    }
}