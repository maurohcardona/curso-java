package programacion_concurrente.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import java.util.concurrent.locks.ReentrantLock;

public class BancoSinSincronizar {
    public static void main(String[] args) {

        Banco b = new Banco();

        for (int i = 0; i < 100; i++) {
            EjecucionTransferencias r = new EjecucionTransferencias(b, i, 2000);
            Thread t = new Thread(r);
            t.start();
        }
        
    }
}

class Banco {

    public Banco() {

        cuentas = new double[100];
        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i] = 2000;
        }

        //saldoSuficiente = cerrojo.newCondition();
    }

    public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException {
        
        //cerrojo.lock();
        
        //try {
            while(cuentas[cuentaOrigen] < cantidad) {
                
                //saldoSuficiente.await();

                wait();
            }

            System.out.println(Thread.currentThread());
            cuentas[cuentaOrigen] -= cantidad;
            System.out.printf("%10.2f de %d para %d ", cantidad, cuentaOrigen, cuentaDestino);
            cuentas[cuentaDestino] += cantidad;
            System.out.printf("Saldo total: %10.2f%n", getSaldoTotal());
            //saldoSuficiente.signalAll();
            notifyAll();
        
    //     } finally {  
            
    //         cerrojo.unlock();
    //     }
    }

    public double getSaldoTotal() {

        double sumaCuentas = 0;
        for (double a : cuentas) {
            sumaCuentas += a;
        }
        return sumaCuentas;
    }

    private final double[] cuentas;

    //private Lock cerrojo = new ReentrantLock();

    //private Condition saldoSuficiente;
}

class EjecucionTransferencias implements Runnable {

    private Banco banco;
    private int deLaCuenta;
    private double cantidadMax;

    public EjecucionTransferencias(Banco b, int de, double max) {
        banco = b;
        deLaCuenta = de;
        cantidadMax = max;
    }

    @Override
    public void run() {
        try {
            while (true) {

                int paraLaCuenta = (int) (100 * Math.random());
                double cantidad = cantidadMax * Math.random();
                banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
}