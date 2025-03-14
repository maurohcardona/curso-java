package cliente.clases;

import eventos.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class EnvioOnline extends WindowAdapter {
    
    private Lamina miLamina;

    public EnvioOnline(Lamina miLamina) {

        this.miLamina = miLamina;
    }

    public void windowOpened(WindowEvent e){

        try {
            
            Socket miSocket = new Socket("192.168.1.188", 9999);

            InetAddress miIP= InetAddress.getLocalHost();

            PaqueteEnvio datos = new PaqueteEnvio(" online", miLamina.getNickname() , miIP.getHostAddress(), miLamina.getSelectedIp());

            datos.setMapIp(miLamina.getNickname(), miIP.getHostAddress());

            ObjectOutputStream paquete_datos = new ObjectOutputStream(miSocket.getOutputStream());

            paquete_datos.writeObject(datos);

            miSocket.close();

        } catch (Exception e1) {
            
            System.err.println(e1.getMessage());
        }
    }

    public void windowClosing(WindowEvent e) {

        try {
            Socket miSocket = new Socket("192.168.1.188", 9999);
    
            InetAddress miIP = InetAddress.getLocalHost();
    
            PaqueteEnvio datos = new PaqueteEnvio(" offline", miLamina.getNickname(), miIP.getHostAddress(), miLamina.getSelectedIp());
    
            ObjectOutputStream paquete_datos = new ObjectOutputStream(miSocket.getOutputStream());

            datos.setMapIp(miLamina.getNickname(), miIP.getHostAddress());
    
            paquete_datos.writeObject(datos);
    
            miSocket.close();

        } catch (Exception e1) {

            System.err.println(e1.getMessage());
        }
    }
    
}
