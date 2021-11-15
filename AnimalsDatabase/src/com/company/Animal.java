package com.company;

import java.security.InvalidParameterException;

public class Animal {
    private int ID;
    protected String CommonName;
    protected String ScientificName;
    protected int Age;
    protected String ConservationStatus;

    private static int NextID = 1;

    public Animal(String common_name, String scientific_name, int age, String conservation_status)
    {
        ID = NextID++;
        setCommonName(common_name);
        setScientificName(scientific_name);
        setAge(age);
        setStatus(conservation_status);
    }

    public int getID() { return ID; }
    public String getCommonName() { return CommonName; }
    public String getScientificName() { return ScientificName; }
    public int getAge() { return Age; }
    public String getStatus() { return ConservationStatus; }

    public void setCommonName(String common_name)
    {
        if(common_name.length() == 0) { throw new InvalidParameterException("Empty common name parameter"); }
        CommonName = common_name;
    }

    public void setScientificName(String scientific_name)
    {
        if(scientific_name.length() == 0) { throw new InvalidParameterException("Empty scientific name parameter"); }
        ScientificName = scientific_name;
    }

    public void setAge(int age)
    {
        Age = age;
    }

    public void setStatus(String conservation_status)
    {
        if(conservation_status.length() == 0) { throw new InvalidParameterException("Empty conservation status parameter"); }
        ConservationStatus = conservation_status;
    }
}
