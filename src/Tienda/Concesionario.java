package Tienda;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Concesionario implements Serializable {
    private static Concesionario tienda;
    private ArrayList<Seccion> Secciones;
    private ArrayList<Coche> Coches;
    private ArrayList<Cliente> Clientes;
    private  ArrayList<Venta> Ventas;

    private Concesionario() {
        Secciones = new ArrayList();
        Coches = new ArrayList();
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
            FileInputStream fis = new FileInputStream(nombreFichero) ;
            ObjectInputStream iis = new ObjectInputStream(fis) ;
            return (A) iis.readObject() ;
        } catch (IOException e) {
            System.err.println("Problem: "+e);}
        catch(ClassNotFoundException e)
        { System.out.println(e.getMessage()); }
        return null ;
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
}
