package servidor.clases;

import java.awt.BorderLayout;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.util.HashMap;
import java.util.Map;

import eventos.PaqueteEnvio;

public class Marco extends JFrame implements Runnable{

    private JTextArea areaTexto;
    private HashMap<String,String> lista_ips = new HashMap<>();
    
    public Marco() {

        setBounds(900, 300, 280, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel miLamina =  new JPanel();
        miLamina.setLayout(new BorderLayout());
        
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);

        miLamina.add(areaTexto, BorderLayout.CENTER);

        add(miLamina);

        Thread miHilo = new Thread(this);

        miHilo.start();
    }

    public void run(){

        System.out.println("Estoy a la escucha");

        try {
            
            ServerSocket server = new ServerSocket(9999);

            while (true) {
                
                Socket miSocket = server.accept();

                ObjectInputStream paquete_datos = new ObjectInputStream(miSocket.getInputStream());

                PaqueteEnvio paquete_recibido = (PaqueteEnvio) paquete_datos.readObject();

                if(!paquete_recibido.getMessage().equals(" online")) {

                    System.out.println(paquete_recibido.getIpDestinatario());

                    areaTexto.append("\n" + paquete_recibido.getNickname() + ": " + paquete_recibido.getMessage() + " para " + paquete_recibido.getIpDestinatario());

                    Socket enviaDestinatario = new Socket(paquete_recibido.getIpDestinatario(), 9090);

                    ObjectOutputStream paquete_reenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());

                    paquete_reenvio.writeObject(paquete_recibido);

                    paquete_reenvio.close();

				    enviaDestinatario.close();

				    miSocket.close();
                
                } else {

                    areaTexto.append("\n" + paquete_recibido.getNickname() + " IP: " + paquete_recibido.getIpPropio() + " se ha conectado");

                    lista_ips.put(paquete_recibido.getNickname(), paquete_recibido.getIpPropio());

                    paquete_recibido.getMapIps().putAll(lista_ips);

                    for(Map.Entry<String,String> usuario : lista_ips.entrySet()){

                        Socket envioDestinatario = new Socket(usuario.getValue(), 9090);

                        ObjectOutputStream paquete_reenvio = new ObjectOutputStream(envioDestinatario.getOutputStream());

                        paquete_reenvio.writeObject(paquete_recibido);

                        paquete_reenvio.close();
                        
                        envioDestinatario.close();

                        miSocket.close();
                        
                    }
                }
            }
        } catch (Exception e) {
            
            System.err.println("Error: " + e);
        }
    }
}
