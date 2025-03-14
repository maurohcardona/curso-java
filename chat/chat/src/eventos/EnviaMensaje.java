package eventos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import cliente.clases.Lamina;

public class EnviaMensaje implements ActionListener {

    private Lamina lamina;
    
    public EnviaMensaje(Lamina lamina){

        this.lamina = lamina;

    }
    public void actionPerformed(ActionEvent e) {

        
        
        try {

            InetAddress miIp = InetAddress.getLocalHost();

            lamina.getCampoChat().append("\n" + lamina.getNickname() + ": " + lamina.getMensaje() + " para " + lamina.getDestinatari());
            
            Socket miSocket = new Socket("192.168.1.188", 9999);

            PaqueteEnvio datos = new PaqueteEnvio(lamina.getMensaje(), lamina.getNickname(), miIp.getHostAddress(), lamina.getSelectedIp());

            datos.setMapIp(lamina.getNickname(), miIp.getHostAddress());

            ObjectOutputStream paquete_datos = new ObjectOutputStream(miSocket.getOutputStream());

            paquete_datos.writeObject(datos);
            
            lamina.setMessageBlank();

            miSocket.close();

        } catch (Exception e1) {
            
            System.err.println(e1.getMessage());
        }
    }
}
