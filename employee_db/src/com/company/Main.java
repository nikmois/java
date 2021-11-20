package com.company;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // Ранний тест для объектов класса Employee, больше не нужен
    /*public static void CreateEmployees()
    {
        Employee e = new Employee("Vasya", "Pupkin", LocalDate.of(1990, 1, 1));

        e.setFirstName("");
    }*/

    public static void main(String[] args) {
        try
        {
//            // Создаём объект типа "файл"
//            File file = new File("employees.txt");
//            // Создаём поток чтения из файла
//            BufferedReader reader = new BufferedReader(new FileReader(file));
//
//            List<Employee> employees = new ArrayList<>();
//
//            String s;
//            // Читаем до тех пор, пока не дошли до конца файла (readLine() не вернул null)
//            while((s = reader.readLine()) != null)
//            {
//                // Пилим строчку на компоненты по разделителю
//                String[] parts = s.split(",");
//
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//
//                Employee e = new Employee(parts[0], parts[1], LocalDate.parse(parts[2],formatter));
//                e.setSalary(Double.parseDouble(parts[3]));
//                employees.add(e);
//
//                //System.out.println(s);
//            }
//
//            reader.close();

//            BufferedWriter writer = new BufferedWriter(new FileWriter("employees-detail.txt"));
//
//            for (Employee e : employees) {
//                writer.write("First name: "+e.FirstName+"\n");
//                writer.write("Last name: "+e.LastName+"\n");
//                writer.write("Birthday: "+e.Birthday+"\n");
//                writer.write("Salary: "+e.Salary+"\n");
//                writer.write("\n");
//            }
//
//            writer.close();

            // Инстанцируем класс "приложение"
            DatabaseApplication app = new DatabaseApplication();
            // Производим его настройку (добавление записей в меню)
            app.Setup();
            // Запускаем основной цикл
            app.Run();
        }
        // Если возникает исключение, не отловленное ниже по уровню - выводим трассировку стэка вызовов, чтобы
        // понять, где в коде возникла ошибка
        catch (Exception e)
        {
            //System.out.println("Error: "+e.toString());
            e.printStackTrace();
        }
    }
}
