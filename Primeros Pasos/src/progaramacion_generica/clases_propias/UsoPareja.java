package progaramacion_generica.clases_propias;

public class UsoPareja {
    public static void main(String[] args) {

        Pareja <String> una = new Pareja<String>();

        una.setPrimero("Juan");

        System.out.println(una.getPrimero());

        Pareja <Persona> dos = new Pareja<Persona>();

        dos.setPrimero(new Persona("Ana", 33));

        System.out.println(dos.getPrimero().getDatos());
        
    }
}

class Persona { 

    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getDatos() {
        return "El nombre es: " + nombre + " y la edad es: " + edad;
    }
    
}

class Empleado extends Persona {

    private double sueldo;

    public Empleado(String nombre, int edad, double sueldo) {
        super(nombre, edad);
        this.sueldo = sueldo;
    }

    public String getDatos() {
        return super.getDatos() + " y el sueldo es: " + sueldo;
    }
    
}

class Jefe extends Empleado {

    private double incentivo;

    public Jefe(String nombre, int edad, double sueldo) {
        super(nombre, edad, sueldo);
    }

    public String getDatos() {
        return super.getDatos() + " y el incentivo es: " + incentivo;
    }

    public void setIncentivo(double incentivo) {
        this.incentivo = incentivo;
    }
    
}