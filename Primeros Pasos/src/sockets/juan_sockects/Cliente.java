package sockets.juan_sockects;

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.ServerSocket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import javax.swing.text.StyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;


import java.io.Serializable;


public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoCliente mimarco=new MarcoCliente();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoCliente extends JFrame{
	
	public MarcoCliente(){
		
		setBounds(600,300,250,350);
				
		LaminaMarcoCliente milamina=new LaminaMarcoCliente();
		
		add(milamina);
		
		setVisible(true);

		addWindowListener(new EnvioOnline());
	}	
	
}

class EnvioOnline extends WindowAdapter{
	
	public void windowOpened(WindowEvent e) {
		
		try {
			
			Socket misocket = new Socket("192.168.100.235",9999);

			PaqueteEnvio datos = new PaqueteEnvio(" online", "192.168.100.235", "192.168.100.235");
			
			ObjectOutputStream paquete_datos = new ObjectOutputStream(misocket.getOutputStream());

			paquete_datos.writeObject(datos);

			misocket.close();
		}
		catch (UnknownHostException e1) {
			
			e1.printStackTrace();
		}
		catch (IOException e1) {
			
			System.out.println(e1.getMessage());
		}
	}	
}

class LaminaMarcoCliente extends JPanel implements Runnable{
	
	public LaminaMarcoCliente(){

		String nickNames = JOptionPane.showInputDialog("Elije tu NickName");
	
		JLabel texto=new JLabel(" Online: ");

		nickName = new JLabel(nickNames);

		ip = new JComboBox<>();

		ip.addItem("Loli");

		ip.addItem("Mauro");

		ip.addItem("Pedro");

		add(new JLabel("Nick: "));

		add(nickName);
		
		add(texto);

		add(ip);

		campo_chat = new JTextPane();

		campo_chat.setPreferredSize(new Dimension(240, 200));

		campo_chat.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(campo_chat);

		scrollPane.setPreferredSize(new Dimension(240, 200)); 

		scrollPane.setMinimumSize(new Dimension(240, 150));

		add(campo_chat);
	
		mensaje=new JTextField(24);
	
		add(mensaje);		
	
		miboton=new JButton("Enviar");

		miboton.addActionListener(new EnviaTexto());
		
		add(miboton);	

		Thread miHilo = new Thread(this);

		miHilo.start();
		
	}	
	private JTextField mensaje;

	private JLabel nickName;

	private JComboBox<String> ip;

	private JTextPane campo_chat;
	
	private JButton miboton;

	public void run(){
		
		try {
			
			ServerSocket servidor = new ServerSocket(9090);
			
			Socket cliente;
			
			PaqueteEnvio paquete;

			while (true) {
				
				cliente = servidor.accept();
				
				ObjectInputStream flujo_entrada = new ObjectInputStream(cliente.getInputStream());
				
				paquete = (PaqueteEnvio) flujo_entrada.readObject();

				StyledDocument doc = campo_chat.getStyledDocument();

				SimpleAttributeSet otherStyle = new SimpleAttributeSet();

        		StyleConstants.setForeground(otherStyle, Color.RED);  
				
				doc.insertString(doc.getLength(), "\n" + paquete.getNickName() + ": " + paquete.getMensaje(), otherStyle);
				
				cliente.close();
			}	
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());

		}
	}

	private class EnviaTexto implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {

			StyledDocument doc = campo_chat.getStyledDocument();

			SimpleAttributeSet userStyle = new SimpleAttributeSet();

        	StyleConstants.setForeground(userStyle, Color.BLUE);  

			
			try {
				doc.insertString(doc.getLength(), "\n" + nickName.getText() + ": " + mensaje.getText(), userStyle);
				
				Socket misocket = new Socket("192.168.100.235",9999);

				PaqueteEnvio datos = new PaqueteEnvio(mensaje.getText(), nickName.getText(), ip.getSelectedItem().toString());

				ObjectOutputStream paquete_datos = new ObjectOutputStream(misocket.getOutputStream());	

				paquete_datos.writeObject(datos);

				mensaje.setText("");

				//DataOutputStream flujo_salida = new DataOutputStream(misocket.getOutputStream());
				// flujo_salida.writeUTF(mensaje.getText());
				// mensaje.setText("");
				// flujo_salida.close();

				misocket.close();

			} catch (UnknownHostException e1) {
				
				e1.printStackTrace();

			} catch (Exception e1) {
				
				System.out.println(e1.getMessage());

			} 
			
		}
	}
	
}

class PaqueteEnvio implements Serializable{
	
	private String mensaje, nickName, ip;
	
	public PaqueteEnvio(String mensaje, String nickName, String ip) {
		
		this.mensaje = mensaje;
		
		this.nickName = nickName;

		this.ip = ip;
		
	}
	
	public String getMensaje() {
		
		return mensaje;
		
	}

	public void setMensaje(String mensaje) {
		
		this.mensaje = mensaje;
		
	}
	
	public String getNickName() {
		
		return nickName;
		
	}

	public void setNickName(String nickName) {
		
		this.nickName = nickName;
		
	}

	public String getIp() {
		
		switch (ip) {
			case "Loli":
				return "192.168.100.232";
			case "Mauro":
				return "192.168.100.235";
			case "Pedro":
				return "192.168.100.234";
			default:
				return "";
		}
	}

	public void setIp(String ip) {
		
		this.ip = ip;
		
	}
	
}