package com.company;


public class Main {

    public static void main(String[] args) {
        try
        {
            AnimalsDatabaseApplication app = new AnimalsDatabaseApplication();
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