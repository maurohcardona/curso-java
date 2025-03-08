package cliente.clases;

import eventos.*;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Lamina extends JPanel implements Runnable{

    private String nickName;
    private JTextField mensaje;
    private JLabel l_nickName;
    private JComboBox<String> lista_ips;
    private JTextPane campo_chat;
    private JButton b_enviar;
    private HashMap<String,String> mapa_ips = new HashMap<>();

    public Lamina(){

        nickName = JOptionPane.showInputDialog("Elije un nickname:");

        l_nickName = new JLabel("Nickname:");

        lista_ips = new JComboBox<>();

        campo_chat = new JTextPane();
        campo_chat.setPreferredSize(new Dimension(240, 200));
        campo_chat.setMinimumSize(new Dimension(240, 150));
        campo_chat.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(campo_chat);
        scrollPane.setPreferredSize(new Dimension(240, 200)); 
		scrollPane.setMinimumSize(new Dimension(240, 150));

        mensaje = new JTextField(24);

        b_enviar = new JButton("Enviar");
        b_enviar.addActionListener(new EnviaMensaje(this));

        add(l_nickName);
        add(new JLabel(nickName));
        add(new JLabel(" Conectados: "));
        add(lista_ips);
        add(campo_chat);
        add(mensaje);
        add(b_enviar);

        Thread miHilo = new Thread(this);
        miHilo.start();
    }

    public String getMensaje(){

        return mensaje.getText();
    }

    public String getNickname(){

        return nickName;
    }

    public String getSelectedIp(){

        return mapa_ips.get((String) lista_ips.getSelectedItem());
    }

    public void setMessageBlank(){

        mensaje.setText("");
    }

    public JTextPane getCampoChat(){

        return campo_chat;
    }

    public void run(){

        try {

            ServerSocket server = new ServerSocket(9090);

            while (true) {
                
                Socket cliente = server.accept();

                ObjectInputStream flujo_entrada = new ObjectInputStream(cliente.getInputStream());

                PaqueteEnvio paquete = (PaqueteEnvio)flujo_entrada.readObject();

                StyledDocument doc = campo_chat.getStyledDocument();

                SimpleAttributeSet otherStyle = new SimpleAttributeSet();

                StyleConstants.setForeground(otherStyle, Color.RED);

                if(!paquete.getMessage().equals(" online")) {

                    doc.insertString(doc.getLength(), "\n" + paquete.getNickname() + ": " + paquete.getMessage(), otherStyle);
                
                } else {


                    lista_ips.removeAllItems();

                    mapa_ips = paquete.getMapIps();

                    InetAddress miIP = InetAddress.getLocalHost();

                    if (mapa_ips != null) {

                        for(Map.Entry<String,String> entrada : mapa_ips.entrySet()){

                            if(!entrada.getValue().equals(miIP.getHostAddress())) {

                                lista_ips.addItem(entrada.getKey());
                            }
                        }
                    }
                    if(!paquete.getIpPropio().equals(miIP.getHostAddress())){
                        
                        doc.insertString(doc.getLength(), "\n" + paquete.getNickname() + " se ha conectado", otherStyle);
                    }   
                }
            
                cliente.close();
            
            } 

        } catch (Exception e) {

            System.err.println(e.getMessage());
        }
    }
    
}
