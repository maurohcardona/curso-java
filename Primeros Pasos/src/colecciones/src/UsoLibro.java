package colecciones.src;

public class UsoLibro {
    public static void main(String[] args) {
        
        Libro libro1 = new Libro("El Quijote", "Cervantes", 25);
        Libro libro2 = new Libro("El Quijote", "Cervantes", 25);
       
        
        if(libro1.equals(libro2)) {
            System.out.println("Los libros son iguales");
        } else {
            System.out.println("Los libros son diferentes");
        }

        if(libro1.hashCode() == libro2.hashCode()) {
            System.out.println("Los hashCodes son iguales");
        } else {
            System.out.println("Los hashCodes son diferentes");
        }

        if(libro1 == libro2) {
            System.out.println("Las referencias son iguales");
        } else {
            System.out.println("Las referencias son diferentes");
        }

        if(libro1.getISBN() == libro2.getISBN()) {
            System.out.println("Los ISBN son iguales");
        } else {
            System.out.println("Los ISBN son diferentes");
        }

        
    }
}
