
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

    ;
public class ejercicio5 {
    static final int IVA =21;
    static Scanner Scanear = new Scanner(System.in);
    public static void main(String[]args){

     
       System.out.print("Cual es el precio a saber convertir: ");
       double Euros = Scanear.nextDouble();
       double valorIva;
       valorIva = (Euros*IVA/100);
       double totalOperacion;
       totalOperacion =(Euros + valorIva);
       String Arroba;
       Arroba = "@";
       
      
       //precio sin iva
       System.out.println("Lo que hay que restar de iva es "+(Euros-valorIva));

       //Valor con Iva
       System.out.println("Lo que hay que sumar de iva es "+(Euros+valorIva));
    }
}
