
package Trabajadores_y_subclases;

public class Gerentes extends Empleados {
    public String ID_Gerente;
    private final String Contraseña_gerente;

    public Gerentes(String nombre, String direccion, int celular, String email, String rfc, int numeroDeTrabajador, String sucursal,
                    String idGerente, String contraseñaGerente) {
        super(nombre, direccion, celular, email, rfc, numeroDeTrabajador, sucursal);
        this.ID_Gerente = idGerente;
        this.Contraseña_gerente = contraseñaGerente;
    }
}
