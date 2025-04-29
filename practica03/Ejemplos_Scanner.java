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
public class Ejemplos_Scanner {
    //Scanner 
    static Scanner inputeclado =new Scanner(System.in);
    public static void main(String[] args) {
        //Para que deje poner texto con espacios 
            inputeclado.useDelimiter("\n");
                   
        System.out.println("Introduce tu nombre: "); 
        
        String nombre = inputeclado.next();
        
        System.out.println("Hola " + nombre + "!");
        
    }
    
    
}
