package programacion_concurrente.threads;

public class SincornizandoHilos {
    public static void main(String[] args) {
        
        HilosVarios hilo1 = new HilosVarios();
        HilosVarios2 hilo2 = new HilosVarios2(hilo1);
        
        hilo1.start();
        hilo2.start();

        System.out.println("Hilos terminados");
    }
}

class HilosVarios extends Thread {

    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.println("Ejecutando hilo " + getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class HilosVarios2 extends Thread {

    public HilosVarios2(Thread hilo){

        this.hilo = hilo;

    }

    public void run() {

        try {
            hilo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 15; i++) {
            System.out.println("Ejecutando hilo " + getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Thread hilo;
}