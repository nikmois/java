package com.company;

import com.company.ConsoleMenuApp;
import com.company.Employee;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatabaseApplication extends ConsoleMenuApp
{
    ArrayList<Employee> employees;

    public DatabaseApplication()
    {
        employees = new ArrayList<>();
    }

    public ArrayList<Employee> LoadFile(String filename) throws IOException {
        // Создаём объект типа "файл"
        File file = new File("employees.txt");
        // Создаём поток чтения из файла
        BufferedReader reader = new BufferedReader(new FileReader(file));

        ArrayList<Employee> employees = new ArrayList<>();

        String s;
        // Читаем до тех пор, пока не дошли до конца файла (readLine() не вернул null)
        while((s = reader.readLine()) != null)
        {
            // Пилим строчку на компоненты по разделителю
            String[] parts = s.split(",");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

            Employee e = new Employee(parts[0], parts[1], LocalDate.parse(parts[2],formatter));
            e.setSalary(Double.parseDouble(parts[3]));
            employees.add(e);
        }

        reader.close();

        return employees;
    }

    public void Insert()
    {
        try
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter employee data");
            System.out.println("===================");
            System.out.print("First name: ");
            String first_name = scanner.next();

            System.out.print("Last name: ");
            String last_name = scanner.next();

            System.out.print("Birthday: ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate birthday = LocalDate.parse(scanner.next(),formatter);
            //new SimpleDateFormat("dd.MM.yyyy").parse(scanner.next());

            System.out.print("Salary: ");
            double salary = scanner.nextDouble();

            Employee e = new Employee(first_name,last_name,birthday);
            e.setSalary(salary);

            employees.add(e);

            System.out.println();
        }
        catch (Exception e)
        {
            System.out.println("Error :"+e.getMessage());
        }
    }

    public void PrintData()
    {
        System.out.println("Employee list");
        System.out.println("=============");
        if(employees.isEmpty())
            System.out.println("Employee list is empty!");

        for (Employee e : employees)
        {
            System.out.println("ID: "+e.getID());
            System.out.println("First name: "+e.getFirstName());
            System.out.println("Last name: "+e.getLastName());
            System.out.println("Birthday: "+e.getBirthday());
            if(e.getSalary() > 0.0)
                System.out.println("Salary: "+e.getSalary());
            System.out.println(" ");
        }
    }

    public void DeleteEmployee()
    {
        if(employees.isEmpty())
        {
            System.out.println("Employee list is empty");
            System.out.println(" ");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Print user ID to delete: ");
        int EmployeeToDelete = scanner.nextInt();

        for (int i = 0; i < employees.size(); i++)
        {
            if(employees.get(i).getID() == EmployeeToDelete)
            {
                employees.remove(i);
            }
        }
        System.out.println("Deleted employee with ID: "+ EmployeeToDelete);
        System.out.println(" ");
    }

    public void ChangeEmployee()
    {
        if(employees.isEmpty())
        {
            System.out.println("Employee list is empty");
            System.out.println(" ");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Print user ID to change: ");
        int EmployeeToChange = scanner.nextInt();
        for (int i = 0; i < employees.size(); i++)
        {
            if(employees.get(i).getID() == EmployeeToChange) {
                System.out.println("Choose what you want to change");
                System.out.println("1. First name");
                System.out.println("2. Last name");
                System.out.println("3. Birthday");
                System.out.print("\nChoose an operation: ");

                String new_name = scanner.next();

                switch (new_name) {
                    case "1":
                        System.out.print("Enter new first name: ");
                        String name = scanner.next();
                        employees.get(i).setFirstName(name);
                        System.out.println("New first name is " + name);
                        System.out.println(" ");
                        break;
                    case "2":
                        System.out.print("Enter new last name: ");
                        String lastname = scanner.next();
                        employees.get(i).setLastName(lastname);
                        System.out.println("New last name is " + lastname);
                        System.out.println(" ");
                        break;
                    case "3":
                        System.out.print("Enter new birthday: ");
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                        LocalDate birthday = LocalDate.parse(scanner.next(), formatter);
                        employees.get(i).setBirthday(birthday);
                        System.out.println("New birthday " + birthday);
                        System.out.println(" ");
                        break;
                    case "4":
                        System.out.print("Enter employee salary: ");
                        Double salary = scanner.nextDouble();
                        employees.get(i).setSalary(salary);
                        System.out.println("Employee salary is " + salary);
                        System.out.println(" ");
                    default:
                        System.out.println("Unknown operation.");
                        System.out.println(" ");
                        break;
                }
                return;
            }
        }
        System.out.println("User with this ID doesn't exist");
    }

    void TestData()
    {
        Employee e = new Employee("Klava", "Braim", LocalDate.of(1945, 1, 16));
        e.setSalary(5000);

        employees.add(e);

        e = new Employee("Borya", "Drozdov", LocalDate.of(1997, 4, 14));
        e.setSalary(800);

        employees.add(e);

        e = new Employee("Mike", "Sand", LocalDate.of(2001, 7, 24));
        e.setSalary(500);

        employees.add(e);
    }

    @Override
    public void AppSetup() throws Exception
    {
        // Регистрируем записи в меню
        RegisterMenuItem("Insert entry", this::Insert);
        RegisterMenuItem("View employee list", this::PrintData);
        RegisterMenuItem("Add test data", this::TestData);
        RegisterMenuItem("Remove employee data", this::DeleteEmployee);
        RegisterMenuItem("Change employee data", this::ChangeEmployee);


        employees = LoadFile("employees.txt");
    }

    @Override
    public void AppExit() throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to save file?");
        System.out.println("Y/N");
        String answer = scanner.next();
        if(answer.equals("Y") || answer.equals("y")) {
            BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt"));

            for (Employee e : employees) {
                String date = String.format("%02d.%02d.%4d", e.Birthday.getDayOfMonth(), e.Birthday.getMonthValue(), e.Birthday.getYear());
                writer.write(e.FirstName+","+e.LastName+","+date+","+e.Salary);
                writer.write("\n");
            }

            writer.close();
        }
    }

    /*public void Run()
    {
        boolean running = true;

        Scanner scanner = new Scanner(System.in);

        // cycle is running until, "running" is true
        while(running)
        {
            System.out.println("MENU");
            System.out.println("================");
            System.out.println("1. Insert entry");
            System.out.println("2. View employee list");
            System.out.println("3. Delete employee");
            System.out.println("4. Change employee data");
            System.out.println("5. Exit");
            System.out.print("\nChoose an operation: ");
            String op = scanner.next();

            switch(op)
            {
                case "1": Insert(); break;
                case "2": PrintData(); break;
                case "3": DeleteEmployee(); break;
                case "4": ChangeEmployee(); break;
                case "5":
                    System.out.println("EXIT");
                    running = false; break;
                default:
                    System.out.println("Unknown operation.");
                    break;
            }
        }
    }*/
}