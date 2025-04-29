import model.Car;
import model.Moto;
import model.Camion;
import colorEnum.colorEnum;
import motorEnum.motorEnum;
import transmissionEnum.Transmision;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import model.Vehiculo;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

        int opcion;
        do {
            System.out.println("======MENU======");
            System.out.println("1: Crear un Coche");
            System.out.println("2: Crear una Moto");
            System.out.println("3: Crear un Camion");
            System.out.println("4: Mostrar Matrículas de todos los vehículos");
            System.out.println("5: Mostrar todos los datos de un vehículo (por matrícula)");
            System.out.println("6: Mostrar el total de vehículos creados");
            System.out.println("7: Mostrar el total de coches creados");
            System.out.println("8: Mostrar el total de motos creadas");
            System.out.println("9: Mostrar el total de camiones creados");
            System.out.println("10: Eliminar un vehículo (por matrícula)");
            System.out.println("11: Salir");

            opcion = sc.nextInt();
            sc.nextLine();  // Limpiar buffer
            switch (opcion) {
                case 1:
                    crearCoche(sc, listaVehiculos);
                    break;
                case 2:
                    crearMoto(sc, listaVehiculos);
                    break;
                case 3:
                    crearCamion(sc, listaVehiculos);
                    break;
                case 4:
                    mostrarMatriculas(listaVehiculos);
                    break;
                case 5:
                    mostrarDatosPorMatricula(sc, listaVehiculos);
                    break;
                case 6:
                    System.out.println("Total de vehículos creados: " + listaVehiculos.size());
                    break;
                case 7:
                    mostrarCantidadVehiculosPorTipo(listaVehiculos, Car.class);
                    break;
                case 8:
                    mostrarCantidadVehiculosPorTipo(listaVehiculos, Moto.class);
                    break;
                case 9:
                    mostrarCantidadVehiculosPorTipo(listaVehiculos, Camion.class);
                    break;
                case 10:
                    eliminarVehiculo(sc, listaVehiculos);
                    break;
                case 11:
                    System.out.println("Saliendo.....");
                    break;
                default:
                    System.out.println("Opción inválida, por favor intenta de nuevo.");
            }
        } while (opcion != 11);
    }

    private static void crearCoche(Scanner sc, ArrayList<Vehiculo> listaVehiculos) {
        System.out.println("Introduce los datos para crear un coche:");
        System.out.print("Marca: ");
        String marca = sc.nextLine();
        System.out.print("Modelo: ");
        String modelo = sc.nextLine();
        System.out.print("Matrícula: ");
        String matricula = sc.nextLine();
        System.out.print("Potencia: ");
        int potencia = sc.nextInt();
        sc.nextLine(); // Limpiar buffer
        System.out.print("Color Blue Gray Green Orange Red: ");
        String colorInput = sc.nextLine().toUpperCase();
        colorEnum color = colorEnum.valueOf(colorInput);
        System.out.print("Motor: ");
        String motorInput = sc.nextLine().toUpperCase();
        motorEnum motor = motorEnum.valueOf(motorInput);
        System.out.print("Fecha de fabricación (dd/MM/yyyy): ");
        String fechaInput = sc.nextLine();
        LocalDate fechaFabricacion = LocalDate.parse(fechaInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Lugar de fabricación: ");
        String lugarCoche = sc.nextLine();
        System.out.print("Transmisión (MANUAL / AUTOMATICA): ");
        String transmisionInput = sc.nextLine().toUpperCase();
        Transmision transmission = Transmision.valueOf(transmisionInput);
        System.out.print("Velocidad máxima: ");
        double velocidad = sc.nextDouble();
        System.out.print("Peso: ");
        double peso = sc.nextDouble();
        System.out.print("Número de puertas: ");
        int numeroPuertas = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        Car nuevoCoche = new Car(marca, modelo, potencia, color, motor, fechaFabricacion, 
                                lugarCoche, transmission, velocidad, matricula, peso, numeroPuertas);
        listaVehiculos.add(nuevoCoche);
    }

    private static void crearMoto(Scanner sc, ArrayList<Vehiculo> listaVehiculos) {
        System.out.println("Introduce los datos para crear una moto:");
        System.out.print("Marca: ");
        String marca = sc.nextLine();
        System.out.print("Modelo: ");
        String modelo = sc.nextLine();
        System.out.print("Matrícula: ");
        String matricula = sc.nextLine();
        System.out.print("Potencia: ");
        int potencia = sc.nextInt();
        sc.nextLine(); // Limpiar buffer
        System.out.print("Color Blue Gray Green Orange Red: ");
        String colorInput = sc.nextLine().toUpperCase();
        colorEnum color = colorEnum.valueOf(colorInput);
        System.out.print("Motor: ");
        String motorInput = sc.nextLine().toUpperCase();
        motorEnum motor = motorEnum.valueOf(motorInput);
        System.out.print("Fecha de fabricación (dd/MM/yyyy): ");
        String fechaInput = sc.nextLine();
        LocalDate fechaFabricacion = LocalDate.parse(fechaInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Lugar de fabricación: ");
        String lugarFabricacion = sc.nextLine();
        System.out.print("Transmisión (MANUAL / AUTOMATICA): ");
        String transmisionInput = sc.nextLine().toUpperCase();
        Transmision transmission = Transmision.valueOf(transmisionInput);
        System.out.print("Velocidad máxima: ");
        double velocidad = sc.nextDouble();
        System.out.print("Peso: ");
        double peso = sc.nextDouble();
        System.out.println("Sidecar(Si /No");
        String sideCarString = sc.next().toUpperCase();
        boolean sideCar = true;
        if (sideCarString.contentEquals("NO")){
            sideCar = false;
        }
        else if (sideCarString.contentEquals("SI")){
            sideCar = true;
        }
        System.out.print("Cilindrada: ");
        int cilindrada = sc.nextInt();
        sc.nextLine(); // Limpiar buffer
        
        Moto nuevaMoto = new Moto(marca, modelo, potencia, color, motor, fechaFabricacion, 
                                lugarFabricacion, transmission, velocidad, matricula, peso, sideCar, cilindrada);
        listaVehiculos.add(nuevaMoto);
    }
    
    private static void crearCamion(Scanner sc, ArrayList<Vehiculo> listaVehiculos) {
        System.out.println("Introduce los datos para crear un camión:");
        System.out.print("Marca: ");
        String marca = sc.nextLine();
        System.out.print("Modelo: ");
        String modelo = sc.nextLine();
        System.out.print("Matrícula: ");
        String matricula = sc.nextLine();
        System.out.print("Potencia: ");
        int potencia = sc.nextInt();
        sc.nextLine(); // Limpiar buffer
        System.out.print("Color Blue Gray Green Orange Red: ");
        String colorInput = sc.nextLine().toUpperCase();
        colorEnum color = colorEnum.valueOf(colorInput);
        System.out.print("Motor: ");
        String motorInput = sc.nextLine().toUpperCase();
        motorEnum motor = motorEnum.valueOf(motorInput);
        System.out.print("Fecha de fabricación (dd/MM/yyyy): ");
        String fechaInput = sc.nextLine();
        LocalDate fechaFabricacion = LocalDate.parse(fechaInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Lugar de fabricación: ");
        String lugarCoche = sc.nextLine();
        System.out.print("Transmisión (MANUAL / AUTOMATICA): ");
        String transmisionInput = sc.nextLine().toUpperCase();
        Transmision transmission = Transmision.valueOf(transmisionInput);
        System.out.print("Velocidad máxima: ");
        double velocidad = sc.nextDouble();
        System.out.print("Peso: ");
        double peso = sc.nextDouble();
        System.out.print("Carga máxima (kg): ");
        double carga = sc.nextDouble();
        System.out.print("Volumen (m³): ");
        double altura = sc.nextDouble();
        sc.nextLine(); // Limpiar buffer

        Camion nuevoCamion = new Camion(marca, modelo, potencia, color, motor, fechaFabricacion, lugarCoche, transmission, velocidad, matricula, peso, carga, altura);
        listaVehiculos.add(nuevoCamion);
    }

    private static void mostrarMatriculas(ArrayList<Vehiculo> listaVehiculos) {
        for (Vehiculo vehiculo : listaVehiculos) {
            System.out.println(vehiculo.getMatricula());
        }
    }

    private static void mostrarDatosPorMatricula(Scanner sc, ArrayList<Vehiculo> listaVehiculos) {
        System.out.print("Introduce la matrícula del vehículo: ");
        String matricula = sc.nextLine();
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                System.out.println(vehiculo);
                return;
            }
        }
        System.out.println("Vehículo no encontrado.");
    }

    private static void mostrarCantidadVehiculosPorTipo(ArrayList<Vehiculo> listaVehiculos, Class<?> tipo) {
        int count = 0;
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getClass().equals(tipo)) {
                count++;
            }
        }
        System.out.println("Total de " + tipo.getSimpleName() + "s creados: " + count);
    }

    private static void eliminarVehiculo(Scanner sc, ArrayList<Vehiculo> listaVehiculos) {
        System.out.print("Introduce la matrícula del vehículo a eliminar: ");
        String matricula = sc.nextLine();
        listaVehiculos.removeIf(vehiculo -> vehiculo.getMatricula().equals(matricula));
    }
    1  nuevoCoche v = new Car()
