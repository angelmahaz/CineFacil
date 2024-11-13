
package Sucursales_y_Peliculas;
import java.util.ArrayList;
import java.time.LocalTime;

public class Peliculas {
    String Nombre_de_Pelicula;
    private String Clasificacion;
    private int Duracion;
    private ArrayList<String> Actores;
    private String Sinopsis;
    private String Resumen;
    private int Costo;
    public int sala;
    public String sucursal;
    private LocalTime Horario;

    public String getNombre_de_Pelicula() {
        return Nombre_de_Pelicula;
    }

    public void setNombre_de_Pelicula(String Nombre_de_Pelicula) {
        this.Nombre_de_Pelicula = Nombre_de_Pelicula;
    }

    public String getClasificacion() {
        return Clasificacion;
    }

    public void setClasificacion(String Clasificacion) {
        this.Clasificacion = Clasificacion;
    }

    public int getDuracion() {
        return Duracion;
    }

    public void setDuracion(int Duracion) {
        this.Duracion = Duracion;
    }

    public ArrayList<String> getActores() {
        return Actores;
    }

    public void setActores(ArrayList<String> Actores) {
        this.Actores = Actores;
    }

    public String getSinopsis() {
        return Sinopsis;
    }

    public void setSinopsis(String Sinopsis) {
        this.Sinopsis = Sinopsis;
    }

    public String getResumen() {
        return Resumen;
    }

    public void setResumen(String Resumen) {
        this.Resumen = Resumen;
    }

    public int getCosto() {
        return Costo;
    }

    public void setCosto(int Costo) {
        this.Costo = Costo;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public LocalTime getHorario() {
        return Horario;
    }

    public void setHorario(LocalTime Horario) {
        this.Horario = Horario;
    }
    
    
    

}