package com.kkirch.generator;

import java.util.Random;

public class AddressGenerator {

    Random r = new Random();

    String[] streetNames = new String[]{
        "Washington",
        "Regina",
        "Pine",
        "Rainy",
        "Bluff",
        "Wall",
        "Lancer",
        "Walker",
        "Penn",
        "Council",
        "Rockwell",
        "Hefner"
    };

    String[] streetSuffixes = new String[]{
        "Pl.",
        "St.",
        "Way",
        "Ave.",
        "Blvd."
    };

    String[] cities = new String[]{
        "Mobile",
        "Tucson",
        "Knoxville",
        "Daytona Beach",
        "Grand Rapids",
        "Stockton",
        "San Antonio",
        "Fresno",
        "Louisville",
        "Norfolk-Virginia Beach",
        "Charlotte",
        "Charleston",
        "New Orleans",
        "Columbia",
        "Raleigh",
        "Harrisburg",
        "Scranton",
        "Rochester",
        "Nashville",
        "Toledo",
        "Las Vegas",
        "Richmond",
        "Boise City",
        "Cincinnati",
        "Providence",
        "Tulsa",
        "Columbus",
        "Oklahoma City",
        "Greenville",
        "Little Rock",
        "Kansas City",
        "Omaha",
        "Dayton",
        "Sarasota-Bradenton",
        "Tampa",
        "Memphis",
        "Baton Rouge",
        "Miami",
        "Youngstown",
        "Austin",
        "Syracuse"
    };

    String[] states = new String[]{
        "AL",
        "AK",
        "AZ",
        "AR",
        "CA",
        "CO",
        "CT",
        "DE",
        "FL",
        "GA",
        "HI",
        "ID",
        "IL",
        "IN",
        "IA",
        "KS",
        "KY",
        "LA",
        "ME",
        "MD",
        "MA",
        "MI",
        "MN",
        "MS",
        "MO",
        "MT",
        "NE",
        "NV",
        "NH",
        "NJ",
        "NM",
        "NY",
        "NC",
        "ND",
        "OH",
        "OK",
        "OR",
        "PA",
        "RI",
        "SC",
        "SD",
        "TN",
        "TX",
        "UT",
        "VT",
        "VA",
        "WA",
        "WV",
        "WI",
        "WY"
    };

    public String generateAddress() {
        String address = (r.nextInt(15000) + 1) + " ";
        switch (r.nextInt(4)) {
            case 0:
            address += "N. ";
            break;
            case 1:
            address += "S. ";
            break;
            case 2:
            address += "W. ";
            break;
            case 3:
            address += "E. ";
            break;
        }
        address += streetNames[r.nextInt(streetNames.length)] + " ";
        address += streetSuffixes[r.nextInt(streetSuffixes.length)];

        if (r.nextBoolean()) {
            address += " #" + r.nextInt(100);
        }

        return address;
    }

    public String generateCity() {
        return cities[r.nextInt(cities.length)];
    }

    public int generateZipCode() {
        return 70000 
            + 5000 
            + r.nextInt(10) * 100 
            + r.nextInt(10) * 10 
            + r.nextInt(10); 
    }

    public String generateState() {
        return states[r.nextInt(states.length)];
    }

}