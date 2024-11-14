package Sucursales_y_Peliculas;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Peliculas {
    public String nombreDePelicula;
    private String clasificacion;
    private int duracion;
    private ArrayList<String> actores;
    private String sinopsis;
    private String resumen;
    private int costo;
    private Map<String, List<LocalTime>> sucursalHorarios;

    public Peliculas(String nombreDePelicula, String clasificacion, int duracion) {
        this.nombreDePelicula = nombreDePelicula;
        this.clasificacion = clasificacion;
        this.duracion = duracion;
        this.actores = new ArrayList<>();
        this.sucursalHorarios = new HashMap<>();
    }

    //información adicional de la película
    public void registrarPelicula(Sucursal a) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe los actores (separados por comas):");
        String actoresInput = scanner.nextLine();
        for (String actor : actoresInput.split(",")) {
            this.actores.add(actor.trim());
        }

        System.out.println("Escribe la sinopsis:");
        this.sinopsis = scanner.nextLine();

        System.out.println("Escribe el resumen:");
        this.resumen = scanner.nextLine();

        System.out.println("Escribe el costo del boleto:");
        this.costo = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= 3; i++) {
            System.out.println("Escribe el nombre de la sucursal " + i + ":");
            String sucursal = scanner.nextLine();

            List<LocalTime> horarios = new ArrayList<>();
            for (int j = 1; j <= 3; j++) {
                System.out.println("Escribe el horario " + j + " para la sucursal " + sucursal + " (HH:MM):");
                horarios.add(LocalTime.parse(scanner.nextLine()));
            }

            sucursalHorarios.put(sucursal, horarios);
        }

        System.out.println("\nPelícula registrada exitosamente con horarios y sucursales.\n");
    }

   
}
