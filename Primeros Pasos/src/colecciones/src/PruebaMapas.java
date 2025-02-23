package colecciones.src;

import java.util.HashMap;
import java.util.Map;

public class PruebaMapas {
    public static void main(String[] args) {
        
        HashMap<String, Empleado> personal = new HashMap<String, Empleado>();

        personal.put("1000", new Empleado("Juan"));
        personal.put("2000", new Empleado("Pedro"));
        personal.put("3000", new Empleado("Antonio"));
        personal.put("4000", new Empleado("Maria"));

        System.out.println(personal);

        personal.remove("2000");

        System.out.println(personal);

        personal.put("1000", new Empleado("Maria"));

        //System.out.println(personal.entrySet());

        for(Map.Entry<String, Empleado> entrada : personal.entrySet()) {

            String clave = entrada.getKey();
            Empleado valor = entrada.getValue();

            System.out.println("Clave=" + clave + ", Valor=" + valor);
        }

    }
}

class Empleado {

    private String nombre;
    private double sueldo;

    public Empleado(String nombre) {
        this.nombre = nombre;
        this.sueldo = 2000;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public String toString() {
        return "Nombre: " + nombre + " Sueldo: " + sueldo;
    }
}