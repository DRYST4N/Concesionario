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
    public static Concesionario getInstance() {
        if(tienda == null) {

        }
    }
}
