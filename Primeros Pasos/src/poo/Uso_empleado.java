package poo;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_empleado {
    public static void main(String[] args) {

        Jefatura jefe_RRHH=new Jefatura ("Juan", 55000, 2006,9,25);
        jefe_RRHH.establece_incentivo(2570);
        Empleado[] misEmpleados=new Empleado[6];
        misEmpleados [0]=new Empleado ("Ana", 30000, 2000, 07, 07);
        misEmpleados [1]=new Empleado ("Carlos", 50000, 1995, 06, 15);
        misEmpleados [2]=new Empleado( "Paco", 25000, 2005, 9, 25);
        misEmpleados[3]=new Empleado ("Antonio" ,47500, 2009, 11, 9);
        misEmpleados[4]=jefe_RRHH; //Polimorfismo en acción. Principio de sustitución
        misEmpleados [5]=new Jefatura ("María",95000, 1999,5,26);
        Jefatura jefa_Finanzas=(Jefatura) misEmpleados[5];
        jefa_Finanzas.establece_incentivo(55000);
        System.out.println(jefa_Finanzas.tomar_decisiones("Dar mas dias de vacaciones a los empleados"));
        System.out.println(jefa_Finanzas.establece_bonus(500));
        System.out.println(misEmpleados[3].establece_bonus(200));

        for(Empleado e: misEmpleados){

            e.aumento_sueldo(5);
        }

        Arrays.sort(misEmpleados);

        for (Empleado e: misEmpleados){

            System.out.println(e.datos_empleados());
        }
        
    }
    
}


class Empleado implements Comparable, Trabajadores {

    private String nombre;
    private double sueldo;
    private Date fecha;
    static int IdSiguiente;
    private int id;

    public Empleado(String nombre, double sueldo, int dia, int mes, int año){

        
        this.nombre = nombre;
        this.sueldo = sueldo;
        GregorianCalendar calendario = new GregorianCalendar(año, mes-1, dia);
        fecha = calendario.getTime(); 
        ++IdSiguiente;
        id = IdSiguiente;

    }

    public Empleado(String nombre){

        this(nombre, 30000, 1, 01, 2000);
        // this.nombre = nombre;
        // sueldo = 30000;
        // GregorianCalendar calendario = new GregorianCalendar(2000, 0, 1);
        // fecha = calendario.getTime();
    }

    public void aumento_sueldo(int porcentaje){

        sueldo += (porcentaje*sueldo)/100;

    }

    public double dame_sueldo(){

        return sueldo;
    }

    public String dame_nombre(){

        return"El empleado se llama " + nombre + " y tiene el id " + id + ".";
    }

    public String datos_empleados(){

        return"El elmpleaso se llama " + nombre + ", tiene un sueldo de " + sueldo + "$, y su fecha de alta es el " +
        fecha;
    }

    public int compareTo(Object miObjeto){

        Empleado otrEmpleado = (Empleado) miObjeto;

        if(this.sueldo<otrEmpleado.sueldo){
            return -1;
        }
        if(this.sueldo>otrEmpleado.sueldo){
            return 1;
        }
        return 0;
    }    

   public double establece_bonus(double bono) {

        return bonus_base + bono;
    }

  
}

class Jefatura extends Empleado implements Jefes {

    public Jefatura(String nombre, double sueldo, int dia, int mes, int año){
        
        super(nombre, sueldo, dia, mes, año);

    }

    private double incentivo;

    public void establece_incentivo(double incentivo){

        this.incentivo = incentivo;
        
    }

    public double dame_sueldo(){

        double sueldo_jefe = super.dame_sueldo();
        return sueldo_jefe + incentivo; 
    }

    public String tomar_decisiones(String decision){
        
        return"Un miembro de la direccion a tomado la decision: " + decision;
    }

    public double establece_bonus(double bono){

        double prima = 2000;
        
        return bonus_base + bono + prima;
    }
    
}   

class Director extends Jefatura {

    public Director(String nombre, double sueldo, int dia, int mes, int año){

        super(nombre, sueldo, dia, mes, año);
    }

    
}





