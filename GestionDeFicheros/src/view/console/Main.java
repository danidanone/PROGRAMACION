
package view.console;

import java.util.Scanner;
import model.Funciones;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path;
        String fileName;
        String content;
        int option;

        do {
            System.out.println("\n--- MENÚ DE ARCHIVOS ---");
            System.out.println("1. Crear carpeta");
            System.out.println("2. Crear archivo");
            System.out.println("3. Mostrar lista de archivos");
            System.out.println("4. Ver contenido de un archivo");
            System.out.println("5. Sobrescribir archivo");
            System.out.println("6. Eliminar archivo");
            System.out.println("7. Contar caracteres de un archivo");
            System.out.println("8. Contar palabras de un archivo");
            System.out.println("9. Reemplazar palabra en archivo");
            System.out.println("10. Imprimir PDF (simulado)");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar un número. Intenta de nuevo.");
                option = -1; // Valor inválido para volver a mostrar el menú
                continue;
            }

            switch (option) {
                case 1:
                    System.out.print("Introduce el nombre de la carpeta: ");
                    String folderName = scanner.nextLine();
                    Funciones.createFolder(folderName);
                    System.out.println("Carpeta creada exitosamente.");
                    break;

                case 2:
                    System.out.print("Introduce el path: ");
                    path = scanner.nextLine();
                    System.out.print("Introduce el nombre del archivo: ");
                    fileName = scanner.nextLine();
                    System.out.print("Introduce el contenido: ");
                    content = scanner.nextLine();
                    Funciones.createFile(path, fileName, content);
                    break;

                case 3:
                    System.out.print("Introduce el path: ");
                    path = scanner.nextLine();
                    String[] archivos = Funciones.showListFiles(path);
                    if (archivos.length > 0) {
                        System.out.println("Archivos encontrados:");
                        for (String archivo : archivos) {
                            System.out.println(archivo);
                        }
                    } else {
                        System.out.println("No se encontraron archivos en el directorio.");
                    }
                    break;

                case 4:
                    System.out.print("Introduce el path: ");
                    path = scanner.nextLine();
                    System.out.print("Introduce el nombre del archivo: ");
                    fileName = scanner.nextLine();
                    String contenido = Funciones.showFile(path, fileName);
                    if (contenido != null) {
                        System.out.println("Contenido:\n" + contenido);
                    } else {
                        System.out.println("No se pudo leer el archivo.");
                    }
                    break;

                case 5:
                    System.out.print("Introduce el path: ");
                    path = scanner.nextLine();
                    System.out.print("Introduce el nombre del archivo: ");
                    fileName = scanner.nextLine();
                    System.out.print("Introduce el nuevo contenido: ");
                    String nuevoContenido = scanner.nextLine();
                    boolean resultado = Funciones.overWriteFile(path, fileName, nuevoContenido);
                    if (resultado) {
                        System.out.println("Archivo sobrescrito correctamente.");
                    } else {
                        System.out.println("No se pudo sobrescribir el archivo.");
                    }
                    break;

                case 6:
                    System.out.print("Introduce el path: ");
                    path = scanner.nextLine();
                    System.out.print("Introduce el nombre del archivo: ");
                    fileName = scanner.nextLine();
                    Funciones.deleteFile(path, fileName);
                    System.out.println("Archivo eliminado o no existente.");
                    break;

                case 7:
                    System.out.print("Introduce el path: ");
                    path = scanner.nextLine();
                    System.out.print("Introduce el nombre del archivo: ");
                    fileName = scanner.nextLine();
                    int chars = Funciones.countChars(path, fileName);
                    System.out.println("Número de caracteres: " + chars);
                    break;

                case 8:
                    System.out.print("Introduce el path: ");
                    path = scanner.nextLine();
                    System.out.print("Introduce el nombre del archivo: ");
                    fileName = scanner.nextLine();
                    int palabras = Funciones.countWords(path, fileName);
                    System.out.println("Número de palabras: " + palabras);
                    break;

                case 9:
                    System.out.print("Introduce el path: ");
                    path = scanner.nextLine();
                    System.out.print("Introduce el nombre del archivo: ");
                    fileName = scanner.nextLine();
                    System.out.print("Palabra a reemplazar: ");
                    String vieja = scanner.nextLine();
                    System.out.print("Nueva palabra: ");
                    String nueva = scanner.nextLine();
                    String resultadoSwap = Funciones.swapWords(path, fileName, vieja, nueva);
                    if (resultadoSwap != null) {
                        System.out.println("Reemplazo realizado. Contenido actualizado:\n" + resultadoSwap);
                    } else {
                        System.out.println("No se pudo realizar el reemplazo.");
                    }
                    break;

                case 10:
                    System.out.print("Introduce el path: ");
                    path = scanner.nextLine();
                    System.out.print("Introduce el nombre del archivo: ");
                    fileName = scanner.nextLine();
                    Funciones.printPDF(path, fileName);
                    System.out.println("Impresión PDF simulada.");
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }

        } while (option != 0);

        scanner.close();
    }
}