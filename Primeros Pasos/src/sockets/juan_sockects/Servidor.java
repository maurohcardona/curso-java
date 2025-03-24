package sockets.juan_sockects;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Servidor  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoServidor mimarco=new MarcoServidor();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}	
}

class MarcoServidor extends JFrame implements Runnable{
	
	public MarcoServidor(){
		
		setBounds(900,300,280,350);				
			
		JPanel milamina= new JPanel();
		
		milamina.setLayout(new BorderLayout());
		
		areatexto=new JTextArea();
		
		milamina.add(areatexto,BorderLayout.CENTER);
		
		add(milamina);
		
		setVisible(true);

		Thread mihilo = new Thread(this);

		mihilo.start();
		
		}
	
	private	JTextArea areatexto;

	private ArrayList<String> lista_ip = new ArrayList<String>();

	@Override
	public void run() {
		// TODO Auto-generated method stub
			

		try {

			ServerSocket servidor = new ServerSocket(9999);

			String nick, ip, mensaje;	

			PaqueteEnvio paquete_recibido;

			while (true) {
				Socket misocket = servidor.accept();

				ObjectInputStream paquete_datos = new ObjectInputStream(misocket.getInputStream());

				paquete_recibido = (PaqueteEnvio) paquete_datos.readObject();

				nick = paquete_recibido.getNickName();

				ip = paquete_recibido.getIp();

				mensaje = paquete_recibido.getMensaje();

				if(!mensaje.equals(" online")) {

				areatexto.append("\n" + nick + ": " + mensaje + " para " + ip);

				Socket enviaDestinatario = new Socket(ip, 9090);

				ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());

				paqueteReenvio.writeObject(paquete_recibido);

				paqueteReenvio.close();

				enviaDestinatario.close();

				misocket.close();

				} else {

					InetAddress localizacion = misocket.getInetAddress();

					String ipRemota = localizacion.getHostAddress();

					lista_ip.add(ipRemota);

					paquete_recibido.setLista_ip(lista_ip);

					for(String ip2 : lista_ip) {

						Socket enviaDestinatario = new Socket(ip2, 9090);

						ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());

						paqueteReenvio.writeObject(paquete_recibido);

						paqueteReenvio.close();

						enviaDestinatario.close();

						misocket.close();

					}

				}

			}

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
