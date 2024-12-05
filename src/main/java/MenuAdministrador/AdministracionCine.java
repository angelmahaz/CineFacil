
package com.poo9.proyectopoo09;
import java.util.ArrayList;
import java.util.List;

public class AdministracionCine {
    private List<Sucursal> sucursales;
    private List<Usuario> usuarios;

    public AdministracionCine() {
        this.sucursales = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        inicializarSucursales();
    }

    public void agregarSucursal(Sucursal sucursal) {
        sucursales.add(sucursal);
    }

    public Sucursal obtenerSucursal(String nombre) {
        for (Sucursal sucursal : sucursales) {
            if (sucursal.getNombre().equals(nombre)) {
                return sucursal;
            }
        }
        return null;
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public boolean registrarUsuario(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u.getCorreoElectronico().equals(usuario.getCorreoElectronico())) {
                return false; // Usuario ya registrado
            }
        }
        usuarios.add(usuario);
        return true;
    }

    public Usuario obtenerUsuario(String correo, String contrasena) {
        for (Usuario u : usuarios) {
            if (u.getCorreoElectronico().equals(correo) && u.iniciarSesion(correo, contrasena)) {
                return u;
            }
        }
        return null;
    }

    private void inicializarSucursales() {
        // Inicializar las sucursales con sus salas y funciones
        Sucursal cu = new Sucursal("CINE-TICs CU");
        cu.agregarSala(new Sala(1, 120));
        cu.agregarSala(new Sala(2, 150));
        cu.agregarSala(new Sala(3, 200));
        cu.agregarFuncion(new Funcion("Five Nights at Freddy's", "22:00 a 00:00", cu.getSalas().get(2)));
        cu.agregarFuncion(new Funcion("Matrix", "19:30 a 21:30", cu.getSalas().get(1)));
        cu.agregarFuncion(new Funcion("Deadpool & Wolverine", "18:00 a 20:00", cu.getSalas().get(0)));
        cu.agregarFuncion(new Funcion("Oppenheimer", "19:30 a 21:30", cu.getSalas().get(2)));
        cu.agregarFuncion(new Funcion("Barbie", "16:00 a 17:30", cu.getSalas().get(0)));
        agregarSucursal(cu);

        Sucursal universidad = new Sucursal("CINE-TICs Universidad");
        universidad.agregarSala(new Sala(1, 100));
        universidad.agregarSala(new Sala(2, 160));
        universidad.agregarSala(new Sala(3, 175));
        universidad.agregarFuncion(new Funcion("Five Nights at Freddy's", "20:30 a 22:30", universidad.getSalas().get(0)));
        universidad.agregarFuncion(new Funcion("Rápidos y Furiosos 10", "18:00 a 20:00", universidad.getSalas().get(0)));
        universidad.agregarFuncion(new Funcion("Super Mario Bros", "13:00 a 15:00", universidad.getSalas().get(2)));
        universidad.agregarFuncion(new Funcion("Deadpool & Wolverine", "20:30 a 22:30", universidad.getSalas().get(1)));
        universidad.agregarFuncion(new Funcion("Godzilla vs Kong 2", "13:00 a 15:00", universidad.getSalas().get(2)));
        agregarSucursal(universidad);

        Sucursal delta = new Sucursal("CINE-TICs Delta");
        delta.agregarSala(new Sala(1, 80));
        delta.agregarSala(new Sala(2, 100));
        delta.agregarSala(new Sala(3, 150));
        delta.agregarFuncion(new Funcion("Hércules", "16:00 a 17:30", delta.getSalas().get(1)));
        delta.agregarFuncion(new Funcion("Hellboy", "22:00 a 00:00", delta.getSalas().get(1)));
        delta.agregarFuncion(new Funcion("Super Mario Bros", "16:30 a 19:00", delta.getSalas().get(2)));
        delta.agregarFuncion(new Funcion("El Rey León: Mufasa", "16:30 a 19:00", delta.getSalas().get(0)));
        delta.agregarFuncion(new Funcion("Deadpool & Wolverine", "22:00 a 00:00", delta.getSalas().get(2)));
        agregarSucursal(delta);

        Sucursal xochimilco = new Sucursal("CINE-TICs Xochimilco");
        xochimilco.agregarSala(new Sala(1, 90));
        xochimilco.agregarSala(new Sala(2, 125));
        xochimilco.agregarSala(new Sala(3, 140));
        xochimilco.agregarFuncion(new Funcion("Hércules", "13:00 a 15:00", xochimilco.getSalas().get(2)));
        xochimilco.agregarFuncion(new Funcion("Deadpool & Wolverine", "19:30 a 21:30", xochimilco.getSalas().get(0)));
        xochimilco.agregarFuncion(new Funcion("Super Mario Bros", "16:00 a 17:30", xochimilco.getSalas().get(2)));
        xochimilco.agregarFuncion(new Funcion("El Rey León", "14:00 a 15:30", xochimilco.getSalas().get(1)));
        xochimilco.agregarFuncion(new Funcion("Alien Romulus", "20:30 a 22:30", xochimilco.getSalas().get(1)));
        agregarSucursal(xochimilco);
    }

    public void mostrarCartelera() {
        for (Sucursal sucursal : sucursales) {
            System.out.println("Cartelera de " + sucursal.getNombre() + ":");
            System.out.println("-------------------------------------------------");
            System.out.printf("%-30s %-20s %-10s\n", "Película", "Horario", "Sala"); 
            System.out.println("-------------------------------------------------");
            for (Funcion funcion : sucursal.getFunciones()) {
                System.out.printf("%-30s %-20s %-10d\n", funcion.getPelicula(), funcion.getHora(), funcion.getSala().getNumero());
            }
            System.out.println("-------------------------------------------------\n");
        }
    }

    public static void main(String[] args) {
        AdministracionCine adminCine = new AdministracionCine();
        adminCine.mostrarCartelera();
    }
}
