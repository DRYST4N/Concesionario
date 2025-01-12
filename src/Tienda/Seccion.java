package Tienda;

import java.io.Serializable;
import java.util.ArrayList;

public class Seccion implements Serializable {

    //Atributos
    private String id; //Nombre que se le pone a la seccion
    private String descripcion;//Breve descripcion de la seccion
    private ArrayList<Coche> coches;

    //Constructor
    public Seccion(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    public String getId() {return id;}
    public void agregarCoche(Coche coche) {
        coches.add(coche);
    }
    public ArrayList<Coche> getCoche() {return coches;}
    public void MostrarInfo(){
        System.out.println("ID: "+id);
        System.out.println("Descripcion: "+descripcion);
    }
}
