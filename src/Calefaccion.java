public class Calefaccion extends DecoradorCoche{
    public Calefaccion(Coche coche){
        super(coche);
    }
    public double precio(){
        return super.precio()*1.05;
    }
    public void MostrarInfo(){
        super.MostrarInfo();
        System.out.println("Mejora: Calefaccion (5%)");
    }
}
