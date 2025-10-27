/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;
import Datos.*;
import Dominio.*;
import java.util.Date;
import java.util.Map;
/**
 *
 * @author 0
 */
public class LogicaBD {
    
    private BDClientes bdc;
    private BDEnvios bde;
    private BDRepartidores bdr;
    private BDZonas bdz;

    public LogicaBD() {
        this.bdc = new BDClientes();
        this.bde = new BDEnvios();
        this.bdr = new BDRepartidores();
        this.bdz = new BDZonas();
    }
    
    //Clientes
    
    public void agregarCliente(Cliente cliente,Zona zona){
        
        bdc.agregarCliente(cliente.getCedula(), cliente);
        zona.asignarCliente(cliente);
        
        System.out.println("Cliente agregado Correctamente ! ");   
   
}
    
    public void eliminarCliente(String cedula,Zona zona){
        bdc.eliminarCliente(cedula);
        
        System.out.println("Cliente eliminado Correctamente !");
    }
    
    public Cliente buscarCliente(String cedula){
        return bdc.buscarCliente(cedula);
    }
    
    public Map<String,Cliente> listarCliente(){
        return bdc.listarClientes();
    } 
    
    //Repartidores 
    
    public void agregarRepartidor(Repartidor repartidor,Zona zona){
        bdr.agregarRepartidor(repartidor.getCedula(), repartidor);
        zona.asignarRepartidor(repartidor);
        System.out.println("Repartidor Registrado Correctamente !");
    }
    
    public Repartidor buscarRepartidor(String cedula){
        return bdr.buscarRepartidor(cedula); 
    }
    
    public Map<String,Repartidor> listarRepartidores(){
        return bdr.listarRepartidores();
    }
    
    //Zonas 
    
    public void agregarZona(Zona zona){
        bdz.agregarZona(zona.getCodigoPostal(), zona);
    }
    
    public Zona buscarZona(String codigoPostal){
        return this.bdz.buscarZona(codigoPostal);
    }
    
    public Map<String,Zona> listarZonas(){
        return this.bdz.listarZonas();
    }
    
    //Envios
 
    public void agregarEnvio(Envio envio){
        bde.agregarEnvio(envio.getId(), envio);
    }
    
    public Map<String,Envio> listarEnvios(){
        return bde.listarEnvio();
    }
    
    public Map<String, Envio> listarEnviosEnProceso() {
        return bde.listarEnviosEnProceso();
    }
    
    
    
    public void balanceoEnvio(Envio envio,Zona zona){
        
        Repartidor menosCargado = zona.getRepartidorMenosCargado();
        
        if(menosCargado == null){
            System.out.println("No hay Repartidores  Disponibles !");
            return;
        }
        
        boolean validacion = menosCargado.validarEnvio(envio);
        if(validacion){
            menosCargado.getEnviosAsignados().add(envio);
            envio.setRepartidor(menosCargado);
            agregarEnvio(envio);

            System.out.println("Envio asignado al repartidor " + menosCargado.getNombre() + " correctamente.");  
        }else{
            System.out.println("El envío no pudo ser asignado. Intentando reasignar...");
            // aquí podrías buscar otro repartidor alternativo
            Repartidor alternativo = zona.buscarOtroRepartidorDisponible(menosCargado, envio);
            if (alternativo != null && alternativo.validarEnvio(envio)) {
                alternativo.getEnviosAsignados().add(envio);
                envio.setRepartidor(alternativo);
                agregarEnvio(envio);
            } else {
            System.out.println("Ningun repartidor disponible puede aceptar el envio.");
        }
        }
    }
    
    public void marcarNoEntregado(String id){
        Envio envio = bde.buscarEnvio(id);
        
        if(envio == null){        
            System.out.println("NO existe el envio");        
        }else{
            if(envio.getEstado().equals("EN PROCESO")){
                envio.setEstado("NO ENTREGADO");
                envio.setFechaEntrega(new Date());
                envio.getRepartidor().calcularPesoActual();
                System.out.println("Se cambio el estado del envio Correctamente");
            }     
        }  
    }
    
    public void marcarEntregado(String id){
        Envio envio = bde.buscarEnvio(id);
        
        if(envio == null){        
            System.out.println("NO existe el envio");        
        }else{
            
            if(envio.getEstado().equals("EN PROCESO")){
                envio.setEstado("ENTREGADO");
                envio.setFechaEntrega(new Date());
                envio.getRepartidor().calcularPesoActual();
                System.out.println("Se cambio el estado del envio Correctamente");

            }
            
        }
         
    }
    
}
