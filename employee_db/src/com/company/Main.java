package com.company;

import java.time.LocalDate;

public class Main {
    public static void CreateEmployees()
    {
        Employee e = new Employee("Vasya", "Pupkin", LocalDate.of(1990, 1, 1));

        e.setFirstName("");
    }

    public static void main(String[] args) {
        try
        {
            DatabaseApplication app = new DatabaseApplication();
            app.Setup();
            app.Run();
        }
        catch (Exception e)
        {
            //System.out.println("Error: "+e.toString());
            e.printStackTrace();
        }
    }
}
