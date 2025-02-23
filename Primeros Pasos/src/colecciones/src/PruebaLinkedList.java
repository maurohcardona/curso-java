package colecciones.src;

import java.util.LinkedList;
import java.util.ListIterator;

public class PruebaLinkedList {
    public static void main(String[] args) {
        
        LinkedList<String> personas = new LinkedList<String>();

        personas.add("Juan");
        personas.add("Ana");
        personas.add("Luis");
        personas.add("Laura");

        System.out.println(personas.size());

        personas.addFirst("Karla");
        personas.addLast("Pedro");

        ListIterator<String> it = personas.listIterator();

        it.next();
        it.add("Roberto");

        for(String persona : personas) {

            System.out.println(persona);
        }
    }
}
