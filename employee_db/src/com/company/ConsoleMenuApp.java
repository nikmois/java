package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

class MenuItem
{
    public char Symbol;
    public String Caption;
    public Runnable Operation;

    public MenuItem(char symbol, String caption, Runnable operation)
    {
        Symbol = symbol;
        Caption = caption;
        Operation = operation;
    }
}

public class ConsoleMenuApp {
    private boolean Running = true;
    private ArrayList<MenuItem> MenuItems = new ArrayList<>();
    private char NextSymbol = '1';
    private Scanner Scan = new Scanner(System.in);

    protected void RegisterMenuItem(String caption, Runnable func) throws Exception
    {
        MenuItems.add(new MenuItem(NextSymbol, caption, func));

        if(NextSymbol == '9') NextSymbol = 'a';
        else if(NextSymbol > 'z')
            throw new Exception("Maximum amount of menu operations reached");
        else ++NextSymbol;
    }

    protected void Exit()
    {
        System.out.println("Exiting...");
        Running = false;
    }

    public void Setup() throws Exception
    {
        // Добавляем операции
        AppSetup();

        RegisterMenuItem("Exit", this::Exit);
    }

    public void AppSetup() throws Exception
    {

    }

    public void AppExit() throws Exception
    {

    }

    public void Run() throws Exception
    {
        while (Running)
        {
            DisplayMenu();
            HandleOperation();
        }
        AppExit();
    }

    public void DisplayMenu()
    {
        System.out.println("Menu");
        System.out.println("====");

        for (MenuItem item : MenuItems)
        {
            System.out.printf("%c. %s\n", item.Symbol, item.Caption);
        }
    }

    public void HandleOperation()
    {
        System.out.print("\nChoose an operation: ");
        String op = Scan.next();

        if(op.length() == 0) return;

        char sym = op.charAt(0);

        MenuItem found_item = null;

        for (MenuItem item : MenuItems)
        {
            if(item.Symbol == sym)
            {
                found_item = item;
                break;
            }
        }

        if(found_item != null) found_item.Operation.run();
        else System.out.println("Unknown operation");

        System.out.println();
    }
}
