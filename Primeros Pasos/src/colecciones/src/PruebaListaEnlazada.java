package colecciones.src;

import java.util.LinkedList;
import java.util.ListIterator;

public class PruebaListaEnlazada {
    public static void main(String[] args) {
        
        LinkedList<String> paises = new LinkedList<String>();

        paises.add("España");
        paises.add("Colombia");
        paises.add("México");
        paises.add("Perú");

        LinkedList<String> capitales = new LinkedList<String>();

        capitales.add("Madrid");
        capitales.add("Bogotá");
        capitales.add("Ciudad de México");
        capitales.add("Lima");

        ListIterator<String> it_p = paises.listIterator();
        ListIterator<String> it_c = capitales.listIterator();

        while(it_p.hasNext()) {

            if(it_c.hasNext()) {

                it_p.next();
                it_p.add(it_c.next());
            }
        }

        System.out.println(paises);

        it_c = capitales.listIterator();

        while (it_c.hasNext()) {

            it_c.next();

            if(it_c.hasNext()) {

                it_c.next();
                it_c.remove();
            }
            
        }

        System.out.println(capitales);

        paises.removeAll(capitales);

        System.out.println(paises);
    }
}
