
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

public class pgm1 {
    public static void main(String ... args) throws Exception {
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
                RecordSorter sorter = new RecordSorter();

                String lastNameFileName = "lastName_" + filename;
                Map<String,String> lastNameSortPerformance = sorter.sortRecordsFromFileByKeyWithOutputFile(filename,
                    "lastName", lastNameFileName);


            }
        }
    }
}
