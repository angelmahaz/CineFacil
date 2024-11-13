/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trabajadores_y_subclases;

/**
 *
 * @author miguelangelhernandezandrade
 */
public class Empleados {
    public String Nombre;
    protected String Dirreccion;
    protected int Celular;
    protected String email;
    public String RFC;
    public int Numero_de_Trabajador;
    public String Sucursal;

    public Empleados(String Nombre, String Dirreccion, int Celular, String email, String RFC, int Numero_de_Trabajador, String Sucursal) {
        this.Nombre = Nombre;
        this.Dirreccion = Dirreccion;
        this.Celular = Celular;
        this.email = email;
        this.RFC = RFC;
        this.Numero_de_Trabajador = Numero_de_Trabajador;
        this.Sucursal = Sucursal;
    }
    
    
}
