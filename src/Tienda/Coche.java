package Tienda;

import java.io.Serializable;

public class Coche implements Serializable {

    //Atributos
    private String id; // Es el modelo + el año de fabricacion.
    private double precio;
    private int stock;
    private String matricula;



    //Constructor
    public Coche(String id, double precio) {
        this.id = id;
        this.precio = precio;
        this.stock = 1;
    }

    //Metodos

    public void mostrarInfo() {
        System.out.println("ID: " + id);
        System.out.println("Precio: " + precio);
        System.out.println("Stock: " + stock);
        System.out.println("Matricula: " + matricula);
    }

    public double precio() {
        return precio;
    }


    public String getID() {return id;}


    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
}
