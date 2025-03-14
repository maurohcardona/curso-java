package cliente;

import cliente.clases.*;


public class Cliente {
    public static void main(String[] args) {
        
        Marco miMarco = new Marco();

        Lamina miLamina = new Lamina(miMarco);

        miMarco.add(miLamina);

        miMarco.addWindowListener(new EnvioOnline(miLamina));
        
        miMarco.setVisible(true);   
    }

}
