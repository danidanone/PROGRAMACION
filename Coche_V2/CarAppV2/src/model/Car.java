package model;

import colorEnum.colorEnum;
import java.time.LocalDate;
import java.time.Period;
import motorEnum.motorEnum;
import transmissionEnum.Transmision;


public class Car extends Vehiculo {
    private int numeroPuertas;

    // Constructor vacío
    public Car() {
    }

    // Constructor con parámetros
    public Car(String marca, String modelo, int potencia,colorEnum color, motorEnum motor, LocalDate fechaFabricacion, String lugarFabricacion, Transmision transmission, double velocidad ,String matricula ,double peso , int numeroPuertas ){
        super(marca, modelo, potencia, color, motor, fechaFabricacion, lugarFabricacion, transmission, velocidad , matricula, peso);
        this.numeroPuertas = numeroPuertas;
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
    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

  
    @Override
    public String toString() {
            StringBuilder sb = new StringBuilder();
                sb.append(super.toString());
                sb.append(" \n numeroPuertas =").append(numeroPuertas);
                sb.append("\n}");
                return sb.toString();
                
    }

    @Override
    public double calcularConsumo() {
        double consumo = 0;
        consumo = this.getPeso();
        return consumo;
    }
}