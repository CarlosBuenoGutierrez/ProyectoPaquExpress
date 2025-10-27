/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.List;

/**
 *
 * @author 0
 */
public class RepCamion extends Repartidor {

    public RepCamion(Zona zona, double capacidadKg, String cedula, String nombre, String telefono, String email, String direccion, String placa) {
        super(zona, capacidadKg, cedula, nombre, telefono, email, direccion, placa);
    }
    
    @Override
    public short getMaxEnvios(){
        return 7;   
    }

    @Override
    public String getTipoVehiculo() {
        return "Camion - Placa: " + super.getPlaca();
    }

}
