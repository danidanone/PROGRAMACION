package model.validations;

import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Clase con métodos para validar diferentes tipos de datos (NIF, fecha, edad,
 * código postal, email, nombre)
 */
public class UserDataValidations {

    static Scanner sc = new Scanner(System.in);

    // Verifica si la cadena contiene solo caracteres alfabéticos
    public static boolean isAlphabetic(String str) {
        if (str == null || str.isEmpty()) {  // Si la cadena está vacía o es null, no es alfabética
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i))) {  // Si algún carácter no es letra, devuelve false
                return false;
            }
        }
        return true;  // Devuelve true si todos los caracteres son letras
    }

    // Verifica si la cadena contiene solo dígitos (números)
    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {  // Si la cadena está vacía o es null, no es numérica
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {  // Si algún carácter no es un número, devuelve false
                return false;
            }
        }
        return true;  // Devuelve true si todos los caracteres son dígitos
    }

    // Verifica si el NIF (DNI español) es válido
    public static boolean checkId(int typeDoc, String id) {
        if (typeDoc != 1) {  // Solo valida para tipo de documento 1 (NIF)
            return false;
        }
        if (id.length() != 9) {  // El NIF debe tener 9 caracteres
            return false;
        }

        // Separamos los primeros 8 caracteres (números) y el último (letra)
        char[] nif = new char[8];
        for (int i = 0; i < nif.length; i++) {
            nif[i] = id.charAt(i);
        }
        String letraNif = "" + id.charAt(8);
        if (!UserDataValidations.isAlphabetic(letraNif)) {  // La letra final debe ser alfabética
            return false;
        }

        // Verificamos que los 8 primeros caracteres sean numéricos
        String numsNifStr = "";
        for (int i = 0; i < nif.length - 1; i++) {
            if (!UserDataValidations.isNumeric("" + nif[i])) {
                return false;
            }
            char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'S', 'F', 'Y', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K'};
            numsNifStr += nif[i];
            int numsNifInt = Integer.parseInt(numsNifStr);
            int indice = numsNifInt % 23;
            char letraNifChar = letraNif.charAt(0);
            if (letraNifChar == letras[indice]) {  // Si la letra coincide con la calculada, el NIF es válido
                return true;
            }
        }
        return false;  // Si no coincide, devuelve false
    }

    // Verifica si el formato de la fecha es correcto (DD/MM/AAAA)
    public static boolean checkFormatDate(String date) {
        String[] partes = date.split("/");  // Separamos la fecha por "/"
        if (partes.length != 3) {  // Si no tiene tres partes, es incorrecta
            return false;
        }
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int anio = Integer.parseInt(partes[2]);
        if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || anio < 1900) {  // Verificamos los rangos válidos para día, mes y año
            return false;
        }
        return true;  // Si todos los datos son válidos, devuelve true
    }

    // Calcula la edad en años a partir de la fecha de nacimiento (formato DD/MM/AAAA)
    public static int calculateAge(String birthDate) {
        String diaCumpleConString = "" + birthDate.charAt(0) + birthDate.charAt(1);
        String mesCumpleConString = "" + birthDate.charAt(3) + birthDate.charAt(4);
        String anioCumpleConString = "" + birthDate.charAt(6) + birthDate.charAt(7) + birthDate.charAt(8) + birthDate.charAt(9);

        LocalDate fechaHoy = LocalDate.now();  // Obtenemos la fecha actual
        String fechaFormateada = fechaHoy.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        int diaCumple = Integer.parseInt(diaCumpleConString);
        int mesCumple = Integer.parseInt(mesCumpleConString);
        int anioCumple = Integer.parseInt(anioCumpleConString);

        int fechaDia = Integer.parseInt(fechaFormateada.substring(0, 2));
        int fechaMes = Integer.parseInt(fechaFormateada.substring(3, 5));
        int fechaAnio = Integer.parseInt(fechaFormateada.substring(6, 10));

        int valorAnio = fechaAnio - anioCumple;
        if (mesCumple > fechaMes || (mesCumple == fechaMes && diaCumple > fechaDia)) {
            valorAnio--;  // Si aún no hemos cumplido años este año, restamos 1
        }
        return valorAnio;  // Devuelve la edad calculada
    }

    // Verifica si el formato del correo electrónico es válido
    public static boolean checkEmail(String email) {
        // Verifica que el correo no sea nulo o vacío
        if (email == null || email.isEmpty()) {
            return false;
        }

        // Patrón para validar el formato del correo electrónico
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();  // Devuelve true si el formato es válido
    }

    // Verifica si el código postal tiene 5 caracteres numéricos
    public static boolean checkPostalCode(String zip) {
        int numero = Integer.parseInt(zip);
        if (zip.length() != 5) {
            return false;
        }
        if (numero < 01000 || numero > 52999){
            return false;
        }
        return true;
    }

    // Verifica si el nombre tiene solo caracteres alfabéticos y una longitud menor a 30
    public static boolean checkName(String name) {
        boolean comprobarEsNum = isAlphabetic(name);  // Verifica si el nombre es alfabético
        int longitud = 30;
        if (comprobarEsNum && name.length() < longitud) {  // Verifica que el nombre sea corto (menos de 30 caracteres)
            return true;
        }
        return false;  // Devuelve true si el nombre es válido
    }
}
