package acceso_ficheros;

import java.io.File;

public class Pruebas_Rutas {
    public static void main(String[] args) {

        File archivo = new File("C:\\Users\\mauro\\OneDrive\\Documentos\\Curso de Java\\Primeros Pasos");

        System.out.println(archivo.getAbsolutePath());

        String[] nombres_archivos = archivo.list();
        
        for (String nombre : nombres_archivos) {
            System.out.println(nombre);

            File archivo2 = new File(archivo.getAbsolutePath(), nombre);

           if (archivo2.isDirectory()) {
               String[] archivos_subcarpeta = archivo2.list();
               for (String nombre2 : archivos_subcarpeta) {
                   System.out.println(nombre2);
               }
           }
        }
    }
}
