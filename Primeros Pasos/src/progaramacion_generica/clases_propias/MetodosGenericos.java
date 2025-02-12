package progaramacion_generica.clases_propias;

import java.util.GregorianCalendar;

public class MetodosGenericos {
    public static void main(String[] args) {

        String nombres[] = {"Jose", "Maria", "Pepe"};

        System.out.println(MisMatrices.getElementos(nombres));

        System.out.println(MisMatrices.getMenor(nombres));

        Persona personas[] = {new Persona("Ana", 33), new Persona("Juan", 23), new Persona("Pepe", 43)};

        System.out.println(MisMatrices.getElementos(personas));

       GregorianCalendar fechas [] = {new GregorianCalendar(2015, 07, 12), new GregorianCalendar(2015, 05, 12), new GregorianCalendar(2015, 06, 12)};

        System.out.println(MisMatrices.getElementos(fechas));

        System.out.println(MisMatrices.getMenor(fechas).getTime());
        
    }
}

class MisMatrices {

    public static <T> String getElementos(T[] a) {

        return "El array tiene " + a.length + " elementos.";
    }

    public static <T> T getMenor(T[] a) {

        if (a == null || a.length == 0) {
            return null;
        }

        T elementoMenor = a[0];

        for (int i = 1; i < a.length; i++) {
            if (elementoMenor.toString().compareTo(a[i].toString()) > 0) {
                elementoMenor = a[i];
            }
        }

        return elementoMenor;
    }
}