package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.TreeSet;
import java.util.Comparator;

public class ConnectionBBDD {

    private Connection miConexion;
    private PreparedStatement miSentencia;
    private PreparedStatement miSentencia2;
    
    public ConnectionBBDD() {
    
       try {
            
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/salvadora", "root", "estufa10");

            miSentencia = miConexion.prepareStatement("SELECT NOMBRE, MARCA, PRECIO FROM PRODUCTO WHERE MARCA=? AND PRECIO=?");

            miSentencia2 = miConexion.prepareStatement("SELECT NOMBRE, MARCA, PRECIO FROM PRODUCTO");


        } catch (Exception e) {
            System.err.println("error");
            e.printStackTrace();
        }
    }

    public ResultSet getTotales(){

        try {

            ResultSet totales = miSentencia2.executeQuery();

        return totales;
            
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }

        
    }

    public ResultSet getResultSet(String marca, String precio) {

        try {

            miSentencia.setString(1, marca);

            miSentencia.setString(2, precio);

            ResultSet resultado = miSentencia.executeQuery();

            return resultado;

        } catch (Exception e) {
            
            System.err.println("Error en la consulta SQL:");
            e.printStackTrace();
            return null;  
        }
    }

    public TreeSet<String> getColumna(String columna){

        Comparator<String> comparator = (s1, s2) -> {

            if (s1.equals("todos")) return -1;
            if (s1.equals("todos")) return 1;

            return s1.compareTo(s2);
        };

        TreeSet<String> miSet = new TreeSet<>(comparator);

        try {
            
            miSentencia = miConexion.prepareStatement("SELECT "+ columna + " FROM PRODUCTO;");

            ResultSet resultado = miSentencia.executeQuery();

            while (resultado.next()) {
                
                miSet.add(resultado.getString(columna));
                
            }

            miSet.add("todos");

            return miSet;

        } catch (Exception e) {
            
            System.err.println("Error en la consulta SQL:");
            e.printStackTrace();
            return null;  
        }
    }

    public void cerrarConexion() {
        try {
            if (miConexion != null) miConexion.close();
        } catch (Exception e) {
            System.err.println("Error al cerrar la conexión:");
            e.printStackTrace();
        }
    }
}

            
    


