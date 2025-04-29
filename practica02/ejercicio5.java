package practica02;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author daniellopesp
 */
public class ejercicio5 {
    static final int IVA =21;
   
    public static void main(String[]args){
       double Euros;
       Euros = 342;
       double valorIva;
       valorIva = (Euros*IVA/100);
       double totalOperacion;
       totalOperacion =(Euros + valorIva);
       String Arroba;
       Arroba = "@";
       
      
       //precio sin iva
       System.out.println("Lo que hay que restar de iva es "+(Euros)+(Arroba));

       //Valor con Iva
       System.out.println("Lo que hay que restar de iva es "+(Euros)+(Arroba));
       
       
       
    }
}
