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
public class ejercicio7 {
 
    public static void main(String[]args){
    Scanner Scanear=new Scanner(System.in);
    System.out.print("Caracter a introducir: ");
    char a;
    a = Scanear.next().charAt(0);
    System.out.println(a);
    char b;
    b = Scanear.next().charAt(0);
    System.out.println(b);
    char c;
    c = Scanear.next().charAt(0);
    System.out.println(a);
    char d;
    d = Scanear.next().charAt(0);
    System.out.println(d);
    char e;
    e = Scanear.next().charAt(0);
    System.out.println(e);
    
    
    String z;
    z = (a +""+ b +""+ c +""+ d +""+ e);
            
    
    
        //PALABR
       System.out.print("La palabra a imprimir es "+(z));
       
       
       
       
    }
}
