package Tienda;

/**
Decorador para añadir llantas de aleación a un coche.**/
public class Llantas extends CocheDecorador {
    private static final double PORCENTAJE_INCREMENTO = 0.08;

    /**
    Constructor de la mejora Llantas de Aleación.*
    @param cocheDecorado El coche que será decorado con esta mejora.
    @throws IllegalArgumentException Si el cocheDecorado es nulo.*/
    public Llantas(Coche cocheDecorado) {
        super(cocheDecorado);}

    @Override
    public double calcularPrecioFinal() {
        return super.calcularPrecioFinal() * (1 + PORCENTAJE_INCREMENTO);
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Mejora Aplicada : LLantas" );
        System.out.println("Coste Adicional: "+ costeAdicional());
    }


    public double costeAdicional() {
        return super.costeAdicional( calcularPrecioFinal());
    }
}