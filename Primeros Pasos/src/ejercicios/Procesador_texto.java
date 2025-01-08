package ejercicios;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.text.StyledEditorKit;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;

public class Procesador_texto {
    public static void main(String[] args) {
        
        MarcoProcesador miMarco = new MarcoProcesador();
        miMarco.setVisible(true);
    }
}

class MarcoProcesador extends JFrame{
    
    public MarcoProcesador(){

        setBounds(50, 50, 600, 300);
        setTitle("Procesador de Texto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JTextPane miArea = new JTextPane();
        miArea.setFont(new Font("Arial", Font.PLAIN, 12));
        miArea.setMargin(new java.awt.Insets(10, 10, 10, 10));
        add(miArea, BorderLayout.CENTER);    
        add(new LaminaProcesadorMenu(miArea), BorderLayout.NORTH);
        JToolBar barra = new JToolBar();
        JButton negritaBtn = new JButton(new ImageIcon("src/graficos/negrita.png"));
        JButton cursivaBtn = new JButton(new ImageIcon("src/graficos/cursiva.png"));
        negritaBtn.addActionListener(new StyledEditorKit.BoldAction());
        cursivaBtn.addActionListener(new StyledEditorKit.ItalicAction());
        barra.add(negritaBtn);
        barra.add(cursivaBtn);
        barra.setOrientation(1);
        add(barra, BorderLayout.WEST);
    } 
}

class LaminaProcesadorMenu extends JPanel{

    private JMenu fuentes, estilos, tamanios;
    private JTextPane miArea;
    
    
    public LaminaProcesadorMenu(JTextPane miArea){

        this.miArea = miArea;
        JMenuBar miBarra = new JMenuBar();

        JPopupMenu emergente = new JPopupMenu();
        JMenuItem menu_negrita = new JMenuItem("Negrita");
        JMenuItem menu_cursiva = new JMenuItem("Cursiva");
        emergente.add(menu_negrita);
        emergente.add(menu_cursiva);
        menu_negrita.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        menu_cursiva.addActionListener(new StyledEditorKit.ItalicAction());
        menu_negrita.addActionListener(new StyledEditorKit.BoldAction());
        emergente.add(menu_negrita);
        emergente.add(menu_negrita);
        miArea.setComponentPopupMenu(emergente);

        fuentes = new JMenu("Fuentes");
        crearMenuItem("Arial", fuentes);
        crearMenuItem("Courier", fuentes);
        crearMenuItem("Verdana", fuentes);
        crearMenuItem("Times New Roman", fuentes);
        crearMenuItem("Comic Sans MS", fuentes);

        estilos = new JMenu("Estilos");
        // crearMenuItem("Negrita", estilos);
        // crearMenuItem("Cursiva", estilos);
        // crearMenuItem("Normal", estilos);
        JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("Negrita");
        JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("Cursiva");
        negrita.addActionListener(new StyledEditorKit.BoldAction());
        cursiva.addActionListener(new StyledEditorKit.ItalicAction());
        negrita.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        cursiva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
        estilos.add(negrita);
        estilos.add(cursiva);
        

        tamanios = new JMenu("Tamaños");
        // crearMenuItem("12", tamanios);
        // crearMenuItem("16", tamanios);
        // crearMenuItem("20", tamanios);
        // crearMenuItem("24", tamanios);
        // crearMenuItem("28", tamanios);
        ButtonGroup tamaño = new ButtonGroup();
        JRadioButtonMenuItem doce = new JRadioButtonMenuItem("12");
        JRadioButtonMenuItem dieciseis = new JRadioButtonMenuItem("16");
        JRadioButtonMenuItem veinte = new JRadioButtonMenuItem("20");
        JRadioButtonMenuItem veinticuatro = new JRadioButtonMenuItem("24");
        JRadioButtonMenuItem veintiocho = new JRadioButtonMenuItem("28");
        tamaño.add(doce);
        tamaño.add(dieciseis);
        tamaño.add(veinte);
        tamaño.add(veinticuatro);
        tamaño.add(veintiocho);
        doce.addActionListener(new StyledEditorKit.FontSizeAction("12", 12));
        dieciseis.addActionListener(new StyledEditorKit.FontSizeAction("16", 16));
        veinte.addActionListener(new StyledEditorKit.FontSizeAction("20", 20));
        veinticuatro.addActionListener(new StyledEditorKit.FontSizeAction("24", 24));
        veintiocho.addActionListener(new StyledEditorKit.FontSizeAction("28", 28));
        tamanios.add(doce);
        tamanios.add(dieciseis);
        tamanios.add(veinte);
        tamanios.add(veinticuatro);
        tamanios.add(veintiocho);
       
        miBarra.add(fuentes);
        miBarra.add(estilos);
        miBarra.add(tamanios);
        add(miBarra);

    }

    private JMenuItem crearMenuItem(String texto, JMenu menu){

        JMenuItem item = new JMenuItem(texto);
        //item.addActionListener(new ManejaFuentes(miArea, texto, menu.getText(), laminaInformacion));
        if(menu == tamanios){
            item.addActionListener(new StyledEditorKit.FontSizeAction(texto, Integer.parseInt(texto)));
        }
        else if(menu == fuentes){
            item.addActionListener(new StyledEditorKit.FontFamilyAction(texto, texto));
        }
        else if(menu == estilos){
            if(texto.equals("Negrita")){
                item.addActionListener(new StyledEditorKit.BoldAction());
            }
            else if(texto.equals("Cursiva")){
                item.addActionListener(new StyledEditorKit.ItalicAction());
            }
            else if(texto.equals("Normal")){
                item.addActionListener(new StyledEditorKit.BoldAction());
                item.addActionListener(new StyledEditorKit.ItalicAction());
            }
        }
        menu.add(item);
        return item;

    }
}

// class LaminaProcesadorInformacion extends JPanel{

//     JTextPane miArea;
//     JLabel fuente;
//     JLabel estilo;
//     JLabel tamano;

//     public LaminaProcesadorInformacion(JTextPane miArea){

//         this.miArea = miArea;
//         fuente = new JLabel("Fuente: " + miArea.getFont().getFontName());
//         estilo = new JLabel("Estilo: " + nombreEstilo(miArea.getFont().getStyle()));
//         tamano = new JLabel("Tamaño: " + miArea.getFont().getSize());
//         add(fuente);
//         add(estilo);
//         add(tamano);

//     }

//     public void actualizaInformacion(String nombreFuente, int estiloFuente, int tamanoFuente) {
//         fuente.setText("Fuente: " + nombreFuente);
//         estilo.setText("Estilo: " + nombreEstilo(estiloFuente));
//         tamano.setText("Tamaño: " + tamanoFuente);
//         repaint();
//     }
    
//     public String nombreEstilo(int estilo){
//         if(estilo == Font.BOLD){
//             return "Negrita";
//         }
//         else if(estilo == Font.ITALIC){
//             return "Cursiva";
//         }
//         else{
//             return "Normal";
//         }
//     }
// }


// class ManejaFuentes implements ActionListener{

//     private JTextPane laminaTexto;
//     private String texto;
//     private String menu;
//     private LaminaProcesadorInformacion laminaInformacion;

    // public ManejaFuentes(JTextPane laminaTexto,String texto, String menu, LaminaProcesadorInformacion laminaInformacion){
    //     this.texto = texto;
    //     this.laminaTexto = laminaTexto;
    //     this.menu = menu;
    //     this.laminaInformacion = laminaInformacion;
    // }   
    
    // public void actionPerformed(ActionEvent e) {

    //     Font fuenteActual = laminaTexto.getFont();
    //     int estilo = fuenteActual.getStyle();
    //     int tamano = fuenteActual.getSize();
    //     String letra = fuenteActual.getFontName();

    //     switch (menu) {
    //         case "Fuentes":
    //             letra = texto;
    //             break;
    //         case "Estilos":
    //         if (texto.equals("Normal")) {
    //             estilo = Font.PLAIN; // Restablece todos los estilos
    //         } else {
    //             estilo = switch (texto) {
    //                 case "Negrita" -> estilo | Font.BOLD;
    //                 case "Cursiva" -> estilo | Font.ITALIC;
    //                 default -> estilo;
    //             };
    //         }
    //         break;
    //         case "Tamaños":
    //             tamano = Integer.parseInt(texto);
    //             break;  
    //     }
    //     laminaTexto.setFont(new Font(letra, estilo, tamano));
    //     laminaInformacion.actualizaInformacion();
        
    // }
  
