package Ventas;


import java.io.*;

public class ArchivoCarrito {

    public static void guardarCarrito(CarritoDeCompra carrito) {
        carrito.guardarCarritoEnArchivo();
    }

    public static CarritoDeCompra cargarCarrito() {
        CarritoDeCompra carrito = new CarritoDeCompra();
        carrito.cargarCarritoDesdeArchivo();
        return carrito;
    }
}
