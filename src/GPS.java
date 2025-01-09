class GPS extends DecoradorCoche {
    public GPS(Coche coche){
        super(coche);
    }
    public double precio(){
        return super.precio() * 1.01;
    }
    public void MostrarInfo(){
        super.MostrarInfo();
        System.out.println("Mejora: GPS (1%)");
    }

}
