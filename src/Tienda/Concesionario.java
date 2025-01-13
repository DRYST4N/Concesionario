package Tienda;

import java.io.*;
import java.util.ArrayList;

public class Concesionario implements Serializable {
    private static Concesionario tienda;
    private ArrayList<Seccion> Secciones;
    private ArrayList<Cliente> Clientes;
    private  ArrayList<Venta> Ventas;

    private Concesionario() {
        Secciones = new ArrayList();
        Clientes = new ArrayList();
        Ventas = new ArrayList();
    }
    // Lo utilizamos para crear una unica instancia de la clase de Concesionario y asi no duplicar los datos.
    public static Concesionario getInstance() {
        if(tienda == null) {
            tienda = deserialize("BackUp.dat");
            if (tienda == null) {
                tienda = new Concesionario();
            }
        }
        return tienda;
    }
    //Con este metodo abrimos el fichero yrecuperamos los datos que estaban guardados.
    private static <A> A deserialize(String nombreFichero) {
        try {
            FileInputStream fis = new FileInputStream(nombreFichero);
            ObjectInputStream iis = new ObjectInputStream(fis);
            return (A) iis.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo " + nombreFichero + " no existe. Se creará uno nuevo.");
        } catch (IOException e) {
            System.err.println("Problema al leer el archivo: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada durante la deserialización: " + e.getMessage());
        }
        return null;
    }

    //Implementaremos las cosas de Clientes
    public void anadirClientes(Cliente c){
        Clientes.add(c);
    }
    public Cliente recuperarClientes(String id){
        for(Cliente c: Clientes) {
         if(c.getID().equals(id)) {
             return c;
         }
        }
        return null;
    }
    public void ListarClientes(){
        for (Cliente c: Clientes) {
            int i = 1;
            System.out.println(i + " - ");
            c.MostrarInfo();
            i = i + 1;
        }
    }
    public void ListarClientesInfo(){
        for (Cliente c: Clientes) {
            int i = 1;
            if (c.getInfo()){
                System.out.println(i + ".- ");
                c.MostrarInfo();
                i = i + 1;
            }
        }
    }

    //Desde aqui se implementaran los metodos que tienen que ver con las Secciones
    public void agregarSeccion(Seccion s){
        Secciones.add(s);
    }
    public Seccion recuperarSeccion(String id){
        for(Seccion s: Secciones) {
            if(s.getId().equals(id)) {
                return s;
            }
        }return null;
    }
    public void eliminarSeccion(Seccion s){
        Secciones.remove(s);
    }
    public void ListarSecciones(){
        for (Seccion s: Secciones) {
            int i = 1;
            System.out.println(i + " - ");
            s.MostrarInfo();
            i = i + 1;
        }
    }
}
