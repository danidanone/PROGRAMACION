package practica03;
import java.util.Scanner;
import static practica03.ejercicio5.Scanear;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author daniellopesp
 */
public class ejercicio8 {
    static final int DINERO =12;
 
    public static void main(String[]args){
    Scanner Scanear=new Scanner(System.in);
    Scanear.useDelimiter("\n");
    System.out.print("Nombre del empleado: ");
    String empleado;
    empleado = Scanear.next();
    int horas;
    horas = Scanear.nextInt();
    String euro;
    euro = "\u20AC";

    int valor_Total;
    valor_Total=(DINERO * horas);

 
        //PALABR
       System.out.print("El nombre del empleado es "+(empleado)+ " y el sueldo a cobrar "+valor_Total+ euro);
       
       
       
       
    }
}
