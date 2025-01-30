package Tienda;

import java.io.Serializable;

public class Cochebase extends Coche   {

    public Cochebase(String id, double precio_base) {
        super(id, precio_base);
    }

    @Override
    public double calcularPrecioFinal() {
        return super.getPrecioBase();
    }


}