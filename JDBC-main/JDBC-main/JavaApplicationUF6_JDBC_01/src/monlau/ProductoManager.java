package monlau;

import monlau.dao.ProductoDAO;
import monlau.dao.ProductoDAOImpl;
import monlau.model.Producto;

import java.util.Scanner;

public class ProductoManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductoDAO productoDAO = new ProductoDAOImpl();
        int opcion;

        do {
            System.out.println("\n--- GESTIÓN DE PRODUCTOS ---");
            System.out.println("1. Insertar producto");
            System.out.println("2. Consultar producto");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero(scanner);

            switch (opcion) {
                case 1:
                    insertarProducto(scanner, productoDAO);
                    break;
                case 2:
                    consultarProducto(scanner, productoDAO);
                    break;
                case 3:
                    actualizarProducto(scanner, productoDAO);
                    break;
                case 4:
                    eliminarProducto(scanner, productoDAO);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);

        scanner.close();
    }

    private static void insertarProducto(Scanner scanner, ProductoDAO dao) {
        System.out.print("ID del producto: ");
        int id = leerEntero(scanner);

        Producto existente = dao.read(id);
        if (existente != null) {
            System.out.println("⚠️ Ya existe un producto con ese ID: " + existente);
            return;
        }

        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Precio del producto: ");
        double precio = leerDouble(scanner);

        Producto nuevo = new Producto(id, nombre, precio);
        dao.insert(nuevo);
    }

    private static void consultarProducto(Scanner scanner, ProductoDAO dao) {
        System.out.print("ID del producto a consultar: ");
        int id = leerEntero(scanner);

        Producto producto = dao.read(id);
        if (producto != null) {
            System.out.println("🔍 Producto encontrado: " + producto);
        }
    }

    private static void actualizarProducto(Scanner scanner, ProductoDAO dao) {
        System.out.print("ID del producto a actualizar: ");
        int id = leerEntero(scanner);

        Producto producto = dao.read(id);
        if (producto == null) {
            System.out.println("⚠️ No se encontró ningún producto con ese ID.");
            return;
        }

        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Nuevo precio: ");
        double precio = leerDouble(scanner);

        producto.setNombre(nombre);
        producto.setPrecio(precio);

        dao.update(producto);
    }

    private static void eliminarProducto(Scanner scanner, ProductoDAO dao) {
        System.out.print("ID del producto a eliminar: ");
        int id = leerEntero(scanner);

        Producto producto = dao.read(id);
        if (producto == null) {
            System.out.println("⚠️ No se encontró ningún producto con ese ID.");
            return;
        }

        dao.delete(producto);
    }

    // Métodos auxiliares para leer con validación
    private static int leerEntero(Scanner scanner) {
        while (true) {
            try {
                String linea = scanner.nextLine();
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.print("❌ Introduzca un número entero válido: ");
            }
        }
    }

    private static double leerDouble(Scanner scanner) {
        while (true) {
            try {
                String linea = scanner.nextLine();
                return Double.parseDouble(linea);
            } catch (NumberFormatException e) {
                System.out.print("❌ Introduzca un número decimal válido: ");
            }
        }
    }
}