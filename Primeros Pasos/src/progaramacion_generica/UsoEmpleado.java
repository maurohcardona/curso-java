package progaramacion_generica;

import java.util.ArrayList;
import java.util.Iterator;

public class UsoEmpleado {
    public static void main(String[] args) {

        // Empleado[] misEmpleados = new Empleado[3];

        // misEmpleados[0] = new Empleado("Juan", 45, 2500);
        // misEmpleados[1] = new Empleado("Ana", 55, 3000);
        // misEmpleados[2] = new Empleado("Antonio", 25, 1500);

        ArrayList<Empleado> misEmpleados = new ArrayList<Empleado>();

        misEmpleados.ensureCapacity(11);

        misEmpleados.add(new Empleado("Juan", 45, 2500));
        misEmpleados.add(new Empleado("Ana", 55, 3000));
        misEmpleados.add(new Empleado("Antonio", 25, 1500));
        misEmpleados.set(0, new Empleado("Carlos", 35, 3500));
        System.out.println(misEmpleados.get(0).getDatos());

        misEmpleados.trimToSize();

        System.out.println(misEmpleados.size());

        // for (Empleado e : misEmpleados) {
        //     System.out.println(e.getDatos());
        // }

        // for (int i = 0; i < misEmpleados.size(); i++) {
        //     Empleado e = misEmpleados.get(i);
        //     System.out.println(e.getDatos());
        // }
        
        // Empleado[] aEmpleado = new Empleado[misEmpleados.size()];
        // misEmpleados.toArray(aEmpleado);

        // for (Empleado e : aEmpleado) {
        //     System.out.println(e.getDatos());
        // }

        Iterator <Empleado> miIterador = misEmpleados.iterator();

        while (miIterador.hasNext()) {
            System.out.println(miIterador.next().getDatos());
        }


    }
}

class Empleado {

    private String nombre;
    private int edad;
    private double salario;

    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String getDatos() {
        return "El empleado se llama " + nombre + ". Tiene " + edad + " años. Y un salario de $" + salario;
    }
}