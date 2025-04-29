/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.console;

import java.util.Scanner;
import model.validations.UserDataValidations;

public class Main {
    // Scanner para capturar entrada del usuario
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Menú principal
        System.out.println("Seleccione una opción:");
        System.out.println("1. Validar NIF");
        System.out.println("2. Validar formato de fecha");
        System.out.println("3. Calcular edad");
        System.out.println("4. Validar código postal");
        System.out.println("5. Verificar si es numérico");
        System.out.println("6. Verificar si es alfabético");
        System.out.println("7. Validar correo electrónico");
        System.out.println("8. Validar nombre");
        System.out.println("9. Salir");

        // Captura la opción seleccionada
        int opcion = sc.nextInt();

        // Ejecuta la opción correspondiente
        switch (opcion) {
            case 1:
                testCheckId();
                break;
            case 2:
                testCheckDate();
                break;
            case 3:
                testCalculateAge();
                break;
            case 4:
                CheckFormatZip();
                break;
            case 5:
                CheckIsNumeric();
                break;
            case 6:
                CheckIsAlpha();
                break;
            case 7:
                CheckEmail();
                break;
            case 8:
                CheckName();
                break;
            case 9:
                System.out.println("Saliendo del programa...");
                break;
        }
    }

    // Valida el NIF (DNI) ingresado por el usuario
    public static void testCheckId() {
        System.out.print("Introduce tu DNI: ");
        String id = sc.next();
        boolean idOK = UserDataValidations.checkId(1, id); // Llama a la validación de DNI
        if (idOK) {
            System.out.println("Correct id");
        } else {
            System.out.println("Wrong id");
        }
    }

    // Valida el formato de una fecha
    public static void testCheckDate() {
        System.out.print("Introduce una Fecha siguiendo el Formato (DD/MM/AAAA): ");
        String date = sc.next();
        boolean esCorrecta = UserDataValidations.checkFormatDate(date); // Llama a la validación de la fecha
        if (esCorrecta) {
            System.out.println("El formato es correcto");
        } else {
            System.out.println("Es incorrecto");
        }
    }

    // Calcula la edad a partir de la fecha de nacimiento
    public static void testCalculateAge() {
        System.out.print("Introduce tu cumple: ");
        String birthDate = sc.next();

        // Primero valida el formato de la fecha
        boolean esCorrecta = UserDataValidations.checkFormatDate(birthDate);
        if (esCorrecta) {
            System.out.println("El formato es correcto");
            int valorAnio = UserDataValidations.calculateAge(birthDate); // Calcula la edad
            System.out.println("Tu edad es: " + valorAnio);
        } else {
            System.out.println("El formato es incorrecto");
        }
    }

    // Valida el formato de un código postal
    public static void CheckFormatZip() {
        System.out.print("Introduce el código Postal: ");
        String zip = sc.next();
        boolean esCorrecta = UserDataValidations.checkPostalCode(zip); // Llama a la validación del código postal
        if (esCorrecta) {
            System.out.println("El formato es correcto");
        } else {
            System.out.println("Es incorrecto");
        }
    }

    // Verifica si un valor ingresado es numérico
    public static void CheckIsNumeric() {
        System.out.print("Introduce un valor: ");
        String str = sc.next();
        boolean isNum = UserDataValidations.isNumeric(str); // Llama a la validación numérica
        if (isNum) {
            System.out.println("El formato es correcto");
        } else {
            System.out.println("El formato es incorrecto");
        }
    }

    // Verifica si un valor ingresado es alfabético
    public static void CheckIsAlpha() {
        System.out.print("Introduce un valor: ");
        String str = sc.next();
        boolean isString = UserDataValidations.isAlphabetic(str); // Llama a la validación alfabética
        if (isString) {
            System.out.println("El formato es correcto");
        } else {
            System.out.println("El formato es incorrecto");
        }
    }

    // Valida el formato de un correo electrónico
    public static void CheckEmail() {
        System.out.print("Introduce tu correo electrónico: ");
        String email = sc.next();
        boolean isString = UserDataValidations.checkEmail(email); // Llama a la validación de correo
        if (isString) {
            System.out.println("El formato es correcto");
        } else {
            System.out.println("El formato es incorrecto");
        }
    }

    // Valida el formato de un nombre
    public static void CheckName() {
        System.out.print("Introduce tu nombre: ");
        String name = sc.next();
        boolean esCorrecta = UserDataValidations.checkName(name); // Llama a la validación del nombre
        if (esCorrecta) {
            System.out.println("El formato es correcto");
        } else {
            System.out.println("El formato es incorrecto");
        }
    }
}