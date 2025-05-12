package monlau.model;

public class Producto {
    private Integer id;
    private String nombre;
    private Double precio;

    // Constructor vacío (NoArgsConstructor)
    public Producto() {
    }

    // Constructor con todos los argumentos (AllArgsConstructor)
    public Producto(Integer id, String nombre, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    // Método toString (equivalente al proporcionado por @Data)
    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    // Métodos equals y hashCode (equivalentes a los proporcionados por @Data)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Producto producto = (Producto) o;

        if (id != null ? !id.equals(producto.id) : producto.id != null) return false;
        if (nombre != null ? !nombre.equals(producto.nombre) : producto.nombre != null) return false;
        return precio != null ? precio.equals(producto.precio) : producto.precio == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (precio != null ? precio.hashCode() : 0);
        return result;
    }
}