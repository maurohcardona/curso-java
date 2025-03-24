package cliente.clases;


import eventos.*;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Lamina extends JPanel implements Runnable{

    private String nickName;
    private JTextArea mensaje;
    private JComboBox<String> lista_ips;
    private JTextArea campo_chat;
    private JButton b_enviar;
    private HashMap<String,String> mapa_ips = new HashMap<>();
    private JFrame ventana;
    private String[] usuarios = new String[6];

    public Lamina(JFrame ventana){

        setLayout(new BorderLayout());
        setSize(350,450);

        JPanel fila1 = new JPanel();
        JPanel fila2 = new JPanel();
        JPanel fila3 = new JPanel();
        
        this.ventana = ventana;

        usuarios = new String[]{"Guardia 1", "Guardia 2", "Hematologia", "Serologia", " Endocrino", "Quimica"};
        
        nickName = (String) JOptionPane.showInputDialog(this, "Elije el usuario", "Usuario", JOptionPane.PLAIN_MESSAGE, null, usuarios, usuarios[0]);

        lista_ips = new JComboBox<>();

        campo_chat = new JTextArea();
        campo_chat.setPreferredSize(new Dimension(340, 350));
        campo_chat.setMinimumSize(new Dimension(340, 350));
        campo_chat.setEditable(false);
        campo_chat.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(campo_chat);
        scrollPane.setPreferredSize(new Dimension(340, 350)); 
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollPane.setMinimumSize(new Dimension(340, 350));

        mensaje = new JTextArea(3,26);
        mensaje.setLineWrap(true);
        mensaje.setWrapStyleWord(true);
        JScrollPane scrollPaneMensaje = new JScrollPane(mensaje);
        scrollPaneMensaje.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


        b_enviar = new JButton("Enviar");
        b_enviar.addActionListener(new EnviaMensaje(this));

        fila1.add(new JLabel(nickName));
        fila1.add(new JLabel(" Conectados: "));
        fila1.add(lista_ips);
        fila2.add(campo_chat);
        fila3.add(mensaje);
        fila3.add(b_enviar);

        add(fila1, BorderLayout.NORTH);
        add(fila2, BorderLayout.CENTER);
        add(fila3, BorderLayout.SOUTH);

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

    public String getDestinatari(){

        return lista_ips.getSelectedItem().toString();
    }

    public void setMessageBlank(){

        mensaje.setText("");
    }

    public JTextArea getCampoChat(){

        return campo_chat;
    }

    public void run(){

        try {

            ServerSocket server = new ServerSocket(9090);

            while (true) {
                
                Socket cliente = server.accept();

                ObjectInputStream flujo_entrada = new ObjectInputStream(cliente.getInputStream());

                PaqueteEnvio paquete = (PaqueteEnvio)flujo_entrada.readObject();

                

                if (paquete.getMessage().equals(" online")){

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
                        
                        campo_chat.append("\n" + paquete.getNickname() + " se ha conectado");
                    }  

                } else if (paquete.getMessage().equals(" offline")){

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

                    campo_chat.append("\n" + paquete.getNickname() + " se ha desconectado");
                    
                } else {

                    //doc.insertString(doc.getLength(), "\n" + paquete.getNickname() + ": " + paquete.getMessage(), otherStyle);

                    campo_chat.append("\n" + paquete.getNickname() + ": " + paquete.getMessage() );

                    ventana.toFront();
                    ventana.requestFocus();
                    ventana.setExtendedState(JFrame.NORMAL);
                    ventana.setAlwaysOnTop(true); 
                    ventana.setAlwaysOnTop(false);
            
                }

                cliente.close();
            } 

        } catch (Exception e) {

            System.err.println(e.getMessage());
        }
    }
    
}

