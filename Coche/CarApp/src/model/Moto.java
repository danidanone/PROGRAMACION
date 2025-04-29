package model;

import colorEnum.colorEnum;
import java.time.LocalDate;
import java.time.Period;
import motorEnum.motorEnum;
import transmissionEnum.Transmision;

public class Moto extends Vehiculo {

    private boolean sideCar;
    private int cilindrada;

    // Constructor vacío
    public Moto() {

    }

    // Constructor con parámetros
    public Moto(String marca, String modelo, int potencia, boolean sideCar, int cilindrada, colorEnum color, motorEnum motor, LocalDate fechaFabricacion, String lugarCoche, Transmision transmission, double velocidad , double peso) {
        super(marca, modelo, potencia, color, motor, fechaFabricacion, lugarCoche, transmission, velocidad , peso);
        this.sideCar = sideCar;
        this.cilindrada = cilindrada;
    }

    // Función para calcular la antigüedad del coche
    @Override
    public int calcularAntiguedad() {
        if (getFechaFabricacion() == null) {
            return 0; // Evita NullPointerException
        }
        return Period.between(getFechaFabricacion(), LocalDate.now()).getYears();
    }

    // Getters y Setters
    public boolean isSideCar() {
        return sideCar;
    }

    public void setSideCar(boolean sideCar) {
        this.sideCar = sideCar;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" \n cilindrada =").append(cilindrada);
         sb.append(" \n sidecar =").append(sideCar);
        sb.append("\n}");
        return sb.toString();

    }
}

