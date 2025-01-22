package Tienda;

import java.lang.reflect.Constructor;

/*
Clase abstracta para decorar un coche con mejoras.*/
public abstract class CocheDecorador extends Coche {
    protected Coche c;

    /*

    Constructor del decorador de coches.*
    @param c El coche que será decorado con mejoras.**/
    public CocheDecorador(Coche c) {
        super(c.getId(), c.getPrecioBase());
        this.c = c;

    }

    @Override
    public double calcularPrecioFinal() {
        return c.calcularPrecioFinal();
    }

    @Override
    public void mostrarInfo() {
        c.mostrarInfo();
    }

    public double costeAdicional(double num){
        return num - c.getPrecioBase();
    }


}