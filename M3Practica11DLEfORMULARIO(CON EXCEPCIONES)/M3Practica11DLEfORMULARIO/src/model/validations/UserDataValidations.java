package model.validations;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

/**
 * Clase que contiene métodos para validar datos de usuario.
 */
public class UserDataValidations {

    // Patrones de expresiones regulares
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"
    );

    private static final Pattern NAME_PATTERN = Pattern.compile(
            "^[\\p{L}\\s'.-]{4,}$" // Al menos 4 caracteres, permite letras Unicode, espacios, apóstrofes, puntos y guiones
    );

    private static final Pattern POSTAL_CODE_PATTERN = Pattern.compile(
            "^\\d{5}$" // Exactamente 5 dígitos
    );

    /**
     * Verifica si una cadena es numérica.
     *
     * @param str La cadena a verificar.
     * @return true si la cadena es numérica, false en caso contrario.
     */
    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Verifica si un nombre es válido.
     *
     * @param name El nombre a verificar.
     * @return true si el nombre es válido, false en caso contrario.
     */
    public static boolean checkName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }

        return NAME_PATTERN.matcher(name).matches();
    }

    /**
     * Verifica si un correo electrónico es válido.
     *
     * @param email El correo electrónico a verificar.
     * @return true si el correo electrónico es válido, false en caso contrario.
     */
    public static boolean checkEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }

        return EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * Verifica si una fecha tiene un formato válido (dd/MM/yyyy) y es
     * coherente.
     *
     * @param date La fecha a verificar.
     * @return true si la fecha tiene un formato válido y es coherente, false en
     * caso contrario.
     */
    public static boolean checkFormatDate(String date) {
        if (date == null || date.trim().isEmpty()) {
            return false;
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate parsedDate = LocalDate.parse(date, formatter);

            // Verificar que no sea una fecha futura
            if (parsedDate.isAfter(LocalDate.now())) {
                return false;
            }

            // Verificar que no sea una fecha demasiado antigua (más de 120 años)
            if (Period.between(parsedDate, LocalDate.now()).getYears() > 120) {
                return false;
            }

            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Calcula la edad a partir de una fecha de nacimiento.
     *
     * @param date La fecha de nacimiento en formato dd/MM/yyyy.
     * @return La edad calculada o -1 si la fecha es inválida.
     */
    public static int calculateAge(String date) {
        if (date == null || !checkFormatDate(date)) {
            return -1; // Indicador de error en lugar de lanzar excepción
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse(date, formatter);
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    /**
     * Verifica si un documento de identidad es válido.
     *
     * @param type El tipo de documento (1 para DNI/NIF).
     * @param id El documento a verificar.
     * @return true si el documento es válido, false en caso contrario.
     */
    public static boolean checkId(int type, String id) {
        if (id == null || id.trim().isEmpty()) {
            return false;
        }

        switch (type) {
            case 1: // DNI/NIF
                // Normalizar el NIF (eliminar espacios y convertir a mayúsculas)
                String normalizedId = id.trim().toUpperCase();
                if (normalizedId.length() != 9) {
                    return false;
                }
                return checkNIF(normalizedId.toCharArray(), normalizedId.substring(normalizedId.length() - 1));
            default:
                return false;
        }
    }

    /**
     * Verifica si un NIE es válido.
     *
     * @param nie El NIE a verificar.
     * @return true si el NIE es válido, false en caso contrario.
     */
    private static boolean checkNIE(String nie) {
        // Implementación básica de validación de NIE
        // Esta es una implementación simple que debería expandirse
        if (nie == null || nie.length() != 9) {
            return false;
        }

        char firstChar = Character.toUpperCase(nie.charAt(0));
        return (firstChar == 'X' || firstChar == 'Y' || firstChar == 'Z');
    }

    /**
     * Verifica si un número de pasaporte es válido.
     *
     * @param passport El pasaporte a verificar.
     * @return true si el pasaporte es válido, false en caso contrario.
     */
    private static boolean checkPassport(String passport) {
        // Implementación básica de validación de pasaporte
        // Esta es una implementación simple que debería expandirse
        if (passport == null) {
            return false;
        }

        // Ejemplo: pasaporte español (una letra seguida de 8 dígitos)
        return passport.length() == 9
                && Character.isLetter(passport.charAt(0))
                && isNumeric(passport.substring(1));
    }

    /**
     * Verifica si un NIF es válido.
     *
     * @param nif El NIF a verificar en forma de array de caracteres.
     * @param letraNif La letra del NIF.
     * @return true si el NIF es válido, false en caso contrario.
     */
    public static boolean checkNIF(char[] nif, String letraNif) {
        if (nif == null || nif.length < 2) {
            return false;
        }

        if (letraNif == null || letraNif.isEmpty()) {
            return false;
        }

        // Verificar que el NIF tiene 9 caracteres (8 números + 1 letra)
        if (nif.length != 9) {
            return false;
        }

        String numsNifStr = "";
        for (int i = 0; i < nif.length - 1; i++) {
            if (!Character.isDigit(nif[i])) {
                return false;
            }
            numsNifStr += nif[i];
        }

        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        try {
            int numsNifInt = Integer.parseInt(numsNifStr);
            int indice = numsNifInt % 23;
            char letraNifChar = Character.toUpperCase(letraNif.charAt(0));

            return letraNifChar == letras[indice];
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Verifica si un código postal es válido.
     *
     * @param zip El código postal a verificar.
     * @return true si el código postal es válido, false en caso contrario.
     */
    public static boolean checkPostalCode(String zip) {
        if (zip == null || zip.trim().isEmpty()) {
            return false;
        }

        return POSTAL_CODE_PATTERN.matcher(zip).matches();
    }

    public static boolean isAlphabetic(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        return str.matches("[\\p{L}\\s]+");
    }
}
