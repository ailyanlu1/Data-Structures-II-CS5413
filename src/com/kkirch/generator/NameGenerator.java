package com.kkirch.generator;

import java.util.Random;

public class NameGenerator {
    Random r = new Random();

    String[] names = new String[]{
        "Arlette",
        "Justa",
        "Christena",
        "Annis",
        "Simon",
        "Annamaria",
        "Roxanna",
        "Mabelle",
        "Keven",
        "Kati",
        "Isabell",
        "Estela",
        "Zofia",
        "Latosha",
        "Maire",
        "Shawnda",
        "Sid",
        "Mitzie",
        "Hong",
        "Danica",
        "Kasandra",
        "Maryann",
        "Elda",
        "Cristi",
        "Bruna",
        "Rigoberto",
        "Robbie",
        "Omega",
        "Andrew",
        "Delilah",
        "Shanel",
        "Debroah",
        "Elizabeth",
        "Margert",
        "Ramona",
        "Susan",
        "Darla",
        "Kari",
        "Francesco",
        "Jesenia",
        "Wiley",
        "Siu",
        "Myriam",
        "Kizzie",
        "Lily",
        "Emiko",
        "Regena",
        "Scarlet",
        "Mariana",
        "Marva"
    };

    public String generateName() {
        return names[r.nextInt(names.length)];
    }
}