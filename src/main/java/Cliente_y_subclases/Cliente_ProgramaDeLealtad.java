

/**
 *
 * 3 % en puntos para el nivel 0
• 7.5 % en puntos para el nivel 5
• 15 % en puntos para el nivel 10
 */
package Cliente_y_subclases;

public class Cliente_ProgramaDeLealtad extends Cliente {

    private int nivel; 
    private double puntosAcumulados; 

    public Cliente_ProgramaDeLealtad(String nombre, String aPaterno, String aMaterno, String direccion, int celular, String email,
                       String idCliente, String contrasenaCliente, String rfc, String direccionFiscal, String formaDePago) {
        super(nombre, aPaterno, aMaterno, direccion, celular, email, idCliente, contrasenaCliente, rfc, direccionFiscal, formaDePago);
        this.nivel = 0; 
        this.puntosAcumulados = 0.0;
    }

    public int getNivel() {
        return nivel;
    }

    public double getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void agregarCompra(int cantidadComprada) {
        validarNivel(cantidadComprada); 
        double porcentajePuntos = calcularPorcentajePuntos();
        double puntosGanados = cantidadComprada * porcentajePuntos;
        this.puntosAcumulados += puntosGanados;

        System.out.println("Compra de $" + cantidadComprada + " registrada.");
        System.out.println("Nivel actual: " + nivel);
        System.out.println("Puntos ganados: " + puntosGanados);
        System.out.println("Puntos acumulados: " + puntosAcumulados);
    }

    private void validarNivel(int cantidadComprada) {
        if (nivel >= 0 && nivel < 5 && puntosAcumulados + cantidadComprada >= 1000) {
            nivel = 5;
        } else if (nivel >= 5 && nivel < 10 && puntosAcumulados + cantidadComprada >= 1200) {
            nivel = 10;
        } else if (nivel >= 10 && nivel < 15 && puntosAcumulados + cantidadComprada >= 1350) {
            nivel = 15;
        }
    }

    private double calcularPorcentajePuntos() {
        if (nivel >= 0 && nivel < 5) {
            return 0.03; // 3%
        } else if (nivel >= 5 && nivel < 10) {
            return 0.075; // 7.5%
        } else if (nivel >= 10 && nivel <= 15) {
            return 0.15; // 15%
        }
        return 0.0; 
    }
}
