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
}