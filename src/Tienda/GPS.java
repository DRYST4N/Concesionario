package Tienda;

/*
Decorador para añadir un sistema GPS a un coche.*/
public class GPS extends CocheDecorador {
    private static final double PORCENTAJE_INCREMENTO = 0.01;

    /*
    Constructor de la mejora GPS.*
    @param cocheDecorado El coche que será decorado con esta mejora.
    @throws IllegalArgumentException Si el cocheDecorado es nulo.*/
    public GPS(Coche cocheDecorado) {
        super(cocheDecorado);}

    @Override
    public double calcularPrecioFinal() {
        return super.calcularPrecioFinal() * (1 + PORCENTAJE_INCREMENTO);
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Mejora Aplicada: GPS" );
        System.out.println("Coste Adicional: "+ costeAdicional());
    }


    public double costeAdicional() {
        return super.costeAdicional( calcularPrecioFinal());
    }
}