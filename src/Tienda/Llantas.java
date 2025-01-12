package Tienda;

public class Llantas extends DecoradorCoche {
    public Llantas(Coche coche){
        super(coche);
    }

    @Override
    public double precio() {
        return super.precio() * 1.05;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Mejora: Llantas de aleacion(5%)");
    }
}
