package model;

import colorEnum.colorEnum;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import motorEnum.motorEnum;
import transmissionEnum.Transmision;

public class Vehiculo {

    private String marca;
    private String matricula = "Por asignar";
    private String modelo;
    private int potencia;
    private colorEnum color;
    private double velocidad;
    private motorEnum motor;
    private LocalDate fechaFabricacion;
    private String lugarCoche;
    private Transmision transmission;
    private double peso;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, int potencia, colorEnum color, motorEnum motor, LocalDate fechaFabricacion, String lugarCoche, Transmision transmission, double velocidad, double peso) {
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.color = color;
        this.motor = motor;
        this.fechaFabricacion = fechaFabricacion;
        this.lugarCoche = lugarCoche;
        this.transmission = transmission;
        setVelocidad(velocidad);
        this.peso = peso;
    }

    //Funciones
    public int calcularAntiguedad() {
        LocalDate currentDate = LocalDate.now();
        Period p = Period.between(fechaFabricacion, currentDate);
        return p.getYears();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public colorEnum getColor() {
        return color;
    }

    public void setColor(colorEnum color) {
        this.color = color;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        if (velocidad >= 0) {
            this.velocidad = velocidad;
        } else {
            this.velocidad = 0;
        }
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public motorEnum getMotor() {
        return motor;
    }

    public void setMotor(motorEnum motor) {
        this.motor = motor;
    }

    public LocalDate getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(LocalDate fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public String getLugarCoche() {
        return lugarCoche;
    }

    public void setLugarCoche(String lugarCoche) {
        this.lugarCoche = lugarCoche;
    }

    public Transmision getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmision transmission) {
        this.transmission = transmission;
    }

    // Métodos para acelerar y frenar
    private void ajustarVelocidad(double cambio) {
        this.velocidad += cambio;
        if (this.velocidad < 0) {
            this.velocidad = 0;
        }
    }

    public void acelerar() {
        ajustarVelocidad(10);
    }

    public void acelerar(double incremento) {
        ajustarVelocidad(incremento);
    }

    public void frenar() {
        ajustarVelocidad(-10);
    }

    public void frenar(double decremento) {
        ajustarVelocidad(-decremento);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Car {");
        sb.append("\n marca = ").append(marca != null ? marca : "Not assigned");
        sb.append("\n matricula = ").append(matricula != null ? matricula : "Not assigned");
        sb.append("\n modelo = ").append(modelo != null ? modelo : "Not assigned");
        sb.append("\n potencia = ").append(potencia);
        sb.append("\n color = ").append(color != null ? color : "Not assigned");
        sb.append("\n velocidad = ").append(velocidad);
        sb.append("\n motor = ").append(motor != null ? motor : "Not assigned");
        sb.append("\n fechaFabricacion = ").append(fechaFabricacion != null ? fechaFabricacion : "Not assigned");
        sb.append("\n lugarCoche = ").append(lugarCoche != null ? lugarCoche : "Not assigned");
        sb.append("\n transmission = ").append(transmission != null ? transmission : "Not assigned");
        sb.append("\npeso=").append(peso);
        sb.append("\n}");
        return sb.toString();

    }
}
