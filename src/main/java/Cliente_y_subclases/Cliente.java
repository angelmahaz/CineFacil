
package Cliente_y_subclases;

import java.util.Scanner;

public class Cliente {
    public String Nombre;
    public String aPaterno;
    public String aMaterno;
    public String Dirreccion;
    public int Celular;
    public String email;
    public String ID_Cliente;
    private String ContraseñaCliente;
    public String RFC;
    public String Direccion_Fiscal;
    public String Forma_de_Pago;

    public Cliente(String Nombre, String aPaterno, String aMaterno, String Dirreccion, int Celular, String email, String ID_Cliente, String Contraseña_cliente, String RFC, String Direccion_Fiscal, String Forma_de_Pago) {
        this.Nombre = Nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.Dirreccion = Dirreccion;
        this.Celular = Celular;
        this.email = email;
        this.ID_Cliente = ID_Cliente;
        this.ContraseñaCliente = Contraseña_cliente;
        this.RFC = RFC;
        this.Direccion_Fiscal = Direccion_Fiscal;
        this.Forma_de_Pago = Forma_de_Pago;
    }
public void setCuenta() {
    Scanner scanner = new Scanner(System.in);
        
    System.out.println("\nEscribe tu nombre(s) \n");
    this.Nombre = scanner.nextLine();
    System.out.println("Escribe tu apellido paterno \n");
    this.aPaterno = scanner.nextLine();
    System.out.println("Escribe tu apellido Materno \n");
    this.aMaterno = scanner.nextLine();
    System.out.println("Escribe tu dirección \n");
    this.Dirreccion = scanner.nextLine();
    System.out.println("Escribe tu numero de celular  \n");
    this.Celular = Integer.parseInt(scanner.nextLine());
    System.out.println("Escribe tu Correo Electronico \n");
    this.email = scanner.nextLine();
    }  
 public void getCuenta() {
    System.out.println("Datos del Cliente:");
    System.out.println("Nombre: " + this.Nombre);
    System.out.println("Apellido Paterno: " + this.aPaterno);
    System.out.println("Apellido Materno: " + this.aMaterno);
    System.out.println("Dirección: " + this.Dirreccion);
    System.out.println("Celular: " + this.Celular);
    System.out.println("Email: " + this.email);
}
 
public void setContraseña(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("\nEscribe Una contraseña de por lo menos 8 caracteres \n");
    boolean entradaValida = false;
    while (!entradaValida) {
        String contraseña = scanner.nextLine();
        
        if(contraseña.length() >= 9 && contraseña.matches("[a-zA-Z0-9]*"))
            {
            
            ContraseñaCliente = contraseña; 
            entradaValida = true;
            
            System.out.println("Contraseña establecida con éxito.");
    
            } else {
                System.out.println("La contraseña debe tener al menos 8 caracteres y no debe incluir caracteres especiales (@, #, %, &, !). Inténtalo de nuevo.");
            }
        
           
        }
        scanner.close();
    }
 















}

