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
    public ArrayList<Coche> getCoches() {return coches;}
    public void MostrarInfo(){
        System.out.println("ID: "+id);
        System.out.println("Descripcion: "+descripcion);
    }
    public Coche RecuperarCoche(String id){
        for (Coche coche : coches) {
            if(coche.getID().equals(id)){
                return coche;
            }
        }return  null;
    }
    public void ListarCoches(){
        for (Coche coche : coches) {
            int i = 1;
            System.out.println(i + "- ");
            coche.mostrarInfo();
        }
    }
}
