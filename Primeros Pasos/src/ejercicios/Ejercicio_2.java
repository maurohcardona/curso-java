package ejercicios;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.*;


public class Ejercicio_2 {
    public static void main(String[] args) {

        MarcoEjercicio2 miMarco = new MarcoEjercicio2();
        miMarco.setVisible(true);
    }
}

class MarcoEjercicio2 extends JFrame{

    public MarcoEjercicio2(){

        setTitle("Ejercicio 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());
        LaminaEjercicio2 miLamina = new LaminaEjercicio2();
        add(miLamina, BorderLayout.CENTER);
        JPanel lamina2 = new JPanel();
        JButton enviar = new JButton("Enviar");
        enviar.addActionListener(miLamina.new AccionEnviar());
        lamina2.add(enviar);
        add(lamina2, BorderLayout.SOUTH);
        
    }
}

class LaminaEjercicio2 extends JPanel{

    JRadioButton r_mensaje, r_confirmar, r_opcion, r_entrada;
    JRadioButton error_message, information_message, warning_message, question_message, plain_message;
    JRadioButton cadena, icono, componente, otros, m_object;
    JRadioButton default_option, yes_no_option, yes_no_cancel_option, ok_cancel_option;
    JRadioButton string, icon, o_object;
    JRadioButton campo_texto, combo;

    ButtonGroup g_tipo = new ButtonGroup();
    ButtonGroup g_tipo_mensaje = new ButtonGroup();
    ButtonGroup g_mensaje = new ButtonGroup();
    ButtonGroup g_confirmar = new ButtonGroup();
    ButtonGroup g_opcion = new ButtonGroup();
    ButtonGroup g_entrada = new ButtonGroup();

    public LaminaEjercicio2(){

        setLayout(new GridLayout(2,3));


        Box c_tipo = Box.createVerticalBox();
        Box c_tipo_mensaje = Box.createVerticalBox();
        Box c_mensaje = Box.createVerticalBox();
        Box c_confirmar = Box.createVerticalBox();
        Box c_opcion = Box.createVerticalBox();
        Box c_entrada = Box.createVerticalBox();

        r_mensaje = new JRadioButton("Mensaje");
        r_confirmar = new JRadioButton("Confirmar");
        r_opcion = new JRadioButton("opcion");
        r_entrada = new JRadioButton("Entrada");

        error_message = new JRadioButton("ERROR_MESSAGE");
        information_message = new JRadioButton("INFORMATION_MESSAGE");
        warning_message = new JRadioButton("WARNING_MESSAGE");
        question_message = new JRadioButton("QUESTION_MESSAGE");
        plain_message = new JRadioButton("PLAIN_MESSAGE");

        cadena = new JRadioButton("Cadena");
        icono = new JRadioButton("Icono");
        componente = new JRadioButton("Componente");
        otros = new JRadioButton("Otros");
        m_object = new JRadioButton("Object[]");

        default_option = new JRadioButton("DEFAULT OPTION");
        yes_no_option = new JRadioButton("YES NO OPTION");
        yes_no_cancel_option =new JRadioButton("YES NO CANCEl OPTION");
        ok_cancel_option = new JRadioButton("OK CANCEL OPTION");

        string = new JRadioButton("String[]");
        icon = new JRadioButton("Icon[]");
        o_object = new JRadioButton("Object[]");

        campo_texto = new JRadioButton("Campo de texto");
        combo = new JRadioButton("Combo");

        g_tipo.add(r_mensaje);
        g_tipo.add(r_confirmar);
        g_tipo.add(r_opcion);
        g_tipo.add(r_entrada);

        g_tipo_mensaje.add(error_message);
        g_tipo_mensaje.add(information_message);
        g_tipo_mensaje.add(warning_message);
        g_tipo_mensaje.add(question_message);
        g_tipo_mensaje.add(plain_message);
        
        g_mensaje.add(cadena);
        g_mensaje.add(icono);
        g_mensaje.add(componente);
        g_mensaje.add(otros);
        g_mensaje.add(m_object);

        g_confirmar.add(default_option);
        g_confirmar.add(yes_no_option);
        g_confirmar.add(yes_no_cancel_option);
        g_confirmar.add(ok_cancel_option);

        g_opcion.add(string);
        g_opcion.add(icon);
        g_opcion.add(o_object);

        g_entrada.add(campo_texto);
        g_entrada.add(combo);
        

        c_tipo.add(r_mensaje);
        c_tipo.add(r_confirmar);
        c_tipo.add(r_opcion);
        c_tipo.add(r_entrada);
        c_tipo.setBorder(new TitledBorder("Tipo"));

        c_tipo_mensaje.add(error_message);
        c_tipo_mensaje.add(information_message);
        c_tipo_mensaje.add(warning_message);
        c_tipo_mensaje.add(question_message);
        c_tipo_mensaje.add(plain_message);
        c_tipo_mensaje.setBorder(new TitledBorder("Tipo de mensaje"));

        c_mensaje.add(cadena);
        c_mensaje.add(icono);
        c_mensaje.add(componente);
        c_mensaje.add(otros);
        c_mensaje.add(m_object);
        c_mensaje.setBorder(new TitledBorder("Mensaje"));

        c_confirmar.add(default_option);
        c_confirmar.add(yes_no_option);
        c_confirmar.add(yes_no_cancel_option);
        c_confirmar.add(ok_cancel_option);
        c_confirmar.setBorder(new TitledBorder("Confirmar"));

        c_opcion.add(string);
        c_opcion.add(icon);
        c_opcion.add(o_object);
        c_opcion.setBorder(new TitledBorder("Opcion"));

        c_entrada.add(campo_texto);
        c_entrada.add(combo);
        c_entrada.setBorder(new TitledBorder("Entrada"));

        r_mensaje.setActionCommand("Mensaje");
        r_confirmar.setActionCommand("Confirmar");
        r_opcion.setActionCommand("Opcion");
        r_entrada.setActionCommand("Entrada");

        error_message.setActionCommand("Error");
        information_message.setActionCommand("Información");
        warning_message.setActionCommand("Advertencia");
        question_message.setActionCommand("Pregunta");
        plain_message.setActionCommand("Plano");

        cadena.setActionCommand("Cadena");
        icono.setActionCommand("Icono");
        componente.setActionCommand("Componente");
        otros.setActionCommand("Otros");
        m_object.setActionCommand("Object[]");
        
        default_option.setActionCommand("Default");
        yes_no_option.setActionCommand("Yes/No");
        yes_no_cancel_option.setActionCommand("Yes/No/Cancel");
        ok_cancel_option.setActionCommand("Ok/Cancel");

        string.setActionCommand("String[]");
        icon.setActionCommand("Icon[]");
        o_object.setActionCommand("Object[]");
        campo_texto.setActionCommand("Campo de texto");
        combo.setActionCommand("Combo");

        add(c_tipo);
        add(c_tipo_mensaje);
        add(c_mensaje);
        add(c_confirmar);
        add(c_opcion);
        add(c_entrada);
    }

    private String cadena_mensaje = "Mensaje de ejemplo";
    private Icon icono_mensaje = new ImageIcon("Primeros Pasos/src/graficos/icono.png");
    private Object objetoMensaje = new Date();
    private Component componenteMensaje = new LamninaEjemplo();

    public Object dame_mensaje() {
        String s = g_mensaje.getSelection().getActionCommand();
        if (s.equals("Cadena")) {
            return cadena_mensaje;
        } else if (s.equals("Icono")) {
            return icono_mensaje;
        } else if (s.equals("Componente")) {
            return componenteMensaje;
        } else if (s.equals("Otros")) {
            return objetoMensaje;
        }else if (s.equals("Object[]")){
            return new Object[]{cadena_mensaje, icono_mensaje, componenteMensaje, objetoMensaje};
        } else {
            return null;
        }
    }

    public int dame_tipo_mensaje() {
        String s = g_tipo_mensaje.getSelection().getActionCommand();
        if (s.equals("Error")) {
            return JOptionPane.ERROR_MESSAGE;
        } else if (s.equals("Información")) {
            return JOptionPane.INFORMATION_MESSAGE;
        } else if (s.equals("Advertencia")) {
            return JOptionPane.WARNING_MESSAGE;
        } else if (s.equals("Pregunta")) {
            return JOptionPane.QUESTION_MESSAGE;
        } else {
            return JOptionPane.PLAIN_MESSAGE;
        }
    }

    public int dame_confirmar() {
        String s = g_confirmar.getSelection().getActionCommand();
        if (s.equals("Default")) {
            return JOptionPane.DEFAULT_OPTION;
        } else if (s.equals("Yes/No")) {
            return JOptionPane.YES_NO_OPTION;
        } else if (s.equals("Yes/No/Cancel")) {
            return JOptionPane.YES_NO_CANCEL_OPTION;
        } else if (s.equals("Ok/Cancel")) {
            return JOptionPane.OK_CANCEL_OPTION;
        } else {
            return JOptionPane.DEFAULT_OPTION;
        }
    }

    public Object[] dame_opcion(){

        String s = g_opcion.getSelection().getActionCommand();
        String[] string_opcion = {"azul", "amarillo", "rojo"};
        Icon[] icon_opcion = {
            new ImageIcon("Primeros Pasos\\src\\graficos\\amarillo.jpg"),
            new ImageIcon("Primeros Pasos\\src\\graficos\\azul.jpg"),
            new ImageIcon("Primeros Pasos\\src\\graficos\\rojo.jpg")
        };
        Object[] object_opcion = {cadena_mensaje, icono_mensaje,objetoMensaje};

        if(s.equals("String[]"))
            return string_opcion;
        else if(s.equals("Icon[]"))
            return icon_opcion;
        else if(s.equals("Object[]"))
            return object_opcion;
        else return null;
    }
     
    class AccionEnviar implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
           
            ButtonModel tipo = g_tipo.getSelection();
            String s = tipo.getActionCommand();
            
            if(s.equals("Mensaje")){

                    JOptionPane.showMessageDialog(LaminaEjercicio2.this, dame_mensaje(), s, dame_tipo_mensaje());
            }
            else if(s.equals("Confirmar")){

                JOptionPane.showConfirmDialog(LaminaEjercicio2.this, dame_mensaje(), s, dame_confirmar(), dame_tipo_mensaje());
            }
            else if(s.equals("Opcion")){

                JOptionPane.showOptionDialog(LaminaEjercicio2.this, dame_mensaje(), s, 1, dame_tipo_mensaje(), null, dame_opcion(), s);
            }
            else if(s.equals("Entrada")){

                if(g_entrada.getSelection().getActionCommand().equals("Campo de texto")){

                    JOptionPane.showInputDialog(LaminaEjercicio2.this, dame_mensaje(), s, dame_tipo_mensaje());
                }
                else{
                    JOptionPane.showInputDialog(LaminaEjercicio2.this, dame_mensaje(), s, dame_tipo_mensaje(), null, new String[]{"Rojo", "Azul", "Amerillo"}, "Rojo");
                }

            }
        }  
    }        
}

class LamninaEjemplo extends JPanel {
    
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
       
        Graphics2D g2 = (Graphics2D) g;

        Rectangle2D rectangulo = new Rectangle2D.Double(0,0,getWidth(),getHeight());

        g2.setPaint(Color.YELLOW);

        g2.fill(rectangulo);
    }
}