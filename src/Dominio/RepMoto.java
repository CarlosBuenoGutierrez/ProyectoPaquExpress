/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author 0
 */
public class RepMoto extends Repartidor {

    public RepMoto(Zona zona, double capacidadKg, String cedula, String nombre, String telefono, String email, String direccion, String placa) {
        super(zona, capacidadKg, cedula, nombre, telefono, email, direccion, placa);
    }

    @Override
    public short getMaxEnvios(){
        return 3;
    }
    
    @Override
    public String getTipoVehiculo() {
        return "Moto - Placa: " + super.getPlaca();
    }
    

}
