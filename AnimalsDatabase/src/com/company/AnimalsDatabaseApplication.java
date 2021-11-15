package com.company;


import java.util.ArrayList;
import java.util.Scanner;

public class AnimalsDatabaseApplication extends ConsoleMenuApp
{
    ArrayList<Animal> animals;

    public AnimalsDatabaseApplication()
    {
        animals = new ArrayList<>();
    }

    public void Insert()
    {
        try
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter animal data");
            System.out.println("===================");
            System.out.print("Common name: ");
            String common_name = scanner.next();

            System.out.print("Scientific name: ");
            String scientific_name = scanner.next();

            System.out.print("Age: ");
            int age = scanner.nextInt();

            System.out.print("Conservation status: ");
            String conservation_status = scanner.next();

            Animal e = new Animal(common_name, scientific_name, age, conservation_status);

            animals.add(e);

            System.out.println();
        }
        catch (Exception e)
        {
            System.out.println("Error :"+e.getMessage());
        }
    }

    public void PrintData()
    {
        System.out.println("Animals list");
        System.out.println("=============");
        if(animals.isEmpty())
            System.out.println("Animals list is empty!");

        for (Animal e : animals)
        {
            System.out.println("ID: "+e.getID());
            System.out.println("Common name: "+e.getCommonName());
            System.out.println("Scientific name: "+e.getScientificName());
            System.out.println("Age: "+e.getAge());
            System.out.println("Conservation status: "+e.getStatus());
            System.out.println(" ");
        }
    }

    public void DeleteAnimal()
    {
        if(animals.isEmpty())
        {
            System.out.println("Animals list is empty");
            System.out.println(" ");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Print animal ID to delete: ");
        int AnimalToDelete = scanner.nextInt();

        animals.removeIf(x -> x.getID() == AnimalToDelete);

        System.out.println("Deleted animal with ID: "+ AnimalToDelete);
        System.out.println(" ");
    }

    public void ChangeAnimal() {
        if (animals.isEmpty()) {
            System.out.println("Animals list is empty");
            System.out.println(" ");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Print animal ID to change: ");
        int AnimalToChange = scanner.nextInt();
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getID() == AnimalToChange) {
                System.out.println("Choose what you want to change");
                System.out.println("1. Common name");
                System.out.println("2. Scientific name");
                System.out.println("3. Age");
                System.out.println("4. Conservation status");
                System.out.print("\nChoose an operation: ");
                String new_name = scanner.next();

                switch (new_name) {
                    case "1":
                        System.out.print("Enter new common name: ");
                        String common_name = scanner.next();
                        animals.get(i).setCommonName(common_name);
                        System.out.println("New common name is " + common_name);
                        System.out.println(" ");
                        break;
                    case "2":
                        System.out.print("Enter new scientific name: ");
                        String scientific_name = scanner.next();
                        animals.get(i).setScientificName(scientific_name);
                        System.out.println("New scientific name is " + scientific_name);
                        System.out.println(" ");
                        break;
                    case "3":
                        System.out.print("Enter new age: ");
                        int age = scanner.nextInt();
                        animals.get(i).setAge(age);
                        System.out.println("New age is " + age);
                        System.out.println(" ");
                        break;
                    case "4":
                        System.out.print("Enter conservation status: ");
                        String status = scanner.next();
                        animals.get(i).setStatus(status);
                        System.out.println("Employee salary is " + status);
                        System.out.println(" ");
                    default:
                        System.out.println("Unknown operation.");
                        System.out.println(" ");
                        break;
                }
                return;
            }
        }
        System.out.println("Animal with this ID doesn't exist");
    }



    void TestData()
    {
        Animal e = new Animal("Amur Leopard", "Panthera pardus orientalis", 15, "Critically endangered");
        animals.add(e);

        e = new Animal("Whale", "Balaenoptera",35, "Endangered");
        animals.add(e);

        e = new Animal("Hippopotamus", "Hippopotamus amphibius", 9, "Vulnerable");
        animals.add(e);
    }

    @Override
    public void AppSetup() throws Exception
    {
        RegisterMenuItem("Insert entry", (ConsoleMenuApp)->{ Insert(); return null; });
        RegisterMenuItem("View animals list", (ConsoleMenuApp)->{ PrintData(); return null; });
        RegisterMenuItem("Insert test data", (ConsoleMenuApp)->{ TestData(); return null; });
        RegisterMenuItem("Delete animal data", (ConsoleMenuApp)->{ DeleteAnimal(); return null; });
        RegisterMenuItem("Change animal data", (ConsoleMenuApp)->{ ChangeAnimal(); return null; });
    }

}