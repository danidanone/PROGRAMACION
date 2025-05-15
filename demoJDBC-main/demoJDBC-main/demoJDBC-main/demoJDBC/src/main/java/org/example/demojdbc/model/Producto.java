package org.example.demojdbc.model;

public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;

    // Getter y Setter para id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter y Setter para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para descripcion
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getter y Setter para precio
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Constructor sin parámetros
    public Producto() {
    }

    // Constructor con todos los campos (sin id)
    public Producto(String nombre, String descripcion, double precio) {
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Constructor con solo el nombre
    public Producto(String nombre) {
        this.nombre = nombre;
    }
}