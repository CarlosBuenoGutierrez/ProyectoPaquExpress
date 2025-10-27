/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author 0
 */
public class Cliente extends Persona {
    

    private Zona zona; 

    public Cliente(){   
    }

    public Cliente(Zona zona, String cedula, String nombre, String telefono, String email, String direccion) {
        super(cedula, nombre, telefono, email, direccion);
        this.zona = zona;
    }

    public Zona getZona() { return zona; }
    public void setZona(Zona zona) { this.zona = zona; }

    @Override
    public String toString() {
        return "Cliente: " + super.getNombre() + " (Cedula: " + super.getCedula() + ")" +
               "\nTelefono: " + super.getTelefono() +
               "\nEmail: " + super.getEmail() +
               "\nDirección: " + super.getDireccion() +
               "\nZona: " + (zona != null ? zona.getNombre() : "Sin zona");

    }
}