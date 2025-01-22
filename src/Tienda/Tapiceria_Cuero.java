package Tienda;

/**
Decorador para añadir tapicería de cuero a un coche.*/
public class Tapiceria_Cuero extends CocheDecorador {
    private static final double PORCENTAJE_INCREMENTO = 0.10;

    /**
    Constructor de la mejora Tapicería de Cuero.*
    @param cocheDecorado El coche que será decorado con esta mejora.
    @throws IllegalArgumentException Si el cocheDecorado es nulo.*/
    public Tapiceria_Cuero(Coche cocheDecorado) {
        super(cocheDecorado);}

    @Override
    public double calcularPrecioFinal() {
        return c.calcularPrecioFinal() * (1 + PORCENTAJE_INCREMENTO);
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Mejora Aplicada : Tapiceria de Cuero" );
        System.out.println("Coste Adicional: "+ costeAdicional());
    }


    public double costeAdicional() {
        return super.costeAdicional( calcularPrecioFinal());
    }
}