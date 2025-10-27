/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author 0
 */
public class Paquete {

    private static short idGenerador= 1;
    private String id;
    private double peso;
    private double alto;
    private double ancho;
    private double largo;
    private String direccionRecogida;
    private String direccionDestino;
    

    
    public Paquete(double peso, double alto, double ancho, double largo, String recogida,String destino) {
    idGenerador++;
    this.id = String.valueOf(idGenerador);
    this.peso = peso;
    this.alto = alto;
    this.ancho = ancho;
    this.largo = largo;
    this.direccionDestino = destino;
    this.direccionRecogida = recogida;
}

public String getId() { return id; }
public double getPeso() { return peso; }
public double getAlto() { return alto; }
public double getAncho() { return ancho; }
public double getLargo() { return largo; }
public String getdireccionDestino() { return direccionDestino; }
public String getdireccionRecogida(){return direccionRecogida;}
public double calcularVolumen() { return alto * ancho * largo; }

@Override
public String toString() {
    return "Paquete ID: " + id + 
           "\n  Peso: " + peso + " kg" +
           "\n  Dimensiones: " + alto + "x" + ancho + "x" + largo + " m" +
           "\n  Volumen: " + String.format("%.2f", calcularVolumen()) + " m³" +
           "\n  Origen: " +direccionRecogida+ 
           "\n  Destino:" +direccionDestino;
}
    
}

