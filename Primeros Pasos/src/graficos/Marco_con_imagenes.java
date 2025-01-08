package graficos;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Marco_con_imagenes {
    public static void main(String[] args) {
        
        Marco miMarco = new Marco();
        miMarco.setVisible(true);

    }
}

class Marco extends JFrame{

    public Marco(){

        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            Image logo = ImageIO.read(new File("src/graficos/icono.png"));
            setIconImage(logo);
        } catch (IOException e) {
            System.out.println("No se pudo cargar imagen logo");
        }
        setTitle("Marco con imagenes");
        Lamina lamina1 = new Lamina();
        add(lamina1);
    }
}

class Lamina extends JPanel{

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        g.setColor(Color.GRAY);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Aplicando imagenes", 15, 30);

        try {
            Image imagen = ImageIO.read(new File("src/graficos/imagen1.jpg"));
            g.drawImage(imagen, 0, 50, null);
            for(int i=0; i<1000; i++){
                for(int j=0; j<700; j++){
                    g.copyArea(0, 50, 202, 250, 202*i, 250*j);
                }
            }
        } catch (IOException e) {  
           System.out.println("La imagen no se encuentra");
        }
        

    }

    
}