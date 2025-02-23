package colecciones.src;

import java.util.Comparator;
import java.util.TreeSet;

public class PruebaTreeSet {
    public static void main(String[] args) {
        
    //     TreeSet<String> ordenar_personas = new TreeSet<String>();

    //     ordenar_personas.add("Sandra");
    //     ordenar_personas.add("Amanda");
    //     ordenar_personas.add("Diana");
    //     ordenar_personas.add("Zoila");

    //     for(String persona : ordenar_personas) {

    //         System.out.println(persona);
    //     }
    // }

    TreeSet<Articulo> ordenar_articulos = new TreeSet<Articulo>();

    ordenar_articulos.add(new Articulo(1, "Primer Artículo"));
    ordenar_articulos.add(new Articulo(3, "Tercer Artículo"));
    ordenar_articulos.add(new Articulo(4, "Cuarto Artículo"));
    ordenar_articulos.add(new Articulo(2, "Segundo Artículo"));

    for(Articulo articulo : ordenar_articulos) {

        System.out.println(articulo);
    }

        //Articulo comparaArticulos = new Articulo();

        //TreeSet<Articulo> ordenar_articulos2 = new TreeSet<Articulo>(comparaArticulos);

    //     ordenar_articulos2.add(new Articulo(1, "Primer Artículo"));
    //     ordenar_articulos2.add(new Articulo(3, "Tercer Artículo"));
    //     ordenar_articulos2.add(new Articulo(4, "Cuarto Artículo"));
    //     ordenar_articulos2.add(new Articulo(2, "Segundo Artículo"));

    //     for(Articulo articulo : ordenar_articulos2) {

    //         System.out.println(articulo);
    //     }
    // }

    comparaArticulos compara_articulos = new comparaArticulos();

    TreeSet<Articulo> ordenar_articulos3 = new TreeSet<Articulo>(compara_articulos);

        ordenar_articulos3.add(new Articulo(1, "Primer Artículo"));
        ordenar_articulos3.add(new Articulo(3, "Tercer Artículo"));
        ordenar_articulos3.add(new Articulo(4, "Cuarto Artículo"));
        ordenar_articulos3.add(new Articulo(2, "Segundo Artículo"));

        for(Articulo articulo : ordenar_articulos3) {

            System.out.println(articulo);
        }
    }   
}

class Articulo implements Comparable<Articulo>/*, Comparator<Articulo> */ {
    private int id;
    private String nombre;

    // public Articulo() {
    // }

    public Articulo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Articulo [id=" + id + ", nombre=" + nombre + "]";
    }

    public int compareTo(Articulo a) {
        return id - a.getId();
        //return this.getNombre().compareTo(a.getNombre());
    }   

    // public int compare(Articulo a1, Articulo a2) {
    //     String nombre1 = a1.getNombre();
    //     String nombre2 = a2.getNombre();
    //     return nombre1.compareTo(nombre2);
    //}
}

class comparaArticulos implements Comparator<Articulo> {
    public int compare(Articulo a1, Articulo a2) {
        String nombre1 = a1.getNombre();
        String nombre2 = a2.getNombre();
        return nombre1.compareTo(nombre2);
    }
}