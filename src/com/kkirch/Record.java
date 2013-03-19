package com.kkirch;

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