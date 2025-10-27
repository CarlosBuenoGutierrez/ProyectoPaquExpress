/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author 0
 */
public class Usuario extends Persona {
    
    private String password;

    public Usuario(String password) {
        this.password = password;
    }

    public Usuario(String password, String cedula, String nombre, String telefono, String email, String direccion) {
        super(cedula, nombre, telefono, email, direccion);
        this.password = password;
    }
    
    public boolean autenticar(String cedula, String passwordIngresada) {
        return this.getCedula().equals(cedula) && this.password.equals(passwordIngresada);
    }
    
    
}



