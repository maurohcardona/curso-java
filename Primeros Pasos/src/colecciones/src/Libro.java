package colecciones.src;

public class Libro {
    
    private String titulo;
    private String autor;
    private int ISBN;

    public Libro(String titulo, String autor, int ISBN) {

        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
    }

    public String getDatos() {

        return "Titulo: " + titulo + ", Autor: " + autor + ", ISBN: " + ISBN;

    }

    public int getISBN() {
        return ISBN;
    }

    public boolean equals(Libro obj) {

        if (obj instanceof Libro) {
            Libro otroLibro = (Libro) obj;
            if (this.ISBN == otroLibro.ISBN) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public int hashCode() {
        return ISBN;
    }
}
