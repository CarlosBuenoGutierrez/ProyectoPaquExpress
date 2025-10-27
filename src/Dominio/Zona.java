/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 0
 */
public class Zona {
    
    private  String  codigoPostal;
    private String nombre;
    private List<Repartidor> repartidores;
    private List<Cliente> clientes;
    
    public Zona(String codigoPostal, String nombre) {
    this.codigoPostal = codigoPostal;
    this.nombre = nombre;
    this.repartidores = new ArrayList<>();
    this.clientes = new ArrayList<>();
}

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Repartidor> getRepartidores() {
        return repartidores;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void asignarRepartidor(Repartidor r) {
        if (!repartidores.contains(r)) {
            repartidores.add(r);
        }
    }

    public void asignarCliente(Cliente c) {
        if (!clientes.contains(c)) {
            clientes.add(c);
        }
    }

    public List<Repartidor> listarRepartidores() {
        return new ArrayList<>(repartidores);
    }

    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes);
    }

    public Map<Repartidor, Integer> getRepartidoresConCarga() {
        Map<Repartidor, Integer> carga = new HashMap<>();
        for (Repartidor r : repartidores) {
            carga.put(r, r.cantidadEnviosAsignados());
        }
        return carga;
    }
    
    public Repartidor getRepartidorMenosCargado() {
    Map<Repartidor, Integer> mapaCargas = this.getRepartidoresConCarga();

    if (mapaCargas.isEmpty()) return null;

    Repartidor menosCargado = null;
    int menorCarga = Integer.MAX_VALUE;

    for (Map.Entry<Repartidor, Integer> entry : mapaCargas.entrySet()) { 
        Repartidor r = entry.getKey();
        int carga = entry.getValue();
        if (carga < menorCarga) {
            menorCarga = carga;
            menosCargado = r;
        }
    }
    return menosCargado;
}
    
    public Repartidor buscarOtroRepartidorDisponible(Repartidor excluido, Envio envio) {
        Repartidor mejorOpcion = null;
        double menorCarga = Double.MAX_VALUE;

        for (Repartidor r : repartidores) {
            if (r != excluido && r.validarEnvio(envio)) {
                double carga = r.calcularPesoActual();
                if (carga < menorCarga) {
                    menorCarga = carga;
                    mejorOpcion = r;
                }
            }
        }
        return mejorOpcion;
    }
    
    @Override
    public String toString() {
        return nombre + " (CP: " + codigoPostal + ")";
    }
    
}
