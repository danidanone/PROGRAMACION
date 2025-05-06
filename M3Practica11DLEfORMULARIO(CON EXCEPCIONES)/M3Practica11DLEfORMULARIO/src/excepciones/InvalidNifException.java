package excepciones;

/**
 * Excepción personalizada para indicar que un NIF no es válido.
 */
public class InvalidNifException extends Exception {

    public static void setText(String message) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public InvalidNifException() {
        super("El documento DNI/NIF no es válido.");
    }
    
    public InvalidNifException(String message) {
        super(message);
    }
}
