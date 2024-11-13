
package Trabajadores_y_subclases;


public class Trabajador extends Empleados {
    public String ID_Trabajador;
    private final String Contraseña_Trabajador;

    public Trabajador(String nombre, String direccion, int celular, String email, String rfc, int numeroDeTrabajador, String sucursal,
                      String idTrabajador, String contraseñaTrabajador) {
        super(nombre, direccion, celular, email, rfc, numeroDeTrabajador, sucursal);
        this.ID_Trabajador = idTrabajador;
        this.Contraseña_Trabajador = contraseñaTrabajador;
    }

}

