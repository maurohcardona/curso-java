package poo;

public class Uso_vehiculo {
    public static void main(String[] args) {
        
        Coche mi_coche1 = new Coche();
        mi_coche1.establece_color("amarillo");

        Furgoneta mi_furgoneta1 = new Furgoneta(7, 580);
        mi_furgoneta1.establece_color("Azul");
        mi_furgoneta1.establece_asientos_cuero("si");;
        mi_furgoneta1.establece_climatizador("si");;
        System.out.println(mi_coche1.dime_datos_generales() + mi_coche1.dime_color());
        System.out.println(mi_furgoneta1.dime_datos_generales());
        System.out.println(mi_furgoneta1.dime_datos_furgoneta());

    }
}
