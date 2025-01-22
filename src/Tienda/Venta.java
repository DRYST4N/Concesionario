package Tienda;


import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Representa una venta realizada en el concesionario.
 */
public class Venta implements Serializable {
    private String idVenta;
    private Cliente cliente;
    private LocalDate fechaVenta;
    private String matricula;
    private Coche coche;
    private double precioFinal;

    /**
     * Constructor de la clase Venta.
     *
     * @param idVenta Identificador único de la venta (9 caracteres).
     * @param cliente Cliente asociado a la venta.
     * @param coche Coche vendido.
     * @throws IllegalArgumentException Si algún parámetro es nulo o inválido.
     */
    public Venta(String idVenta, Cliente cliente, Coche coche,String matricula, LocalDate fechaVenta) {

        try {
            if ( cliente == null || coche == null ) {
                throw new IllegalArgumentException("Parámetros inválidos para crear la venta.");
            }
            this.idVenta = idVenta;
            this.cliente = cliente;
            this.fechaVenta = LocalDate.now();
            this.coche =  coche;
            this.matricula = matricula;
            this.fechaVenta = fechaVenta;

            this.precioFinal = calcularPrecioFinalConIVA();
        }catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Calcula el precio final del coche incluyendo el IVA.
     *
     * @return Precio final con IVA.
     */
    private double calcularPrecioFinalConIVA() {
        return coche.calcularPrecioFinal() * 1.21; // IVA del 21%
    }

    /**
     * Obtiene el identificador de la venta.
     *
     * @return El identificador de la venta.
     */
    public String getIdVenta() {
        return idVenta;
    }

    /**
     * Obtiene el cliente asociado a la venta.
     *
     * @return El cliente de la venta.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Obtiene la fecha de la venta.
     *
     * @return La fecha de la venta.
     */
    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    /**
     * Obtiene el coche vendido.
     *
     * @return El coche vendido.
     */
    public Coche getCoche() {
        return coche;
    }

    public String getMatricula() {
        return matricula;
    }

    /**
     * Obtiene el precio final de la venta con IVA incluido.
     *
     * @return El precio final de la venta.
     */
    public double getPrecioFinal() {
        return precioFinal;
    }

    public void mostrarInformacion(){
        System.out.println("ID: " + idVenta);
        System.out.println("Nombre completo del cliente : " + cliente.getNombre());
        System.out.println("Fecha dela venta: " + fechaVenta);
        System.out.println("Info del coche: ");
        coche.mostrarInfo();
        System.out.println("Precio final: " + calcularPrecioFinalConIVA());
    }

}