package programacion_concurrente.threads;

import java.awt.geom.*;

import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

import java.lang.Thread;

public class UsoThreads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame marco=new MarcoRebote();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class PelotaHilos implements Runnable{
    
    public PelotaHilos(Pelota unaPelota, Component unComponente){
        
        pelota=unaPelota;
        
        componente=unComponente;
    }
    
    public void run(){
        
        //for(int i=1; i<=3000; i++){
        while(!Thread.interrupted()){
            
            pelota.mueve_pelota(componente.getBounds());
            
            componente.paint(componente.getGraphics());
            
            try{
                
                Thread.sleep(4);
                
            }catch(InterruptedException e){

                Thread.currentThread().interrupt();
            }
        }
    }
    
    private Pelota pelota;
    
    private Component componente;
    
}



//Movimiento de la pelota-----------------------------------------------------------------------------------------

class Pelota{
	
	// Mueve la pelota invirtiendo posici�n si choca con l�mites
	
	public void mueve_pelota(Rectangle2D limites){
		
		x+=dx;
		
		y+=dy;
		
		if(x<limites.getMinX()){
			
			x=limites.getMinX();
			
			dx=-dx;
		}
		
		if(x + TAMX>=limites.getMaxX()){
			
			x=limites.getMaxX() - TAMX;
			
			dx=-dx;
		}
		
		if(y<limites.getMinY()){
			
			y=limites.getMinY();
			
			dy=-dy;
		}
		
		if(y + TAMY>=limites.getMaxY()){
			
			y=limites.getMaxY()-TAMY;
			
			dy=-dy;
			
		}
		
	}
	
	//Forma de la pelota en su posici�n inicial
	
	public Ellipse2D getShape(){
		
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
		
	}	
	
	private static final int TAMX=15;
	
	private static final int TAMY=15;
	
	private double x=0;
	
	private double y=0;
	
	private double dx=1;
	
	private double dy=1;
	
	
}

// L�mina que dibuja las pelotas----------------------------------------------------------------------


class LaminaPelota extends JPanel{
	
	//A�adimos pelota a la l�mina
	
	public void add(Pelota b){
		
		pelotas.add(b);
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
		
		for(Pelota b: pelotas){
			
			g2.fill(b.getShape());
		}
		
	}
	
	private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
}


//Marco con l�mina y botones------------------------------------------------------------------------------

class MarcoRebote extends JFrame{
	
	public MarcoRebote(){
		
		setBounds(600,300,600,350);
		
		setTitle ("Rebotes");
		
		lamina=new LaminaPelota();
		
		add(lamina, BorderLayout.CENTER);
		
		JPanel laminaBotones=new JPanel();

		arranca1=new JButton("Hilo 1");

		arranca1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent evento){

				comienza_el_juego(t1);

			}

		});

		laminaBotones.add(arranca1);

		detener1=new JButton("Detener 1");

		detener1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent evento){

				detener_el_juego(t1);

			}
		});

		laminaBotones.add(detener1);

		arranca2=new JButton("Hilo 2");

		arranca2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent evento){

				comienza_el_juego(t2);

			}

		});

		laminaBotones.add(arranca2);

		detener2=new JButton("Detener 2");

		detener2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent evento){

				detener_el_juego(t2);

			}
		});

		laminaBotones.add(detener2);

		arranca3=new JButton("Hilo 3");

		arranca3.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent evento){

				comienza_el_juego(t3);

			}

		});

		laminaBotones.add(arranca3);

		detener3=new JButton("Detener 3");

		detener3.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent evento){

				detener_el_juego(t3);

			}
		});

		laminaBotones.add(detener3);
		
		// ponerBoton(laminaBotones, "Dale!", new ActionListener(){
			
		// 	public void actionPerformed(ActionEvent evento){
				
		// 		comienza_el_juego();
		// 	}
			
		// });
		
		
		// ponerBoton(laminaBotones, "Salir", new ActionListener(){
			
		// 	public void actionPerformed(ActionEvent evento){
				
		// 		System.exit(0);
				
		// 	}
			
		// });

        // ponerBoton(laminaBotones, "Detener", new ActionListener(){

        //     public void actionPerformed(ActionEvent evento){

        //         detener_el_juego();

        //     }
        // });
		
		add(laminaBotones, BorderLayout.SOUTH);
	}
	
	
	//Ponemos botones
	
	// public void ponerBoton(Container c, String titulo, ActionListener oyente){
		
	// 	JButton boton=new JButton(titulo);
		
	// 	c.add(boton);
		
	// 	boton.addActionListener(oyente);
		
	// }
	
	//A�ade pelota y la bota 1000 veces
	
	public void comienza_el_juego (Thread t){
				
        Pelota pelota=new Pelota();
        
        lamina.add(pelota);
        
        Runnable r = new PelotaHilos(pelota, lamina);

        if (t == t1) {
			t1 = new Thread(r);
			t1.start();
		} else if (t == t2) {
			t2 = new Thread(r);
			t2.start();
		} else if (t == t3) {
			t3 = new Thread(r);
			t3.start();
		}
		
	}

    public void detener_el_juego (Thread t){

        t.interrupt();
        
    }
    
    Thread t1, t2, t3;
	
	JButton arranca1, arranca2, arranca3, detener1, detener2, detener3;
	
	private LaminaPelota lamina;
	
	
}
