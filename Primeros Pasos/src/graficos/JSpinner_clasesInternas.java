package graficos;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class JSpinner_clasesInternas {
    public static void main(String[] args) {

        MarcoJSpinner miMarco = new MarcoJSpinner();
        miMarco.setVisible(true);
        
    }
}

class MarcoJSpinner extends JFrame{

    public MarcoJSpinner(){

        setBounds(0, 0, 600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LaminaSpinner miLamina = new LaminaSpinner();
        add(miLamina);
    }
}

class LaminaSpinner extends JPanel{

    public LaminaSpinner(){

        JSpinner control = new JSpinner(new SpinnerNumberModel(5,0,10,1){

            public Object getNextValue(){

                return super.getPreviousValue();
            }
                
            public Object getPreviousValue(){
                
                return super.getNextValue();
            }

        });
        control.setPreferredSize(new Dimension(100,20));
        add(control);
    }
}

//     private class MiModeloSpinner extends SpinnerNumberModel{

//         public MiModeloSpinner(){

//             super(5,0,10,1);
//         }

//         public Object getNextValue(){

//             return super.getPreviousValue();
//         }

//         public Object getPreviousValue(){

//             return super.getNextValue();
//         }
//     }
// }