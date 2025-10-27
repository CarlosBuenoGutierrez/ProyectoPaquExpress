/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nuevopaquexpress;

import Logica.*;
import Dominio.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class NuevoPaquExpress {    
    
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        LogicaBD logica = new LogicaBD();

        Zona zona1 = new Zona("1001","Norte");
        logica.agregarZona(zona1);
        Zona zona2 = new Zona("1002","Sur");
        logica.agregarZona(zona2);
        Zona zona3 = new Zona("1003","Este");
        logica.agregarZona(zona3);
        Zona zona4 = new Zona("1004","Oeste");
        logica.agregarZona(zona4);
        
        Cliente cliente1 = new Cliente(zona1,"1066","Carlos Bueno","301","gmail","Carrizal");
        logica.agregarCliente(cliente1, zona1);
        
        Cliente cliente2 = new Cliente(zona2,"1067","Dalan roa","3012","gmail1","Cerca de la U");
        logica.agregarCliente(cliente2, zona2);
        
        Cliente cliente3 = new Cliente(zona3,"1068","Daniel Chavez","30112","gmail23","Nose");
        logica.agregarCliente(cliente3, zona3);
        
        Cliente cliente4 = new Cliente(zona1,"1069","Sebastian","3016","gma21il","La paz");
        logica.agregarCliente(cliente4, zona1);
        
        
        Repartidor r1 = new RepCamion(zona1,60,"1006","Alonso","321","example@example.com","pescaito","AAA");
        logica.agregarRepartidor(r1, zona1);
        
        Repartidor r2 = new RepMoto(zona1,60,"1007","Xavi","322","example@example.com","pescaito","BBB");
        logica.agregarRepartidor(r2, zona1);
        
        Repartidor r3 = new RepCamion(zona1,60,"1008","iniesta","323","example@example.com","pescaito","CCC");
        logica.agregarRepartidor(r3, zona1);
        
        Repartidor r4 = new RepMoto(zona2,60,"1009","Ramos","324","example@example.com","pescaito","DDD");
        logica.agregarRepartidor(r4, zona2);
        
        Repartidor r5 = new RepCamion(zona3,60,"1010","Segio","325","example@example.com","pescaito","EEE");
        logica.agregarRepartidor(r5, zona3);
        
        Usuario admin = new Usuario("12345","10763432","David","324597212","example@example.com","Por el centro");

        
        System.out.println("Autentificacion !");
        System.out.print("Ingrese la Cedula: ");
        String cedula = sc.nextLine();
        System.out.print("Ingrese ;a contrase;a: ");
        String password = sc.nextLine();
        
        
        boolean autentificacion = admin.autenticar(cedula, password);
        if(autentificacion){
            short opcion;
            do{
                System.out.println("\n===== MENU PRINCIPAL =====");
                System.out.println("1. Agregar Zona");
                System.out.println("2. Agregar Cliente");
                System.out.println("3. Agregar Repartidor");
                System.out.println("4. Registrar Envio");
                System.out.println("5. Listar Zonas");
                System.out.println("6. Listar Clientes");
                System.out.println("7. Listar Repartidores");
                System.out.println("8. Listar Envios");
                System.out.println("9. Envios en proceso");
                System.out.println("10. Salir");
                System.out.print("Seleccione una opcion: ");
                opcion = sc.nextShort();
                sc.nextLine();

                switch (opcion) {
                    case 1 ->
                        zonas(sc, logica);
                    case 2 ->
                        Clientes(sc, logica);
                    case 3 ->
                        repartidores(sc, logica);
                    case 4 ->
                        envios(sc, logica);
                    case 5 ->
                        listarZonas(logica);
                    case 6 ->
                        listarClientes(logica);
                    case 7 ->
                        listarRepartidores(logica);
                    case 8 ->
                        listarEnvios(logica);
                    case 9 ->
                        marcarEnvio(sc,logica);
                    case 10 ->
                        System.out.println("Saliendo...");
                    default ->
                        System.out.println("Opción inválida.");
            }
            
        }while(opcion != 10);
    
    
        }else{ 
            System.out.println("Ingreso Invalido"); 
        }
        
    }
    
    public static void zonas(Scanner sc, LogicaBD logica){
        //pide la info
        System.out.print("Ingrese el nombre de la zona: ");
        String nombreZona = sc.nextLine();
        System.out.print("Ingrese el codigo postal: ");
        String codigoPostal = sc.nextLine();

        //agrega la Zona
        Zona zona = new Zona(codigoPostal, nombreZona);
        logica.agregarZona(zona);
        System.out.println("Zona agregada correctamente.");
    }
    
    public static void Clientes(Scanner sc, LogicaBD logica){   
       //Pide la info
       System.out.print("Ingrese la cedula del cliente: ");
       String cedula = sc.nextLine();
       System.out.print("Ingrese el nombre: ");
       String nombre = sc.nextLine();
       System.out.print("Ingrese el telefono: ");
       String telefono = sc.nextLine();
       System.out.print("Ingrese el email: ");
       String email = sc.nextLine();
       System.out.print("Ingrese Su direccion: ");
       String direccion = sc.nextLine();
       System.out.print("Ingrese el codigo postal de la zona: ");
       String codigoPostal = sc.nextLine();

       //Busca que la zona exita
       Zona zonaCliente = logica.buscarZona(codigoPostal);
       if (zonaCliente == null) {
            System.out.println("Zona no encontrada. Agregue la zona primero.");
            return;
            }
                    
         //Se agrega el cliente 
        Cliente cliente = new Cliente(zonaCliente,cedula, nombre, telefono,email,direccion);
        logica.agregarCliente(cliente, zonaCliente);
                     
    }
    
    public static void repartidores(Scanner sc, LogicaBD logica){   
        //info

        System.out.print("Ingrese tipo de repartidor (1=Moto, 2=Camion): ");
        short tipo = sc.nextShort();
        sc.nextLine();
        System.out.print("Ingrese la cedula: ");
        String cedula = sc.nextLine();
        System.out.print("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el telefono: ");
        String telefono = sc.nextLine();
        System.out.print("Ingrese su Direccion: ");
        String direccion = sc.nextLine();
        System.out.print("Ingrese el email: ");
        String email = sc.nextLine();
        System.out.print("Ingrese la capacidad (kg): ");
        double capacidad = sc.nextDouble();
        sc.nextLine();
        System.out.print("Ingrese la placa del vehiculo: ");
        String placa = sc.nextLine();
        System.out.print("Ingrese el codigo postal de la zona a la que pertenece:");
        String codigoPostal = sc.nextLine();

        //busca si la zona existe
        Zona zona = logica.buscarZona(codigoPostal);
        if (zona == null) {
            System.out.println("Zona no encontrada. Agregue la zona primero.");
        return;
        }
        
        //agrega el repartidor dependiendo del tipo
        Repartidor repartidor;
        if (tipo == 1) { 
            repartidor = new RepMoto(zona,capacidad, cedula, nombre, telefono,email,direccion,placa);
        } else {
            repartidor = new RepCamion(zona,capacidad, cedula, nombre, telefono,email,direccion,placa);
        }
        logica.agregarRepartidor(repartidor, zona);
    }
    
    public static void envios(Scanner sc, LogicaBD logica){  
        //info
        System.out.print("Ingrese cedula del cliente: ");
        String cedulaCliente = sc.nextLine();
        
        //verifica si la cedula existe
        Cliente cliente = logica.buscarCliente(cedulaCliente);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        //Pregunta la zona
        Zona zona;
        System.out.println("Misma zona del cliente o Diferente zona?\n Cliente = 1\nDiferente =2 \n");
        short decision = sc.nextShort();
        sc.nextLine();
        if(decision == 1){
            zona = cliente.getZona();
        }else{
            System.out.print("Ingrese el codigo postal de la zona: ");
            String codigoPostal = sc.nextLine();

            //Busca que la zona exita
            zona = logica.buscarZona(codigoPostal);
            if (zona == null) {
            System.out.println("Zona no encontrada. Agregue la zona primero.");
            return;
            }        
        }
        
        //Creacion de paquetes
        List<Paquete> paquetes = new ArrayList<>();
        String respuesta;
        do {
          
            System.out.print("Ingrese peso (Kg): ");
            double peso = sc.nextDouble();
            System.out.print("Ingrese alto (m): ");
            double alto = sc.nextDouble();
            System.out.print("Ingrese ancho (m): ");
            double ancho = sc.nextDouble();
            System.out.print("Ingrese largo (m): ");
            double largo = sc.nextDouble();
            sc.nextLine();
            System.out.print("Ingrese direccion de recogida: ");
            String dire = sc.nextLine();
            System.out.print("Ingrese direccion destino: ");
            String dir = sc.nextLine();
            Paquete paquete = new Paquete( peso, alto, ancho, largo, dire,dir);
            paquetes.add(paquete);

            System.out.print("Agregar otro paquete? (s/n): ");
            respuesta = sc.nextLine();
        } while (respuesta.equalsIgnoreCase("s"));
           
        System.out.print("Ingrese El precio total del envio: ");
        double precioTotal = sc.nextDouble();
        sc.nextLine();
        
        //registro del envio
        Envio envio = new Envio(cliente, zona, paquetes,precioTotal);
        logica.balanceoEnvio(envio, zona);
    }
    
    public static void listarEnvios(LogicaBD logica){   
        System.out.println("\n=== ZONAS ===");
        logica.listarEnvios().values().forEach(c -> System.out.println(c + "\n"));
    }
    
    public static void listarZonas( LogicaBD logica){
        System.out.println("\n=== ZONAS ===");
        logica.listarZonas().values().forEach(c -> System.out.println(c + "\n"));
        
    }
    
    public static void listarClientes(LogicaBD logica){   
        System.out.println("\n=== CLIENTES ===");
        logica.listarCliente().values().forEach(c -> System.out.println(c + "\n"));
    }
    
    public static void listarRepartidores(LogicaBD logica){
        System.out.println("\n=== REPARTIDORES ===");
        logica.listarRepartidores().values().forEach(c -> System.out.println(c + "\n"));
    }
    
    public static void marcarEnvio(Scanner sc,LogicaBD logica){
        
        System.out.println("ENVIOS EN PROCESO");        
        logica.listarEnviosEnProceso().values().forEach(System.out::println);
        
        System.out.println("1. Marcar como entregado");
        System.out.println("2. Marcar como No entregado");
        short opcion = sc.nextShort();
        sc.nextLine();
        
        switch(opcion){
            case 1 ->{
                System.out.println("Digite el id del envio:");
                String id = sc.nextLine();
                logica.marcarEntregado(id);
                break;
            }
            case 2 ->{
                System.out.println("Digite el id del envio:");
                String id = sc.nextLine();
                logica.marcarNoEntregado(id);
                break;
            }
            default ->{
                System.out.println("Opcion invalida");
            }
        } 
    }   
}
