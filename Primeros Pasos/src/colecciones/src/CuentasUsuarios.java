package colecciones.src;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CuentasUsuarios {
    public static void main(String[] args) {
        
        Cliente cliente1 = new Cliente("Juan", "00001", 1000);
        Cliente cliente2 = new Cliente("Pedro", "00002", 2000);
        Cliente cliente3 = new Cliente("Ana", "00003", 3000);
        Cliente cliente4 = new Cliente("Maria", "00004", 4000);
        Cliente cliente5 = new Cliente("Juan", "00001", 1000);
        
        Set <Cliente> clientes = new HashSet<Cliente>();

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);
        clientes.add(cliente5);

        // for (Cliente cliente : clientes) {
            
        //     System.out.println(cliente.getNombre() + " " + cliente.getNumeroCuenta() + " $" + cliente.getSaldo()  + ", id: " + cliente.getId());

        //     System.out.println("Hashcode: " + cliente.hashCode());
        // }

        Iterator<Cliente> it = clientes.iterator();
        
        while(it.hasNext()) {

            Cliente cliente = it.next();
            System.out.println(cliente.getNombre());
            System.out.println(cliente.getNumeroCuenta());
            System.out.println(cliente.getSaldo());
        }

    }
}
