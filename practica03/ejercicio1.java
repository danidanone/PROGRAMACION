/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica03;

import java.util.Scanner;

/**
 *
 * @author daniellopesp
 */
public class ejercicio1 {
    static Scanner Scanear = new Scanner(System.in);
    public static void main(String[]args){
       Scanear.useDelimiter("\n");
       int X;
       X = Scanear.nextInt();
       int Y;
       Y = Scanear.nextInt();
       //Suma
       System.out.println("el valor a mostrar "+ (X + Y));
       //Resta
       System.out.println("el valor a mostrar "+ (Y - X));
       //Multiplicacion
       System.out.println("el valor a mostrar "+ (Y * X));
       //Division
       System.out.println("el valor a mostrar "+ (Y / X));
       
    }
}
