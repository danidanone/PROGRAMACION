package model;

import colorEnum.colorEnum;
import java.time.LocalDate;
import java.time.Period;
import motorEnum.motorEnum;
import transmissionEnum.Transmision;


public class Camion extends Vehiculo {
    private double carga;
    private double altura;

    // Constructor vacío
    public Camion() {
    }

    // Constructor con parámetros
        public Camion(String marca, String modelo, int potencia,colorEnum color, motorEnum motor, LocalDate fechaFabricacion, String lugarFablicacion, Transmision transmission, double velocidad ,String matricula , double peso , double carga , double altura) {
        super(marca, modelo, potencia, color, motor, fechaFabricacion, lugarFablicacion, transmission, velocidad , matricula, peso);
        this.altura = altura;
        this.carga = carga;
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

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    

  
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" \n cilindrada =").append(altura);
         sb.append(" \n sidecar =").append(carga);
        sb.append("\n}");
        return sb.toString();

    }
}