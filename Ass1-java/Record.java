
import java.lang.reflect.Field;

public class Record {
    public final String lastName;
    public final String firstName;
    public final String address;
    public final String city;
    public final String state;
    public final int zipcode;

    public Record(String delimitedString) {
        String[] parts = delimitedString.split(" \\| ");
        String name = parts[0];
        String[] nameParts = name.split(" ");
        firstName = nameParts[0];
        lastName = nameParts[1];
        address = parts[1];
        city =  parts[2];
        state = parts[3];
        zipcode = Integer.parseInt(parts[4]);
    }

    public static int compareRecordsWithKey(Record r1, Record r2, String key) {
        try {
            Field field = Record.class.getDeclaredField(key);

            if ("zipcode".equals(key)) {
                //special things for int field
                return field.getInt(r1) - field.getInt(r2);
            } else {
                String keyVal1 = (String)field.get(r1);
                String keyVal2 = (String)field.get(r2);
                return keyVal1.compareToIgnoreCase(keyVal2);
            }
        } catch (Exception e) {
            throw new RuntimeException("Shouldn't ever reach here...");
        }

    }

    public String toDelimitedString() {
        return new StringBuilder()
            .append(firstName).append(" ").append(lastName)
            .append(" | ")
            .append(address)
            .append(" | ")
            .append(city)
            .append(" | ")
            .append(state)
            .append(" | ")
            .append(zipcode).toString();

    }

    @Override
    public String toString() {
        return new StringBuilder()
            .append("Record = {")
            .append("First Name : ").append(firstName)
            .append(", Last Name : ").append(lastName)
            .append(", Address : ").append(address)
            .append(", City : ").append(city)
            .append(", State : ").append(state)
            .append(", Zipcode : ").append(zipcode)
            .append(" }").toString();
    }
}