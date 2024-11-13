package Sucursales_y_Peliculas;

import java.util.HashMap;
import java.util.Map;
import java.util.List;


public class Sucursal {
    
    public static final int SALA_1 = 1;
    public static final int SALA_2 = 2;
    public static final int SALA_3 = 3;
    
    public static final int COSTO_BOLETO_ADULTO = 80;
    public static final int COSTO_BOLETO_NIÑO = 50;
    
    private String nombre;
    public List<Peliculas> peliculas;     
    public Map<Integer, Integer> salas;    

    public Sucursal(int capacidadSala1, int capacidadSala2, int capacidadSala3) {
        salas = new HashMap<>();
        
        salas.put(SALA_1, capacidadSala1);
        salas.put(SALA_2, capacidadSala2);
        salas.put(SALA_3, capacidadSala3);
    }

    public Sucursal(String nombre, List<Peliculas> peliculas) {
        this.nombre = nombre;
        this.peliculas = peliculas;
    }

    

    
    public void agregarPelicula(Peliculas pelicula) {
        peliculas.add(pelicula);
        System.out.println("Película agregada: " + pelicula.Nombre_de_Pelicula);
    }
   
}

