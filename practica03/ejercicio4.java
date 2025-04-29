package practica03;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;

/**
 *
 * @author daniellopesp
 */
public class ejercicio4 {
    static Scanner Scanear = new Scanner(System.in);
    public static void main(String[]args){

       
       System.out.print("Cuantos euros quieres convertir: ");
       double Euros = Scanear.nextDouble();
       double conversionDolar;
       conversionDolar = 1.10;
       //Nombre
       System.out.println("La cantidad de dolares es de "+(Euros * conversionDolar));
    }
}
