/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 0
 */
public abstract class Repartidor extends Persona implements InterfaceRepartidor{

    private String placa;
    private Zona zona;
    private double capacidadKg;
    private List<Envio> enviosAsignados;

    
    public Repartidor(){
        
    }
    
    public Repartidor(Zona zona, double capacidadKg, String cedula, String nombre, String telefono, String email, String direccion,String placa) {
        super(cedula, nombre, telefono, email, direccion);
        this.zona = zona;
        this.capacidadKg = capacidadKg;
        this.enviosAsignados = new ArrayList();
        this.placa = placa;
    }
    
    // Getters
    public Zona getZona() { return zona; }
    public double getCapacidadKg() { return capacidadKg; }
    public List<Envio> getEnviosAsignados() { return enviosAsignados; }
    public String getPlaca(){return placa; }

    // Setters
    public void setZona(Zona zona) { this.zona = zona; }
    public void setCapacidadKg(double capacidadKg) { this.capacidadKg = capacidadKg; }
    public void setEnviosAsignados(List<Envio> enviosAsignados) { this.enviosAsignados = enviosAsignados; }

    
    public int cantidadEnviosAsignados(){
        return enviosAsignados.size();
    }
    
    public double calcularPesoActual() {
        double pesoTotal = 0;
        for (Envio e : enviosAsignados) {
            if(e.getEstado().equals("EN PROCESO")){
              for (Paquete p : e.getPaquetes()) {
                pesoTotal += p.getPeso();
                }  
            }
        }
        return pesoTotal;
    }
    
    public boolean validarEnvio(Envio envio) {
        long enviosEnProceso = enviosAsignados.stream()
              .filter(e -> e.getEstado().equalsIgnoreCase("EN PROCESO"))
                .count();

        if (enviosEnProceso >= getMaxEnvios()) {
            System.out.println("No se puede asignar mas envios a " + getNombre() +
                               ". Límite máximo alcanzado (" + getMaxEnvios() + ").");
            return false;
        }

        // Calcular el peso solo con envíos en proceso
        double pesoActual = enviosAsignados.stream()
                .filter(e -> e.getEstado().equalsIgnoreCase("EN PROCESO"))
                .flatMap(e -> e.getPaquetes().stream())
                .mapToDouble(Paquete::getPeso)
                .sum();

        double pesoNuevo = pesoActual + envio.calcularPesoEnvio();

        if (pesoNuevo > capacidadKg) {
            System.out.println("El envío excede la capacidad de carga de " + getNombre());
            return false;
        }

        return true;
}
    
    
    @Override
    public String toString() {
        return super.getNombre() + " (" + getTipoVehiculo() + ") - Cédula: " + super.getCedula()+
               "\n  Capacidad: " + capacidadKg + " kg" +
               "\n  Peso actual: " + String.format("%.2f", calcularPesoActual()) + " kg" +
               "\n  Envios asignados: " + cantidadEnviosAsignados() +
               "\n  Zona: " + (zona != null ? zona.getNombre() : "Sin zona");
    }

    
}
