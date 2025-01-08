package poo;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class Uso_persona {
    public static void main(String[] args) {

        Empleado2 persona1 = new Empleado2("Mauro", 10000, 6, 4, 1989);
        System.out.println(persona1.dame_descripcion());
        Alumno alumno1 = new Alumno("Fernando", "Bioquimica");
        System.out.println(alumno1.dame_descripcion());
        
    }
}

abstract class Persona {

    private String nombre;

    public Persona(String nombre){

        this.nombre = nombre;
    }

    public String dame_nombre(){

        return nombre;
    }

    abstract public String dame_descripcion();
    
}

class Empleado2 extends Persona {

    private double sueldo;
    private Date fecha;
    static int IdSiguiente;
    private int id;

    public Empleado2(String nombre, double sueldo, int dia, int mes, int año){

        super(nombre);
        this.sueldo = sueldo;
        GregorianCalendar calendario = new GregorianCalendar(año, mes-1, dia);
        fecha = calendario.getTime(); 
        ++IdSiguiente;
        id = IdSiguiente;

    }


    public void aumento_sueldo(){

        int incremento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el aumento en %"));

        sueldo += (incremento*sueldo)/100;

    }

    public double dame_sueldo(){

        return sueldo;
    }

    public  String dame_descripcion(){

        return"Este empleado se llama " + dame_nombre() + ", y tiene el id: " + id + ", y un sueldo de: $" + sueldo;
    }

  
}

class Alumno extends Persona {

    private String carrera;

    public Alumno(String nombre, String carrera){

        super(nombre);
        this.carrera = carrera;
    }

    public String dame_descripcion(){
        return"Este alumno se llama " + dame_nombre() + ", y estudia la carrera de: " + carrera;
    }
    
}


