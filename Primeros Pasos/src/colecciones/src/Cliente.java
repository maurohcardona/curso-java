package colecciones.src;

public class Cliente {
    
    
    private String nombre;
    private String numeroCuenta;
    private double saldo;
    private int idCliente;

    private static int idContador = 1;

    public Cliente(String nombre, String numeroCuenta, double saldo) {

        this.idCliente = idContador;
        this.nombre = nombre;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        idContador++;
    }

    public int getId() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }    

    public boolean equals(Object obj) {
        if (obj instanceof Cliente) {
            Cliente otroCliente = (Cliente) obj;
            if (this.numeroCuenta.equals(otroCliente.numeroCuenta)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public int hashCode() {
        return numeroCuenta.hashCode();
    }

}
