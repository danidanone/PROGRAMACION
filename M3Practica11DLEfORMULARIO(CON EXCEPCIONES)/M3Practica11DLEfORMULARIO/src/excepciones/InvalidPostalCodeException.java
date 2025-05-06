package excepciones;

/**
 * Excepción personalizada para indicar que un código postal no es válido.
 */
public class InvalidPostalCodeException extends Exception {
    
    public InvalidPostalCodeException() {
        super("El código postal no es válido. Debe ser numérico y tener 5 dígitos.");
    }
    
    public InvalidPostalCodeException(String message) {
        super(message);
    }
}
