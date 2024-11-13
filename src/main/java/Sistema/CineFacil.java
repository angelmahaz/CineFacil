
package Sistema;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CineFacil {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 11) {
            try {
                System.out.println("** Menú Principal **");
                
                System.out.println("1. Ver Cartelera (de la sucursal seleccionada)");
                System.out.println("2. Buscar Película");
                System.out.println("3. Cambiar Sucursal");
                System.out.println("4. Iniciar Sesión");
                System.out.println("5. Buscar Producto");
                System.out.println("6. Ver Carrito");
                System.out.println("   a. Ver Carrito (editar)");
                System.out.println("   b. Comprar");
                System.out.println("7. Actualizar Datos Personales");
                System.out.println("8. Registrarse (solo si no inició sesión)");
                System.out.println("9. Ver Mis Compras (solo si inició sesión)");
                System.out.println("10. Ver Mis Puntos (solo si inició sesión)");
                System.out.println("11. Salir");
                System.out.print("Seleccione una opción: ");

                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1 -> System.out.println("Mostrando cartelera de la sucursal seleccionada...");
                    case 2 -> System.out.println("Buscando película...");
                    case 3 -> System.out.println("Cambiando sucursal...");
                    case 4 -> System.out.println("Iniciando sesión...");
                    case 5 -> System.out.println("Buscando producto...");
                    case 6 -> {
                        System.out.println("Ver Carrito");
                        System.out.println("   a. Ver Carrito (editar)");
                        System.out.println("   b. Comprar");
                        System.out.print("Seleccione una opción para el carrito (a/b): ");
                        char subOpcion = scanner.next().charAt(0);
                        switch (subOpcion) {
                            case 'a' -> System.out.println("Editando el carrito...");
                            case 'b' -> System.out.println("Realizando la compra...");
                            default -> System.out.println("Opción inválida en el carrito.");
                        }
                    }
                    case 7 -> System.out.println("Actualizando datos personales...");
                    case 8 -> System.out.println("Registrándose...");
                    case 9 -> System.out.println("Viendo mis compras...");
                    case 10 -> System.out.println("Viendo mis puntos...");
                    case 11 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción inválida. Por favor, intente de nuevo.");
                }
                System.out.println();

            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido.");
                scanner.next(); 
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println(); 
            }
        }

        scanner.close();
        System.out.println("¡Hasta luego!");
    }
}
