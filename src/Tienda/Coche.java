package Tienda;

import java.io.Serializable;

public abstract class Coche  {

    //Atributos
    private String id; // Es el modelo + el año de fabricacion.
    private double precioBase;
    private int stock;



    /**
     * Constructor de la clase Coche.
     *
     * @param id Identificador del coche
     * @param precioBase Precio base del coche.
     *
     * @throws IllegalArgumentException Si el modelo es nulo o vacío, el año es inválido,
     *                                  el precio base es negativo o el stock es negativo.
     */
    public Coche(String id, double precioBase) {
        try {
            if (id == null || id.isEmpty()  || precioBase < 0  ) {
                throw new IllegalArgumentException("Parámetros inválidos para crear un coche.");
            }
            this.id =id;
            this.precioBase = precioBase;
            this.stock = 1;
        }catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    //Metodos

    public void mostrarInfo() {
        System.out.println("ID: " + id);
        System.out.println("Precio: " + calcularPrecioFinal());
        System.out.println("Stock: " + stock);
    }

    /**
     * Obtiene el identificador único del coche.
     *
     * @return El identificador único del coche.
     */
    public String getId() {
        return id;
    }

    /**
     * Obtiene el precio base del coche.
     *
     * @return El precio base del coche.
     */
    public double getPrecioBase() {
        return precioBase;
    }

    /**
     * Obtiene la cantidad de coches disponibles en stock.
     *
     * @return La cantidad de coches en stock.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Actualiza la cantidad de coches disponibles en stock.
     *
     * @param stock La nueva cantidad de coches en stock (mínimo 0).
     */
    public void setStock(int stock) {
        try {
            if (stock < 0) {
                throw new IllegalArgumentException("El stock no puede ser negativo.");
            }

            this.stock = stock;

        }catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Calcula el precio final del coche, incluyendo posibles mejoras.
     * Este método debe ser implementado por las subclases.
     *
     * @return El precio final del coche.
     */
    public abstract double calcularPrecioFinal();


}