package eventos;

import java.io.Serializable;
import java.util.HashMap;

public class PaqueteEnvio implements Serializable {
    
    private String mensaje, nickName, ip_propio, ip_destinatario;
    private HashMap<String, String> lista_ips = new HashMap<>();


    public PaqueteEnvio(String mensaje, String nickName, String ip_propio, String ip_destinatario){

        this.mensaje = mensaje;
        this.nickName = nickName;
        this.ip_propio =ip_propio;
        this.ip_destinatario = ip_destinatario;
    }

    public String getMessage(){

        return mensaje;
    }

    public HashMap<String, String> getMapIps(){

        if (lista_ips == null) { 

            lista_ips = new HashMap<>();
        }
        return lista_ips;
    }

    public String getNickname(){

        return nickName;
    }

    public String getIpPropio(){

        return ip_propio;
    }

    public String getIpDestinatario() {

        return ip_destinatario;
    }

    public void setMapIp(String nickName, String ip_propio){

        if (lista_ips == null) { 

            lista_ips = new HashMap<>();
        }

        lista_ips.put(nickName, ip_propio);
    }

    public void setearMap(HashMap<String,String> nueva_lista) {

        lista_ips = nueva_lista;
    }

}
