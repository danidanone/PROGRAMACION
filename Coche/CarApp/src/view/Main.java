package view;

import model.Car;
import colorEnum.colorEnum;
import motorEnum.motorEnum;
import transmissionEnum.Transmision;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import model.Moto;
import model.Vehiculo;

public class Main {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaFabricacion = LocalDate.parse("24/02/2023", formatter);
        ArrayList<Car> listaCoches = new ArrayList<Car>();
        Car miCoche = new Car("Toyota", "Corolla", 120, 4, colorEnum.Red, motorEnum.gasolina, fechaFabricacion, "Madrid", Transmision.manual, 240 , 0);
        Scanner sc = new Scanner(System.in);
        // Convertir la fecha de fabricación a LocalDate
        miCoche.setPeso(1200);
        calcularConsumo(miCoche);
        
        // Crear un coche con valores conocidos en la fabricación
        int opcion;
        Moto miMoto = new Moto("Kawasaki", "Ninja", 130, false, 1000, colorEnum.Green, motorEnum.gasolina, fechaFabricacion, "Marruecos", Transmision.manual, 260, 160);
        System.out.println(miMoto);
        System.out.println("Tamaño de listaCoches:" + listaCoches.size());
        listaCoches.add(miCoche);
        System.out.println("Tamaño de listaCoches:" + listaCoches.size());
        Car cocheBuscado = null;

        Vehiculo vehiculo = new Vehiculo();
        
        int numero = 0;
        
        for (Car elemCoche : listaCoches) {

            listaCoches.remove(cocheBuscado);
            System.out.println("Elemento borrado");
            System.out.println("Final Bucle");
            numero ++;
        }

        System.out.println("");
        do {
            System.out.println("======MENU======");
            System.out.println("1: Calcular Antiguedad");
            System.out.println("2: Acelerar la cantidad especificada");
            System.out.println("3: Acelerar cantidad No especifica");
            System.out.println("4: Frenar cantidad especificada");
            System.out.println("5: Frenar cantidad No especidicada");
            System.out.println("6: Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    CalcularAntiguedad(miCoche);

                    break;
                case 2:
                    acelerarCantiadEspecificada(miCoche, sc);
                    break;
                case 3:
                    acelerarCantidadNoEspecificada(miCoche);
                    break;
                case 4:
                    frenarCantidadEspecificada(miCoche, sc);
                    break;
                case 5:
                    frenarCantidadNoEspecificada(miCoche);
                    break;
                case 6:
                    System.out.println("Saliendo.....");
                    break;
                default:
                    System.out.println("Opcion invalida vuelve a intentarlo: ");
            }

        } while (opcion != 6);

    }

    private static void CalcularAntiguedad(Car coche) {
        System.out.println("La antigüedad del coche es: " + coche.calcularAntiguedad() + " años");

    }

    private static void acelerarCantiadEspecificada(Car coche, Scanner sc) {
        System.out.print("Introduce la cantidad para acelerar: ");
        double incremento = sc.nextDouble();
        coche.acelerar(incremento);
        System.out.println("La velocidad actual es: " + coche.getVelocidad() + " km/h");
    }

    private static void acelerarCantidadNoEspecificada(Car coche) {
        coche.acelerar();  // Acelera con el valor por defecto (10)
        System.out.println("La velocidad actual es: " + coche.getVelocidad() + " km/h");
    }

    private static void frenarCantidadEspecificada(Car coche, Scanner sc) {
        System.out.print("Introduce la cantidad para frenar: ");
        double decremento = sc.nextDouble();
        coche.frenar(decremento);
        System.out.println("La velocidad actual es: " + coche.getVelocidad() + " km/h");

    }

    private static void frenarCantidadNoEspecificada(Car coche) {
        coche.frenar();  // Frena con el valor por defecto (10)
        System.out.println("La velocidad actual es: " + coche.getVelocidad() + " km/h");
    }

    private static void calcularConsumo(Car cochecillo) {
        System.out.println("El consumo es de: " + cochecillo.getPeso() * 10 / 100);
    }

}
