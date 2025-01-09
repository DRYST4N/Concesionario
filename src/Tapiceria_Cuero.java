class Tapiceria_Cuero extends  DecoradorCoche{
    public Tapiceria_Cuero(Coche coche){
        super(coche);
    }
    public double precio(){
        return super.precio()*1.10;
    }
    public void MostrarInfo(){
        super.MostrarInfo();
        System.out.println("Mejora: Tapiceria de cuero (10%).");
    }
}
