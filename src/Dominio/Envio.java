/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author 0
 */
public class Envio {
    
    private static long idGenerador= 1000;
    private String id;
    private List<Paquete> paquetes;
    private Cliente cliente;
    private Repartidor repartidor;
    private Zona zona;
    private String estado;
    private Date fechaSalida;
    private Date fechaEntrega;
    private double precioTotal;
    
    public Envio( Cliente cliente, Zona zona, List<Paquete> paquetes,double precioTotal) {
    idGenerador++;
    this.id = String.valueOf(idGenerador);
    this.cliente = cliente;
    this.zona = zona;
    this.paquetes = new ArrayList<>(paquetes);
    this.estado = "EN PROCESO"; 
    this.fechaSalida = new Date();
    this.fechaEntrega = null;
    this.precioTotal = precioTotal;

}
   
    // Getters
    public String getId() { return id; }
    public List<Paquete> getPaquetes() { return paquetes; }
    public Cliente getCliente() { return cliente; }
    public Repartidor getRepartidor() { return repartidor; }
    public Zona getZona() { return zona; }
    public String getEstado() { return estado; }
    public Date getFechaSalida() { return fechaSalida; }
    public Date getFechaEntrega() { return fechaEntrega; }
    public double getPrecioTotal(){return  precioTotal;}
    
    // Setters
    public void setId(String id) { this.id = id; }
    public void setPaquetes(List<Paquete> paquetes) { this.paquetes = paquetes; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setRepartidor(Repartidor repartidor) { this.repartidor = repartidor; }
    public void setZona(Zona zona) { this.zona = zona; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setFechaEntrega(Date fechaEntrega) { this.fechaEntrega = fechaEntrega; }
    
    
    
    public double calcularPesoEnvio() {
        double total = 0;
        for (Paquete p : paquetes) {
            total += p.getPeso();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Envio ID: " + id + 
               "\nCliente: " + (cliente != null ? cliente.getNombre() : "Sin cliente") +
               "\nRepartidor: " + (repartidor != null ? repartidor.getNombre() : "No asignado") +
               "\nZona: " + (zona != null ? zona.getNombre() : "Sin zona") +
               "\nEstado: " + estado +
               "\nPeso total: " + String.format("%.2f", calcularPesoEnvio()) + " kg" +
               "\nFecha salida: " + fechaSalida +
               "\nFecha entrega: " + (fechaEntrega != null ? fechaEntrega : "Pendiente") +
                "\n: Precio total: "+ this.precioTotal+
               "\nCantidad paquetes: " + paquetes.size();
    }
    
}
