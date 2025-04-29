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
public class ejercicio3 {
    static Scanner Scanear = new Scanner(System.in);
    public static void main(String[]args){
       Scanear.useDelimiter("\n");
       System.out.print("Cual es el nombre: ");
       String name =Scanear.next();
       System.out.print("Cual es tu direccion: ");
       String address =Scanear.next();
       System.out.print("Cual es tu telefono: ");
       int telefono = Scanear.nextInt();
       System.out.println("El nombre es "+ (name) +" Su direccion  es "+(address)+" Su numero de telefono es "+(telefono));
       
       
    }
}
