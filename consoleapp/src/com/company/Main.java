package com.company;

import java.util.ArrayList;
import java.util.Scanner;

class Vector3D
{
    public float x;
    public float y;
    public float z;

    public Vector3D(float p_x, float p_y, float p_z)
    {
        x = p_x;
        y = p_y;
        z = p_z;
    }

    public Vector3D()
    {
        x = 0.0f;
        y = 0.0f;
        z = 0.0f;
    }

    public float length()
    {
        return (float)Math.sqrt(x*x + y*y + z*z);
    }

    public static int getDimensions()
    {
        return 3;
    }

    public String getString()
    {
        return String.format("(%.2f;%.2f;%.2f)", x,y,z);
    }

    public Vector3D add(Vector3D other)
    {
        Vector3D new_vec = new Vector3D();
        new_vec.x = this.x + other.x;
        new_vec.y = this.y + other.y;
        new_vec.z = this.z + other.z;

        return new_vec;
    }
    //В классе Vector3D сделать метод, который возвращает строку с вектором в отформатированном виде: (1.0,2.3,5.1)
    //Для создания строки использовать метод String.format который действует аналогично printf()
    //для вывода значений float использовать спецификатор %f

}


public class Main {

    public static void main(String[] args) {
        //System.out.printf("Argument count: %d\n", args.length);

        /*for (int i = 0; i < args.length; i++) {
            System.out.printf("%d: %s\n", i+1,args[i]);
        }*/
        ArrayList<Vector3D> vectors = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            String[] parts = args[i].split(";");
            vectors.add(new Vector3D(Float.parseFloat(parts[0]), Float.parseFloat(parts[1]), Float.parseFloat(parts[2])));
        }

        int length = vectors.size();

        for (int i = 0; i < length; i++) {
            System.out.printf("%d: %s, length = %f\n", i, vectors.get(i).getString(), vectors.get(i).length());
        }

        /*Vector3D vec10 = new Vector3D();
        vec10.x = Float.parseFloat(args[0]);
        vec10.y = Float.parseFloat(args[1]);
        vec10.z = Float.parseFloat(args[2]);
        System.out.println(vec10.getString());
        System.out.printf(" length = %f \n", vec10.length());

        Vector3D vec11 = new Vector3D();
        vec11.x = Float.parseFloat(args[3]);
        vec11.y = Float.parseFloat(args[4]);
        vec11.z = Float.parseFloat(args[5]);
        System.out.println(vec11.getString());
        System.out.printf(" length = %f \n", vec11.length());

        Vector3D res = vec10.add(vec11);
        System.out.println(res.getString());
        System.out.printf(" length = %f \n", res.length());

        /*Vector3D vec1 = new Vector3D();
        vec1.x = 3.1f;
        vec1.y = 5.3f;
        vec1.z = 1.0f;


        Vector3D vec2 = new Vector3D();
        vec2.x = 2.1f;
        vec2.y = 3.3f;
        vec2.z = 1.4f;

        System.out.println(vec1.getString());
        System.out.printf(" length = %f \n", vec1.length());
        Vector3D result = vec1.add(vec2);
        System.out.println(result.getString());

        System.out.println(vec2.getString());
        System.out.printf(" length = %f \n", vec2.length());

        Vector3D vec3 = new Vector3D();

        java.util.Scanner scan1 = new Scanner(System.in);

        System.out.print("Enter x: ");
        vec3.x = scan1.nextInt();

        System.out.print("Enter y: ");
        vec3.y = scan1.nextInt();

        System.out.print("Enter z: ");
        vec3.z = scan1.nextInt();

        System.out.println(vec3.getString());
        System.out.printf(" length = %f \n", vec3.length());*/}

    public static void Part1()
    {

        int a = 5;
        int b = 3;
        int c = a + b;

        System.out.println("Hello KTA-20V!");
        System.out.println(c);
        System.out.printf("%d + %d = %d\n", a, b, c);

        java.util.Scanner scan2 = new Scanner(System.in);
        System.out.print("Enter a: ");
        a = scan2.nextInt();

        System.out.print("Enter b: ");
        b = scan2.nextInt();

        System.out.printf("%d + %d = %d\n", a, b, a + b);
    }

}
