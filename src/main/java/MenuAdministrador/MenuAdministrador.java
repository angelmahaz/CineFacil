

package com.poo9.proyectopoo09;

/**
 *
 * Galicia Barragan Edson
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class MenuAdministrador {

    public static void main(String[] args) {
    Scanner leerDato = new Scanner(System.in);
        System.out.println("Bienvenido al menu de Administrador del Sistema CINETIC´s");
        System.out.println("Selecciona una opción: ");
        System.out.println("1)Actualizar cartelera");
        System.out.println("2)Ver productos");
        System.out.println("3)Actualizar stock de productos");
        System.out.println("4)Agregar producto");
        System.out.println("5)Ver empleados");
        System.out.println("6)Agregar empleados");
        System.out.println("7)Ver estadisticas de ventas");
        int op  = leerDato.nextInt();
        
        switch (op){
                case 1: 
                    System.out.println("Ingrese la cantidad de funciones que desea agregar: ");
                    int cines = leerDato.nextInt();
                    for (int i=0; i<=cines; i++){
                       System.out.println("Ingresa el nombre de la función: "+(i+1));
                       String peli=leerDato.nextLine();
                       System.out.println("Ingresa la hora del estreno: ");
                       String horario = leerDato.nextLine();
                        System.out.println("Ingresa el numero de sala que ocupara esta funcion: ");
                        int numsala=leerDato.nextInt();
                        System.out.println("Ingresa la capacidad maxima de aforo: ");
                        int capa=leerDato.nextInt();
                        Sala sala = new Sala(numsala, capa);     
                        Funcion funcion = new Funcion(peli,horario, sala);
                    System.out.println("Informacion de la funcion agregada: ");
                    System.out.println("Nombre: "+ funcion.getPelicula());
                    System.out.println("Hora: "+ funcion.getHora());
                    System.out.println("Sala: "+sala.getNumero());
                    System.out.println("Capacidad maxima de aforo: "+sala.getCapacidad());
                    }
                break;
                case 2: 
                Dulceria dulceria= new Dulceria();
                AdministracionCine adminCine = new AdministracionCine();
                System.out.println("Sucursales disponibles:");
                for (Sucursal sucursal : adminCine.getSucursales()) {
                System.out.println(sucursal.getNombre());
                }
                System.out.println("Ingrese el nombre de la sucursal que desea consultar:");
                leerDato.nextLine();
                String cine=leerDato.nextLine();
                Sucursal sucursalActual = adminCine.obtenerSucursal(cine);
                System.out.println("Productos disponibles en la dulcería de " + sucursalActual.getNombre() + ":");
                for (Producto producto : dulceria.getProductosPorSucursal(sucursalActual.getNombre())) {
                System.out.println("Producto: " + producto.getNombre() + " - Código: " + producto.getCodigo() + " - Precio: $" + producto.getPrecio() + " - Categoría: " + producto.getCategoria() + " - Stock: " + producto.getStock(sucursalActual.getNombre()));
            }  
                break;
                case 3:
                AdministracionCine adminCine1 = new AdministracionCine();
                Dulceria dulcerias= new Dulceria();
                System.out.println("Ingrese la sucursal: ");
                leerDato.nextLine();
                String sucursal1 = leerDato.nextLine();
                Sucursal sucursalActual1 = adminCine1.obtenerSucursal(sucursal1);
                System.out.println("Productos disponibles en la dulcería de " + sucursalActual1.getNombre() + ":");
                for (Producto productos : dulcerias.getProductosPorSucursal(sucursalActual1.getNombre())) 
                {
                System.out.println("Producto: " + productos.getNombre() + " - Código: " + productos.getCodigo() + " - Precio: $" + productos.getPrecio() + " - Categoría: " + productos.getCategoria() + " - Stock: " + productos.getStock(sucursalActual1.getNombre()));
                }  

                // Solicitar datos para actualizar stock
                System.out.println("\nIngrese el código del producto: ");
                int codigoProducto = leerDato.nextInt();
                System.out.println("Ingrese la cantidad a agregar: ");
                int cantidad = leerDato.nextInt();
                // Actualizar el stock
                dulcerias.actualizarStock(codigoProducto, sucursal1, cantidad);
                // Mostrar productos nuevamente después de actualizar stock
                System.out.println("\nProductos después de actualizar el stock:");
                for (Producto productos : dulcerias.getProductosPorSucursal(sucursalActual1.getNombre())) 
                {
                System.out.println("Producto: " + productos.getNombre() + " - Código: " + productos.getCodigo() + " - Precio: $" + productos.getPrecio() + " - Categoría: " + productos.getCategoria() + " - Stock: " + productos.getStock(sucursalActual1.getNombre()));
                }  
                break;
                case 4: 
                AdministracionCine adminCine2 = new AdministracionCine();
                Dulceria dulceria2= new Dulceria();
                System.out.println("Ingrese la sucursal: ");
                leerDato.nextLine();
                String sucursal2 = leerDato.nextLine();
                    System.out.println("Ingrese el nombre del producto: ");
                    String nombre = leerDato.nextLine();
                    System.out.println("Ingrese el código del producto: ");
                    int codigo = leerDato.nextInt();
                    System.out.println("Ingrese el precio del producto: ");
                    int precio = leerDato.nextInt();
                    leerDato.nextLine(); // Consumir el salto de línea
                    System.out.println("Ingrese la categoría del producto: ");
                    String categoria = leerDato.nextLine();
                    System.out.println("Ingresa la cantidad de Stock del producto: ");
                    int stk=leerDato.nextInt();
                    Dulceria dulceNuevo=new Dulceria();
                    dulceNuevo.agregarProducto(nombre, codigo, precio, categoria, sucursal2, stk); 
                    dulceNuevo.getProductosPorSucursal(sucursal2);
                    Sucursal sucursalActual2 = adminCine2.obtenerSucursal(sucursal2);
                    System.out.println("Productos disponibles en la dulcería de " + sucursalActual2.getNombre() + ":");
                    for (Producto productos : dulceNuevo.getProductosPorSucursal(sucursalActual2.getNombre())) 
                {
                    System.out.println("Producto: " + productos.getNombre() + " - Código: " + productos.getCodigo() + " - Precio: $" + productos.getPrecio() + " - Categoría: " + productos.getCategoria() + " - Stock: " + productos.getStock(sucursalActual2.getNombre()));
                }  
                   
                    System.out.println("Producto agregado con éxito.");
                    break;
                default:
                break;
    }
    }
    }
    
    

