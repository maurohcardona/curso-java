package poo;

public class Furgoneta extends Coche {
    
    private int capacidad_carga;
    private int plazas_extras;

    public Furgoneta(int plazas_extras, int capacidad_carga) {

        super();
        this.plazas_extras = plazas_extras;
        this.capacidad_carga = capacidad_carga;

    }

    public String dime_datos_furgoneta(){

        return"Lacapacidad de carga es " + capacidad_carga + "Kg, y las plazas extras son " + 
        plazas_extras;
    }
    
}
