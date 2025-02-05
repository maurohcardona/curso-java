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