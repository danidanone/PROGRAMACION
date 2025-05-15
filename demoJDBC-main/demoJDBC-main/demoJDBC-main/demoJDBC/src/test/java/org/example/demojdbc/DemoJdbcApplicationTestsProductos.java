package org.example.demojdbc;

import jakarta.transaction.Transactional;
import org.example.demojdbc.model.Producto;
import org.example.demojdbc.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class DemoJdbcApplicationTestsProductos {

    @Autowired
    ProductoRepository repositorio;

    @BeforeEach
    void setUp() {
        repositorio.borrarTodos();
        repositorio.insertar(new Producto("Laptop", "Laptop de alta gama", 1500.99));
        repositorio.insertar(new Producto("Mouse", "Mouse inalámbrico", 25.50));
    }

    @Test
    void borrarTodos() {
        repositorio.borrarTodos();
        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(0, lista.size());
    }

    @Test
    void insertarProducto() {
        Producto producto = new Producto("Teclado", "Teclado mecánico", 45.99);
        repositorio.insertar(producto); // total: 3
        producto = new Producto("Monitor", "Monitor 4K", 299.99);
        repositorio.insertar(producto); // total: 4
        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(4, lista.size());
    }

    @Test
    void buscarTodos() {
        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(2, lista.size());
    }

    @Test
    void borrarProducto() {
        Producto producto = new Producto("Auriculares", "Auriculares Bluetooth", 75.00);
        repositorio.insertar(producto);
        repositorio.borrar(producto);
        List<Producto> lista = repositorio.buscarTodos();
        assertEquals(2, lista.size());
    }

    @Test
    void buscarUno() {
        Producto producto = repositorio.buscarUno("Laptop");
        assertEquals("Laptop", producto.getNombre());
    }
}