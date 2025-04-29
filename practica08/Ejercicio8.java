
package Ejercicio8;

import java.util.Scanner;
import java.lang.Math;


public class Ejercicio8 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String opcion = "";
        sc.useDelimiter("\n");
        do {
            System.out.println("\n");
            System.out.println("Menu: ");
            System.out.println("1.- Ejercicio 1");
            System.out.println("2.- Ejercicio 2");
            System.out.println("3.- Ejercicio 3");
            System.out.println("4.- Ejercicio 4");
            System.out.println("5.- Ejercicio 5");
            System.out.println("6.- Ejercicio 6");
            System.out.println("7.-Ejercicio 7 \n");
            System.out.println("Z - Salir \n");
            System.out.println("Enter option: ");
            opcion = sc.next().toUpperCase();
            switch (opcion) {
                case "1":
                    exercise1();

                    break;
                case "2":
                    exercise2();

                    break;
                case "3":
                    exercise3();

                    break;
                case "4":
                    exercise4();

                    break;
                case "5":
                    exercise5();

                    break;
                case "6":
                    exercise6();
                
                case "7":
                    exercise7();

                    break;
                case "Z":
                    System.out.println("Adios");

                    break;

                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (!opcion.contentEquals("Z"));
    }

    static void exercise1() {
    String numero = sc.next();
    int total = 0;
        for(int i = 0; i < (numero.length()) ;i++) {
           int digito = numero.charAt(i);
           digito = digito - '0';
           total = total + digito;
                
       
        }
        System.out.println(total);    
        

   
    }
    

    static void exercise2() {
        System.out.println("Introduce una palabra: ");
        String palabra = sc.next().toLowerCase();
        System.out.println("Introduce la letra: ");
        char letra =sc.next().charAt(0);
        
        int contador = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra){
                contador++;
            }
            System.out.println("La letra '" + letra + "' aparece " + contador + " veces en la palabra '" + palabra + "'.");
                    
        }
        
        
        
        
       
        
            
    }

    static void exercise3() {
        System.out.println("Introduce una palabra: ");
        String palabra =sc.next();
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            for (int x = 0; x < i; x++) {
                System.out.print(" ");
            }
            System.out.println(letra);
            
               
        }
        

        

    }

    static void exercise4() {
   
        for (int i = 1; i <= 10; i++) {
            
              System.out.printf("%3s %3s %3s %3s %3s %3s %3s %3s %3s %3s\n",(i*1) ,(i*2) ,(i*3) ,(i*4) ,(i*5) ,(i*6) ,(i*7) ,(i*8) ,(i*9) ,(i*10));
          
                   
        }
         
        
    }

    static void exercise5() {
     int vidaPlayer = 100;
     int vidaEnemigo = 100;
     int Navajazo = 5;
     int Puñetazo = 2;  
     boolean Turno;
     Turno= true;
   
    
     
     
     
        while(vidaPlayer > 0 && vidaEnemigo > 0){
            int ataque = Math.random() < 0.5 ? Navajazo : Puñetazo;
           
            
            if(Turno == true){
               vidaPlayer = (vidaPlayer-ataque);
               System.out.println("El Enemigo a atacado a Enemigo con "+ ataque + " y su vida es de " + vidaPlayer);
                Turno = false;
            }
            else 
                vidaEnemigo = (vidaEnemigo-ataque);
                Turno = true;
                System.out.println("El jugador a atacado a el jugador con "+ ataque + " y su vida es de " + vidaEnemigo);
                
            }
 
    }

    static void exercise6() {
        int numAlumno = 1;
        int sumaNotas = 0;
        int maximo = 5;
        while(numAlumno <-maximo){
           System.out.println("Introduce la nota del alumno: ");
           int nota = sc.nextInt();
           sumaNotas = (sumaNotas+nota);
           numAlumno =(numAlumno + 1);
        }
        int media = sumaNotas/(numAlumno-1);
        System.out.println("La media de los alumnos es " + media);
    
        }
        
              

    
    static void exercise7(){
        System.out.println("Ingrese un numero entero: ");   
        int num = sc.nextInt();
        boolean es_primo = true;
        for (int i = 2; i < num; i++) {
           if (num % i == 0){
           es_primo = false;
               System.out.println(i + "es divisible entre " + num);
           }
           if (es_primo){
                System.out.println("El numero "+ num + "es primo");
           }
           else 
                System.out.println("El numero " + num + "No es primo");
               
        
       

        }
        
    }}
    

