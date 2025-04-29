import java.util.Random;
import java.util.Scanner;

public class JuegoDeBarcos {
    public static void main(String[] args) {
        // Crear los tableros
        char[][] tableroUsuario = new char[5][5];
        char[][] tableroEnemigo = new char[5][5];
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        
        // Inicializar los tableros
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tableroUsuario[i][j] = ' ';
                tableroEnemigo[i][j] = ' ';
            }
        }
        
        // Colocar barco enemigo aleatoriamente
        boolean colocado = false;
        while (!colocado) {
            boolean horizontal = rand.nextBoolean();
            int fila = rand.nextInt(4);  // 0 a 3 para evitar que el barco se salga
            int columna = rand.nextInt(4);  // 0 a 3 para evitar que el barco se salga
            
            if (horizontal) {
                // Verificar si se puede colocar el barco horizontalmente
                if (columna < 3 && tableroEnemigo[fila][columna] == ' ' && tableroEnemigo[fila][columna + 1] == ' ') {
                    tableroEnemigo[fila][columna] = 'B';
                    tableroEnemigo[fila][columna + 1] = 'B';
                    colocado = true;
                }
            } else {
                // Verificar si se puede colocar el barco verticalmente
                if (fila < 3 && tableroEnemigo[fila][columna] == ' ' && tableroEnemigo[fila + 1][columna] == ' ') {
                    tableroEnemigo[fila][columna] = 'B';
                    tableroEnemigo[fila + 1][columna] = 'B';
                    colocado = true;
                }
            }
        }
        
        boolean juegoTerminado = false;
        
        // Loop principal del juego
        while (!juegoTerminado) {
            // Mostrar el tablero del usuario
            System.out.println("  A B C D E");
            for (int i = 0; i < 5; i++) {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < 5; j++) {
                    System.out.print(tableroUsuario[i][j] + " ");
                }
                System.out.println();
            }

            // Pedir jugada al usuario
            System.out.print("Ingresa tu jugada (Ej. 4B): ");
            String jugada = scanner.nextLine().toUpperCase();

            // Validar la jugada
            if (jugada.length() != 2 || !Character.isDigit(jugada.charAt(0)) || "ABCDE".indexOf(jugada.charAt(1)) == -1) {
                System.out.println("Jugada inválida. Intenta nuevamente.");
                continue;
            }

            // Convertir la jugada a índices
            int fila = Integer.parseInt(jugada.substring(0, 1)) - 1;  // Convertir fila (1-5) a índice (0-4)
            int col = jugada.charAt(1) - 'A';  // Convertir columna (A-E) a índice (0-4)

            // Verificar si el disparo es un acierto
            if (tableroEnemigo[fila][col] == 'B') {
                System.out.println("¡Acierto!");
                tableroUsuario[fila][col] = '*';  // Marcar con * si acierta
            } else {
                System.out.println("¡Fallaste!");
                tableroUsuario[fila][col] = 'x';  // Marcar con x si falla
            }

            // Comprobar si el juego ha terminado (si el barco ha sido hundido)
            boolean barcoHundido = true;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (tableroEnemigo[i][j] == 'B') {
                        barcoHundido = false;
                        break;
                    }
                }
                if (!barcoHundido) break;
            }

            if (barcoHundido) {
                System.out.println("¡Has hundido el barco enemigo!");
                juegoTerminado = true;
            }
        }

    }
}
