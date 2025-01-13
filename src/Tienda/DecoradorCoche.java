package Tienda;

abstract class DecoradorCoche{
    protected Coche coche;
    public DecoradorCoche(Coche coche){
        this.coche = coche;
    }
    public double precio(){
        return coche.precio();
    }
    public void mostrarInfo(){
        coche.mostrarInfo();
    }

}
