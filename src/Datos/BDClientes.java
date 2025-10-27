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
public class BDClientes {
    
    private Map<String,Cliente> clientes;

    public BDClientes() {
        this.clientes = new HashMap();
    }
    
    public void agregarCliente(String cedula, Cliente cliente){
        this.clientes.put(cedula,cliente);  
    }
    
    public void eliminarCliente(String cedula){
        this.clientes.remove(cedula);
    }
    
    public Cliente buscarCliente(String cedula){   
       return this.clientes.get(cedula);   
    }
    
    public Map<String,Cliente> listarClientes(){
        return this.clientes;
    }
}
