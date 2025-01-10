public class Coche implements CocheInterface {
    private String ID; // Es el modelo + el año de fabricacion.
    private float precio;
    private int stock;
    public Coche(String ID, float precio, int stock) {
        this.ID = ID;
        this.precio = precio;
        this.stock = stock;
    }
    public String getID() {return ID;}


    @Override
    public double precio() {
        return precio;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("ID: " + ID);
        System.out.println("Precio: " + precio);
        System.out.println("Stock: " + stock);
    }
}
