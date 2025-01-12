package Tienda;

public class Coche implements CocheInterface {

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

    @Override
    public void mostrarInfo() {
        System.out.println("ID: " + id);
        System.out.println("Precio: " + precio);
        System.out.println("Stock: " + stock);
        System.out.println("Tienda.Matricula: " + matricula);
    }

    @Override
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
