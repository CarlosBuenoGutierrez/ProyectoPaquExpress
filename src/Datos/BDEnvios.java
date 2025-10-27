/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;
import Dominio.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 0
 */
public class BDEnvios {
    
    private Map<String,Envio> envios;

    public BDEnvios() {
        this.envios = new HashMap();
    }
    
    public void agregarEnvio(String id, Envio envio){
        this.envios.put(id,envio);
    }

    public Envio buscarEnvio(String id){
        return this.envios.get(id);
    }
    
    public Map<String,Envio> listarEnvio(){
        return this.envios;
    }

    public Map<String, Envio> listarEnviosEnProceso() {
        Map<String, Envio> enProceso = new HashMap<>();
        for (Map.Entry<String, Envio> entry : this.envios.entrySet()) {
            if (entry.getValue().getEstado().equals("EN PROCESO")) {
                enProceso.put(entry.getKey(), entry.getValue());
            }
        }
        return enProceso;
    }
}

