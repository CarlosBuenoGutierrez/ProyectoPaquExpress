/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Dominio.*;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author 0
 */
public class BDZonas {
    
    private Map<String,Zona> zonas;

    public BDZonas() {
        this.zonas = new HashMap();
    }
    
    public void agregarZona(String codigoPostal,Zona zona){
        this.zonas.put(codigoPostal,zona);
    }

    public Zona buscarZona(String codigoPostal){
        return this.zonas.get(codigoPostal);
    }
    
    public Map<String,Zona> listarZonas(){
        return this.zonas;
    }
    
}

