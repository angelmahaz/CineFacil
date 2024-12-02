package Ventas;


import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

public class CarritoDeCompra implements Serializable {
    private ArrayList<Producto> productos;

    public CarritoDeCompra() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        Optional<Producto> existente = productos.stream()
            .filter(p -> p.getCodigo().equals(producto.getCodigo()))
            .findFirst();

        if (existente.isPresent()) {
            Producto existenteProducto = existente.get();
            existenteProducto.setCantidad(existenteProducto.getCantidad() + cantidad);
        } else {
            producto.setCantidad(cantidad);
            productos.add(producto);
        }
    }

    public void quitarProducto(String codigo, int cantidad) {
        Optional<Producto> existente = productos.stream()
            .filter(p -> p.getCodigo().equals(codigo))
            .findFirst();

        if (existente.isPresent()) {
            Producto producto = existente.get();
            if (producto.getCantidad() <= cantidad) {
                productos.remove(producto);
            } else {
                producto.setCantidad(producto.getCantidad() - cantidad);
            }
        }
    }

    public void mostrarCarrito() {
        if (productos.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            productos.forEach(p -> System.out.println(p + " - Cantidad: " + p.getCantidad()));
        }
    }

    public double calcularTotal() {
        return productos.stream().mapToDouble(p -> p.getPrecio() * p.getCantidad()).sum();
    }

    public void guardarCarritoEnArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("carrito.dat"))) {
            oos.writeObject(productos);
        } catch (IOException e) {
            System.err.println("Error al guardar el carrito: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void cargarCarritoDesdeArchivo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("carrito.dat"))) {
            productos = (ArrayList<Producto>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró un carrito guardado. Iniciando nuevo carrito.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar el carrito: " + e.getMessage());
        }
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
}
