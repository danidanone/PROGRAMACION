package view.console;

import java.util.Scanner;
import model.validations.UserDataValidations;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
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

        int opcion = sc.nextInt();

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

    public static void testCheckId() {
        System.out.print("Introduce tu DNI: ");
        String id = sc.next();
        boolean esCorrecta = UserDataValidations.checkId(1, id);
        if (esCorrecta) {
            System.out.println("El formato es correcto");
        } else {
            System.out.println("El formato es incorrecto");
        }
    }

    public static void testCheckDate() {
        System.out.print("Introduce una Fecha siguiendo el Formato (DD/MM/AAAA): ");
        String date = sc.next();
        boolean esCorrecta = UserDataValidations.checkFormatDate(date);
        if (esCorrecta) {
            System.out.println("El formato es correcto");
        } else {
            System.out.println("El formato es incorrecto");
        }
    }

    public static void testCalculateAge() {
        System.out.print("Introduce tu cumple: ");
        String birthDate = sc.next();
        boolean esCorrecta = UserDataValidations.checkFormatDate(birthDate);
        if (esCorrecta) {
            System.out.println("El formato es correcto");
            int valorAnio = UserDataValidations.calculateAge(birthDate);
            System.out.println("Tu edad es: " + valorAnio);
        } else {
            System.out.println("El formato es incorrecto");
        }
    }

    public static void CheckFormatZip() {
        System.out.print("Introduce el código Postal: ");
        String zip = sc.next();
        boolean esCorrecta = UserDataValidations.checkPostalCode(zip);
        if (esCorrecta) {
            System.out.println("El formato es correcto");
        } else {
            System.out.println("El formato es incorrecto");
        }
    }

    public static void CheckIsNumeric() {
        System.out.print("Introduce un valor: ");
        String str = sc.next();
        boolean esCorrecta = UserDataValidations.isNumeric(str);
        if (esCorrecta) {
            System.out.println("El formato es correcto");
        } else {
            System.out.println("El formato es incorrecto");
        }
    }

    public static void CheckIsAlpha() {
        System.out.print("Introduce un valor: ");
        String str = sc.next();
        boolean esCorrecta = UserDataValidations.isAlphabetic(str);
        if (esCorrecta) {
            System.out.println("El formato es correcto");
        } else {
            System.out.println("El formato es incorrecto");
        }
    }

    public static void CheckEmail() {
        System.out.print("Introduce tu correo electrónico: ");
        String email = sc.next();
        boolean esCorrecta = UserDataValidations.checkEmail(email);
        if (esCorrecta) {
            System.out.println("El formato es correcto");
        } else {
            System.out.println("El formato es incorrecto");
        }
    }

    public static void CheckName() {
        System.out.print("Introduce tu nombre: ");
        String name = sc.next();
        boolean esCorrecta = UserDataValidations.checkName(name);
        if (esCorrecta) {
            System.out.println("El formato es correcto");
        } else {
            System.out.println("El formato es incorrecto");
        }
    }
}
