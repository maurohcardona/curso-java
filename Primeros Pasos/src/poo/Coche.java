package poo;

public class Coche {
    
    private int ruedas;
    private int largo;
    private int ancho;
    private int motor;
    private int peso_plataforma;
    private String color;
    private int peso_total;
    private boolean asientos_cuero, climatizador;

    public Coche() {

        ruedas = 4;
        largo = 2000;
        ancho = 300;
        motor = 1600;
        peso_plataforma = 500;

    }

    public String dime_largo() {
        
        return"El largo del coche es " + largo + " cm";
    }

    public void establece_color(String auto_color) {

        color = auto_color;
    }

    public String dime_color() {

        return"El auto es de color " + color;
    }

    public String dime_datos_generales(){

        return"El coche tiene " + ruedas + " ruedas, tiene " + largo/1000 + " metros de largo, tiene un motor de " +
         motor + "cc y un peso de " + peso_plataforma;
    }

    public void establece_asientos_cuero(String asientos_cuero){

       if(asientos_cuero == "si") {
            this.asientos_cuero = true;
       }else{
            this.asientos_cuero = false;
       }
        
    }
    public String dime_asientos_cuero(){
        
        if (asientos_cuero){
            return"El auto tiene asientos de cuero";
        }else{
            return"El auto no tiene asientos de cuero";
        }
        
    }

    public void establece_climatizador(String climatizador){

        if(climatizador == "si"){
            this.climatizador = true;
        }else{
            this.climatizador = false;
        }
    }

    public String dime_climatizador(){
        if(climatizador){
            return"El auto cuenta con climatizador";

        }else{
            return"El auto no cuenta con climatizador";
            
        }
    }
}
