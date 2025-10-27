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
public class BDRepartidores {
    
    private Map<String,Repartidor> repartidores;

    public BDRepartidores() {
        this.repartidores = new HashMap ();
    }
    
    public void agregarRepartidor(String cedula, Repartidor repartidor){
        this.repartidores.put(cedula,repartidor);
    }
    
    public void eliminarRepartidor(String cedula){
        this.repartidores.remove(cedula);
    }
    
    public Repartidor buscarRepartidor(String cedula){   
       return this.repartidores.get(cedula);   
    }
    
    public Map<String,Repartidor> listarRepartidores(){
        return this.repartidores;
    }
    
    public Map<String,Repartidor> ListarPorZona(Zona zona){
        
        Map<String ,Repartidor > listadoZona = new HashMap();
        
        for(Map.Entry<String,Repartidor> r : this.repartidores.entrySet()){
            Repartidor rep = r.getValue();
                if(rep.getZona().equals(zona)){
                    listadoZona.put(r.getKey(),rep);
                }
               
        }
        return listadoZona;
    }
    
}
