package Tienda;

/**
Decorador para añadir calefacción en los asientos a un coche.*/
public class Calefaccion extends CocheDecorador {
    private static final double PORCENTAJE_INCREMENTO = 0.1;

    /**
    Constructor de la mejora Calefacción en los Asientos.*
    @param cocheDecorado El coche que será decorado con esta mejora.
    @throws IllegalArgumentException Si el cocheDecorado es nulo.*/
    public Calefaccion(Coche cocheDecorado) {
        super(cocheDecorado);}

    @Override
    public double calcularPrecioFinal() {
        return super.calcularPrecioFinal() * (1 + PORCENTAJE_INCREMENTO);
    }


    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Mejora Aplicada : Calefaccion" );
        System.out.println("Coste Adicional: "+ costeAdicional());
    }

    public double costeAdicional() {
        return super.costeAdicional(calcularPrecioFinal());
    }


}