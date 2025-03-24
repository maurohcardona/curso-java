package conectaBD;

import java.sql.*;

public class ConsultaPreparada {
    public static void main(String[] args) {
        
        try {
            
            Connection miConecxion = DriverManager.getConnection("jdbc:mysql://localhost:3306/salvadora", "root", "estufa10");

            PreparedStatement miSentencia = miConecxion.prepareStatement("SELECT NOMBRE, MARCA, PRECIO FROM PRODUCTO WHERE (? IS NULL OR MARCA=?) AND (? IS NULL OR PRECIO=?)");

            miSentencia.setString(1, "continental");

            miSentencia.setDouble(2, 1800);

            ResultSet rs = miSentencia.executeQuery();

            while (rs.next()) {
                
                System.out.println(rs.getString("NOMBRE") + " " + rs.getString("MARCA") + " " + rs.getDouble("PRECIO"));
    
            }

            rs.close();

            miConecxion.close();

        } catch (Exception e) {
            System.err.println("error");
            e.printStackTrace();
        }
    }
}
