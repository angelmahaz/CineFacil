
package Sistema;

import Cliente.Usuario;
import Sucursales_y_Peliculas.Boleto;
import Sucursales_y_Peliculas.Funcion;
import Sucursales_y_Peliculas.Sucursal;
import Ventas.CarritoDeCompra;
import Ventas.Dulceria;
import Ventas.Producto;
import Ventas.TicketVirtual;
import java.util.Scanner;
import java.util.UUID;

public class CineFacil {
    private static AdministracionCine adminCine = new AdministracionCine();
    private static Sucursal sucursalActual;
    private static Usuario usuarioActual;
    private static Dulceria dulceria = new Dulceria();
    private static CarritoDeCompra carritoDeCompra = new CarritoDeCompra();

    public static void main(String[] args) {
        inicializarSucursales();
        mostrarMenu();
    }

    private static void inicializarSucursales() {
        // Inicializar las sucursales
        sucursalActual = adminCine.obtenerSucursal("CINE-TICs CU");
    }

    private static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Menú:");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Iniciar Sesión");
            System.out.println("3. Seleccionar Cine");
            System.out.println("4. Comprar Boletos");
            System.out.println("5. Ver Dulcería");
            System.out.println("6. Ver Carrito de Compras");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar

            switch (opcion) {
                case 1:
                    registrarCliente(scanner);
                    break;
                case 2:
                    iniciarSesion(scanner);
                    break;
                case 3:
                    seleccionarCine(scanner);
                    break;
                case 4:
                    comprarBoletos(scanner);
                    break;
                case 5:
                    verDulceria(scanner);
                    break;
                case 6:
                    verCarritoDeCompras(scanner);
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scanner.close();
    }

    private static void registrarCliente(Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido Paterno: ");
        String apellidoPaterno = scanner.nextLine();

        System.out.print("Apellido Materno: ");
        String apellidoMaterno = scanner.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Celular: ");
        String celular = scanner.nextLine();

        System.out.print("Correo Electrónico: ");
        String correoElectronico = scanner.nextLine();

        String contrasena;
        while (true) {
            System.out.print("Contraseña (mínimo 8 caracteres): ");
            contrasena = scanner.nextLine();
            if (contrasena.length() >= 8) {
                break;
            } else {
                System.out.println("La contraseña debe tener al menos 8 caracteres.");
            }
        }

        Usuario nuevoUsuario = new Usuario(nombre, apellidoPaterno, apellidoMaterno, direccion, celular, correoElectronico, contrasena);
        boolean registrado = adminCine.registrarUsuario(nuevoUsuario);
        if (registrado) {
            System.out.println("Registro exitoso. Ahora puede iniciar sesión.");
        } else {
            System.out.println("El correo electrónico ya está registrado. Intente con otro correo.");
        }
    }

    private static void iniciarSesion(Scanner scanner) {
        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        Usuario usuario = adminCine.obtenerUsuario(correo, contrasena);
        if (usuario != null) {
            usuarioActual = usuario;
            System.out.println("Inicio de sesión exitoso. Bienvenido, " + usuarioActual.getNombre() + "!");
        } else {
            System.out.println("Correo electrónico o contraseña incorrectos. Intente de nuevo.");
        }
    }

    private static void seleccionarCine(Scanner scanner) {
        System.out.println("Sucursales disponibles:");
        for (Sucursal sucursal : adminCine.getSucursales()) {
            System.out.println(sucursal.getNombre());
        }
        System.out.print("Ingrese el nombre de la sucursal a la que desea cambiar: ");
        String nombreSucursal = scanner.nextLine();
        Sucursal nuevaSucursal = adminCine.obtenerSucursal(nombreSucursal);
        if (nuevaSucursal != null) {
            sucursalActual = nuevaSucursal;
            System.out.println("Sucursal cambiada a " + sucursalActual.getNombre());
            verCartelera();
        } else {
            System.out.println("Sucursal no encontrada.");
        }
    }

    private static void verCartelera() {
        System.out.println("Cartelera de " + sucursalActual.getNombre() + ":");
        for (Funcion funcion : sucursalActual.getFunciones()) {
            System.out.println("Película: " + funcion.getPelicula() + " - Horarios: " + funcion.getHora() + " - Sala: " + funcion.getSala().getNumero());
        }
    }

    private static void comprarBoletos(Scanner scanner) {
        if (usuarioActual == null) {
            System.out.println("Debe iniciar sesión para comprar boletos.");
            return;
        }

        System.out.println("Cartelera de " + sucursalActual.getNombre() + ":");
        for (int i = 0; i < sucursalActual.getFunciones().size(); i++) {
            Funcion funcion = sucursalActual.getFunciones().get(i);
            System.out.println((i + 1) + ". Película: " + funcion.getPelicula() + " - Horarios: " + funcion.getHora() + " - Sala: " + funcion.getSala().getNumero());
        }

        System.out.print("Seleccione el número de la función que desea ver: ");
        int seleccion = scanner.nextInt();
        scanner.nextLine(); // Limpiar

        if (seleccion < 1 || seleccion > sucursalActual.getFunciones().size()) {
            System.out.println("Selección no válida.");
            return;
        }

        Funcion funcionSeleccionada = sucursalActual.getFunciones().get(seleccion - 1);
        System.out.println("Costo de la entrada por persona:");
        System.out.println("Adulto: $80");
        System.out.println("Niño: $50");

        System.out.print("Ingrese la cantidad de boletos de adulto que desea comprar: ");
        int cantidadAdultos = scanner.nextInt();
        scanner.nextLine(); // Limpiar

        System.out.print("Ingrese la cantidad de boletos de niño que desea comprar: ");
        int cantidadNinos = scanner.nextInt();
        scanner.nextLine(); // Limpiar

        carritoDeCompra.agregarBoletos(cantidadAdultos, cantidadNinos);
        Boleto.realizarPago(scanner, usuarioActual, cantidadAdultos, cantidadNinos);
        System.out.println("Ha comprado " + cantidadAdultos + " boletos de adulto y " + cantidadNinos + " boletos de niño para la película " + funcionSeleccionada.getPelicula() + " en la sala " + funcionSeleccionada.getSala().getNumero() + " a las " + funcionSeleccionada.getHora() + ".");

        System.out.print("¿Desea agregar productos de la tienda a su compra? (1: sí, 0: no): ");
        int respuesta = scanner.nextInt();
        scanner.nextLine(); // Limpiar
        if (respuesta == 1) {
            agregarProductos(scanner);
        }

        generarTicketVirtual(scanner);
    }

    private static void agregarProductos(Scanner scanner) {
        String identificadorConsumo = UUID.randomUUID().toString();
        System.out.println("Identificador de consumo: " + identificadorConsumo);

        boolean agregarMas = true;
        while (agregarMas) {
            System.out.println("Productos disponibles en la dulcería de " + sucursalActual.getNombre() + ":");
            for (Producto producto : dulceria.getProductosPorSucursal(sucursalActual.getNombre())) {
                System.out.println("Producto: " + producto.getNombre() + " - Código: " + producto.getCodigo() + " - Precio: $" + producto.getPrecio() + " - Categoría: " + producto.getCategoria() + " - Stock: " + producto.getStock(sucursalActual.getNombre()));
            }

            System.out.print("Ingrese el código del producto que desea agregar: ");
            String codigoProducto = scanner.nextLine();
            Producto productoSeleccionado = null;
            for (Producto producto : dulceria.getProductosPorSucursal(sucursalActual.getNombre())) {
                if (producto.getCodigo().equals(codigoProducto)) {
                    productoSeleccionado = producto;
                    break;
                }
            }

            if (productoSeleccionado == null) {
                System.out.println("Producto no encontrado. Intente de nuevo.");
                continue;
            }

            System.out.print("Ingrese la cantidad que desea agregar: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Limpiar

            if (cantidad > productoSeleccionado.getStock(sucursalActual.getNombre())) {
                System.out.println("Cantidad no disponible en stock. Intente de nuevo.");
                continue;
            }

            carritoDeCompra.agregarProducto(productoSeleccionado, cantidad);
            System.out.println("Ha agregado " + cantidad + " " + productoSeleccionado.getNombre() + "(s) a su compra.");

            System.out.print("¿Desea agregar más productos? (1: sí, 0: no): ");
            int respuesta = scanner.nextInt();
            scanner.nextLine(); // Limpiar
            if (respuesta != 1) {
                agregarMas = false;
            }
        }

        carritoDeCompra.mostrarCarrito();
        System.out.println("Productos agregados a su compra. Identificador de consumo: " + identificadorConsumo);
    }

    private static void verCarritoDeCompras(Scanner scanner) {
        boolean editarCarrito = true;
        while (editarCarrito) {
            carritoDeCompra.mostrarCarrito();
            System.out.println("Opciones:");
            System.out.println("1. Agregar productos");
            System.out.println("2. Quitar productos");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar

            switch (opcion) {
                case 1:
                    agregarProductos(scanner);
                    break;
                case 2:
                    quitarProductos(scanner);
                    break;
                case 3:
                    editarCarrito = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void quitarProductos(Scanner scanner) {
        System.out.print("Ingrese el código del producto que desea quitar: ");
        String codigoProducto = scanner.nextLine();
        Producto productoSeleccionado = null;
        int indiceProducto = -1;
        for (int i = 0; i < carritoDeCompra.getProductos().size(); i++) {
            Producto producto = carritoDeCompra.getProductos().get(i);
            if (producto.getCodigo().equals(codigoProducto)) {
                productoSeleccionado = producto;
                indiceProducto = i;
                break;
            }
        }

        if (productoSeleccionado == null) {
            System.out.println("Producto no encontrado en el carrito. Intente de nuevo.");
            return;
        }

        System.out.print("Ingrese la cantidad que desea quitar: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar

        if (cantidad > carritoDeCompra.getCantidades().get(indiceProducto)) {
            System.out.println("Cantidad no disponible en el carrito. Intente de nuevo.");
            return;
        }

        carritoDeCompra.quitarProducto(indiceProducto, cantidad);
        System.out.println("Ha quitado " + cantidad + " " + productoSeleccionado.getNombre() + "(s) de su carrito.");
    }

    private static void verDulceria(Scanner scanner) {
        System.out.println("Productos disponibles en la dulcería de " + sucursalActual.getNombre() + ":");
        for (Producto producto : dulceria.getProductosPorSucursal(sucursalActual.getNombre())) {
            System.out.println("Producto: " + producto.getNombre() + " - Código: " + producto.getCodigo() + " - Precio: $" + producto.getPrecio() + " - Categoría: " + producto.getCategoria() + " - Stock: " + producto.getStock(sucursalActual.getNombre()));
        }
    }

    private static void generarTicketVirtual(Scanner scanner) {
        TicketVirtual ticket = new TicketVirtual(sucursalActual.getNombre(), carritoDeCompra);
        ticket.mostrarTicket();
        ticket.guardarTicketEnArchivo();
        Boleto.realizarPagoFinal(scanner, usuarioActual, carritoDeCompra.getTotal());
    }
}
