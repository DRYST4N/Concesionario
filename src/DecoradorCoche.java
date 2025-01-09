abstract class DecoradorCoche implements CocheInterface{
    protected Coche coche;
    public DecoradorCoche(Coche coche){
        this.coche = coche;
    }
    public double precio(){
        return coche.precio();
    }
    public void MostrarInfo(){
        coche.MostrarInfo();
    }

}
