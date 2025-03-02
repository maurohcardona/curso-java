package sockets.juan_sockects;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Estoy a la escucha");

		try {

			ServerSocket servidor = new ServerSocket(9999);

			String nick, ip, mensaje;	

			PaqueteEnvio paquete_recibido;

			while (true) {
				Socket misocket = servidor.accept();

				InetAddress localizacion = misocket.getInetAddress();

				String ipRemota = localizacion.getHostAddress();

				System.out.println("Conexión entrante desde la IP: " + ipRemota);

				ObjectInputStream paquete_datos = new ObjectInputStream(misocket.getInputStream());

				paquete_recibido = (PaqueteEnvio) paquete_datos.readObject();

				nick = paquete_recibido.getNickName();

				ip = paquete_recibido.getIp();
				
				System.out.println(ip);

				mensaje = paquete_recibido.getMensaje();

				areatexto.append("\n" + nick + ": " + mensaje + " para " + ip);

				Socket enviaDestinatario = new Socket(ip, 9090);

				ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());

				paqueteReenvio.writeObject(paquete_recibido);

				paqueteReenvio.close();

				enviaDestinatario.close();

				misocket.close();

			}

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
