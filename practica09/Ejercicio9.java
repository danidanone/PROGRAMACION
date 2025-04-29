package Ejercicio9;

import java.util.Scanner;
import java.lang.Math;

public class Ejercicio9 {

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
            System.out.println("7.- Ejercicio 7");
            System.out.println("8.- Ejercicio 8");
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
                    break;
                case "7":
                    exercise7();
                    break;
                case "8":
                    exercise8();
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
        int[] numeros = new int[10];
        for (int i = 0; i < 10; i++) {
            int valor = sc.nextInt();
            numeros[i] = valor;
        }
        for (int i = 9; i >= 0; i--) {  // Corregido el índice para evitar ArrayIndexOutOfBoundsException
            System.out.println(numeros[i]);
        }
    }

    static void exercise2() {
        int[] numeros = new int[20];
        System.out.printf("%-10s %-10s %-10s\n", "Numero", "Cuadrado", "Cubo");
        for (int i = 0; i < 20; i++) {
            numeros[i] = (int)(Math.random() * 100);  // Corrección del cast y del índice
            int n = numeros[i];
            System.out.printf("%-10s %-10s %-10s\n", n, n * n, n * n * n);
        }
    }

    static void exercise3() {
        int lista[] = new int[10];
        for (int i = 0; i < lista.length; i++) {
            int datos = sc.nextInt();
            lista[i] = datos;
        }
        int numeroMayor = lista[0];
        int numeroMenor = lista[0];
        for (int i = 1; i < lista.length; i++) {
            if (lista[i] > numeroMayor) {
                numeroMayor = lista[i];
            }
            if (lista[i] < numeroMenor) {
                numeroMenor = lista[i];
            }
        }
        System.out.println("Maximum " + numeroMayor);
        System.out.println("Minimum " + numeroMenor);
    }

    static void exercise4() {
        String[] palabra = new String[5];
        for (int i = 0; i < 5; i++) {  // Corregido el índice del bucle
            System.out.println("Introduce Palabras: ");
            String datos = sc.next();
            palabra[i] = datos;
        }
        for (int i = 0; i < 5; i++) {  // Corregido el índice del bucle
            System.out.printf("%3s", palabra[i]);
        }
        String temp = palabra[0];
        palabra[0] = palabra[1];
        palabra[2] = palabra[3];
        palabra[4] = temp;
        for (int i = 0; i < 5; i++) {  // Corregido el índice del bucle
            System.out.println(palabra[i]);
        }
    }

    static void exercise5() {
        int[] Numero = new int[100];
        System.out.println("Que numero quieres remplazar: ");
        int datoBuscado = sc.nextInt();
        System.out.println("Porque numero lo quieres remplazar: ");
        int datoNuevo = sc.nextInt();
        System.out.println(" ");
        System.out.println(" Lista Sin Modificar ");
        for (int i = 0; i < 100; i++) {
            int numeroAleatorio = (int) (Math.random() * 21);
            Numero[i] = numeroAleatorio;
            System.out.print(" " + Numero[i]);
        }
        System.out.println(" ");
        System.out.println(" Lista Modificada ");
        for (int j = 0; j < 100; j++) {
            if (Numero[j] == datoBuscado) {
                Numero[j] = datoNuevo;
            }
            System.out.print(" " + Numero[j]);
        }
    }

    static void exercise6() {
        int[] lista = new int[8];
        for (int i = 0; i < 8; i++) {
            int datos = sc.nextInt();
            lista[i] = datos;
        }
        for (int i = 0; i < 8; i++) {
            System.out.print(" " + lista[i]);
            if (lista[i] % 2 == 0) {
                System.out.print(" even");
            } else {
                System.out.print(" odd");
            }
        }
    }

    static void exercise7() {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];
        int[] primes = new int[10];
        int[] nonPrimes = new int[10];
        int primeCount = 0;
        int nonPrimeCount = 0;

        System.out.println("Enter 10 numbers:");
        for (int i = 0; i < 10; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Original Array:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Index " + i + ": " + numbers[i]);
        }

        for (int i = 0; i < 10; i++) {
            boolean isPrime = true;
            if (numbers[i] <= 1) {
                isPrime = false;
            } else {
                for (int j = 2; j <= Math.sqrt(numbers[i]); j++) {
                    if (numbers[i] % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime) {
                primes[primeCount++] = numbers[i];
            } else {
                nonPrimes[nonPrimeCount++] = numbers[i];
            }
        }

        for (int i = 0; i < primeCount; i++) {
            numbers[i] = primes[i];
        }
        for (int i = 0; i < nonPrimeCount; i++) {
            numbers[primeCount + i] = nonPrimes[i];
        }
        System.out.println("Array after moving primes to the front:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Index " + i + ": " + numbers[i]);
        }
    }

    private static void exercise8() {
        String[] palabras = new String[8];
        String[] colores = {"verde", "rojo", "azul", "amarillo", "naranja", "rosa", "negro", "blanco", "morado"};
        String[] coloresAlmacenados = new String[8];
        String[] noColoresAlmacenados = new String[8];

        int contadorColores = 0;
        int contadorNoColores = 0;

        System.out.println("Introduce 8 palabras:");
        for (int i = 0; i < 8; i++) {
            palabras[i] = sc.next().toLowerCase(); 
        }

        for (int i = 0; i < palabras.length; i++) {
            boolean esColor = false;
            for (int j = 0; j < colores.length; j++) {
                if (palabras[i].equals(colores[j])) {
                    esColor = true;
                    break;
                }
            }
            if (esColor) {
                coloresAlmacenados[contadorColores++] = palabras[i];
            } else {
                noColoresAlmacenados[contadorNoColores++] = palabras[i];
            }
        }

        System.out.println("Colores:");
        for (int i = 0; i < contadorColores; i++) {
            System.out.println(coloresAlmacenados[i]);
        }

        System.out.println("No colores:");
        for (int i = 0; i < contadorNoColores; i++) {
            System.out.println(noColoresAlmacenados[i]);
        }
    }
}
