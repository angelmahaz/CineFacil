package Administracion;

import Cliente.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.time.LocalTime;

public final class AdministracionCine {

    public final ArrayList<Sucursal> sucursales;
    private List<Usuario> usuarios;
    
    // Constructor
    public AdministracionCine() {
        this.sucursales = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        usuarios.add(new Usuario("", "", "1", "","", "", ""));
        usuarios.add(new Usuario("", "", "2", "","", "", ""));
        
        inicializarCines();
    }
    
    
     public void inicializarCines(){
        //Lists de peliculas en cada sucursal
        ArrayList<Peliculas> PeliculasCU = new ArrayList<>();
        ArrayList<Peliculas> PeliculasUniversidad = new ArrayList<>();
        ArrayList<Peliculas> PeliculasDelta = new ArrayList<>();
        ArrayList<Peliculas> PeliculasXochimilco = new ArrayList<>();
        
        //Sucursales
        Sucursal CU = new Sucursal("CU", PeliculasCU, 120, 150, 200);
        Sucursal Universidad = new Sucursal("Universidad",PeliculasUniversidad, 100, 160, 175);
        Sucursal Delta = new Sucursal("Delta", PeliculasDelta, 80, 100, 150);
        Sucursal Xochimilco = new Sucursal("Xochimilco", PeliculasXochimilco, 90, 125, 140);
        
        sucursales.add(CU);
        sucursales.add(Universidad);
        sucursales.add(Delta);
        sucursales.add(Xochimilco);
          
     
        //CU
        Peliculas Five_Nights_at_Freddys_CU = new Peliculas ("Five Nights at Freddys",3,120 );
        Five_Nights_at_Freddys_CU.setHorarioInicio("22:00");
        
        Peliculas Matrix_CU = new Peliculas ("Matrix", 2 , 120);
        Matrix_CU.setHorarioInicio("19:30");
        
        Peliculas Deadpool_Wolverine_CU = new Peliculas ("Deadpool & Wolverine",1,120);
        Deadpool_Wolverine_CU.setHorarioInicio("18:20");
        
        Peliculas Oppenheimer_CU = new Peliculas ("Oppenheimer",1, 120);
        Oppenheimer_CU.setHorarioInicio("19:30");
        
        Peliculas Barbie_CU = new Peliculas ("Barbie",1, 90);
        Barbie_CU.setHorarioInicio("16:00");
        // Agregar películas a la lista de CU
        PeliculasCU.add(Five_Nights_at_Freddys_CU);
        PeliculasCU.add(Matrix_CU);
        PeliculasCU.add(Deadpool_Wolverine_CU);
        PeliculasCU.add(Oppenheimer_CU);
        PeliculasCU.add(Barbie_CU);
                
        //Universidad
        Peliculas Five_Nights_at_Freddys_Universidad = new Peliculas ("Five Nights at Freddys",1,120);
        Five_Nights_at_Freddys_Universidad.setHorarioInicio("20:30");        
        
        Peliculas Rápidos_y_Furiosos_10_Universidad = new Peliculas("Rápidos_y_Furiosos_10",1,120);
        Rápidos_y_Furiosos_10_Universidad.setHorarioInicio("18:00");
        
        Peliculas Super_Mario_Bros_Universidad = new Peliculas("Super Mario Bros",3,120);
        Super_Mario_Bros_Universidad.setHorarioInicio("13:00");
        
        Peliculas Deadpool_Wolverine_Universidad = new Peliculas("Deadpool_Wolverine",2,140);
        Deadpool_Wolverine_Universidad.setHorarioInicio("20:30");
        
        Peliculas Godzilla_vs_Kong_2_Universidad = new Peliculas("Godzilla_vs_Kong_2",3,120);
        Godzilla_vs_Kong_2_Universidad.setHorarioInicio("13:00");
        
        // Agregar películas a la lista de Universidad
        PeliculasUniversidad.add(Five_Nights_at_Freddys_Universidad);
        PeliculasUniversidad.add(Rápidos_y_Furiosos_10_Universidad);
        PeliculasUniversidad.add(Super_Mario_Bros_Universidad);
        PeliculasUniversidad.add(Deadpool_Wolverine_Universidad);
        PeliculasUniversidad.add(Godzilla_vs_Kong_2_Universidad);
        
        Peliculas Hércules_Delta = new Peliculas("Hércules",2,90);
        Hércules_Delta.setHorarioInicio("16:00");
        
        Peliculas Hellboy_Delta = new Peliculas("Hellboy",2,120);
        Hellboy_Delta.setHorarioInicio("22:00");
        
        Peliculas Super_Mario_Bros_Delta = new Peliculas("Super_Mario_Bros",3,150);
        Super_Mario_Bros_Delta.setHorarioInicio("16:30");
        
        Peliculas El_Rey_León_Delta = new Peliculas("El_Rey_León",1,150);
        El_Rey_León_Delta.setHorarioInicio("16:30");
        
        Peliculas Deadpool_Wolverine_Delta = new Peliculas("Deadpool & Wolverine",3,120);
        Deadpool_Wolverine_Delta.setHorarioInicio("22:00");
        
        PeliculasDelta.add(Hércules_Delta);
        PeliculasDelta.add(Hellboy_Delta);
        PeliculasDelta.add(Super_Mario_Bros_Delta);
        PeliculasDelta.add(El_Rey_León_Delta);
        PeliculasDelta.add(Deadpool_Wolverine_Delta);
        
        Peliculas Hércules_Xochimilco = new Peliculas("Hércules",3,120);
        Hércules_Xochimilco.setHorarioInicio("13:00");
        
        Peliculas Deadpool_Wolverine_Xochimilco = new Peliculas("Deadpool & Wolverine",1,120);
        Deadpool_Wolverine_Xochimilco.setHorarioInicio("19:30");
        
        Peliculas Super_Mario_Bros_Xochimilco = new Peliculas("Super Mario Bros",3,90);
        Super_Mario_Bros_Xochimilco.setHorarioInicio("16:00");
        
        Peliculas  El_Rey_León_Xochimilco = new Peliculas("El_Rey_León",2,90);
        El_Rey_León_Xochimilco.setHorarioInicio("14:00");
        
        Peliculas  Alien_Romulus_Xochimilco = new Peliculas("Alien Romulus",2,120);
        Alien_Romulus_Xochimilco.setHorarioInicio("20:30");
        
        PeliculasXochimilco.add(Hércules_Xochimilco);
        PeliculasXochimilco.add(Deadpool_Wolverine_Xochimilco);
        PeliculasXochimilco.add(Super_Mario_Bros_Xochimilco);
        PeliculasXochimilco.add(El_Rey_León_Xochimilco);
        PeliculasXochimilco.add(Alien_Romulus_Xochimilco);
     
    }
    
    public static void mostrarPeliculasDeSucursal(Sucursal sucursal) {
        System.out.println("\n========================================");
        System.out.println("         Películas en " + sucursal.getNombre());
        System.out.println("========================================");
        System.out.printf("| %-30s | %-10s | %-10s |\n", "Nombre de Película", "Horario", "Sala");
        System.out.println("----------------------------------------");

        for (Peliculas pelicula : sucursal.getPeliculas()) {
            System.out.printf("| %-30s | %-10s | %-10d |\n",
                    pelicula.getNombreDePelicula(),
                    (pelicula.getHorarioInicio() != null ? pelicula.getHorarioInicio().toString() : "No definido"),
                    pelicula.getSala());
        }

        System.out.println("========================================\n");
    }
 
    public static void comprarBoleto(Sucursal sucursal, Scanner scanner) {
        // Mostrar las películas disponibles
        System.out.println("\n========================================");
        System.out.println("         Comprar Boleto en " + sucursal.getNombre());
        System.out.println("========================================");

        // Listar las películas con índices
        List<Peliculas> peliculas = sucursal.getPeliculas();
        if (peliculas.isEmpty()) {
            System.out.println("No hay películas disponibles en esta sucursal.");
            return;
        }

        for (int i = 0; i < peliculas.size(); i++) {
            Peliculas pelicula = peliculas.get(i);
            System.out.printf("%d. %s (Horario: %s, Sala: %d, Capacidad restante: %d)\n",
                    i + 1,
                    pelicula.getNombreDePelicula(),
                    (pelicula.getHorarioInicio() != null ? pelicula.getHorarioInicio().toString() : "No definido"),
                    pelicula.getSala(),
                    sucursal.getSalas().getOrDefault(pelicula.getSala(), 0)); // Mostrar capacidad
        }
        System.out.println("========================================");

        // Seleccionar una película
        System.out.print("Seleccione el número de la película que desea: ");
        int seleccion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        // Validar la selección
        if (seleccion < 1 || seleccion > peliculas.size()) {
            System.out.println("Selección inválida. Inténtelo de nuevo.");
            return;
        }

        Peliculas peliculaSeleccionada = peliculas.get(seleccion - 1);

        // Mostrar detalles de la película seleccionada
        System.out.println("\n========================================");
        System.out.println("Detalles de la película seleccionada:");
        System.out.println("Nombre: " + peliculaSeleccionada.getNombreDePelicula());
        System.out.println("Horario: " + (peliculaSeleccionada.getHorarioInicio() != null
                ? peliculaSeleccionada.getHorarioInicio().toString()
                : "No definido"));
        System.out.println("Sala: " + peliculaSeleccionada.getSala());
        System.out.println("Resumen: " + peliculaSeleccionada.getResumen());
        System.out.println("Sinopsis: " + peliculaSeleccionada.getSinopsis());
        System.out.println("Actores: " + peliculaSeleccionada.getActores());
        System.out.println("Clasificación: " + peliculaSeleccionada.getClasificacion());
        System.out.println("Capacidad restante: " + sucursal.getSalas().getOrDefault(peliculaSeleccionada.getSala(), 0));
        System.out.println("========================================");

        // Confirmar compra
        System.out.print("¿Desea comprar un boleto para esta película? (s/n): ");
        String confirmar = scanner.nextLine().toLowerCase();

        if (confirmar.equals("s")) {
            // Reducir capacidad de la sala
            if (sucursal.reducirCapacidadSala(peliculaSeleccionada.getSala())) {
                // Generar el boleto
                Boleto boleto = new Boleto(
                        UUID.randomUUID().toString(),
                        sucursal.getNombre(),
                        peliculaSeleccionada.getNombreDePelicula(),
                        peliculaSeleccionada.getHorarioInicio(),
                        peliculaSeleccionada.getSala()
                );

                // Programar liberación automática de la sala
                peliculaSeleccionada.programarLiberacion(sucursal);

                // Confirmación de compra
                System.out.println("\n========================================");
                System.out.println("¡Boleto comprado con éxito!");
                System.out.println("Detalles del boleto:");
                System.out.println("ID de Boleto: " + boleto.getId());
                System.out.println("Sucursal: " + boleto.getSucursal());
                System.out.println("Película: " + boleto.getNombrePelicula());
                System.out.println("Horario: " + boleto.getHorario());
                System.out.println("Sala: " + boleto.getSala());
                System.out.println("========================================\n");
            } else {
                System.out.println("No hay lugares disponibles en la sala " + peliculaSeleccionada.getSala() + ".");
            }
        } else {
            System.out.println("Compra cancelada.");
        }
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
    
   
    public void buscarPeliculaPorNombre(String nombrePelicula) {
        boolean encontrada = false;
        
        for (Sucursal sucursal : sucursales) {
            for (Peliculas pelicula : sucursal.getPeliculas()) {
                if (pelicula.getNombreDePelicula().equalsIgnoreCase(nombrePelicula)) {
                    System.out.println("Película encontrada en la sucursal: " + sucursal.getNombre());
                    System.out.printf("Nombre: %-30s | Horario: %-10s | Sala: %-10d\n",
                            pelicula.getNombreDePelicula(),
                            (pelicula.getHorarioInicio() != null ? pelicula.getHorarioInicio().toString() : "No definido"),
                            pelicula.getSala());
                    encontrada = true;
                }
            }
        }
        
        if (!encontrada) {
            System.out.println("Película no encontrada en ninguna sucursal.");
        }
    }
}