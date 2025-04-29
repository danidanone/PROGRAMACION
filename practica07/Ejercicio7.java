package Ejercicio7;

import java.util.Scanner;
import java.lang.Math;

public class Ejercicio7 {

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

        String opcionSubmenu = "";
        do {

            System.out.println("[1]Using for");
            System.out.println("[2]Using while");
            System.out.println("[3]Using do-while");
            System.out.println("[Z]Salir: ");
            opcionSubmenu = sc.next().toUpperCase();

            switch (opcionSubmenu) {
                case "1":

                    ejercicio_1_1();

                    break;

                case "2":
                    ejercicio_1_2();

                    break;

                case "3":
                    ejercicio_1_3();

                    break;
                default:
                    System.out.println("Opcio Incorrecta");

            }
        } while (!opcionSubmenu.contentEquals("Z"));

    }

    static void ejercicio_1_1() {

        System.out.println("Introduce el valor a multiplicar: ");

        for (int i = 1; i <= 100; i++) {

            System.out.println(i);
        }

    }

    static void ejercicio_1_2() {
        int i = 0;

        while (i <= 100) {
            System.out.println(i);
            i = i + 2;

        }

    }

    static void ejercicio_1_3() {
        int i = 0;
        do {
            System.out.println(i);
            i = i + 3;
        } while (i <= 100);

    }

    static void exercise2() {
        String opcionSubmenu = "";
        do {

            System.out.println("[1]Using for");
            System.out.println("[2]Using while");
            System.out.println("[3]Using do-while");
            System.out.println("[Z]Salir: ");
            opcionSubmenu = sc.next().toUpperCase();

            switch (opcionSubmenu) {
                case "1":

                    ejercicio_2_1();

                    break;

                case "2":
                    ejercicio_2_2();

                    break;

                case "3":
                    ejercicio_2_3();

                    break;
                default:
                    System.out.println("Opcio Incorrecta");

            }
        } while (!opcionSubmenu.contentEquals("Z"));

    }

    static void ejercicio_2_1() {

        System.out.println("Enter an integer > 10: ");
        int numeroIntroducido = sc.nextInt();
        for (int numero = numeroIntroducido; numero >= 0; numero -= 10) {
            System.out.println(numero);
        }

    }

    static void ejercicio_2_2() {
        System.out.println("Enter an integer > 10: ");

        int numeroIntroducido = sc.nextInt();
        int numero = numeroIntroducido;
        while (numero >= 0) {
            System.out.println(numero);
            numero -= 10;

        }

    }

    static void ejercicio_2_3() {
        System.out.println("Enter an integer > 10: ");

        int numeroIntroducido = sc.nextInt();
        int numero = numeroIntroducido;
        do {
            System.out.println(numero);
            numero -= 10;
        } while (numero >= 0);

    }

    static void exercise3() {
        System.out.print("Enter a number to the multiplication table: ");
        int numero = sc.nextInt();
        int operacion = 1;

        for (int contador = 1; contador <= 10; contador++, operacion = numero * contador) {
            System.out.println(contador + " x " + numero + " = " + operacion);

        }

    }

    static void exercise4() {
        System.out.print("Ingresa un numero: ");
        int number = sc.nextInt();
        System.out.printf("%-10s %-10s %-10s\n", "Numero", "Cuadrado", "Cubo");
        for (int contador = 0; contador < 5; contador++) {
            int Numero = number + contador;
            int Cuadrado = Numero * Numero;
            int Square = Numero * Numero * Numero;
            System.out.printf("%-10s %-10s %-10s\n", Numero, Cuadrado, Square);

        }

    }

    static void exercise5() {
        String Numero = sc.next();
        int contador = 0;
        int numero = Integer.parseInt(Numero);
       
        while (numero > 0) {
            numero = (numero / 10);
            contador++;
            if (contador == 1) {
                System.out.println("El numero tiene " + contador + " numero");
            } else {
                System.out.println("El numero tiene " + contador + " numeros");
            }

        }
    }

    static void exercise6() {
        int contador = 3;
        int numeroAleatorio = (int) (Math.random() * (10 - 0));
        System.out.println("Introduce un numero: ");
        while (contador > 0) {
            int numero = sc.nextInt();
            if (numero == numeroAleatorio) {
                System.out.println("Has acertado el numero " + numero);
            } else {
                System.out.println("No has acertado el numero tus vidas son " + contador);
                contador--;
            }

        }
        System.out.println("Te has quedado sin vidas:");

    }
    static void exercise7(){
        double resultado;
        System.out.println("Introduce la base: ");
        double base = sc.nextInt();
        System.out.println("Introduce el exponente: ");
        double exponente = sc.nextInt();
        resultado = base;
      
        if(exponente == 0){
            
            System.out.println("El resultado de esta potencia es "+resultado);
        }
         else if (exponente < 0){
            exponente =- exponente;
            for (int i = 1; i < exponente; i++) {
               resultado = resultado*base;
               
                
            }
            resultado= 1 / resultado;
            System.out.println("El resultado de esta potencia es "+resultado);
        }
        
        else{
            for (int i = 1; i < exponente; i ++ ) {
                resultado = resultado * base;
                System.out.println(resultado);
                
            }
        }
       
        
    }
    
}
