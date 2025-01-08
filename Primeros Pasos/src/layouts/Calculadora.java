package layouts;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculadora {
    public static void main(String[] args) {

        Marco_calculadora miMarco = new Marco_calculadora();
        miMarco.setVisible(true);
        
    }
}

class Marco_calculadora extends JFrame{

    public Marco_calculadora(){

        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0,0,600,400);
        setLayout(new BorderLayout());
        Lamina_Visor lamina_visor = new Lamina_Visor();
        add(lamina_visor, BorderLayout.NORTH);
        Lamina_Teclado lamina_teclado = new Lamina_Teclado(lamina_visor);
        add(lamina_teclado);

    }
}

class Lamina_Visor extends JPanel{

    JButton visor = new JButton("0");
    
    public Lamina_Visor(){

        setLayout(new BorderLayout());
        visor.setEnabled(false);
        add(visor, BorderLayout.NORTH);
    }

    public void establece_numero(String numero){

        visor.setText(numero);
    }

    public String dame_valor(){
        
        return visor.getText();
    }
}

class Lamina_Teclado extends JPanel{

    private boolean primera_operacion = true;
    private double resultado = 0;
    private String operacion;
    private boolean esperando_operador = false;

    public Lamina_Teclado(Lamina_Visor lamina_visor){

        setLayout(new GridLayout(5, 4));

        String[] botones = {
            "C","7", "8", "9", "*", 
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            ".", "0", "=", "/", 
        };

        for (String texto : botones) {
            JButton boton = new JButton(texto);
            boton.addActionListener(new Inserta_numero(lamina_visor));
            add(boton);
        }
        
    }

    private class Inserta_numero implements ActionListener {

        private Lamina_Visor lamina_Visor;

        public Inserta_numero(Lamina_Visor oyente) {
            this.lamina_Visor = oyente;
        }

        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();

            if ("+-*/".contains(comando)) {
                procesar_operador(comando);
            } else if (comando.equals("=")) {
                procesar_igual();
            } else if(comando.equals("C")){
                resultado = 0;
                primera_operacion = true;
                esperando_operador = false;
                lamina_Visor.establece_numero("0");
            }
            else {
                procesar_numero(comando);
            }
        }

        private void procesar_numero(String numero) {
            if (esperando_operador || lamina_Visor.dame_valor().equals("0")) {
                lamina_Visor.establece_numero(numero);
            } else {
                lamina_Visor.establece_numero(lamina_Visor.dame_valor() + numero);
            }
            esperando_operador = false;
        }

        private void procesar_operador(String operador) {
            if (primera_operacion) {
                resultado = Double.parseDouble(lamina_Visor.dame_valor());
                primera_operacion = false;
            } else if (!esperando_operador) {
                calcular(Double.parseDouble(lamina_Visor.dame_valor()));
                lamina_Visor.establece_numero(String.valueOf(resultado));
            }
            operacion = operador;
            esperando_operador = true;
            lamina_Visor.establece_numero(operador);
        }

        private void procesar_igual() {
            if (!primera_operacion && !esperando_operador) {
                calcular(Double.parseDouble(lamina_Visor.dame_valor()));
                lamina_Visor.establece_numero(String.valueOf(resultado));
                primera_operacion = true;
            }
        }

        private void calcular(double a) {
            switch (operacion) {
                case "+":
                    resultado += a;
                    break;
                case "-":
                    resultado -= a;
                    break;
                case "*":
                    resultado *= a;
                    break;
                case "/":
                    if (a != 0) {
                        resultado /= a;
                    } else {
                        lamina_Visor.establece_numero("Error");
                        primera_operacion = true;
                    }
                    break;
            }
        }
    }
}    

//     private class Inserta_numero implements ActionListener{

//         private Lamina_Visor lamina_Visor;

//         public Inserta_numero(Lamina_Visor oyente) {
//             this.lamina_Visor = oyente;
//         }

//         public void actionPerformed(ActionEvent e){

//             if("+-*/".contains(lamina_Visor.dame_valor()) || lamina_Visor.dame_valor().equals("0")){

//                 lamina_Visor.establece_numero(e.getActionCommand());
//             }
//             else if("+-*/".contains(e.getActionCommand())){

//                 if(primera_operacion){

//                     resultado = Double.parseDouble(lamina_Visor.dame_valor());
//                     operacion = e.getActionCommand();
//                     lamina_Visor.establece_numero(e.getActionCommand());
//                     primera_operacion = false;
//                     System.out.println(resultado);
//                 }
//                 else{
//                     //resultado = Double.parseDouble(lamina_Visor.dame_valor());
//                     String xoperacion = e.getActionCommand();
//                     calcular(Double.parseDouble(lamina_Visor.dame_valor()));
//                     lamina_Visor.establece_numero(e.getActionCommand());
//                     operacion = xoperacion;
//                     System.out.println(resultado);
//                 }
        
//             }
//             else if (e.getActionCommand().equals("=")){

//                 calcular(Double.parseDouble(lamina_Visor.dame_valor()));
//                 lamina_Visor.establece_numero(String.valueOf(resultado));
                    
//             }
//             else{
//                 lamina_Visor.establece_numero(lamina_Visor.dame_valor() + e.getActionCommand());
//             }
             
//         }
//             public void calcular(double a){

//                 if(operacion.equals("+")){

//                     resultado += a;
//                 }
//                 else if(operacion.equals("-")){

//                     resultado -= a;
//                 }
//                 else if(operacion.equals("*")){

//                     resultado *= a;
//                 }
//                 else if(operacion.equals("/")){

//                     resultado /= a;
//                 }
                
//             }
//     }
// }